package phonebook.entity;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import phonebook.Application;

/**
 * @author S
 */
abstract public class Entity {

	public abstract void attachResultSet(ResultSet set);

	public Object getProperty(String s) {
		try {
			Method declaredMethod = getClass().getDeclaredMethod("get" + s);
			Object invoke = declaredMethod.invoke(this);
			return invoke;
		} catch (Exception ex) {
			Application.handleException(ex);
		}
		return null;
	}
}
