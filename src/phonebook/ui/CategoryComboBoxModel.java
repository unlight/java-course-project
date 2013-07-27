package phonebook.ui;

import java.security.InvalidParameterException;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import phonebook.entity.Category;
import phonebook.model.CategoryModel;

/**
 * @author S
 */
public class CategoryComboBoxModel extends AbstractListModel implements ComboBoxModel {

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
	public Object getElementAt(int index) {
		Category category = getDataList().get(index);
		System.out.println("getElementAt " + index + " " + category);
		System.out.println("getElementAt check hash " + category.hashCode() + " vs " + selected.hashCode());
		return category.getName();
	}

	public int getIndexOf(Object anObject) {
		return getDataList().indexOf(anObject);
	}

	public void setSelectedItem(Category anObject) {
		System.out.println("setSelectedItem.last " + anObject);
		selected = anObject;
	}

	public Category getSelectedCategory() {
		Object object = getSelectedItem();
		return (Category) object;
	}

	@Override
	public Object getSelectedItem() {
		System.out.println("getSelectedItem x " + selected + " " + getIndexOf(selected));
		return selected;
	}

	@Override
	public int getSize() {
		return categoryModel.getCount();
	}

	@Override
	public void setSelectedItem(Object anItem) {
		System.out.println("CategoryComboBoxModel.setSelectedItem " + anItem);
		if (anItem == null) {
			anItem = 0;
		}
		if (anItem instanceof Category) {
			setSelectedItem((Category) anItem);
		} else if (anItem instanceof Integer) {
			Category category = categoryModel.getId((Integer) anItem);
			setSelectedItem(category);
		} else if (anItem instanceof String) {
			Category category = categoryModel.getByName(anItem.toString());
			if (category == null && anItem.toString().length() > 0) {
				category = categoryModel.create(anItem.toString());
				dataList = null;
			}
			setSelectedItem(category);
		} else {
			throw new InvalidParameterException(String.format("Unexpected %s (%s).", anItem.getClass(), anItem));
		}
	}
}
