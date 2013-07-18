package phonebook;

import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import phonebook.entity.Entry;
import phonebook.model.EntryModel;

/**
 * @author S
 */
public class EntryTableModel implements TableModel {

    EntryModel entryModel = new EntryModel();
    String[] columnNames = new String[]{
	  "Имя", "Фамилия", "Телефон", "Дата рождения"
    };
    String[] columnKeys = new String[]{
	  "FirstName", "LastName", "Phone", "BirthDate"
    };
    Class<?>[] columnClasses = new Class<?>[]{
	  String.class, String.class, String.class, Date.class
    };
    List<Entry> dataList;

    public EntryTableModel() {
    }
    
    public Entry getRow(int rowIndex) {
	  return getDataList().get(rowIndex);
    }
    
    public List<Entry> getDataList() {
	  if (dataList == null) {
		dataList = entryModel.get();
	  }
	  return dataList;
    }

    @Override
    public int getRowCount() {
	  return entryModel.getCount();
    }

    @Override
    public int getColumnCount() {
	  return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
	  return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
	  return columnClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	  return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	  String name = columnKeys[columnIndex];
	  Entry entry = (Entry) getDataList().get(rowIndex);
	  return entry.getProperty(name);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
}
