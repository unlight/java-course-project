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
			int rowID = target.getEntityId();
			new EditEntryDialog(rowID).setVisible(true);
		}
	}
}
