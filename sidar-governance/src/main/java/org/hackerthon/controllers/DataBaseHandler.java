package org.hackerthon.controllers;

import net.lemnik.eodsql.QueryTool;
import org.hackerthon.database.ResponsesDAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler{

    private final static String fileName = System.getProperty("user.dir")
            +"org/hackerthon/database/sidar.sqlite";
    private final static ResponsesDAI RESPONSES_DAI;

    static {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:sqlite:"+fileName);
            RESPONSES_DAI = QueryTool.getQuery(connection, ResponsesDAI.class);
            RESPONSES_DAI.creteTable("EnterprisePurpose");
            RESPONSES_DAI.creteTable("AccountabilityForPerformance");
            RESPONSES_DAI.creteTable("Sustainability");
            RESPONSES_DAI.creteTable("Conformance");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponsesDAI getResponsesDaiDAI() {
        return RESPONSES_DAI;
    }
}
