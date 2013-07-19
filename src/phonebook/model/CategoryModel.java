package phonebook.model;

import com.github.sqlbuilder.InsertQuery;
import com.github.sqlbuilder.UpdateQuery;
import phonebook.entity.Category;
import utils.SqlUtils;

/**
 * @author S
 */
public class CategoryModel extends Model<Category> {
	
	public CategoryModel() {
		super("Category");
	}
	
	@Override
	public Integer insert(Category entity) {
		InsertQuery query = new InsertQuery(name)
				.columns("Name")
				.values(entity.Name);
		return SqlUtils.insert(query);
	}
	
	@Override
	public void update(Category entity) {
		UpdateQuery query = new UpdateQuery(name)
				.set("Name", entity.Name)
				.addWhere(this.primaryKey + "=" + getPrimaryKeyValue(entity));
		SqlUtils.update(query);
	}
}