package phonebook;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author S
 */
public class PicturePanel extends JPanel {

    AddEntryDialog owner;

    public PicturePanel(AddEntryDialog owner) {
	  this.owner = owner;
    }

    @Override
    protected void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  File pictureFile = owner.getPictureFile();
	  if (pictureFile != null) {
		ImageIcon icon = new ImageIcon(pictureFile.getPath());
		g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);
		setBorder(new LineBorder(Color.GRAY));
	  }
	  // ?: Почему постоянно вызывается paint() здесь.
    }
}