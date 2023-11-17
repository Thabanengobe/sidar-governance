package org.hackerthon.model;

import org.hackerthon.database.ResponsesDO;

import java.util.Collection;

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
}
