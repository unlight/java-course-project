package phonebook;

import utils.StringUtils;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;

public class Structure {

    private Connection connection;
    private HashMap<String, String[]> structure = new HashMap() {
	  {
		put("Entry", new String[]{
		    "EntryID integer primary key autoincrement",
		    "FirstName text",
		    "LastName text",
		    "Phone text",
		    "BirthDate text",
		    "DateInserted text not null",
		    "CategoryID integer constraint FK_Category_CategoryID references Category(CategoryID)"});
		put("Category", new String[]{
		    "CategoryID integer primary key autoincrement",
		    "Name text not null constraint UX_Category_Name unique on conflict replace"
		});
	  }
    };

    public Structure(Connection connection) {
	  this.connection = connection;
    }

    public ResultSet query(String sql) throws SQLException {
	  ResultSet resultSet = connection.createStatement().executeQuery(sql);
	  return resultSet;
    }

    public ArrayList<String> getColumns(String table) {
	  ArrayList<String> result = new ArrayList<String>();
	  try {
		String query = "PRAGMA table_info('" + table + "')";
		ResultSet resultSet = query(query);
		while (resultSet.next()) {
		    String name = resultSet.getString("name");
		    result.add(name);
		}
	  } catch (SQLException ex) {
		Application.handleException(ex);
	  }
	  return result;
    }

    private ArrayList<String> getTables() throws SQLException {
	  ArrayList<String> result = new ArrayList<String>();
	  ResultSet resultSet = query("select name from sqlite_master where type = 'table'");
	  while (resultSet.next()) {
		String name = resultSet.getString("name");
		result.add(name);
	  }
	  return result;
    }

    public void update() {
	  ArrayList<String> databaseTables;
	  boolean isFirstRun = false;
	  try {
		databaseTables = this.getTables();
		isFirstRun = databaseTables.isEmpty();
		for (String table : structure.keySet()) {
		    if (!databaseTables.contains(table)) {
			  this.createTable(table);
		    } else {
			  this.updateTable(table);
		    }
		}
		if (isFirstRun) {
		}
	  } catch (SQLException ex) {
		Application.handleException(ex);
	  }
    }

    private void updateTable(String table) throws SQLException {
	  String[] columns = structure.get(table);
	  ArrayList<String> tableColumns = getColumns(table);
	  for (String columnDefinition : columns) {
		String name = columnDefinition.split(" ")[0];
		if (!tableColumns.contains(name)) {
		    addColumn(table, columnDefinition);
		}
	  }
    }

    private boolean addColumn(String table, String columnDefinition) throws SQLException {
	  boolean result = connection.createStatement()
		    .execute("alter table `" + table + "` add " + columnDefinition + "");
	  return result;
    }

    public void create() throws SQLException {
	  for (Map.Entry<String, String[]> entry : structure.entrySet()) {
		String table = entry.getKey();
		createTable(table);
	  }
    }

    private void createTable(String table) throws SQLException {
	  String[] columns = structure.get(table);
	  connection.createStatement().execute("create table `" + table + "`(" + StringUtils.join(columns, ", ") + ")");
    }
}