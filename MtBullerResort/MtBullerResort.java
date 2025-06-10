import java.io.*; // imports classes and related to input/output operations.
import java.util.*; // imports classes and functionality related to various utility(Scanner, properties, ArrayList class) operations and data structures.
import java.time.*; // import classes related to date and time manipulation.

public class MtBullerResort {
    // Create Scanners for user input 
    Scanner myScanner = new Scanner(System.in); // Scanner to read input from the keyboard
    Scanner enterScanner = new Scanner(System.in); // Another Scanner for input (not typically needed)

    // Variable to store user choices    
    int choose; // An integer variable to store user menu choices

    // File input and output streams for reading/writing data to/from files
    private FileInputStream fis; // // FileInputStream for reading data from a file
    private ObjectInputStream ois; //ObjectInputStream for reading objects from a file
    private FileOutputStream fos; // FileOutputStream for writig data to a file
    private ObjectOutputStream oos; //ObjectoutputStream for writing objects to a file

    // ArrayLists to store data
    private ArrayList<Accommodation> accommodations ; // An ArrayList to store accommodation data
    private ArrayList<Customer> customers ;
    private ArrayList<TravelPackage> travelpackages ;

    // Constructor for initialising data structures
    public  MtBullerResort() {
        accommodations = new ArrayList<Accommodation>(); // Initalize the accommodation ArrayList
        customers = new ArrayList<Customer>();
        travelpackages = new ArrayList<TravelPackage>();
    }

    public void populateLists(){
        //Create an array of Accommodation objects and initialize 
        Accommodation[] arrOfAccommodations = { // declares an array named arrofAccommodations that will hold objects of the Accommodation class
            new Accommodation("Hotel", 120, 1), // constructed with three arguments: representing the type, price, ID of the accommodation
            new Accommodation("Hotel", 200, 2),
            new Accommodation("Hotel", 270, 3),
            new Accommodation("Lodge", 100, 1),
            new Accommodation("Lodge", 160, 2),
            new Accommodation("Lodge", 220, 3),
            new Accommodation("Apartment", 290, 2),
            new Accommodation("Apartment", 340, 3),
            new Accommodation("Apartment", 400, 4),
            new Accommodation("Apartment", 480, 5)
        };
        Customer[] arrOfCustomers = { // declares an array named arrOfCustomers that will hold objects of the Customer class. 
            new Customer("Gilbert", "gilbert77@gmail.com", "Expert"),
            new Customer("Daniel", "daniel99@gmail.com", "Beginner"),
            new Customer("Ray", "ray16@gmail.com4", "Intermediate")
        };
        for(int i = 0; i < arrOfAccommodations.length; i++)
            accommodations.add(arrOfAccommodations[i]); // arrOfAccommodations array and adds each Accomodation objects to the accommodations ArrayList

        for(int i = 0; i < arrOfCustomers.length; i++)
            customers.add(arrOfCustomers[i]); // arrofCustomers array, adding each Customer object to the customers ArrayList
        travelpackages.clear(); // ArrayList, effectively removing any existing travel packages that might have been there before. It initializes this list as empty.
    }
    public static void main (String[] args) {
        MtBullerResort mr = new MtBullerResort(); // Create a new instance of MtBullerResort
        mr.populateLists(); // Populate the lists of accommodations, customers, and clear travel packages
        mr.run(); // Start the main operation loop of the MtBullerResort
    }
    public void run() {
        boolean flag = true; // Initialize a boolean variable to control the loop
        Scanner input = new Scanner(System.in); // Create a Scanner object for user input 
        while (flag) { // Start a loop that continues as long as flag is true
            // Display the menu of MtBullerResort options
            System.out.println("MtBullerResort options\n------------------------\n"+
                               "1: Display all accommodations\n" +
                               "2: Display available accommodations\n"+
                               "3: Add customer\n"+
                               "4: List customers\n"+
                               "5: Create a package\n" +
                               "6: Add a lift pass to package\n"+
                               "7: Add lesson fees to package\n"+
                               "8: List packages\n"+
                               "9: Save packages to file\n"+
                               "10: Read packages from file\n"+
                               "11: Quit\n");
            System.out.print("Choose an option: "); // Prompt the user to choose an option
            int option = input.nextInt(); // Read the user's choice as on integer 
            input.nextLine(); // Consume the newline character left in the input buffer
            switch (option) {
                case 1:
                    displayAllAccommodations(); // Call a method to display all accomodations
                    break;
                case 2:
                    displayAvailableAccommodations();
                    break; // When option is 2, Exits to switch statement 
                case 3:
                    addCustomer();
                    break;
                case 4:
                    listCustomers();
                    break; // 
                case 5:
                    createPackage();
                    break;
                case 6:
                    addLiftPass();
                    break;
                case 7:
                    addLessonFees();
                    break;
                case 8:
                    listPackages();
                    break;
                case 9:
                    savePackages();
                    break;
                case 10:
                    readPackages();
                    break;
                case 11:
                    flag = false; // set flag to false to exit the loop
                    break;
                default: // Handle unexpected or invalid inputs 
                    System.out.println("Invalid option.");
            }
        } }

