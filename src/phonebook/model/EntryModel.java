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

	@Override
	public Integer save(Entry entity) {
		if (entity.EntryID == null) {
			return this.insert(entity);
		} else {
			this.update(entity);
			return entity.EntryID;
		}
	}

	private Integer insert(Entry entity) {
		InsertQuery query = new InsertQuery(name)
				.columns("FirstName", "LastName", "Phone", "BirthDate", "CategoryID")
				.values(entity.FirstName, entity.LastName, entity.Phone, entity.BirthDate, entity.CategoryID);
		return SqlUtils.insert(query);
	}

	private void update(Entry entity) {
		UpdateQuery query = new UpdateQuery(name)
				.set("FirstName", entity.FirstName)
				.set("LastName", entity.LastName)
				.set("Phone", entity.Phone)
				.set("BirthDate", entity.BirthDate.toString())
				.set("CategoryID", entity.CategoryID.toString())
				.addWhere("EntryID = " + entity.EntryID);
		SqlUtils.update(query);
	}
}