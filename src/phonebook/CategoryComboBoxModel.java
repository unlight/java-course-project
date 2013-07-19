package phonebook;

import javax.swing.DefaultComboBoxModel;
import phonebook.entity.Category;
import phonebook.model.CategoryModel;

/**
 * @author S
 */
public class CategoryComboBoxModel extends DefaultComboBoxModel<Category> {
	
	private CategoryModel categoryModel;

	public CategoryComboBoxModel() {
	}

	public CategoryComboBoxModel(Category[] items) {
		super(items);
	}
	
	

//	@Override
//	public void setSelectedItem(Object anObject) {
//		super.setSelectedItem(anObject);
//	}
//
//	@Override
//	public Object getSelectedItem() {
//		return super.getSelectedItem();
//	}
}
