package phonebook.model;

import com.github.sqlbuilder.InsertQuery;
import com.github.sqlbuilder.SelectQuery;
import com.github.sqlbuilder.UpdateQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonebook.Application;
import phonebook.entity.Category;
import utils.SqlUtils;

/**
 * @author S
 */
public class CategoryModel extends Model<Category> {

	public CategoryModel() {
		super("Category");
	}

	public Category create(String name) {
		Category c = new Category();
		c.setName(name);
		int id = this.save(c);
		return getId(id);
	}

	public Category getByName(String s) {
		String query = new SelectQuery()
				.addFrom(name)
				.addWhere("Name = ?")
				.toString();
		PreparedStatement prepareStatement;
		Category Category = null;
		try {
			prepareStatement = Application.connection().prepareStatement(query);
			prepareStatement.setString(1, s);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				Category = new Category();
				Category.attachResultSet(resultSet);
			}
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
		return Category;
	}

	@Override
	public Integer insert(Category entity) {
		InsertQuery query = new InsertQuery(name)
				.columns("Name")
				.values(entity.getName());
		return SqlUtils.insert(query);
	}

	@Override
	public void update(Category entity) {
		UpdateQuery query = new UpdateQuery(name)
				.set("Name", entity.getName())
				.addWhere(this.primaryKey + "=" + getPrimaryKeyValue(entity));
		SqlUtils.update(query);
	}
}