package org.hackerthon;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import org.hackerthon.controllers.ReadResponseHandler;
import org.hackerthon.excel_parser.ExcelParser;

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
        });
        server.post("/submitPurpose", ReadResponseHandler::purposeResponse);
        server.get("/purposeform", ctx -> {
            ctx.json(parser.getPurposeQO().getQuestions());
        }).before(ctx->{
            ctx.header("Access-Control-Allow-Origin", "*");
        });
    }
}