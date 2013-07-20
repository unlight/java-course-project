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
                .values(entity.getFirstName(), entity.getLastName(), entity.getPhone(), entity.getBirthDate(), entity.getCategoryID(), "@datetime('Now')", "@datetime('Now')");
        return SqlUtils.insert(query);
    }

    public void update(Entry entity) {
        UpdateQuery query = new UpdateQuery(name)
                .set("FirstName", entity.getFirstName())
                .set("LastName", entity.getLastName())
                .set("Phone", entity.getPhone())
                .set("BirthDate", entity.getBirthDate().toString())
                .set("CategoryID", entity.getCategoryID())
                .set("DateUpdated", "@datetime('Now')")
                .addWhere("EntryID = " + entity.getEntryID());
		System.out.println("update: " + query);
        SqlUtils.update(query);
    }
}