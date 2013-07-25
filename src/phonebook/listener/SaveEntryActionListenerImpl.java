package phonebook.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import phonebook.Application;
import phonebook.EntryTableModel;
import phonebook.ValidateRequiredListener;
import phonebook.entity.Entry;
import phonebook.model.EntryModel;
import phonebook.ui.AddEntryDialog;
import phonebook.ui.EntryTable;

/**
 *
 * @author S
 */
public class SaveEntryActionListenerImpl implements ActionListener {

	private AddEntryDialog frame;

	public SaveEntryActionListenerImpl(AddEntryDialog frame) {
		this.frame = frame;
	}

	protected boolean validate(Entry entry) {
		// Validation.
		ArrayList<JTextField> errorList = new ArrayList();
		Color errorColor = new Color(255, 148, 148);
		if (entry.LastName.length() == 0) {
			errorList.add(frame.lastNameTextField);
			frame.lastNameTextField.getDocument().addDocumentListener(new ValidateRequiredListener(frame.lastNameTextField));
		}
		if (entry.Phone.length() == 0) {
			errorList.add(frame.phoneNumberTextField);
			frame.phoneNumberTextField.getDocument().addDocumentListener(new ValidateRequiredListener(frame.phoneNumberTextField));
		}
		if (errorList.size() > 0) {
			for (JTextField jTextField : errorList) {
				jTextField.setBackground(errorColor);
			}
			errorList.get(0).requestFocus();
		}
		return (errorList.isEmpty());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EntryModel EntryModel = new EntryModel();
		// Собираем данные из формы.
		Entry entry = frame.getData();
		// Все ли нужные поля заполнены.
		boolean isValid = validate(entry);
		if (isValid) {
			EntryModel.save(entry);
		}

		EntryTable entryTable = (EntryTable) (Application.getInstance().frame).entryTable;
		EntryTableModel entryTableModel = entryTable.getModel();
		if (entry != null && entry.getEntryID() != null) {
			int selectedRow = entryTable.getSelectedRow();
			entryTableModel.fireTableRowsUpdated(selectedRow, selectedRow);
		} else {
			entryTableModel.fireTableDataChanged();
		}

		frame.dispose();
	}
}