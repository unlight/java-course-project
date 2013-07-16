package phonebook.entity;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author S
 */
abstract public class Entity {
 
    public abstract void attachResultSet(ResultSet set);
    
    public Object getProperty(String s) {
        try {
            Field field = getClass().getDeclaredField(s);
            return field.get(this);
        } catch (Exception ex) {
        }
        return null;
    }
}
