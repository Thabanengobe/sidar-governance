package org.hackerthon.database;

import net.lemnik.eodsql.ResultColumn;

public class ResponsesDO {

    private static String question;
    private static String choice;
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

    @ResultColumn(value = "questions")
    public void setQuestion(String question) {
        ResponsesDO.question = question;
    }

    @ResultColumn(value = "roles")
    public void setRole(String role){
        ResponsesDO.role = role;
    }
    @ResultColumn(value = "choices")
    public void setChoice(String choice) {
        ResponsesDO.choice = choice;
    }

}
