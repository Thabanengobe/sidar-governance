package org.hackerthon.controllers;

import java.util.List;

import org.hackerthon.database.ResponsesDO;

import io.javalin.http.Context;

public class ReadResponseHandler {
   
    public static void purposeResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getPurposeQO().getQuestions();
        startSavingResponses(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataInEnterprisePurpose());
    }

    public static void conformanceResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getConformanceQO().getQuestions();
        startSavingResponses(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataConformance());
    }

    public static void sustainabilityResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getSustainabilityQO().getQuestions();
        startSavingResponses(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataInSustainability());
    }

    public static void performanceResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getPerformanceQO().getQuestions();
        startSavingResponses(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataInAccountabilityForPerformance());
    }

    public  static void startSavingResponses(Context context, List<String> questions){
        for (int index = 0; index < context.formParamMap().size(); index++) {
            saveResponse(questions.get(index), context.formParam(String.valueOf(index)), context.formParam("role"));
        }
    }
    public static void saveResponse(String question, String choice, String role){
        ResponsesDO response = new ResponsesDO();
        response.setQuestion(question);
        response.setChoice(choice);
        response.setRole(role);
        DataBaseHandler.getResponsesDAI().saveResponseEnterprisePurpose(response);
    }
}
