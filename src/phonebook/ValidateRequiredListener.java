package phonebook;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author S
 */
public class ValidateRequiredListener implements DocumentListener {

	private JTextField textfield;
	
	public ValidateRequiredListener(JTextField textfield) {
		this.textfield = textfield;
	}

	public void insertUpdate(DocumentEvent e) {
		validate(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		validate(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		validate(e);
	}
	
	private void validate(DocumentEvent e) {
		if (e.getDocument().getLength() > 0) {
			textfield.setBackground(Color.white);
		}		
	}
	
}
