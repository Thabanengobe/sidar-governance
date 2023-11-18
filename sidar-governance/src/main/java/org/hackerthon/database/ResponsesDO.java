package org.hackerthon.database;


import net.lemnik.eodsql.ResultColumn;

public class ResponsesDO {

    @ResultColumn(value = "questions")
    private  String question;
    @ResultColumn(value = "categories")
    private String category;
    @ResultColumn(value = "choices")
    private  String choice;

    @ResultColumn(value = "roles")
    private  String role;

    public String getQuestion() {
        return question;
    }
    public String getCategory() {
        return category;
    }

    public String getChoice(){
        return choice;
    }

    public String getRole(){
        return role;
    }
    public ResponsesDO(){}

    public  void setQuestion(String question) {
        this.question = question;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
