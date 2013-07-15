package phonebook;

import java.io.File;
import net.iharder.dnd.FileDrop;

/**
 * @author S
 */
public class FileDropListener implements FileDrop.Listener {

    AddEntryDialog owner;

    FileDropListener(AddEntryDialog owner) {
	  this.owner = owner;
    }

    @Override
    public void filesDropped(File[] files) {
	  owner.setPictureFile(files[0]);
    }
}
