package phonebook.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author S
 */
public class ExitActionListener implements ActionListener {

	public ExitActionListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
