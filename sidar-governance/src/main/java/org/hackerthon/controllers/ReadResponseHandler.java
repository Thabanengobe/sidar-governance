package org.hackerthon.controllers;

import java.util.List;

import org.hackerthon.database.ResponsesDO;

import io.javalin.http.Context;

public class ReadResponseHandler {
   
    public static void purposeResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getPurposeQO().getQuestions();
        saveResponse(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataInEnterprisePurpose());
    }

    public static void conformanceResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getConformanceQO().getQuestions();
        saveResponse(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataConformance());
    }

    public static void sustainabilityResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getSustainabilityQO().getQuestions();
        saveResponse(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataInSustainability());
    }

    public static void performanceResponse(Context context){
        List<String>  questions = DataBaseHandler.getExcelParser().getPerformanceQO().getQuestions();
        saveResponse(context, questions);
        context.json(DataBaseHandler.getResponsesDAI().getAllDataInAccountabilityForPerformance());
    }

    public  static void saveResponse(Context context, List<String> questions){
        for (int index = 0; index < context.formParamMap().size(); index++) {
            ResponsesDO response = new ResponsesDO(context.
                    formParam(String.valueOf(index)), questions.get(index), context.formParam("role"));
            DataBaseHandler.getResponsesDAI().saveResponseEnterprisePurpose(response);
        }
    }
}
