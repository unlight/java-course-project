package phonebook.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import phonebook.Application;
import phonebook.ui.EntryTable;
import phonebook.EntryTableModel;
import phonebook.model.EntryModel;
import phonebook.ui.AddEntryDialog;
import phonebook.ui.MainFrame;

/**
 * @author S
 */
public class RemoveEntryActionListener implements ActionListener {

	private AddEntryDialog entryDialog = null;

	public RemoveEntryActionListener(AddEntryDialog entryDialog) {
		this.entryDialog = entryDialog;
	}

	public RemoveEntryActionListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame mainFrame = Application.getInstance().frame;
		EntryModel entryModel = new EntryModel();
		int entityId = ((EntryTable) mainFrame.entryTable).getEntityId();
		entryModel.delete(entityId);
		int tableRowId = mainFrame.entryTable.getSelectedRow();
		((EntryTableModel) mainFrame.entryTable.getModel()).fireTableRowsDeleted(tableRowId, tableRowId);

		if (entryDialog != null) {
			entryDialog.dispose();
		}

	}
}
