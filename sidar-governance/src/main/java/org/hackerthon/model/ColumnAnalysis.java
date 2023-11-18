package org.hackerthon.model;

import org.hackerthon.controllers.Categories;
import org.hackerthon.controllers.DataBaseHandler;
import org.hackerthon.database.ResponsesDO;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnAnalysis {

    public static int[] getAllColumnsStat(Collection<ResponsesDO> responses){
        return new int[]{filterByChoice(responses, 0), filterByChoice(responses, 1),
                filterByChoice(responses, 2), filterByChoice(responses, 3),
                filterByChoice(responses, 4)};
    }

    public static int filterByChoice(Collection<ResponsesDO> responses, int choiceIndex) {

        String[] CHOICES = {"Non-Existent", "Minimal",
                "Some Elements", "Largely in Place", "Fully in Place"};

        return responses.stream()
                .map(ResponsesDO::getChoice)
                .filter((choice)-> CHOICES[choiceIndex].equals(choice))
                .toList().size();
    }

    public HashMap<String, Collection<ResponsesDO>> filterByQuestion(List<String> questionDO){
        HashMap<String, Collection<ResponsesDO>> questions = new HashMap<>();
        questionDO.iterator()
                .forEachRemaining((question)->{
                    questions.put(question, DataBaseHandler.getResponsesDAI().getDataByQuestion(question));
                });
        return questions;
    }

    public HashMap<String, Collection<ResponsesDO>> filterByCategory(){

        HashMap<String, Collection<ResponsesDO>> categoriesData = new HashMap<>();
        String[] categories = {Categories.SUSTAINABILITY.name(), Categories.PURPOSE.name()
        ,Categories.PERFORMANCE.name(), Categories.CONFORMANCE.name()};

        for (String category:categories){
            categoriesData.put(category, DataBaseHandler.getResponsesDAI().getDataByCategory(category));
        }

        return categoriesData;
    }
}
