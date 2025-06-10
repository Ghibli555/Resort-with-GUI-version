import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.util.List;

public class ResortGUI extends JFrame implements ActionListener {
	
// ArraLists
	private ArrayList<Accommodation> accommodations;
	private ArrayList<Customer> customers;
	private ArrayList<TravelPackage> travelpackages;

	// GUI components
	private JTabbedPane tabs;
	private JPanel pnlAccommodation, pnlAccInput, pnlAccDisplay, pnlAvaDisplay, pnlAccButtons, pnlAvaButtons,
	pnlCustomer, pnlCustomerInput, pnlCustomerDisplay, pnlCustomerButtons,
	pnlTravelPackage, pnlTravelPackageInput, pnlTravelPackageDisplay,pnlTravelPackageButtons;
	private JScrollPane scrollAccommodationPanel, scrollCustomerPanel, scrollTravelPackagePanel;

	// Accommodation panel
	private JList<Accommodation> listDisplayAcc, listAccSelection;
	private DefaultListModel<Accommodation> modelDisplayAcc;
	private JScrollPane scrollAccs, scrollAccSelection;
	private JButton btnAvailableAccommodations, btnListAccommodations,
	 btnRemoveAccommodation;

	// Customer panel
	private JLabel lblCustomerName, lblCustomerEmail, lblCustomerSkillsLevel;
	private JTextField txtCustomerName, txtCustomerEmail, txtSkillLevels;
	private ButtonGroup skillsLevelGroup;
	private JRadioButton rbtn1, rbtn2, rbtn3;
	private JList<Customer> listDisplayCustomer;
	private DefaultListModel<Accommodation> modelAccSelection;
	private DefaultListModel<Customer> modelDisplayCustomer;
	private JScrollPane scrollCustomers;
	private JButton btnAddCustomer, btnListCustomers, btnRemoveCustomer;

	// TravelPackage
	private JLabel lblTravelPackageDate, lblTravelPackageDuration, lblTravelPackageLiftPass, lblTravelPackageLessonFees;
	private JTextField txtTravelPackageDate, txtTravelPackageDuration, txtTravelPackageLiftPass,
			txtTravelPackageLessonFees;
	private JComboBox cmbTravelPackageLiftPass, cmbTravelPackageLessonFees;
	private JList<Accommodation> listSelectAccommodation;
	private JList<Customer> listSelectCustomer;
	private JList<TravelPackage> listDisplayTravelPackage;
	private DefaultListModel<Customer> modelSelectCustomer;
	private DefaultListModel<Accommodation> modelSelectAccommodation;
	private DefaultListModel<TravelPackage> modelDisplayTravelPackage;
	private JScrollPane scrollCustomerSelection, scrollAccommodationSelection, scrollTravelPackageDislay;
	private JButton btnAddTravelPackage, btnListTravelPackages, btnShowCustomers, btnShowAccommodations,
			btnRemoveTravelPackage, btnSaveTravelPackages, btnReadTravelPackages;

