package phonebook;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author S
 */
public class PicturePanel extends JPanel {

	AddEntryDialog owner;
	BufferedImage image;

	public PicturePanel(AddEntryDialog owner) {
		this.owner = owner;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		File pictureFile = owner.getPictureFile();
		if (pictureFile != null) {
			try {
				image = ImageIO.read(pictureFile);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			} catch (IOException ex) {
				Application.handleException(ex);
			}
			setBorder(new LineBorder(Color.GRAY));
		}
	}
}