package phonebook.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.Application;

/**
 * @author S
 */
public class Category extends Entity {
    
    public int CategoryID;
    public String Name;

    @Override
    public void attachResultSet(ResultSet set) {
        try {
            CategoryID = set.getInt("CategoryID");
            Name = set.getString("Name");
        } catch (SQLException ex) {
            Application.handleException(ex);
        }
    }

}