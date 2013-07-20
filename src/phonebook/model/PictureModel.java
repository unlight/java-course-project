package phonebook.model;

import com.github.sqlbuilder.InsertQuery;
import com.github.sqlbuilder.UpdateQuery;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonebook.Application;
import phonebook.entity.Entry;
import phonebook.entity.Picture;
import utils.SqlUtils;
import utils.StringUtils;

/**
 *
 * @author S
 */
public class PictureModel extends Model<Picture> {

	public PictureModel() {
		super("Picture");
	}

	@Override
	public Integer insert(Picture entity) {
		InsertQuery query = new InsertQuery(name)
				.columns("EntryID", "File")
				.values(entity.getEntryID(), entity.getFileValue());
		System.out.println("PictureModel.insert: " + query);
		return SqlUtils.insert(query);
	}

	@Override
	public void update(Picture entity) {
		UpdateQuery query = new UpdateQuery(name)
				.set("EntryID", entity.getEntryID())
				.set("File", entity.getFileValue())
				.addWhere("PictureID = " + entity.getPictureID());
		System.out.println("PictureModel.update: " + query);
		SqlUtils.update(query);
	}

	@Override
	public Integer save(Picture entity) {
		saveFile(entity);
		return super.save(entity);
	}

	protected void saveFile(Picture entity) {
		File incomingFile = entity.getIncomingFileObject();
		Integer entryID = entity.getEntryID();
		File newFile = new File("./pictures/" + entryID + "." + StringUtils.getExtension(incomingFile));
		File picturesDirectory = new File(newFile.getParent());
		if (!picturesDirectory.exists()) {
			picturesDirectory.mkdirs();
		}
		try {
			SqlUtils.copyFile(incomingFile, newFile);
		} catch (IOException ex) {
			Application.handleException(ex);
		}
		entity.setFile(newFile);
		entity.setIncomingFileObject(newFile);
	}
}
