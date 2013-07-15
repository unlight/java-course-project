package phonebook;

import com.github.sqlbuilder.SelectQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import utils.KeyValue;
import utils.SqlUtils;

public class Model<T> {

    protected String name;
    protected String primaryKey;

    public Model(String name) {
	  this.name = name;
	  this.primaryKey = name + "ID";
    }

//    public T getById(int rowID) {
//	  String query = new SelectQuery()
//		    .addColumn("*")
//		    .addFrom(name)
//		    .addWhere(primaryKey + " = ?")
//		    .toString();
//	  List list = selectQuery(query, new Object[]{
//		rowID
//	  });
//	  return T;
//    }

    public List getListById(int rowID) {
	  String query = new SelectQuery()
		    .addColumn("*")
		    .addFrom(name)
		    .addWhere(primaryKey + " = ?")
		    .toString();
	  List list = selectQuery(query, new Object[]{
		rowID
	  });
	  return list;
    }

    public List<HashMap<String, Object>> get() {
	  String query = new SelectQuery()
		    .addFrom(name)
		    .toString();
	  return selectQuery(query);
    }

    public static List<HashMap<String, Object>> selectQuery(String query) {
	  return selectQuery(query, new Object[]{});
    }

    public static List<HashMap<String, Object>> selectQuery(String query, Object[] values) {
	  List list = null;
	  try {
		PreparedStatement preparedStatement = Application.connection().prepareStatement(query);
		for (int i = 0; i < values.length; i++) {
		    preparedStatement.setString(i, values[i].toString());
		}
		ResultSet executeQuery = preparedStatement.executeQuery();
		list = SqlUtils.resultSetToArrayList(executeQuery);
	  } catch (SQLException e) {
		Application.handleException(e);
	  }
	  return list;
    }

    public int getCount() {
	  String query = new SelectQuery()
		    .addColumn("count(*) as count")
		    .addFrom(name)
		    .toString();
	  Object object = selectQuery(query, new Object[]{}).get(0).get("count");
	  int result = Integer.parseInt(object.toString());
	  return result;
    }
}