package phonebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import phonebook.model.EntryModel;

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
