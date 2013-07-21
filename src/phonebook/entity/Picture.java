package phonebook.entity;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonebook.Application;

/**
 * @author S
 */
public class Picture extends Entity {

	static Picture createFromFile(File pictureFile) {
		return new Picture(pictureFile);
	}
	private Integer PictureID;
	private Integer EntryID;
	private String File;
	private File fileObject;
	private File incomingFileObject;

	public Picture() {
	}

	public Picture(File fileObject) {
		this.incomingFileObject = fileObject;
	}

	public String getFileValue() {
		String result = fileObject.getName();
		return result;
	}

	@Override
	public void attachResultSet(ResultSet set) {
		try {
			PictureID = set.getInt("PictureID");
			EntryID = set.getInt("EntryID");
			File = set.getString("File");
			fileObject = new File("./pictures/" + File);
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
	}

	public Integer getEntryID() {
		return EntryID;
	}

	public File getFile() {
		if (fileObject == null) {
			return incomingFileObject;
		}
		return fileObject;
	}

	public Integer getPictureID() {
		return PictureID;
	}

	public void setEntryID(Integer EntryID) {
		this.EntryID = EntryID;
	}

	public File getIncomingFileObject() {
		return incomingFileObject;
	}
	
	public File getFileObject() {
		return fileObject;
	}

	public void setFile(File newFile) {
		this.fileObject = newFile;
	}

	public void setIncomingFileObject(File incomingFileObject) {
		this.incomingFileObject = incomingFileObject;
	}
}
