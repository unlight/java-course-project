package phonebook.ui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
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
		removeColumn(column);

		setAutoCreateRowSorter(true);
//		setFont(getFont().deriveFont((float)(getFont().getSize() + 1)));
	}

	private Entry getSelectedEntry() {
		int rowId = getSelectedRow();
		Entry entry = null;
		// -1 means noting is selected.
		if (rowId > -1) {
			int convertRowIndexToModel = ((EntryTable) this).convertRowIndexToModel(rowId);
			rowId = convertRowIndexToModel;
			entry = ((EntryTableModel) getModel()).getRow(rowId);
		}
		return entry;
	}

	public int getSelectedEntryId() {
		Entry entry = getSelectedEntry();
		Integer result = 0;
		if (entry != null) {
			result = entry.getEntryID();
		}
		return result;
	}

	@Override
	public EntryTableModel getModel() {
		return (EntryTableModel) super.getModel();
	}
}
