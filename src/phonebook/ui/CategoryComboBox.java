package phonebook.ui;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import phonebook.entity.Category;

/**
 * @author S
 */
public class CategoryComboBox extends JComboBox {

	@Override
	public ComboBoxModel getModel() {
		return super.getModel();
	}
	
	@Override
	public void setSelectedItem(Object anObject) {
		System.out.println("CategoryComboBox.setSelectedItem " + anObject);
		super.setSelectedItem(anObject);
	}
	
	@Override
	public Category getSelectedItem() {
		Category c = (Category) super.getSelectedItem();
		System.out.println("CategoryComboBox.getSelectedItem " + c);
		return c;
	}
}
