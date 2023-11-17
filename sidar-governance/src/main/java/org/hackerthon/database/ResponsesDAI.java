package org.hackerthon.database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.Collection;

public interface ResponsesDAI extends BaseQuery {
    String COLUMNS = "(questions, non_existent, minimal, some_elements,largely_in_place, fully_in_place)";
    @Update("CREATE TABLE IF NOT EXISTS EnterprisePurpose"+COLUMNS)
    void createCategoryEnterprisePurpose();

    @Update("CREATE TABLE IF NOT EXISTS AccountabilityForPerformance"+COLUMNS)
    void createCategoryAccountabilityForPerformance();
    @Update("CREATE TABLE IF NOT EXISTS Sustainability"+COLUMNS)
    void createCategorySustainability();
    @Update("CREATE TABLE IF NOT EXISTS Conformance"+COLUMNS)
    void createCategoryConformance();

    @Update("INSERT INTO Sustainability"+COLUMNS+" VALUES(?{1.question}, ?{1.non_existent}, ?{1.minimal}," +
            "?{1.some_elements}, ?{1.largely_in_place}, ?{1.fully_in_place})")
    void saveResponseSustainability(ResponsesDO responsesDO);

    @Update("INSERT INTO Conformance"+COLUMNS+" VALUES(?{1.question}, ?{1.non_existent}, ?{1.minimal}," +
            "?{1.some_elements}, ?{1.largely_in_place}, ?{1.fully_in_place})")
    void saveResponseConformance(ResponsesDO responsesDO);

    @Update("INSERT INTO AccountabilityForPerformance"+COLUMNS+" VALUES(?{1.question}, ?{1.non_existent}, ?{1.minimal}," +
            "?{1.some_elements}, ?{1.largely_in_place}, ?{1.fully_in_place})")
    void saveResponseAccountabilityForPerformance(ResponsesDO responsesDO);

    @Update("INSERT INTO Sustainability"+COLUMNS+" VALUES(?{1.question}, ?{1.non_existent}, ?{1.minimal}," +
            "?{1.some_elements}, ?{1.largely_in_place}, ?{1.fully_in_place})")
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
