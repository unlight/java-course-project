package phonebook.entity;

import java.sql.ResultSet;

/**
 * @author S
 */
abstract public class Entity {
 
    abstract void attachResultSet(ResultSet set);
}
