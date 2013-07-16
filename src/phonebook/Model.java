package phonebook;

import com.github.sqlbuilder.SelectQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phonebook.entity.Entity;
import utils.SqlUtils;

public class Model<T> {

    protected String name;
    protected String primaryKey;
//    protected Class<T> classRef;

    public Model(String name) {
        this.name = name;
        this.primaryKey = name + "ID";
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
                    ((Entity)row).attachResultSet(resultSet);
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