package org.hackerthon.database;

import net.lemnik.eodsql.ResultColumn;

public class SidarResponsesDO {

    public String question;
    private int non_existent;
    private int minimal;
    private int some_elements;
    private int largely_in_place;


    private int fully_in_place;

    @ResultColumn("fully_in_place")
    public void setFully_in_place(int fully_in_place) {
        this.fully_in_place = fully_in_place;
    }

    @ResultColumn("largely_in_place")
    public void setLargely_in_place(int largely_in_place) {
        this.largely_in_place = largely_in_place;
    }

    @ResultColumn("non_existent")
    public void setNon_existent(int non_existent) {
        this.non_existent = non_existent;
    }

    @ResultColumn("some_elements")
    public void setSome_elements(int some_elements) {
        this.some_elements = some_elements;
    }

    @ResultColumn("minimal")
    public void setMinimal(int minimal) {
        this.minimal = minimal;
    }

    @ResultColumn("question")
    public void setQuestion(String question) {
        this.question = question;
    }

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
}
