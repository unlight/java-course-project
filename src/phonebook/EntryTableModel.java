package phonebook;

import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import phonebook.entity.Date;
import phonebook.entity.Entry;
import phonebook.model.EntryModel;

/**
 * @author S
 */
public class EntryTableModel extends AbstractTableModel {

    EntryModel entryModel = new EntryModel();
    String[] columnNames = new String[]{
        "Имя", "Фамилия", "Телефон", "Дата рождения", "Категория"
    };
    String[] columnKeys = new String[]{
        "FirstName", "LastName", "Phone", "BirthDate", "Category"
    };
    Class<?>[] columnClasses = new Class<?>[]{
        String.class, String.class, String.class, Date.class, String.class
    };
    List<Entry> dataList;

    public EntryTableModel() {
    }

    public Entry getRow(int rowIndex) {
        return getDataList().get(rowIndex);
    }

    @Override
    public void fireTableChanged(TableModelEvent e) {
        dataList = null;
        super.fireTableChanged(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Entry> getDataList() {
        if (dataList == null) {
            dataList = entryModel.get();
        }
        return dataList;
    }

    @Override
    public int getRowCount() {
        return getDataList().size();
//        return entryModel.getCount();
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
}
