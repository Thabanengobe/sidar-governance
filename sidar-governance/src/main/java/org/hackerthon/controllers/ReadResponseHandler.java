package org.hackerthon.controllers;

import java.util.Collection;
import java.util.List;

import org.hackerthon.database.ResponsesDO;

import io.javalin.http.Context;

public class ReadResponseHandler {

    public static void purposeResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getPurposeQO().getQuestions();
        saveResponse(context, questions, Categories.PURPOSE.name());
        Collection<ResponsesDO> db = DataBaseHandler.getResponsesDAI().getAllData();
        context.json(db);
    }

    public static void conformanceResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getConformanceQO().getQuestions();
        saveResponse(context, questions, Categories.CONFORMANCE.name());
        context.json(DataBaseHandler.getResponsesDAI().getAllData());
    }

    public static void sustainabilityResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getSustainabilityQO().getQuestions();
        saveResponse(context, questions, Categories.SUSTAINABILITY.name());
        context.json(DataBaseHandler.getResponsesDAI().getAllData());
    }

    public static void performanceResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getPerformanceQO().getQuestions();
        saveResponse(context, questions, Categories.BOARD_COMPOSITION.name());
        context.json(DataBaseHandler.getResponsesDAI().getAllData());
    }

    public  static void saveResponse(Context context, List<String> questions, String category){
        for (int index = 0; index < context.formParamMap().size()-1; index++) {
            ResponsesDO response = new ResponsesDO();
            response.setChoice(context.formParam(String.valueOf(index)));
            response.setQuestion(questions.get(index));
            response.setRole(context.formParam("role"));
            response.setCategory(category);
            DataBaseHandler.getResponsesDAI().saveResponse(response);
        }
    }
}
