
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MyInit extends javax.swing.JFrame {

    public MyInit(List<Person> listPersons, String filePath, String fileName) {
    	
        initComponents(listPersons);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            		ObjectOutputStream out;
        		
            		List<Person> writeListPersons = listPersons;
        		
            		try {
            			out = new ObjectOutputStream(new FileOutputStream(filePath));
            			out.writeObject(writeListPersons);
            			out.close();
            		}
            		catch (Exception ex) {
            			System.out.println(ex.getMessage());
            		}
        		
            		JOptionPane.showMessageDialog(null, "Contacts written to " + fileName);
            }
        });
    }

    @SuppressWarnings("unchecked")
                             
    private void initComponents(List<Person> listPersons) {
    		
    		newPerson = new Person();
    		this.listPersons = listPersons;
    	
        tableScrollPane = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        contactPanel = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        phoneLabel = new javax.swing.JLabel();
        phoneListScrollPane = new javax.swing.JScrollPane();
        phoneList = new javax.swing.JList<>();
        emailLabel = new javax.swing.JLabel();
        emailListScrollPane = new javax.swing.JScrollPane();
        emailList = new javax.swing.JList<>();
        addressLabel = new javax.swing.JLabel();
        addressListScrollPane = new javax.swing.JScrollPane();
        addressList = new javax.swing.JList<>();
        phoneAddButton = new javax.swing.JButton();
        phoneEditButton = new javax.swing.JButton();
        phoneDelButton = new javax.swing.JButton();
        emailAddButton = new javax.swing.JButton();
        emailEditButton = new javax.swing.JButton();
        emailDelButton = new javax.swing.JButton();
        addressAddButton = new javax.swing.JButton();
        addressEditButton = new javax.swing.JButton();
        addressDelButton = new javax.swing.JButton();
        noteLabel = new javax.swing.JLabel();
        noteScrollPane = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        newContactButton = new javax.swing.JButton();
        deleteContactButton = new javax.swing.JButton();
        tempPerson = new Person();
        
        sampleAddress1 = new Address("type", "street", "city", "state", "zip");
        sampleAddress2 = new Address("type", "street", "city", "state", "zip");
        sampleAddress3 = new Address("type", "street", "city", "state", "zip");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Address Book");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        personTable.setModel(new ContactTableModel(listPersons));
        personTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				personTableMouseClickPerformed(e);
			}
        });
        
        tableScrollPane.setViewportView(personTable);

        firstNameLabel.setText("First:");

        firstNameTextField.setText("\"Johnny\"");
        
        lastNameLabel.setText("Last:");

        lastNameTextField.setText("\"Appleseed\"");

        phoneLabel.setText("Phone:");

        phoneList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        phoneListScrollPane.setViewportView(phoneList);

        emailLabel.setText("Email:");

        emailList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        emailListScrollPane.setViewportView(emailList);

        addressLabel.setText("Address:");

        addressList.setModel(new javax.swing.AbstractListModel<Address>() {
            Address[] addresses = {sampleAddress1, sampleAddress2, sampleAddress3};
            public int getSize() { return addresses.length; }
            public Address getElementAt(int i) { return addresses[i]; }
        });
        addressListScrollPane.setViewportView(addressList);

        phoneAddButton.setText("Add");
        phoneAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneAddButtonActionPerformed(evt);
            }
        });

        phoneEditButton.setText("Edit");
        phoneEditButton.addActionListener(new java.awt.event.ActionListener() {
        		public void actionPerformed(java.awt.event.ActionEvent evt) {
        			phoneEditButtonActionPerformed(evt);
            }
        });

        phoneDelButton.setText("Del");
        phoneDelButton.addActionListener(new java.awt.event.ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			phoneDelButtonActionPerformed(evt);
        }
    });

        emailAddButton.setText("Add");
        emailAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAddButtonActionPerformed(evt);
            }
        });

        emailEditButton.setText("Edit");
        emailEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEditButtonActionPerformed(evt);
            }
        });

        emailDelButton.setText("Del");
        emailDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailDelButtonActionPerformed(evt);
            }
        });

        addressAddButton.setText("Add");
        addressAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressAddButtonActionPerformed(evt);
            }
        });

        addressEditButton.setText("Edit");
        addressEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressEditButtonActionPerformed(evt);
            }
        });

        addressDelButton.setText("Del");
        addressDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressDelButtonActionPerformed(evt);
            }
        });

        noteLabel.setText("Note:");

        noteTextArea.setColumns(20);
        noteTextArea.setRows(5);
        noteScrollPane.setViewportView(noteTextArea);

        saveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firstNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(lastNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contactPanelLayout.createSequentialGroup()
                                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneLabel)
                                    .addComponent(phoneListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailLabel)
                                    .addComponent(emailListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contactPanelLayout.createSequentialGroup()
                                        .addComponent(emailAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emailEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emailDelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(addressLabel)
                            .addGroup(contactPanelLayout.createSequentialGroup()
                                .addComponent(phoneAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneDelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contactPanelLayout.createSequentialGroup()
                                .addComponent(addressAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressDelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(noteLabel)
                            .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contactPanelLayout.createSequentialGroup()
                                    .addComponent(noteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(addressListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel)
                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameLabel)
                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(phoneListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneAddButton)
                    .addComponent(phoneEditButton)
                    .addComponent(phoneDelButton)
                    .addComponent(emailAddButton)
                    .addComponent(emailEditButton)
                    .addComponent(emailDelButton))
                .addGap(18, 18, 18)
                .addComponent(addressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressAddButton)
                            .addComponent(addressEditButton)
                            .addComponent(addressDelButton))
                        .addGap(18, 18, 18)
                        .addComponent(noteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        newContactButton.setText("New");
        newContactButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                newContactButtonActionPerformed(evt);
            }
        });

        deleteContactButton.setText("Delete");
        deleteContactButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newContactButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteContactButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newContactButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteContactButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
        resetContactPanel();
    }// </editor-fold>
    
    private void newContactButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		resetContactPanel();
    		tempPerson = new Person();
    		personTable.clearSelection();
    }
    private void deleteContactButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		if (personTable.getSelectionModel().isSelectionEmpty() == false) {
    			listPersons.remove(newPerson);
    			personTable.setModel(new ContactTableModel(listPersons));
    			personTable.validate();
		
    			resetContactPanel();
    			tempPerson = new Person();
    		} 
    }

    // ---PHONELIST BUTTON ACTIONS----
    private void updatePhoneList() {
    		String[] phoneNums = newPerson.getPhoneNums();
		phoneList.setListData(phoneNums);
		phoneList.validate();
    }
    private void phoneAddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    		String phone = JOptionPane.showInputDialog(null, "Phone:");
    		String phoneType = JOptionPane.showInputDialog(null, "Type:");
    		newPerson.addPhoneNum(phone, phoneType);
    		
    		updatePhoneList();
    }              
    private void phoneEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		if (phoneList.isSelectionEmpty() == false) {
    			String phone = JOptionPane.showInputDialog(null, "Phone:");
    			String phoneType = JOptionPane.showInputDialog(null, "Type:");
    			String selectedKey = phoneList.getSelectedValue();
    			selectedKey  = selectedKey.split(":")[0];
    			newPerson.editPhoneNum(selectedKey, phone, phoneType);
		
    			updatePhoneList();
    		}
    }
    private void phoneDelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		if (phoneList.isSelectionEmpty() == false) {
    			String selectedKey = phoneList.getSelectedValue();
    			selectedKey  = selectedKey.split(":")[0];
    			newPerson.delPhoneNum(selectedKey);
		
    			updatePhoneList();
    		}
    }
    
    //---EMAIL-LIST BUTTON ACTIONS---
    private void updateEmailList() {
    		String[] emails = newPerson.getEmails();
		emailList.setListData(emails);
		emailList.validate();
    }
    private void emailAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		String email = JOptionPane.showInputDialog(null, "Email:");
		String emailType = JOptionPane.showInputDialog(null, "Type:");
		newPerson.addEmail(email, emailType);
		
		updateEmailList();
    }
    private void emailEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		if (emailList.isSelectionEmpty() == false) {
    			String email = JOptionPane.showInputDialog(null, "Email:");
    			String emailType = JOptionPane.showInputDialog(null, "Type:");
    			String selectedKey = emailList.getSelectedValue();
    			selectedKey  = selectedKey.split(":")[0];
    			newPerson.editEmail(selectedKey, email, emailType);
		
    			updateEmailList();
    		}
    }
    private void emailDelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		if (emailList.isSelectionEmpty() == false) {
    			String selectedKey = emailList.getSelectedValue();
    			selectedKey  = selectedKey.split(":")[0];
    			newPerson.delEmail(selectedKey);
		
    			updateEmailList();
    		}
    }
    
    //---ADDRESSLIST BUTTON ACTIONS
    private void updateAddressList() {
    		Address[] addresses = newPerson.getAddresses();
		addressList.setListData(addresses);
		addressList.validate();
    }
    private void addressAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		String street = JOptionPane.showInputDialog(null, "Street:");
		String city = JOptionPane.showInputDialog(null, "City:");
		String state = JOptionPane.showInputDialog(null, "State:");
		String zip = JOptionPane.showInputDialog(null, "Zip:");
		String type = JOptionPane.showInputDialog(null, "Type:");
		
		Address addressObj = new Address(type, street, city, state, zip);
		newPerson.addAddress(addressObj);
		
		updateAddressList();
    }
    private void addressEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
    			if (addressList.isSelectionEmpty() == false) {
    				String street = JOptionPane.showInputDialog(null, "Street:");
    				String city = JOptionPane.showInputDialog(null, "City:");
    				String state = JOptionPane.showInputDialog(null, "State:");
    				String zip = JOptionPane.showInputDialog(null, "Zip:");
    				String type = JOptionPane.showInputDialog(null, "Type:");
		
    				Address addressObj = addressList.getSelectedValue();
    				Address newAddressObj = new Address(type, street, city, state, zip);
    				newPerson.editAddress(addressObj, newAddressObj);
		
    				updateAddressList();
    			}
    }
    private void addressDelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		if (addressList.isSelectionEmpty() == false) {
    			Address addressObj = addressList.getSelectedValue();
    			newPerson.delAddress(addressObj);
    		
    			updateAddressList();
    		}
    }
    
    //---SAVE BUTTON---
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
    		newPerson.setNote(noteTextArea.getText());
    		newPerson.setFirstName(firstNameTextField.getText());
    		newPerson.setLastName(lastNameTextField.getText());
    		
    		listPersons.add(newPerson);
    		listPersons.remove(tempPerson);
    		personTable.setModel(new ContactTableModel(listPersons));
    		personTable.validate();
    		
    		resetContactPanel();
    		tempPerson = new Person();
    }
    
    private void resetContactPanel() {
    		newPerson = new Person();
    		
		updatePhoneList();
		updateEmailList();
		updateAddressList();
		
		firstNameTextField.setText("\"Johnny\"");
		lastNameTextField.setText("\"Appleseed\"");
		noteTextArea.setText(" ");
    }
    
    private void personTableMouseClickPerformed(MouseEvent e) {
    		if(e.getClickCount() == 1) {
			JTable target = (JTable)e.getSource();
			int row = target.getSelectedRow();
			row = personTable.convertRowIndexToModel(row);
			int column = target.getSelectedColumn();
			
			newPerson = (Person)((ContactTableModel) personTable.getModel()).returnPerson(row);
			tempPerson = (Person)((ContactTableModel) personTable.getModel()).returnPerson(row);
			
			updatePhoneList();
			updateEmailList();
			updateAddressList();
			
			firstNameTextField.setText(newPerson.getFirstName());
			lastNameTextField.setText(newPerson.getLastName());
			noteTextArea.setText(newPerson.getNote());
			
		}
    }
    
    public List<Person> getList() {
    		return listPersons;
    }
   
    // Variables declaration - do not modify                     
    private javax.swing.JButton addressAddButton;
    private javax.swing.JButton addressDelButton;
    private javax.swing.JButton addressEditButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JList<Address> addressList;
    private javax.swing.JScrollPane addressListScrollPane;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JButton deleteContactButton;
    private javax.swing.JButton emailAddButton;
    private javax.swing.JButton emailDelButton;
    private javax.swing.JButton emailEditButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JList<String> emailList;
    private javax.swing.JScrollPane emailListScrollPane;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton newContactButton;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JScrollPane noteScrollPane;
    private javax.swing.JTextArea noteTextArea;
    private javax.swing.JTable personTable;
    private javax.swing.JButton phoneAddButton;
    private javax.swing.JButton phoneDelButton;
    private javax.swing.JButton phoneEditButton;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JList<String> phoneList;
    private javax.swing.JScrollPane phoneListScrollPane;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane tableScrollPane;
    private Person newPerson;
    private Person tempPerson;
    private Address sampleAddress1;
    private Address sampleAddress2;
    private Address sampleAddress3;
    private List<Person> listPersons;
    // End of variables declaration                   


}

