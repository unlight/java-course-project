package phonebook;

import javax.swing.JTable;
import phonebook.entity.Entry;

/**
 * @author S
 */
public class EntryTable extends JTable {

    EntryTable(EntryTableModel entryTableModel) {
        super(entryTableModel);
    }

    public Entry getEntity() {
        int rowId = getSelectedRow();
        return ((EntryTableModel) getModel()).getRow(rowId);
    }

    public int getEntityId() {
        return getEntity().getEntryID();
    }
    
    @Override
    public EntryTableModel getModel() {
        return (EntryTableModel) super.getModel();
    }
}
