package phonebook.model;

import com.github.sqlbuilder.SelectQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonebook.Application;
import phonebook.entity.Entity;
import utils.SqlUtils;

abstract public class Model<T> {

    protected String name;
    protected String primaryKey;
    protected PreparedStatement pstatement;

    public Model(String name) {
	  this.name = name;
	  this.primaryKey = name + "ID";
    }
    
    public abstract Integer save(T entity);

    public T getId(int id) {
	  SelectQuery sql = new SelectQuery()
		    .addFrom(name)
		    .addWhere(this.primaryKey + " = " + id);
	  ResultSet resultSet = SqlUtils.getResultSet(sql);
	  T entity = null;
	  try {
		resultSet.next();
		entity = (T) Class.forName("phonebook.entity." + name).newInstance();
		((Entity) entity).attachResultSet(resultSet);
	  } catch (Exception ex) {
		Application.handleException(ex);
	  }
	  return entity;
    }

    public List<T> get() {
	  SelectQuery sql = new SelectQuery()
		    .addFrom(name);
	  ResultSet resultSet = SqlUtils.getResultSet(sql);
	  ArrayList result = new ArrayList();
	  if (resultSet != null) {
		try {
		    while (resultSet.next()) {
			  T row = (T) Class.forName("phonebook.entity." + name).newInstance();
			  ((Entity) row).attachResultSet(resultSet);
			  result.add(row);
		    }
		} catch (Exception ex) {
		    Application.handleException(ex);
		}
	  }
	  return result;
    }

    public int getCount() {
	  SelectQuery sql = new SelectQuery()
		    .addColumn("count(*) as count")
		    .addFrom(name);
	  Object cell = SqlUtils.getCell(sql);
	  return Integer.parseInt(cell.toString());
    }
}