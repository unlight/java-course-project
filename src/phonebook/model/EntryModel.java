package phonebook.model;

import com.github.sqlbuilder.InsertQuery;
import com.github.sqlbuilder.UpdateQuery;
import phonebook.entity.Category;
import phonebook.entity.Entry;
import phonebook.entity.Picture;
import utils.SqlUtils;

/**
 * @author S
 */
public class EntryModel extends Model<Entry> {

    public EntryModel() {
        super("Entry");
    }

    @Override
    public Integer save(Entry entry) {
        Category category = entry.getCategory();
        return super.save(entry);
    }

    @Override
    public Integer insert(Entry entity) {
        InsertQuery query = new InsertQuery(name)
                .columns("FirstName", "LastName", "Phone", "BirthDate", "CategoryID", "DateInserted", "DateUpdated")
                .values(entity.getFirstName(), entity.getLastName(), entity.getPhone(), entity.getBirthDate(), entity.getCategoryID(), "@datetime('Now')", "@datetime('Now')");
        return SqlUtils.insert(query);
    }
    
    PictureModel pictureModel = new PictureModel();
    CategoryModel categoryModel = new CategoryModel();

    @Override
    public void update(Entry entity) {
        SqlUtils.transaction();
        Picture picture = entity.getPicture();
        Integer pictureID = null;
        if (picture != null) {
            picture.setEntryID(entity.getEntryID());
            pictureID = pictureModel.save(picture);
        }
        UpdateQuery query = new UpdateQuery(name)
                .set("FirstName", entity.getFirstName())
                .set("LastName", entity.getLastName())
                .set("Phone", entity.getPhone())
                .set("BirthDate", entity.getBirthDate().toString())
                .set("CategoryID", entity.getCategoryID())
                .set("DateUpdated", "@datetime('Now')")
                .set("PictureID", pictureID)
                .addWhere("EntryID = " + entity.getEntryID());
        SqlUtils.update(query);
        SqlUtils.commit();
    }

    @Override
    public void delete(int id) {
        SqlUtils.transaction();
        Entry entry = this.getId(id);
        Picture picture = entry.getPicture();
        pictureModel.delete(picture);
		super.delete(id);
        // Delete empty category.
        Integer CategoryID = entry.getCategoryID();
        if (CategoryID != null) {
            int count = getCountWhere("CategoryID", CategoryID);
            if (count == 0) {
                categoryModel.delete(CategoryID);
            }
        }
        SqlUtils.commit();
    }
}