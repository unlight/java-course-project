package phonebook.entity;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.Application;

/**
 * @author S
 */
public class Entry extends Entity {

    public Integer EntryID;
    public String FirstName;
    public String LastName;
    public String Phone;
    public Date BirthDate;
    public Integer CategoryID;

    @Override
    public void attachResultSet(ResultSet set) {
	  try {
		EntryID = set.getInt("EntryID");
		FirstName = set.getString("FirstName");
		LastName = set.getString("LastName");
		BirthDate = set.getDate("BirthDate");
		Phone = set.getString("Phone");
		CategoryID = set.getInt("CategoryID");
	  } catch (SQLException ex) {
		Application.handleException(ex);
	  }
    }
}