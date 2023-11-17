package org.hackerthon.database;

import net.lemnik.eodsql.ResultColumn;

public class ResponsesDO {

    @ResultColumn(value = "questions")
    private static String question;

    @ResultColumn(value = "choices")
    private static String choice;

    @ResultColumn(value = "roles")
    private static String role;

    public String getQuestion() {
        return question;
    }


    public String getChoice(){
        return choice;
    }

    public String getRole(){
        return role;
    }

    public ResponsesDO(String choice, String question, String role){
        ResponsesDO.choice = choice;
        ResponsesDO.question = question;
        ResponsesDO.role = role;
    }
}
