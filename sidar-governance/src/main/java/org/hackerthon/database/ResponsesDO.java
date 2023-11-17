package org.hackerthon.database;

import net.lemnik.eodsql.ResultColumn;

public class ResponsesDO {

    private static String question;
    private static int non_existent;
    private static int minimal;
    private static int some_elements;
    private static int largely_in_place;

    private int fully_in_place;

    public String getQuestion() {
        return question;
    }

    public int getLargely_in_place() {
        return largely_in_place;
    }

    public int getMinimal() {
        return minimal;
    }

    public int getNon_existent() {
        return non_existent;
    }

    public int getSome_elements() {
        return some_elements;
    }

    public int getFully_in_place() {
        return fully_in_place;
    }

    @ResultColumn(value = "questions")
    public void setQuestion(String question) {
        ResponsesDO.question = question;
    }
    @ResultColumn(value = "fully_in_place")
    public void setFully_in_place(int fully_in_place) {
        this.fully_in_place = fully_in_place;
    }

    @ResultColumn(value = "largely_in_place")
    public void setLargely_in_place(int largely_in_place) {
        ResponsesDO.largely_in_place = largely_in_place;
    }

    @ResultColumn(value = "non_existent")
    public void setNon_existent(int non_existent) {
        ResponsesDO.non_existent = non_existent;
    }

    @ResultColumn(value = "some_elements")
    public void setSome_elements(int some_elements) {
        ResponsesDO.some_elements = some_elements;
    }

    @ResultColumn(value = "minimal")
    public void setMinimal(int minimal) {
        ResponsesDO.minimal = minimal;
    }



}
