package phonebook;

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import phonebook.entity.Category;
import phonebook.model.CategoryModel;

/**
 * @author S
 */
public class CategoryComboBoxModel extends AbstractListModel<Category> implements ComboBoxModel<Category> {

	private CategoryModel categoryModel = new CategoryModel();
	private List<Category> dataList;
	private Category selected;

	public CategoryComboBoxModel() {
		super();
	}

	private List<Category> getDataList() {
		if (dataList == null) {
			dataList = categoryModel.get();
		}
		return dataList;
	}

	@Override
	public Category getElementAt(int index) {
		Category category = getDataList().get(index);
		return category;
	}

	public int getIndexOf(Object anObject) {
		return getDataList().indexOf(anObject);
	}

	public void setSelectedItem(Category anObject) {
		selected = anObject;
	}

	public Category getSelectedCategory() {
		Object object = getSelectedItem();
		return (Category) object;
	}

	@Override
	public Object getSelectedItem() {
		return selected;
	}

	@Override
	public int getSize() {
		return categoryModel.getCount();
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if (anItem == null) {
			anItem = 0;
		}
		System.out.println("setSelectedItem " + anItem.getClass() + " " + anItem + " ");
		if (anItem instanceof Category) {
			setSelectedItem((Category) anItem);
		} else if (anItem instanceof Integer) {
			Category category = categoryModel.getId((int) anItem);
			System.out.println("category: " + category);
			setSelectedItem(category);
		} else if (anItem instanceof String) {
			Category category = categoryModel.getByName(anItem.toString());
			System.out.println("Found by name: " + category);
			if (category == null && anItem.toString().length() > 0) {
				System.out.println("Creating cate: " + anItem.toString());
				category = categoryModel.create(anItem.toString());
				dataList = null;
			}
			setSelectedItem(category);
		} else {
			throw new InvalidParameterException(String.format("Unexpected %s (%s).", anItem.getClass(), anItem));
		}
	}
}
