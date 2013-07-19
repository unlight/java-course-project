package phonebook;

import java.awt.Frame;
import phonebook.entity.Entry;
import phonebook.model.EntryModel;

/**
 * @author S
 */
public class EditEntryDialog extends AddEntryDialog {

    private EntryModel entryModel;

    public EditEntryDialog(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Редактировать");
        saveButton.setText("Сохранить");
        entryModel = new EntryModel();
    }

    public EditEntryDialog(int id, MainFrame aThis, boolean b) {
        this(aThis, b);
        Entry entry = entryModel.getId(id);
        setData(entry);
    }
}