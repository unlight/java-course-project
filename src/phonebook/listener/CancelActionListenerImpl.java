package phonebook.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import phonebook.ui.AddEntryDialog;

/**
 *
 * @author S
 */
public class CancelActionListenerImpl implements ActionListener {

	private final AddEntryDialog frame;

	public CancelActionListenerImpl(AddEntryDialog frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
}
