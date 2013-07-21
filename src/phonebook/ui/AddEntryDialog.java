package phonebook.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import net.iharder.dnd.FileDrop;
import phonebook.CategoryComboBox;
import phonebook.CategoryComboBoxModel;
import phonebook.EntryTableModel;
import phonebook.listener.FileDropListener;
import phonebook.listener.PictureMouseClickListener;
import phonebook.listener.RemoveEntryActionListener;
import phonebook.entity.Date;
import phonebook.entity.Entry;
import phonebook.entity.Picture;
import phonebook.model.EntryModel;
import utils.StringUtils;

/**
 * @author S
 */
public class AddEntryDialog extends JDialog implements ActionListener {

	PictureMouseClickListener pictureMouseClickListener;
	private Picture picture;
	private Entry data;
	private CategoryComboBoxModel categoryComboBoxModel;

	public AddEntryDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		postInit();
	}

	protected void setData(Entry entry) {
		data = entry;
		lastNameTextField.setText(data.getLastName());
		firstNameTextField.setText(data.getFirstName());
		phoneNumberTextField.setText(data.getPhone());
		birthDateField.setValue(data.getBirthDate());
		categoryComboBoxModel.setSelectedItem(entry.getCategoryID());
		setPicture(data.getPicture());
	}

	protected Entry getData() {
		if (data == null) {
			data = new Entry();
		}
		data.LastName = lastNameTextField.getText();
		data.FirstName = firstNameTextField.getText();
		data.Phone = phoneNumberTextField.getText();
		data.BirthDate = new Date((java.util.Date) birthDateField.getValue());
		data.setCategory(categoryComboBoxModel.getSelectedCategory());
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

	private void postInit() {
		pictureMouseClickListener = new PictureMouseClickListener(this);
		picturePanel.addMouseListener(pictureMouseClickListener);
		new FileDrop(picturePanel, new FileDropListener(this));
		categoryComboBoxModel = new CategoryComboBoxModel();
		categoryComboBox.setModel(categoryComboBoxModel);
	}

	@SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

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
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

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

        testDataButton.setText("Lorem ipsum");
        testDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testDataButtonActionPerformed(evt);
            }
        });

        categoryComboBox.setEditable(true);

        categoryLabel.setText("Категория:");
        categoryLabel.setPreferredSize(new java.awt.Dimension(90, 20));

        removeButton.setText("Удалить");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

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
    }//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
		EntryModel EntryModel = new EntryModel();
		int EntryID = EntryModel.save(getData());
		EntryTable entryTable = (EntryTable) ((MainFrame) getParent()).entryTable;
		EntryTableModel entryTableModel = entryTable.getModel();
		if (getData() != null && getData().getEntryID() != null) {
			int selectedRow = entryTable.getSelectedRow();
			entryTableModel.fireTableRowsUpdated(selectedRow, selectedRow);
		} else {
			entryTableModel.fireTableDataChanged();
		}
		dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		dispose();
//        lastNameTextField.setBackground(new Color(221, 0, 0));
//        lastNameTextField.setBorder(new LineBorder(new Color(221, 0, 0), 2));
//        lastNameTextField.setInputVerifier();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void testDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testDataButtonActionPerformed
		lastNameTextField.setText(StringUtils.loremWord());
		firstNameTextField.setText(StringUtils.loremWord());
		birthDateField.setValue(StringUtils.randomDate());
		phoneNumberTextField.setText(StringUtils.randomPhone());
		((JButton) evt.getSource()).setEnabled(false);
    }//GEN-LAST:event_testDataButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
		new RemoveEntryActionListener().actionPerformed(evt);
		dispose();
    }//GEN-LAST:event_removeButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.sf.nachocalendar.components.DateField birthDateField;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JPanel picturePanel;
    private javax.swing.JButton removeButton;
    protected javax.swing.JButton saveButton;
    private javax.swing.JButton testDataButton;
    // End of variables declaration//GEN-END:variables
}
