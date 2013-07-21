package phonebook.listener;

import phonebook.ui.AddEntryDialog;
import java.io.File;
import net.iharder.dnd.FileDrop;

/**
 * @author S
 */
public class FileDropListener implements FileDrop.Listener {

    AddEntryDialog owner;

    public FileDropListener(AddEntryDialog owner) {
        this.owner = owner;
    }

    @Override
    public void filesDropped(File[] files) {
        owner.setPictureFile(files[0]);
    }
}
