import java.util.*;
import java.io.*;
enum ContactTypes{ SCHOOL, PERSONAL, WORK , HOME, BUSINESS};
public class Person implements Serializable {
	private int index;
  private String[] group;
	private String firstName;
	private String lastName;
	private String note;
	private TreeMap<String, String> emails = new TreeMap<String, String>();
	private HashSet<Address> addresses = new HashSet<Address>();
	private TreeMap<String, String> phoneNums = new TreeMap<String, String>();

	public Person() {

	}
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		String retVal;
		retVal = "------" + firstName + " " + lastName + "------";
		retVal += "\nPhone...";

		for (String key: phoneNums.keySet()) {
			String value = phoneNums.get(key);
			retVal += "\n\t-" + key + ": " + value;
		}

		retVal += "\nEmail...";

		for (String key: emails.keySet()) {
			String value = emails.get(key);
			retVal += "\n\t-" + key + ": " + value;
		}

		retVal += "\nAddress...";

		for (Address addy: addresses) {
			retVal += "\n\t-" + addy;
		}

		return retVal;

	}

	public String[] getGroup() {
		return group;
	}

	public void setGroup(String[] group) {
		this.group = group;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	// -------EMAIL---------
	public String[] getEmails() {
		String[] arEmails = new String[1000];
		int i = 0;

		for (String key: emails.keySet()) {
			String value = emails.get(key);

			arEmails[i] = key + ": " + value;
			i++;
		}
		return arEmails;
	}

	public void editEmail(String key, String newKey, String newValue) {
		emails.remove(key);
		emails.put(newKey, newValue);
	}

	public void delEmail(String key) {
		emails.remove(key);
	}

	public void addEmail(String key, String value) {
		emails.put(key, value);
	}

	public String getEmail() {
		return emails.firstKey();
	}

	// --------ADDRESS--------
	public Address[] getAddresses() {
		Address[] arAddresses = new Address[100];
		int i = 0;

		for (Address addy: addresses) {
			arAddresses[i] = addy;
			i++;
		}
		return arAddresses;
	}

	public void editAddress(Address addressObj, Address newAddressObj) {
		addresses.remove(addressObj);
		addresses.add(newAddressObj);
	}

	public void delAddress(Address addressObj) {
		addresses.remove(addressObj);
	}

	public void addAddressTemp(String type, String street, String city, String state, String zip) {
		Address addressObj = new Address(type, street, city, state, zip);
		addresses.add(addressObj);
	}

	public void addAddress(Address addressObj) {
		addresses.add(addressObj);
	}

	// --------PHONE----------
	public String[] getPhoneNums() {
		String[] arPhoneNums = new String[1000];
		int i = 0;

		for (String key: phoneNums.keySet()) {
			String value = phoneNums.get(key);

			arPhoneNums[i] = key + ": " + value;
			i++;
		}
		return arPhoneNums;
	}

	public void editPhoneNum(String key, String newKey, String newValue) {
		phoneNums.remove(key);
		phoneNums.put(newKey, newValue);
	}

	public void delPhoneNum(String key) {
		phoneNums.remove(key);
	}

	public void addPhoneNum(String key, String value) {
		phoneNums.put(key, value);
	}

	public String getPhone() {
		return phoneNums.firstKey();
	}

}
