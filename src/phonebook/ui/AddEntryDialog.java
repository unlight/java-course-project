package phonebook.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JDialog;
import net.iharder.dnd.FileDrop;
import phonebook.listener.FileDropListener;
import phonebook.listener.PictureMouseClickListener;
import phonebook.listener.RemoveEntryActionListener;
import phonebook.entity.Date;
import phonebook.entity.Entry;
import phonebook.entity.Picture;
import phonebook.listener.CancelActionListenerImpl;
import phonebook.listener.SaveEntryActionListenerImpl;
import phonebook.listener.TestDataActionListenerImpl;

/**
 * @author S
 */
public class AddEntryDialog extends JDialog implements ActionListener {

	PictureMouseClickListener pictureMouseClickListener;
	private Picture picture;
	private Entry data;

	public AddEntryDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		postInit();
	}

	private void postInit() {
		pictureMouseClickListener = new PictureMouseClickListener(this);
		picturePanel.addMouseListener(pictureMouseClickListener);
		new FileDrop(picturePanel, new FileDropListener(this));
		categoryComboBox.setModel(new CategoryComboBoxModel());
		cancelButton.addActionListener(new CancelActionListenerImpl(this));
		removeButton.addActionListener(new RemoveEntryActionListener(this));
		saveButton.addActionListener(new SaveEntryActionListenerImpl(this));

		final TestDataActionListenerImpl testDataActionListenerImpl = new TestDataActionListenerImpl(this);
//		categoryComboBox.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent evt) {
//				System.out.println(evt);
//				if (evt.getClickCount() == 2) {
//					testDataActionListenerImpl.run();
//				}
//			}
//		});
//		testDataButton.setVisible(false);
		testDataButton.addActionListener(testDataActionListenerImpl);
		testDataButton.setFont(getFont().deriveFont((float)(getFont().getSize() / 2)));
	}

	protected void setData(Entry entry) {
		data = entry;
		lastNameTextField.setText(data.getLastName());
		firstNameTextField.setText(data.getFirstName());
		phoneNumberTextField.setText(data.getPhone());
		birthDateField.setValue(data.getBirthDate());
		((CategoryComboBox) categoryComboBox).setSelectedItem(entry.getCategory());
		setPicture(data.getPicture());
	}

	public Entry getData() {
		if (data == null) {
			data = new Entry();
		}
		data.LastName = lastNameTextField.getText();
		data.FirstName = firstNameTextField.getText();
		data.Phone = phoneNumberTextField.getText();
		data.BirthDate = new Date((java.util.Date) birthDateField.getValue());
		data.setCategory(((CategoryComboBoxModel) categoryComboBox.getModel()).getSelectedCategory());
		data.setPicture(getPicture());
		return data;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(true);
	}

	public File getPictureFile() {
		if (getPicture() != null) {
			File result = getPicture().getIncomingFileObject();
			if (result == null) {
				result = getPicture().getFile();
			}
			return result;
		}
		return null;
	}

	private Picture getPicture() {
		return picture;
	}

	public void setPictureFile(File file) {
		if (picture == null) {
			picture = new Picture();
		}
		picture.setFile(file);
		picture.setIncomingFileObject(file);
		setPicture(picture);
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
		picturePanel.repaint();
		picturePanel.updateUI();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lastnameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        birthdateLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        lastNameTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        birthDateField = new net.sf.nachocalendar.components.DateField();
        cancelButton = new javax.swing.JButton();
        picturePanel = new PicturePanel(this);
        testDataButton = new javax.swing.JButton();
        categoryComboBox = new CategoryComboBox();
        categoryLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Новая запись");

        lastnameLabel.setText("Фамилия:");
        lastnameLabel.setPreferredSize(new java.awt.Dimension(90, 20));

        firstNameLabel.setText("Имя:");
        firstNameLabel.setPreferredSize(new java.awt.Dimension(90, 20));

        phoneLabel.setText("Телефон:");
        phoneLabel.setPreferredSize(new java.awt.Dimension(90, 20));

        birthdateLabel.setText("День рождения:");
        birthdateLabel.setPreferredSize(new java.awt.Dimension(90, 20));

        saveButton.setText("Добавить");

        cancelButton.setText("Отмена");

        picturePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Изображение"));
        picturePanel.setForeground(new java.awt.Color(204, 204, 204));
        picturePanel.setToolTipText("Щелкните на области или перетащите изображение");
        picturePanel.setPreferredSize(new java.awt.Dimension(100, 120));

        javax.swing.GroupLayout picturePanelLayout = new javax.swing.GroupLayout(picturePanel);
        picturePanel.setLayout(picturePanelLayout);
        picturePanelLayout.setHorizontalGroup(
            picturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        picturePanelLayout.setVerticalGroup(
            picturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        testDataButton.setText("Fill test data");

        categoryComboBox.setEditable(true);

        categoryLabel.setText("Категория:");
        categoryLabel.setPreferredSize(new java.awt.Dimension(90, 20));

        removeButton.setText("Удалить");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lastnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(birthDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(testDataButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lastnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birthdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(picturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testDataButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(removeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public net.sf.nachocalendar.components.DateField birthDateField;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JButton cancelButton;
    public javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel firstNameLabel;
    public javax.swing.JTextField firstNameTextField;
    public javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel phoneLabel;
    public javax.swing.JTextField phoneNumberTextField;
    public javax.swing.JPanel picturePanel;
    private javax.swing.JButton removeButton;
    protected javax.swing.JButton saveButton;
    private javax.swing.JButton testDataButton;
    // End of variables declaration//GEN-END:variables
}