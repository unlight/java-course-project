package phonebook.model;

import com.github.sqlbuilder.InsertQuery;
import com.github.sqlbuilder.UpdateQuery;
import java.io.File;
import java.io.IOException;
import phonebook.Application;
import phonebook.entity.Picture;
import utils.FileUtils;
import utils.SqlUtils;

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
		File newFile = new File("./pictures/" + entryID + "." + FileUtils.getExtension(incomingFile));
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
	
	@Override
	public void delete(int id) {
		Picture p = this.getId(id);
		delete(p);
	}
	
	public void delete(Picture p) {
		if (p == null) {
			return;
		}
		File file = p.getFileObject();
		if (file.exists()) {
			file.delete();
		}
		super.delete(p.getPictureID());
	}
}