	// Constructor
	public ResortGUI() {
		super("Resort GUI");
		accommodations = new ArrayList<Accommodation>();
		customers = new ArrayList<Customer>();
		travelpackages = new ArrayList<TravelPackage>();

		// Load Accommodations and Customers
		Accommodation a1 = new Accommodation("Hotel", 120, 1);
		accommodations.add(a1);
		Accommodation a2 = new Accommodation("Hotel", 200, 2);
		accommodations.add(a2);
		Accommodation a3 = new Accommodation("Hotel", 270, 3);
		accommodations.add(a3);
		Accommodation a4 = new Accommodation("Lodge", 100, 1);
		accommodations.add(a4);
		Accommodation a5 = new Accommodation("Lodge", 160, 2);
		accommodations.add(a5);
		Accommodation a6 = new Accommodation("Lodge", 220, 3);
		accommodations.add(a6);
		Accommodation a7 = new Accommodation("Apartment", 290, 2);
		accommodations.add(a7);
		Accommodation a8 = new Accommodation("Apartment", 340, 3);
		accommodations.add(a8);
		Accommodation a9 = new Accommodation("Apartment", 400, 4);
		accommodations.add(a9);
		Accommodation a10 = new Accommodation("Apartment", 480, 5);
		accommodations.add(a10);

		Customer c1 = new Customer("Gilbert", "gilbert77@gmail.com", "Expert");
		customers.add(c1);
		Customer c2 = new Customer("Daniel", "daniel99@gmail.com", "Beginner");
		customers.add(c2);
		Customer c3 = new Customer("Ray", "ray16@gmail.com4", "Intermediate");
		customers.add(c3);

		// tabs
		tabs = new JTabbedPane();
		add(tabs);

		pnlAccommodation = new JPanel();
		pnlAccommodation.setLayout(new BorderLayout());
		pnlAccommodation.setPreferredSize(new Dimension(600, 700));
		scrollAccommodationPanel = new JScrollPane(pnlAccommodation);
		tabs.addTab("Accommodations", scrollAccommodationPanel);

		pnlCustomer = new JPanel();
		pnlCustomer.setLayout(new BorderLayout());
		pnlCustomer.setPreferredSize(new Dimension(600, 700));
		scrollCustomerPanel = new JScrollPane(pnlCustomer);
		tabs.addTab("Customers", scrollCustomerPanel);

		pnlTravelPackage = new JPanel();
		pnlTravelPackage.setLayout(new BorderLayout());
		pnlTravelPackage.setPreferredSize(new Dimension(600, 700));
		scrollTravelPackagePanel = new JScrollPane(pnlTravelPackage);
		tabs.addTab("TravelPackages", scrollTravelPackagePanel);

		// Accommodation display panel
		pnlAccDisplay = new JPanel();
		modelDisplayAcc = new DefaultListModel<Accommodation>();
		listDisplayAcc = new JList<Accommodation>(modelDisplayAcc);
		listDisplayAcc.setBorder(new TitledBorder("List of Accommodations"));
		scrollAccs = new JScrollPane(listDisplayAcc);
		scrollAccs.setPreferredSize(new Dimension(872, 310));
		pnlAccDisplay.add(scrollAccs);
		pnlAccommodation.add(pnlAccDisplay, BorderLayout.NORTH);
		
		modelAccSelection = new DefaultListModel<Accommodation>();
		listAccSelection = new JList<Accommodation>(modelAccSelection);
		listAccSelection.setBorder(new TitledBorder("List of available accommodations"));
		scrollAccSelection = new JScrollPane(listAccSelection);
		scrollAccSelection.setPreferredSize(new Dimension(872, 310));
		pnlAccDisplay.add(scrollAccSelection);
		pnlAccommodation.add(pnlAccDisplay, BorderLayout.CENTER);
		

		// Accommodation button panel
		pnlAccButtons = new JPanel();
		btnAvailableAccommodations = new JButton("List Available Accommodations");
		btnListAccommodations = new JButton("List Accommodations");
		btnRemoveAccommodation = new JButton("Remove Accommodation/s");
		
		pnlAccButtons.add(btnAvailableAccommodations);
		pnlAccButtons.add(btnListAccommodations);
		pnlAccButtons.add(btnRemoveAccommodation);
		
		pnlAccommodation.add(pnlAccButtons, BorderLayout.SOUTH);
		btnAvailableAccommodations.addActionListener(this);
		btnListAccommodations.addActionListener(this);
		btnRemoveAccommodation.addActionListener(this);
		
		
		// Customer input panel
		pnlCustomerInput = new JPanel();
		pnlCustomerInput.setLayout(new GridLayout(5, 1, 10, 10));
		pnlCustomerInput.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		pnlCustomerInput.setLayout(new BoxLayout(pnlCustomerInput, BoxLayout.Y_AXIS));
		lblCustomerName = new JLabel("Full name: ");
		lblCustomerEmail = new JLabel("Email: ");
		lblCustomerSkillsLevel = new JLabel("Customer SkillsLevel: ");
		txtCustomerName = new JTextField(30);
		txtCustomerEmail = new JTextField(30);

		skillsLevelGroup = new ButtonGroup();
		JRadioButton rbtn1 = new JRadioButton("Beginner");
		JRadioButton rbtn2 = new JRadioButton("Intermediate");
		JRadioButton rbtn3 = new JRadioButton("Expert");
		skillsLevelGroup.add(rbtn1);
		skillsLevelGroup.add(rbtn2);
		skillsLevelGroup.add(rbtn3);

		pnlCustomerInput.add(lblCustomerName);
		pnlCustomerInput.add(txtCustomerName);
		pnlCustomerInput.add(lblCustomerEmail);
		pnlCustomerInput.add(txtCustomerEmail);
		pnlCustomerInput.add(rbtn1);
		pnlCustomerInput.add(rbtn2);
		pnlCustomerInput.add(rbtn3);

		pnlCustomer.add(pnlCustomerInput, BorderLayout.NORTH);

		// Customer display panel
		pnlCustomerDisplay = new JPanel();
		modelDisplayCustomer = new DefaultListModel<Customer>();
		listDisplayCustomer = new JList<Customer>(modelDisplayCustomer);
		listDisplayCustomer.setBorder(new TitledBorder("List of Customers"));
		scrollCustomers = new JScrollPane(listDisplayCustomer);
		scrollCustomers.setPreferredSize(new Dimension(872, 525));
		pnlCustomerDisplay.add(scrollCustomers);
		pnlCustomer.add(pnlCustomerDisplay, BorderLayout.CENTER);

		// Customer button panel
		pnlCustomerButtons = new JPanel();
		btnAddCustomer = new JButton("Add Customer");
		btnListCustomers = new JButton("List Customers");
		btnRemoveCustomer = new JButton("Remove Customer/s");
		pnlCustomerButtons.add(btnAddCustomer);
		pnlCustomerButtons.add(btnListCustomers);
		pnlCustomerButtons.add(btnRemoveCustomer);
		pnlCustomer.add(pnlCustomerButtons, BorderLayout.SOUTH);
		btnAddCustomer.addActionListener(this);
		btnListCustomers.addActionListener(this);
		btnRemoveCustomer.addActionListener(this);

		// TravelPackage input panel
		pnlTravelPackageInput = new JPanel();
		pnlTravelPackageInput.setLayout(new GridLayout(2, 1, 10, 10));
		pnlTravelPackageInput.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		lblTravelPackageDate = new JLabel("Date(yyyy-mm-dd): ");
		lblTravelPackageDuration = new JLabel("Duration: ");
		lblTravelPackageLiftPass = new JLabel("LiftPass: ");
		lblTravelPackageLessonFees = new JLabel("LessonFees: ");
		txtTravelPackageDate = new JTextField(30);
		txtTravelPackageDuration = new JTextField(30);
		String[] liftPass = { "1 day is $26", "5 days is $200" };
		cmbTravelPackageLiftPass = new JComboBox<>(liftPass);

		String[] lessonFees = { "Expert is $15", "Intermediate is $20", "Beginner is $25" };
		cmbTravelPackageLessonFees = new JComboBox<>(lessonFees);

		pnlTravelPackageInput.add(lblTravelPackageDate);
		pnlTravelPackageInput.add(txtTravelPackageDate);
		pnlTravelPackageInput.add(lblTravelPackageDuration);
		pnlTravelPackageInput.add(txtTravelPackageDuration);
		pnlTravelPackageInput.add(lblTravelPackageLiftPass);
		pnlTravelPackageInput.add(cmbTravelPackageLiftPass);
		pnlTravelPackageInput.add(lblTravelPackageLessonFees);
		pnlTravelPackageInput.add(cmbTravelPackageLessonFees);

		pnlTravelPackage.add(pnlTravelPackageInput, BorderLayout.NORTH);

		// TravelPackage display panel
		pnlTravelPackageDisplay = new JPanel();
		modelSelectCustomer = new DefaultListModel<Customer>();
		listSelectCustomer = new JList<Customer>(modelSelectCustomer);
		listSelectCustomer.setBorder(new TitledBorder("Select a Customer"));
		scrollCustomerSelection = new JScrollPane(listSelectCustomer);
		scrollCustomerSelection.setPreferredSize(new Dimension(872, 200));
		pnlTravelPackageDisplay.add(scrollCustomerSelection);

		modelSelectAccommodation = new DefaultListModel<Accommodation>();
		listSelectAccommodation = new JList<Accommodation>(modelSelectAccommodation);
		listSelectAccommodation.setBorder(new TitledBorder("Select a Accommodation"));
		scrollAccommodationSelection = new JScrollPane(listSelectAccommodation);
		scrollAccommodationSelection.setPreferredSize(new Dimension(872, 200));
		pnlTravelPackageDisplay.add(scrollAccommodationSelection);

		modelDisplayTravelPackage = new DefaultListModel<TravelPackage>();
		listDisplayTravelPackage = new JList<TravelPackage>(modelDisplayTravelPackage);
		listDisplayTravelPackage.setBorder(new TitledBorder("List of TravelPackages"));
		scrollTravelPackageDislay = new JScrollPane(listDisplayTravelPackage);
		scrollTravelPackageDislay.setPreferredSize(new Dimension(872, 200));
		pnlTravelPackageDisplay.add(scrollTravelPackageDislay);
		pnlTravelPackage.add(pnlTravelPackageDisplay, BorderLayout.CENTER);

		// TravelPackage button panel
		pnlTravelPackageButtons = new JPanel();
		btnAddTravelPackage = new JButton("Add TravelPackage");
		btnListTravelPackages = new JButton("List TravelPackages");
		btnShowCustomers = new JButton("Display Customers");
		btnShowAccommodations = new JButton("Display Accommodations");
		btnRemoveTravelPackage = new JButton("Remove TravelPackage/s");
		btnSaveTravelPackages = new JButton("Save");
		btnReadTravelPackages = new JButton("Read");
		pnlTravelPackageButtons.add(btnShowCustomers);
		pnlTravelPackageButtons.add(btnShowAccommodations);
		pnlTravelPackageButtons.add(btnAddTravelPackage);
		pnlTravelPackageButtons.add(btnListTravelPackages);
		pnlTravelPackageButtons.add(btnRemoveTravelPackage);
		pnlTravelPackageButtons.add(btnSaveTravelPackages);
		pnlTravelPackageButtons.add(btnReadTravelPackages);
		pnlTravelPackage.add(pnlTravelPackageButtons, BorderLayout.SOUTH);
		btnAddTravelPackage.addActionListener(this);
		btnShowCustomers.addActionListener(this);
		btnShowAccommodations.addActionListener(this);
		btnListTravelPackages.addActionListener(this);
		btnRemoveTravelPackage.addActionListener(this);
		btnSaveTravelPackages.addActionListener(this);
		btnReadTravelPackages.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnListAccommodations) {
			modelDisplayAcc.clear();
			for (Accommodation acc : accommodations) {
				modelDisplayAcc.addElement(acc);
			}
		} 
		else if(e.getSource() == btnAvailableAccommodations){
			modelAccSelection.clear();
			for(Accommodation acc: accommodations){
				modelAccSelection.addElement(acc);
			}
		}
		else if (e.getSource() == btnRemoveAccommodation) {
			List<Accommodation> selected = listDisplayAcc.getSelectedValuesList();
			for (Accommodation acc : selected) {
				accommodations.remove(acc);
			}
			modelDisplayAcc.clear();
			for (Accommodation acc : accommodations) {
				modelDisplayAcc.addElement(acc);
			}
		}
		
