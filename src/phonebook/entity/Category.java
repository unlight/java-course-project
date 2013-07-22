package phonebook.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.Application;

/**
 * @author S
 */
public class Category extends Entity {

	private Integer CategoryID;
	private String Name;

	@Override
	public void attachResultSet(ResultSet set) {
		try {
			setCategoryID((Integer) set.getInt("CategoryID"));
			setName(set.getString("Name"));
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public Integer getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(Integer CategoryID) {
		this.CategoryID = CategoryID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
}