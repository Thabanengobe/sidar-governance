package org.hackerthon.questionDO;

import java.util.List;

public class PerformanceDO {
    private final List<String> questions;
    public PerformanceDO(List<String> questions)
    {
        this.questions = questions;
    }

    public List<String> getQuestions() {
        return questions;
    }
    
}