    public void displayAllAccommodations(){
        for (Accommodation a:accommodations) { // iterate through the accommodations collection
            System.out.println(a);
        }
    }

    public void displayAvailableAccommodations(){
        for (Accommodation a:accommodations) {
            if (a.getAvailability()) // checks if the availability of each Accommodation object is true
                System.out.println(a);
        }
    }
    public void addCustomer() {
        Scanner input = new Scanner(System.in); // new instance of the Scanner class, which is used for reading input from the standard input stream(keyboard). user input
        System.out.println("Customer name? ");
        String name = input.nextLine();
        System.out.println("Email? ");
        String email = input.nextLine();
        System.out.println("Skills Level? ");
        String skillsLevel = input.nextLine(); // reads a line of text from the standard input and stores it in the skills level variable
        Customer c = new Customer(name, email, skillsLevel); // initializes a customer with the provided information
        customers.add(c); //adds the newly created Customer object c to a collection of customers named
    }
    public void listCustomers() {
        for (Customer c:customers) {
            System.out.println(c);
        }
    }

    public Customer searchCustomerById() { // expected to return an object of the Customer class. it takes no parameters, meaning you need to call it without posing any arguments
        Scanner input = new Scanner(System.in);
        System.out.println("Customer ID? ");
        int custId = input.nextInt(); // reads an integer from the user using the nextIn() method of the input scanner and stores it in the custId
        input.nextLine(); // reads the newline character that remains in the input buffer after reading the integer
        for (Customer c:customers) {
            if (c.getCustId() == custId) // checks if the customer ID of the current Customer object c matches the custId
                return c; } // indicating the the customer with the specified ID has been found
        return null;  // if the loop completes without finding a customer with the specified ID, returns null, indicating that no matching customer was found in the collection
    }
    public void createPackage() {
        Scanner input = new Scanner(System.in);
        System.out.println("Customer ID? ");
        int custID = input.nextInt(); // Reads an integer from the user's input and stores it in the custID variable
        input.nextLine(); // Consumes the newline character left in the iput buffer reading the integer 
        System.out.println("Accommodation ID? ");
        int accID = input.nextInt();
        input.nextLine();
        System.out.println("Duration? ");
        int dur = input.nextInt();
        input.nextLine();
        System.out.println("Date in format yyyy-mm-dd? ");
        String dateStr = input.nextLine(); // used to read a line of text entered by the user and store it in a variable named dateStr
        LocalDate date = null; // Declares a LocalDate variable named date and intializes it to null.
        try{
            date = LocalDate.parse(dateStr); // Tries to parse the dateStr into a LocalDate object
        }
        catch(Exception e){} // exeptions that might be thrown within a preceding try block
        TravelPackage travelpackage = new TravelPackage(custID, accID, date, dur); // : Creates a new TravelPackage object using the customer ID, accommodation ID, date, and duration obtained from the user's input.
        boolean match = false; // check if an accommodation type match is found
        while(true) { // it will keep looping until a break statement is encountered
            System.out.println("Accommodation Type? ");
            String accommodationType = input.nextLine(); // used to read a line of text entered by the user and store it in a variable named accommodationType
            for (Accommodation a: accommodations){  // Iterates through the accommodations collection 
                if (a.getType().equalsIgnoreCase(accommodationType) &&
                    a.getAvailability()) { // Checks if the current accommodation's type matches 
                    a.setAvailability(false); // Sets the availability of the accommodation to false(indicating it's booked)
                    match = true;  // indicate the match was found 
                    break; // Exists the for loop since a match was found 
                } }
            if (match)
                break; // if a match was found, it breaks out of the while  loop 
            System.out.println("Did not find a match.");
        }
        travelpackages.add(travelpackage); // adds the travelpackage

    }
    
