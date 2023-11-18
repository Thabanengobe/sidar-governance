package org.hackerthon.controllers;

import net.lemnik.eodsql.QueryTool;
import org.hackerthon.database.ResponsesDAI;
import org.hackerthon.excel_parser.ExcelParser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler{

    private final static String fileName = System.getProperty("user.dir")
            +"/src/main/java/org/hackerthon/database/sidardb.sqlite";
    private final static  ExcelParser PARSER;
    private final static ResponsesDAI RESPONSES;

    static {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:sqlite:"+fileName);
            RESPONSES = QueryTool.getQuery(connection, ResponsesDAI.class);
            RESPONSES.createTable();
            PARSER = new ExcelParser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponsesDAI getResponsesDAI() {
        return RESPONSES;
    }

    public static ExcelParser getExcelParser(){
        return PARSER;
    }
}
