package phonebook.entity;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.Application;
import phonebook.model.CategoryModel;
import phonebook.model.PictureModel;

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
	protected Integer PictureID = null;
	protected Picture Picture = null;
	CategoryModel categoryModel = new CategoryModel();
	private Category category;

	@Override
	public void attachResultSet(ResultSet set) {
		try {
			setEntryID((Integer) set.getInt("EntryID"));
			FirstName = set.getString("FirstName");
			LastName = set.getString("LastName");
			BirthDate = Date.fromString(set.getString("BirthDate"));
			Phone = set.getString("Phone");
			setCategory(set.getInt("CategoryID"));
			Integer x = set.getInt("PictureID");
			if (x == 0) {
				x = null;
			}
			setPictureID(x);
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

	public Category getCategory() {
		if (category == null && CategoryID != null) {
			category = categoryModel.getId(CategoryID);
		}
		return category;
	}

	public void setCategory(Category selectedCategory) {
		category = selectedCategory;
		if (category != null) {
			setCategory(category.getCategoryID());
		}
	}

	public void setCategory(Integer c) {
		if (c != null && c == 0) {
			c = null;
		}
		CategoryID = c;
		if (category == null) {
			category = getCategory();
		}
	}

	public Integer getEntryID() {
		return EntryID;
	}

	public void setEntryID(Integer EntryID) {
		this.EntryID = EntryID;
	}
	PictureModel pictureModel = new PictureModel();

	public Integer getPictureID() {
		if (getPicture() != null) {
			return getPicture().getPictureID();
		}
		return null;
	}

	public Picture getPicture() {
		if (Picture == null && PictureID != null) {
			Picture = pictureModel.getId(PictureID);
		}
		return Picture;
	}

	public void setPicture(Picture picture) {
		this.Picture = picture;
	}

	private void setPictureID(Integer aInt) {
		PictureID = aInt;
	}

	public File getPictureFile() {
		if (getPicture() != null) {
			return getPicture().getFile();
		}
		return null;
	}

	public void reset() {
		setPicture(null);
	}
}