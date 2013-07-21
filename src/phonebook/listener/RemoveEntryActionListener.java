package phonebook.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import phonebook.Application;
import phonebook.ui.EntryTable;
import phonebook.EntryTableModel;
import phonebook.model.EntryModel;
import phonebook.ui.MainFrame;

/**
 * @author S
 */
public class RemoveEntryActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = Application.getInstance().frame;
		EntryModel entryModel = new EntryModel();
		int entityId = ((EntryTable) frame.entryTable).getEntityId();
		entryModel.delete(entityId);
		int tableRowId = frame.entryTable.getSelectedRow();
		((EntryTableModel) frame.entryTable.getModel()).fireTableRowsDeleted(tableRowId, tableRowId);
	}
}
