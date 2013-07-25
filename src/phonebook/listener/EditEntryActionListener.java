package phonebook.listener;

import java.awt.event.ActionListener;
import phonebook.Application;
import phonebook.ui.EntryTable;
import phonebook.ui.EditEntryDialog;
import phonebook.ui.MainFrame;

/**
 * @author S
 */
public class EditEntryActionListener implements ActionListener {

	@Override
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		MainFrame frame = Application.getInstance().frame;
		int rowID = ((EntryTable) frame.entryTable).getEntityId();
		new EditEntryDialog(rowID, frame, false).setVisible(true);
	}
}
