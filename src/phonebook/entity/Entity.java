package phonebook.entity;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import phonebook.Application;

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
            Application.handleException(ex);
        }
        return null;
    }
}
