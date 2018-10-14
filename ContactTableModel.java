import javax.swing.table.*;
import java.util.*;

public class ContactTableModel extends AbstractTableModel {
	private static final int COLUMN_LAST = 0;
	private static final int COLUMN_FIRST = 1;
	private String[] columnNames = {"Last", "First"};
	private List<Person> listPersons;

	public ContactTableModel(List<Person> listPersons){

		for (int j = 0; j < listPersons.size() - 1; j++) {
			for (int i = 0; i < listPersons.size() - j - 1; i++){
				Person p1 = listPersons.get(i);
				Person p2 = listPersons.get(i+1);

				if (p1.getLastName().compareTo(p2.getLastName()) > 0) {
					listPersons.set(i, p2);
					listPersons.set(i + 1, p1);
				}
			}
		}
		this.listPersons = listPersons;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listPersons.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = listPersons.get(rowIndex);
		Object retVal = null;
		switch(columnIndex){
			case COLUMN_LAST: retVal = person.getLastName(); break;
			case COLUMN_FIRST: retVal = person.getFirstName(); break;
			default: throw new IllegalArgumentException("Invalid column index.");
		}
		return retVal;
	}

	public Object returnPerson(int rowIndex) {
		Person person = listPersons.get(rowIndex);
		Object retVal = person;
		return retVal;
	}

	@Override
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex){
		if(listPersons.isEmpty()) return Object.class;
		else return getValueAt(0, columnIndex).getClass();
	}

  public String[] getColumnNames(){
    return columnNames;
  }
}
