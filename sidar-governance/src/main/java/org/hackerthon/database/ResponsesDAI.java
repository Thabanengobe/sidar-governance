package org.hackerthon.database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.Collection;

public interface ResponsesDAI extends BaseQuery {
    String COLUMNS = "(categories, questions, choices, roles)";
    String VALUES = " VALUES(?{1.category},?{1.question}, ?{1.choice}, ?{1.role})";

    @Update("CREATE TABLE IF NOT EXISTS DataAnalysis"+COLUMNS)
    void createTable();

    @Update("INSERT INTO DataAnalysis"+COLUMNS+VALUES)
    void saveResponse(ResponsesDO responsesDO);

    @Select("SELECT * FROM DataAnalysis WHERE question=?{1}")
    Collection<ResponsesDO> getDataByQuestion(String question);

    @Select("SELECT * FROM DataAnalysis  WHERE categories=?{1}")
    Collection<ResponsesDO> getDataByCategory(String category);

    @Select("SELECT * FROM DataAnalysis WHERE roles=?{1}")
    Collection<ResponsesDO> getDataByRole(String role);
    
    @Select("SELECT * FROM DataAnalysis")
    Collection<ResponsesDO> getAllData();
}
