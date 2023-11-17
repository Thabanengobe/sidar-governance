package org.hackerthon.controllers;

import net.lemnik.eodsql.QueryTool;
import org.hackerthon.database.ResponsesDAI;
import org.hackerthon.database.ResponsesDO;
import org.hackerthon.model.AnalysisData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler{

    private final static String fileName = System.getProperty("user.dir")
            +"/src/main/java/org/hackerthon/database/sidardb.sqlite";
    private final static ResponsesDAI RESPONSES_DAI;

    static {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:sqlite:"+fileName);
            RESPONSES_DAI = QueryTool.getQuery(connection, ResponsesDAI.class);
            RESPONSES_DAI.createCategoryEnterprisePurpose();
            RESPONSES_DAI.createCategoryAccountabilityForPerformance();
            RESPONSES_DAI.createCategorySustainability();
            RESPONSES_DAI.createCategoryConformance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponsesDAI getResponsesDaiDAI() {
        return RESPONSES_DAI;
    }

    public static void main(String[] args) {
        ResponsesDO responsesDO = new ResponsesDO();
        ResponsesDAI dai = DataBaseHandler.getResponsesDaiDAI();

    }
}
