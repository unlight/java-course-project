package phonebook;

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
		return getDataList().get(index);
	}

	public int getIndexOf(Object anObject) {
		return getDataList().indexOf(anObject);
	}

	public void setSelectedItem(Category anObject) {
		selected = anObject;
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
		selected = (Category) anItem;
	}
}
