import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainDriver {

	public static void main(String[] args) {

		String fileName = "Project_1_johnBillingham_demo.txt";
		String workingDirectory = System.getProperty("user.dir");
		String filePath = workingDirectory + File.separator + fileName;

		// Create or open file to write/read contacts.
		File tempDir = new File(filePath);
		if (tempDir.exists() && !tempDir.isDirectory()) {
			readFile(filePath, fileName);
		}
		else {
			startWriteFile(filePath, fileName);
		}

	}

	public static void readFile(String filePath, String fileName) {
		ObjectInputStream in;

		try {
			in = new ObjectInputStream(new FileInputStream(filePath));
			List<Person> listPersons = (ArrayList<Person>)in.readObject();

			myInit = new MyInit(listPersons, filePath, fileName);
			myInit.setVisible(true);

		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void startWriteFile(String filePath, String fileName) {
		ObjectOutputStream out;

		List<Person> listPersons = new ArrayList<Person>();

		try {
			out = new ObjectOutputStream(new FileOutputStream(filePath));
			out.writeObject(listPersons);
			out.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		JOptionPane.showMessageDialog(null, "Contacts written to " + fileName);
		readFile(filePath, fileName);
	}

	private static MyInit myInit;

}
