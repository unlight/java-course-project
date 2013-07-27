package phonebook.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import phonebook.ui.EditEntryDialog;
import phonebook.ui.EntryTable;

/**
 *
 * @author S
 */
public class EntryTableMouseClickListener extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			EntryTable target = (EntryTable) evt.getSource();
			int rowID = target.getSelectedEntryId();
			if (rowID > 0) {
				new EditEntryDialog(rowID).setVisible(true);
			}
		}
	}
}
