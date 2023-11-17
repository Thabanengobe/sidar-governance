package org.hackerthon.questionDO;

import java.util.List;

public class SustainabilityDO {

    private final List<String> questions;

    public SustainabilityDO(List<String> questions)
    {
        this.questions = questions;
    }

    public List<String> getQuestions() {
        return questions;
    }
    
}
