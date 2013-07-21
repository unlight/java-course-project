package phonebook;

import javax.swing.table.TableRowSorter;

/**
 *
 * @author S
 */
public class EntryTableRowSorter extends TableRowSorter<EntryTableModel> {

	public EntryTableRowSorter(EntryTableModel entryTableModel) {
		super(entryTableModel);
	}
}
