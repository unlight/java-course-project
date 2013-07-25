package phonebook.listener;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utils.StringUtils;

/**
 * @author S
 */
public class AboutActionListener implements ActionListener {

	@Override
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		String[] messages = {
			"Url: rv-home.ru",
			"Copyright: 2013."
		};
		JOptionPane.showMessageDialog(null, StringUtils.join(messages, "\n"), "О программе", JOptionPane.INFORMATION_MESSAGE);
	}
}
