package phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import utils.KeyValue;

/**
 * @author S
 */
public class EntryTableModel<Entry> implements TableModel {
  
    EntryModel entryModel = new EntryModel();
    String[] columnNames = new String[] {
	  "Имя", "Фамилия", "Дата рождения"
    };
    String[] columnKeys = new String[] {
	"FirstName", "LastName", "BirthDate"
    };
    List<HashMap<String,Object>> dataList;
    
    public EntryTableModel() {
    }
    
    public List<HashMap<String,Object>> getDataList() {
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
	  return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	  return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	  String key = columnKeys[columnIndex];
	  return getDataList().get(rowIndex).get(key);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
}
