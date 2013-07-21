package phonebook.listener;

import phonebook.ui.AddEntryDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author S
 */
public class PictureMouseClickListener extends MouseAdapter {

    AddEntryDialog owner;

    public PictureMouseClickListener(AddEntryDialog owner) {
        this.owner = owner;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser pictureFileChooser = new JFileChooser();
        pictureFileChooser.setFileFilter(new FileNameExtensionFilter("Изображения", ImageIO.getReaderFileSuffixes()));
        int showDialog = pictureFileChooser.showDialog(owner, null);
        File selectedFile = pictureFileChooser.getSelectedFile();
        owner.setPictureFile(selectedFile);
    }
}