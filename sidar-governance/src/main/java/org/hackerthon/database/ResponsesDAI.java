package org.hackerthon.database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.Collection;

public interface ResponsesDAI extends BaseQuery {
    String COLUMNS = "(questions, choices, roles)";
    String VALUES = " VALUES(?{1.question}, ?{1.choice}, ?{1.role})";
    @Update("CREATE TABLE IF NOT EXISTS EnterprisePurpose"+COLUMNS)
    void createCategoryEnterprisePurpose();

    @Update("CREATE TABLE IF NOT EXISTS AccountabilityForPerformance"+COLUMNS)
    void createCategoryAccountabilityForPerformance();
    @Update("CREATE TABLE IF NOT EXISTS Sustainability"+COLUMNS)
    void createCategorySustainability();
    @Update("CREATE TABLE IF NOT EXISTS Conformance"+COLUMNS)
    void createCategoryConformance();

    @Update("INSERT INTO Sustainability"+COLUMNS+VALUES)
    void saveResponseSustainability(ResponsesDO responsesDO);

    @Update("INSERT INTO Conformance"+COLUMNS+VALUES)
    void saveResponseConformance(ResponsesDO responsesDO);

    @Update("INSERT INTO AccountabilityForPerformance"+COLUMNS+VALUES)
    void saveResponseAccountabilityForPerformance(ResponsesDO responsesDO);

    @Update("INSERT INTO Sustainability"+COLUMNS+VALUES)
    void saveResponseEnterprisePurpose(ResponsesDO responsesDO);

    @Select("SELECT * FROM EnterprisePurpose WHERE question=?{1}")
    Collection<ResponsesDO> getDataByQuestionInEnterprisePurpose(String question);

    @Select("SELECT *  FROM AccountabilityForPerformance WHERE question=?{1}")
    Collection<ResponsesDO> getDataByQuestionInAccountabilityForPerformance(String question);

    @Select("SELECT * FROM Sustainability  WHERE question=?{1}")
    Collection<ResponsesDO> getDataByQuestionInSustainability(String question);

    @Select("SELECT * FROM Conformance WHERE question=?{1}")
    Collection<ResponsesDO> getDataByQuestionInConformance(String question);


    @Select("SELECT * FROM EnterprisePurpose")
    Collection<ResponsesDO> getAllDataInEnterprisePurpose();

    @Select("SELECT * FROM Sustainability ")
    Collection<ResponsesDO> getAllDataInSustainability();

    @Select("SELECT * FROM EnterprisePurpose")
    Collection<ResponsesDO> getAllDataConformance();

    @Select("SELECT * FROM AccountabilityForPerformance")
    Collection<ResponsesDO> getAllDataInAccountabilityForPerformance();
}