    public void addLiftPass() {
        System.out.println("Do you want to have 1 day pass or 5 days pass?");
        System.out.println("If 5 days pass, you will get a discount.");
        System.out.println("The 1 day pass will be $26.");
        System.out.println("The 5 days pass will be $200.");
        System.out.println("Which one do you prefer (1 for 1 day, 5 for 5 days)?");

        try {
            if (myScanner.hasNextInt()) {
                choose = myScanner.nextInt();
                myScanner.nextLine(); // Consume the newline character
                if (choose == 1) {
                    System.out.println("You have successfully added a 1 day LiftPass.");
                } else if (choose == 5) {
                    System.out.println("You have successfully added a 5 days LiftPass.");
                } else {
                    System.out.println("Invalid choice. Please choose 1 or 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter 1 or 5.");
                myScanner.nextLine(); // Consume the invalid input
            }
        } catch (java.util.InputMismatchException e) { // exception that occurs when there's a mismatch between the expected input
            System.out.println("Invalid input. Please enter 1 or 5.");
            myScanner.nextLine(); // Consume the invalid input
        }
    }


    public void addLessonFees() {
        boolean validInput = false; // he program assumes that the user has not provided valid input
        int choose = 0; // initial/default value for the user's choice

        while (!validInput) { // While validInput is false, continue executing the code inside this loop
            try {
                System.out.println("Price for the lesson will depend on your skill level");
                System.out.println("1. Expert = $15");
                System.out.println("2. Intermediate = $20");
                System.out.println("3. Beginner = $25");
                System.out.println("Which one do you prefer?");

                if (myScanner.hasNextInt()) { // Check if the next token is an integer
                    choose = myScanner.nextInt();
                    myScanner.nextLine(); // Consume the newline character

                    if (choose >= 1 && choose <= 3) { // Check if it's within the valid range
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter a valid number (1, 2, or 3).");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    myScanner.nextLine(); // Consume the invalid input
                }
            } catch (java.util.InputMismatchException e) { //  exception that occurs when there's a mismatch between the expected input
                System.out.println("Invalid input. Please enter a valid choice (1, 2, or 3).");
                myScanner.nextLine(); // Consume the invalid input
            }
        }

        // determine the price
        double price;
        switch (choose) {
            case 1:
                price = 15.0;
                break;
            case 2:
                price = 20.0;
                break;
            case 3:
                price = 25.0;
                break;
            default:
                price = 0.0; // Handle the case of invalid input
        }

        System.out.println("The lesson fee for your skill level is: $" + price);
    }

    public static void main(String[] args) {
        MtBullerResort resort = new MtBullerResort(); // creates an instance of the MtBullerResort class and assigns it to a variable named resort
        resort.addLessonFees(); // the resort object. It's invoking a method of the MtBullerResort class
    }
}




    public Customer searchCustomerByID() {  // Expected to return an object of the Customer class
        Scanner input = new Scanner(System.in);
        System.out.println("Customer ID? ");
        int custId = input.nextInt();
        input.nextLine();
        for (Customer c:customers) { // Iterates through the Customers collection 
            if (c.getCustId() == custId)  // checks if the customer ID of the current Customer object c matches the custId 
                return c; // indicating the the customer with the specified ID has been found
        }
        return null; // if the loop completes without finding a customer with the specified ID, returns null, indicating that no matching customer was found in the collection
    }

    public TravelPackage searchAccommodationsByCustId(int custId) {
        for (TravelPackage p: travelpackages) {
            if (p.getCustID() == custId)
                return p; }
        return null;
    }

    public Accommodation searchAccommodationsByAccID(int accID){
        for(Accommodation a: accommodations){ // Iterates through the accommodations collection
            if(a.getAccID() == accID)
                return a;
        }
        return null;
    }

    public void listPackages() {
        for (TravelPackage p: travelpackages) {
            System.out.println(p);
        } }

    public void savePackages() {
        try {
            fos = new FileOutputStream("travelpackages.dat"); // Store the serialized data. Create a FileOutPutStream object named fos and opens a file named travelpackages.dat
            oos = new ObjectOutputStream(fos); // Serilaized format to the file. create an ObjectOutputStream named oos 
            for (TravelPackage p: travelpackages) {
                oos.writeObject(p); // Saves the contents of travelpakages
            }
            fos.close(); // Ensure all data is flushed and the file is properly closed
            oos.close();
        } catch (Exception e) {
            e.printStackTrace(); // Common way to handle exceptions and troubleshoot
        } }

    public void readPackages() {
        travelpackages.clear();
        try {
            fis = new FileInputStream("travelpackages.dat"); // Reading binary data from a file
            ois = new ObjectInputStream(fis); // Reading object from an input stream
            while (true) { // it will keep looping until a break statement is encountered
                try { // prepared to handle any exceptions that may occur during its execution
                    Object object = ois.readObject(); // Reads an object from the ois(ObjectInputStream)
                    TravelPackage p = (TravelPackage)object; //  Performs a type cast. treat p as a TravelPackage object
                    int accID = p.getAccID(); // getAccID() method on the TravelPackage object p to retrieve the accommodationID associated with the travel package
                    Accommodation a = searchAccommodationsByAccID(accID); // search for an accommodation based on the accommodationID obtained from the TravelPackage
                    a.setAvailability(false); // a represents an accommodation object. accommodations may have an availability status, and setting it to false  
                    travelpackages.add(p); // adds the TravelPackage object p to a collection called travelpackages
                    System.out.println(p);
                } catch (EOFException eof) { //  Catches an End of File Exception
                    fis.close();  // Proceeds to close the file input stream 
                    ois.close(); // Proceeds to close the object input stream 
                    break; // if a match was found, it breaks out of the while loop 
                } }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions and troubleshoot 
        }
    } }
