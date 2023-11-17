package org.hackerthon.controllers;

import net.lemnik.eodsql.QueryTool;
import org.hackerthon.database.SidarDai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HandleFormSubmission {
    private final static String fileName = System.getProperty("user.dir")
            +"org/hackerthon/database/sidar.sqlite";
    private final static SidarDai sidarDai;
    static {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:sqlite:"+fileName);
            sidarDai = QueryTool.getQuery(SidarDai.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
