package phonebook.entity;

import java.sql.ResultSet;

/**
 * @author S
 */
public class Entry extends Entity {
    
    public int EntryID;
    public String FirstName;
    public String LastName;
    public String BirthDate;
    public int CategoryID;

    @Override
    void attachResultSet(ResultSet set) {
//	  EntryID = set.get
    }
    
    
}