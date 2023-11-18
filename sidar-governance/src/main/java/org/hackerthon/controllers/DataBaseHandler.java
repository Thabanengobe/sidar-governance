package org.hackerthon.controllers;

import net.lemnik.eodsql.QueryTool;
import org.hackerthon.database.ResponsesDAI;
import org.hackerthon.database.ResponsesDO;
import org.hackerthon.excel_parser.ExcelParser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class DataBaseHandler{

    private final static String fileName = System.getProperty("user.dir")
            +"/src/main/java/org/hackerthon/database/sidardb.sqlite";
    private final static  ExcelParser PARSER;
    private final static ResponsesDAI RESPONSES_DAI;

    static {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:sqlite:"+fileName);
            RESPONSES_DAI = QueryTool.getQuery(connection, ResponsesDAI.class);
            RESPONSES_DAI.createTable();
            PARSER = new ExcelParser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponsesDAI getResponsesDAI() {
        return RESPONSES_DAI;
    }

    public static ExcelParser getExcelParser(){
        return PARSER;
    }

    public static void main(String[] args) {
        ResponsesDO responsesDO = new ResponsesDO();
        responsesDO.setChoice("Minimal");
        responsesDO.setRole("CEO");
        responsesDO.setQuestion("Haibo");
        responsesDO.setCategory(Categories.CONFORMANCE.name());
        DataBaseHandler
                .getResponsesDAI()
                .saveResponse(responsesDO);

        Collection<ResponsesDO> db =DataBaseHandler.getResponsesDAI().getAllData();
        db.iterator().forEachRemaining((data)->{
            System.out.println(data.getCategory());
        });

    }
}
