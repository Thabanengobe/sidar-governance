package org.hackerthon.model;

import org.hackerthon.database.ResponsesDO;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class AnalysisData {

    private final  static String[] CHOICES = {"Non-Existent", "Minimal", "Some Elements", "Largely in Place", "Fully in Place"};
    public static int filterByChoice(Collection<ResponsesDO> responses, int choiceIndex) {

        return responses.stream()
                .map(ResponsesDO::getChoice)
                .filter((choice)-> CHOICES[choiceIndex].equals(choice))
                .toList().size();
    }

    public static Collection<ResponsesDO> filterByRole(Collection<ResponsesDO> responses,String role){
        return responses.stream()
                .filter((response)->response.getRole().equals(role))
                .collect(Collectors.toList());
    }
    public static   boolean isChoiceTheSame(String userChoice){
        return Arrays.asList(CHOICES).contains(userChoice);
    }

}
