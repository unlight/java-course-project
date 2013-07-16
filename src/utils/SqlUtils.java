package utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import phonebook.Application;

/**
 *
 * @author S
 */
public class SqlUtils {

    public static ResultSet getResultSet(Object query) {
        ResultSet rs = null;
        try {
            Statement statement = Application.connection().createStatement();
            rs = statement.executeQuery(query.toString());
        } catch (SQLException ex) {
            Application.handleException(ex);
        }
        return rs;
    }

    public static Object getCell(Object query) {
        try {
            ResultSet rs = getResultSet(query);
            if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (SQLException ex) {
            Application.handleException(ex);
        }
        return null;
    }

    public static List resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList();
        while (rs.next()) {
            HashMap row = new HashMap(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }
}
