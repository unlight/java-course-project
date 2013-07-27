package phonebook.ui;

import java.security.InvalidParameterException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import phonebook.entity.Category;
import phonebook.model.CategoryModel;

/**
 * @author S
 */
public class CategoryComboBoxModel extends DefaultComboBoxModel {

	private CategoryModel categoryModel = new CategoryModel();
	private List<Category> dataList;

	public CategoryComboBoxModel() {
		super();
		for (Category category : getDataList()) {
			addElement(category);
		}
	}

	private List<Category> getDataList() {
		if (dataList == null) {
			dataList = categoryModel.get();
		}
		return dataList;
	}

	public Category getSelectedCategory() {
		Object anItem = getSelectedItem();
		if (anItem instanceof String) {
			Category category = categoryModel.getByName(anItem.toString());
			if (category == null) {
				anItem = categoryModel.create(anItem.toString());
				dataList = null;
			} else {
				anItem = category;
			}
		}
		if (!(anItem instanceof Category)) {
			throw new InvalidParameterException(String.format("Unexpected %s (%s).", anItem.getClass(), anItem));
		}
		return (Category) anItem;
	}
}
