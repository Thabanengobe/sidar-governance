package org.hackerthon.database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.Collection;

public interface SidarDai extends BaseQuery {
    String COLUMNS = "(non_existent, minimal, some_elements,largely_in_place, fully_in_place)";

    @Update("CREATE TABLE ?{1}"+COLUMNS)
    void creteTable(String tableName);

    @Select("SELECT * ?{1} FROM WHERE question=?{2}")
    Collection<SidarResponsesDO> getDataByQuestion(String tableName, String question);
}
