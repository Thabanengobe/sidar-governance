package org.hackerthon.questionDO;

import java.util.List;

public class ConformanceDO {

    private final List<String> questions;
     public ConformanceDO(List<String> questions)
     {
         this.questions = questions;
     }

    public List<String> getQuestions() {
        return this.questions;
    }
    
 }
