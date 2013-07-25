package phonebook.ui;

import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import phonebook.DateCellRenderer;
import phonebook.EntryTableModel;
import phonebook.entity.Entry;

/**
 * @author S
 */
public class EntryTable extends JTable {

    public EntryTable(EntryTableModel entryTableModel) {
        super(entryTableModel);
		getColumnModel().getColumn(3).setCellRenderer(new DateCellRenderer());
		setIntercellSpacing(new Dimension(5, 5));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumn column = getColumnModel().getColumn(0);
		//removeColumn(column);
//        convertColumnIndexToModel(editingColumn);
//        getColumnModel().removeColumn(column);
		setAutoCreateRowSorter(true);
		//		EntryTableRowSorter entryTableRowSorter = new EntryTableRowSorter(entryTableModel);
		//		entryTableRowSorter.setComparator(3, new ColumnSorter());
		//		setRowSorter(entryTableRowSorter);

    }

    public Entry getEntity() {
        int rowId = getSelectedRow();
		
        System.out.println("getSelectedRow: " + rowId);
        int convertRowIndexToModel = ((EntryTable) this).convertRowIndexToModel(rowId);
        System.out.println("convertRowIndexToModel: " + convertRowIndexToModel);

        rowId = convertRowIndexToModel;
        
        Entry entry = ((EntryTableModel) getModel()).getRow(rowId);
        System.out.println("getEntity.entry: " + entry.getEntryID());
       
        return entry;
    }

    public int getEntityId() {
        return getEntity().getEntryID();
    }
    
    @Override
    public EntryTableModel getModel() {
        return (EntryTableModel) super.getModel();
    }
}
