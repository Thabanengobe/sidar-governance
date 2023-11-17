package org.hackerthon.database;

import java.sql.*;

public class Sidar {
    private  static Connection connection;
    private final static String COLUMNS = "(non_existent, minimal, some_elements,largely_in_place, fully_in_place)";
    private static String fileName = System.getProperty("user.dir") +"/sidar.sqlite";

    static {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+fileName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE EnterprisePurpose"+COLUMNS);
        statement.execute("CREATE TABLE AccountabilityForPerformance"+COLUMNS);
        statement.execute("CREATE TABLE Sustainability"+COLUMNS);
        statement.execute("CREATE TABLE Conformance"+COLUMNS);
    }
//    mvn install:install-file -Dfile=libs/eodsql.jar -DgroupId=net.lemnik -DartifactId=eodsql -Dversion=2.2 -Dpackaging=jar
    public int getColumnData(String table, String column) throws SQLException {
        Statement statement= connection.createStatement();
        String sql = String.format("SELECT %s FROM %s", table, column);
        boolean dataAvailable = statement.execute(sql);
        if(dataAvailable){
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){

            }
        }
        return 0;
    }
}
