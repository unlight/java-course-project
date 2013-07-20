package phonebook.model;

import com.github.sqlbuilder.InsertQuery;
import com.github.sqlbuilder.UpdateQuery;
import phonebook.entity.Entry;
import utils.SqlUtils;

/**
 * @author S
 */
public class EntryModel extends Model<Entry> {

    public EntryModel() {
        super("Entry");
    }

    public Integer insert(Entry entity) {
        InsertQuery query = new InsertQuery(name)
                .columns("FirstName", "LastName", "Phone", "BirthDate", "CategoryID", "DateInserted", "DateUpdated")
                .values(entity.FirstName, entity.LastName, entity.Phone, entity.BirthDate, entity.CategoryID, "@datetime('Now')", "@datetime('Now')");
        return SqlUtils.insert(query);
    }

    public void update(Entry entity) {
        UpdateQuery query = new UpdateQuery(name)
                .set("FirstName", entity.FirstName)
                .set("LastName", entity.LastName)
                .set("Phone", entity.Phone)
                .set("BirthDate", entity.BirthDate.toString())
                .set("CategoryID", entity.CategoryID.toString())
                .set("DateUpdated", "@datetime('Now')")
                .addWhere("EntryID = " + entity.EntryID);
        SqlUtils.update(query);
    }
}