		else if (e.getSource() == btnAddCustomer) {
			try {
				String customerName = txtCustomerName.getText();
				String customerEmail = txtCustomerEmail.getText();
				String customerSkillsLevel = "";

				// Get the selected radio button from the ButtonGroup
				Enumeration<AbstractButton> buttons = skillsLevelGroup.getElements();
				while (buttons.hasMoreElements()) {
					AbstractButton button = buttons.nextElement();
					if (button.isSelected()) {
						customerSkillsLevel = button.getText();
						break;
					}
				}

				// Check if a radio button was selected
				if (customerSkillsLevel.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Please select a skill level.", "Input Error",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Customer cl = new Customer(customerName, customerEmail, customerSkillsLevel);
					customers.add(cl);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}

		else if (e.getSource() == btnListCustomers) {
			modelDisplayCustomer.clear();
			for (Customer cl : customers) {
				modelDisplayCustomer.addElement(cl);
			}
		} else if (e.getSource() == btnRemoveCustomer) {
			List<Customer> selected = listDisplayCustomer.getSelectedValuesList();
			for (Customer cl : selected) {
				customers.remove(cl);
			}
			modelDisplayCustomer.clear();
			for (Customer cl : customers) {
				modelDisplayCustomer.addElement(cl);
			}
		} else if (e.getSource() == btnShowCustomers) {
			modelSelectCustomer.clear();
			for (Customer cl : customers) {
				modelSelectCustomer.addElement(cl);
			}
		} else if (e.getSource() == btnShowAccommodations) {
			modelSelectAccommodation.clear();
			for (Accommodation acc : accommodations) {
				modelSelectAccommodation.addElement(acc);
			}
		} else if (e.getSource() == btnAddTravelPackage) {
			try {
				String date = txtTravelPackageDate.getText();
				double duration = Double.parseDouble(txtTravelPackageDuration.getText());

				// Get the selected lift pass and lesson fees options
				String liftpass = "";
				if (cmbTravelPackageLiftPass != null && cmbTravelPackageLiftPass.getSelectedItem() != null) {
					liftpass = (String) cmbTravelPackageLiftPass.getSelectedItem();
				}
				String lessonfees = "";
				if (cmbTravelPackageLessonFees != null && cmbTravelPackageLessonFees.getSelectedItem() != null) {
					lessonfees = (String) cmbTravelPackageLessonFees.getSelectedItem();
				}

				TravelPackage tr = new TravelPackage(date, duration, liftpass, lessonfees);
				travelpackages.add(tr);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == btnListTravelPackages) {
			modelDisplayTravelPackage.clear();
			for (TravelPackage tr : travelpackages) {
				modelDisplayTravelPackage.addElement(tr);
			}
		} else if (e.getSource() == btnRemoveTravelPackage) {
			List<TravelPackage> selected = listDisplayTravelPackage.getSelectedValuesList();
			for (TravelPackage tr : selected) {
				travelpackages.remove(tr);
			}
			modelDisplayTravelPackage.clear();
			for (TravelPackage tr : travelpackages) {
				modelDisplayTravelPackage.addElement(tr);
			}
		} else if (e.getSource() == btnSaveTravelPackages) {
			/* TravelPackages to be saved. */
			JFileChooser fileSaver = new JFileChooser();
			int returnValue = fileSaver.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileSaver.getSelectedFile();

				FileOutputStream fos = null;
				ObjectOutputStream oos = null;

				try {
					fos = new FileOutputStream(selectedFile);
					oos = new ObjectOutputStream(fos);

					for (TravelPackage tr : travelpackages) {
						oos.writeObject(tr);
					}
				} catch (Exception ex) {
					System.err.println("Error in saving: " + ex.getMessage());
				} finally {
					try {
						fos.close();
						oos.close();
					} catch (Exception fe) {
						System.err.println("Error: " + fe.getMessage());
					}
				}
			}
		} else if (e.getSource() == btnReadTravelPackages) {
			/* TravelPackages to be read. */
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				FileInputStream fis = null;
				ObjectInputStream ois = null;

				try {
					fis = new FileInputStream(selectedFile);
					ois = new ObjectInputStream(fis);

					TravelPackage tr = null;
					while (true) {
						try {
							Object obj = ois.readObject();
							tr = (TravelPackage) obj;
							travelpackages.add(tr);
						} catch (EOFException eofe) {
							break;
						}
					}
				} catch (Exception ex) {
					System.err.println("Error: " + ex.getMessage());
				} finally {
					try {
						fis.close();
						ois.close();
					} catch (Exception fe) {
						System.err.println("Error: " + fe.getMessage());
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ResortGUI fr = new ResortGUI();
		fr.setSize(920, 820);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
