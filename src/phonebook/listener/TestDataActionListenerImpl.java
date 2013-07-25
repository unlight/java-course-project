package phonebook.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import phonebook.LoremTextThread;
import phonebook.ui.AddEntryDialog;
import utils.StringUtils;

/**
 *
 * @author S
 */
public class TestDataActionListenerImpl implements ActionListener {

	private AddEntryDialog frame;

	public TestDataActionListenerImpl(AddEntryDialog frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new LoremTextThread(frame.lastNameTextField).run();
		new LoremTextThread(frame.firstNameTextField).run();
		frame.birthDateField.setValue(StringUtils.randomDate());
		frame.phoneNumberTextField.setText(StringUtils.randomPhone());
		((JButton) e.getSource()).setEnabled(false);

	}
}
