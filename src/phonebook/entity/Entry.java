package phonebook.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.Application;

/**
 * @author S
 */
public class Entry extends Entity {

	private Integer EntryID;
	public String FirstName;
	public String LastName;
	public String Phone;
	public Date BirthDate;
	protected Integer CategoryID;

	@Override
	public void attachResultSet(ResultSet set) {
		try {
			setEntryID((Integer) set.getInt("EntryID"));
			FirstName = set.getString("FirstName");
			LastName = set.getString("LastName");
			BirthDate = Date.fromString(set.getString("BirthDate"));
			Phone = set.getString("Phone");
			setCategory(set.getInt("CategoryID"));
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getPhone() {
		return Phone;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public Integer getCategoryID() {
		return CategoryID;
	}

	public void setCategory(Category selectedCategory) {
		setCategory(selectedCategory.CategoryID);
	}

	public void setCategory(Integer c) {
		if (c == 0) {
			c = null;
		}
		CategoryID = c;
	}

	public Integer getEntryID() {
		return EntryID;
	}

	public void setEntryID(Integer EntryID) {
		this.EntryID = EntryID;
	}
}