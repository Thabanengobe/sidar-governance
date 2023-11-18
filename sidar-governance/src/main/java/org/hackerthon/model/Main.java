package org.hackerthon.model;

import io.javalin.http.Context;
import org.hackerthon.controllers.Categories;
import org.hackerthon.controllers.DataBaseHandler;
import org.hackerthon.database.ResponsesDO;
import org.hackerthon.questionDO.PurposeDO;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(Context context) {

        List<String> purposeDOS = DataBaseHandler.getExcelParser().getPurposeQO().getQuestions();
        HashMap<String, Collection<ResponsesDO>> dos = ColumnAnalysis.filterByQuestion(purposeDOS);

        HashMap<String, int[]> questionsScore = new HashMap<>();
        int total = 0;
        for (String queston: purposeDOS){
            Collection<ResponsesDO> bv = dos.get(queston);
            if(total == 0) total += bv.size();
            questionsScore.put(queston, ColumnAnalysis.getAllColumnsStat(bv));
        }
        int NonExistent = 0;
        int Minimal = 0;
        int SomeElements = 0;
        int LargelyInPlace = 0;
        int FullyInPlace = 0;
        System.out.println(total);
        for (String question:questionsScore.keySet()){
            int[] data = questionsScore.get(question);
            System.out.println(Arrays.toString(data));
            NonExistent += data[0];
            Minimal += data[1];
            SomeElements += data[2];
            LargelyInPlace += data[3];
        }
        System.out.println(Minimal);
        double pecent = ((double) (NonExistent) / (total*14))*100;
        double pecent1 = ((double) (Minimal) / (total*14))*100;
        double pecent2 = ((double) (SomeElements) / (total*14))*100;
        double pecent3 = ((double) (LargelyInPlace) / (total*14))*100;
        String[] CHOICES = {"Non-Existent", "Minimal",
                "Some Elements", "Largely in Place", "Fully in Place"};
        context.json(" "+CHOICES[0]+":"+pecent+"\n"+CHOICES[1]+":"+pecent1+"\n"+CHOICES[2]+":"+pecent2+"\n");
    }
}
