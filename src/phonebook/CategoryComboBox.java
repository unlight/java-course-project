package phonebook;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import phonebook.entity.Category;

/**
 * @author S
 */
public class CategoryComboBox extends JComboBox<Category> {

	@Override
	public ComboBoxModel<Category> getModel() {
		return super.getModel();
	}

	@Override
	public void setSelectedItem(Object anObject) {
		super.setSelectedItem(anObject);
	}

	@Override
	public void addItem(Category item) {
		super.addItem(item);
	}
}
