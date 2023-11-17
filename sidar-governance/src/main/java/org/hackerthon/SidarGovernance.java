package org.hackerthon;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;
import org.hackerthon.excel_parser.ExcelParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SidarGovernance {

    private static Javalin server;
    private final int DEFAULT_PORT = 8000;
    private static final String TEMPLATE_DIR = "/templates";
    static {

    }

    public SidarGovernance(){
        configureServer();
    }
    public static void main(String[] args) {
        SidarGovernance sidar = new SidarGovernance();
        sidar.start();
    }

    public void  start(){
        SidarGovernance.server.start(DEFAULT_PORT);
    }

    public void configureServer(){
        ExcelParser parser = new ExcelParser();
        SidarGovernance.server = Javalin.create(config->{
            config.addStaticFiles( TEMPLATE_DIR, Location.CLASSPATH);
//            config.post("/submitForm", this::submitForm);
        });
//        server.get("/", ctx -> {
//           ctx.render("/index.html");
//        });
        server.get("/purposeform", ctx -> {
            ctx.json(parser.getPurposeQO().getQuestions());
        });
        server.post("/submitForm", this::submitForm);
    }

    private void submitForm(Context ctx) {
//        String grade = ctx.formParam("grade_1");
//        System.out.println(grade);
        Map<String, List<String>> formValues = ctx.formParamMap();
//        ctx.formParamAsClass()
        System.out.println(formValues);

        // Create lists to store questions and selected values
        List<String> questions = new ArrayList<>();
        List<String> selectedValues = new ArrayList<>();

        formValues.forEach((key, value) -> {
            // Assuming radio inputs are named like grade_0, grade_1, etc.
            if (key.startsWith("grade_")) {
                String selectedValue = value.toString(); // Get the selected value
                System.out.println("Question " + key + ": " + selectedValue);

                // Add question and selected value to lists
                questions.add("Question " + key);
                selectedValues.add(selectedValue);
            }
        });
        System.out.println(questions.size());
        System.out.println(selectedValues.size());
        // You can handle the form data as needed and send a response back to the client
        ctx.result("Form submitted successfully!");
    }
}