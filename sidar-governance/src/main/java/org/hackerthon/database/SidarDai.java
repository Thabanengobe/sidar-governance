package org.hackerthon.database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.Collection;

public interface SidarDai extends BaseQuery {
    String COLUMNS = "(non_existent, minimal, some_elements,largely_in_place, fully_in_place)";

    @Update("CREATE TABLE ?{1}"+COLUMNS)
    void creteTable(String tableName);

    @Update("INSERT INTO ?{1}"+COLUMNS+"VALUES(?{1.question}, ?{1.non_existent}, ?{1.minimal}," +
            "?{1.some_elements}, ?{1.largely_in_place}, ?{fully_in_place})")
    void saveResponse(String tableName, SidarResponsesDO responsesDO);

    @Select("SELECT * ?{1} FROM WHERE question=?{2}")
    Collection<SidarResponsesDO> getDataByQuestion(String tableName, String question);

    @Select("SELECT * FROM ?{1}")
    Collection<SidarResponsesDO> getAllData(String tableName);
}
