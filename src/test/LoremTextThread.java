package test;

import javax.swing.JTextField;
import utils.StringUtils;

/**
 *
 * @author S
 */
public class LoremTextThread extends Thread {
	
	JTextField textField;

	public LoremTextThread(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void run() {
		textField.setText(StringUtils.loremWord());
	}
}
