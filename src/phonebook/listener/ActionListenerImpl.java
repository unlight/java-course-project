package phonebook.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import phonebook.ui.AddEntryDialog;
import phonebook.ui.MainFrame;

/**
 *
 * @author S
 */
public class ActionListenerImpl implements ActionListener {
	private final MainFrame frame;

	public ActionListenerImpl(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AddEntryDialog(frame, false).setVisible(true);
	}
	
}
