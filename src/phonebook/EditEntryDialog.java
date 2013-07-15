package phonebook;

import java.awt.Frame;

/**
 * @author
 * S
 */
public class EditEntryDialog extends AddEntryDialog {

    public EditEntryDialog(Frame parent, boolean modal) {
	  super(parent, modal);
	  setTitle("Редактировать");
	  saveButton.setText("Сохранить");
    }
    
    
}