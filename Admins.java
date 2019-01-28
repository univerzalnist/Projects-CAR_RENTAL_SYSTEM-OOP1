package cars;

import java.util.ArrayList;
import java.util.Scanner;

public class Admins extends Cars { 

    static ArrayList<Cars> cars = new ArrayList<>(); //List of the cars
    static ArrayList<Clients> clients = new ArrayList<>(); // List of Clients
    static Menu m = new Menu(); // used for printing menus depend on the type of interface (Polymorphisim)

    @Override // Display menu for Admins interface
    public void menu() {
        System.out.println("ADMINISTRATIVE MENU");
        System.out.println("-----------------------------");
        System.out.println("1.Display Cars");
        System.out.println("2.Display Clients");
        System.out.println("3.Set Renting Price");
        System.out.println("4.Add New Car");
        System.out.println("5.Remove Car");
        System.out.println("6.Return");

    }
    //Display Clients from the ArrayList clients
    void display_Clients(ArrayList<Clients> clients) {
        
        //check if empty then print no clients if true
        if (clients.isEmpty()) {
            System.out.println("No clients!");
        }
        

        for (int i = 0; i < clients.size(); i++) {

            System.out.print("-----------------------------------------\n");
            System.out.print((i + 1) + ".\n"
                    + "");
            System.out.println(clients.get(i).toString()); //access each client in the ArrayList by its refrence to print its information
            System.out.print("-----------------------------------------\n");
        }
        System.out.println("Choose another option: ");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // used for innputs
        String user="Admin"; // predefined username for admin system
        String password="Admin"; // predefined password for admin system
        welcome();

        //predefined cars
        
        cars.add(new Cars("Toyota", "Camry", 2007, 10000, "Automatic", "Benzin")); //your car on a rent service :)
        cars.add(new Cars("Honda", "Mazati", 2015, 150, "Manual", "Diesel"));
        cars.add(new Cars("Lada", "Ruska", 2018, 350, "Manual", "Diesel"));
        cars.add(new Cars("GCM", "Acadia", 2017, 200, "Automatic", "Benzin"));
        cars.add(new Cars("Lamborghini", "Huracan", 2018, 5000, "Automatic", "Benzin"));
        cars.add(new Cars("Dodge", "Challenger", 2018, 2000, "Manual", "Benzin"));
        cars.add(new Cars("Mercedes", "190D", 1997, 500, "Manual", "Diesel"));
        cars.add(new Cars("VW", "Golf V", 2010, 300, "Manual", "Diesel"));
        cars.add(new Cars("KIA", "Rio", 2014, 60, "Automatic", "Benzin"));
        cars.add(new Cars("Roolls Royce", "Phantom", 2018, 4000, "Automatic", "Benzin"));

        int opt; //used to pick option inside the switch for main interface
           
        m.print_menus(cars.get(0)); //Display main menu interface to choose which system.
        do {
            opt = input.nextInt(); //to allow the user to choose option

            switch (opt) {
                case 1:
                    input.nextLine(); 
                    System.out.println("User Name:");// enter user name to access admin system
                    user=input.nextLine();
                    System.out.println("Password:"); // enter password to access admin system
                    password=input.nextLine();
                    
                    // made for security pourposes to protect admin system from unauthorized users
                    if(user.equals("Admin")&&password.equals("Admin")){
                    admin_System(cars, clients); // entering the admin system 
                    }
                    else {
                        System.out.println("You don't have authorization to access the system");
                    }
                    
                    m.print_menus(cars.get(0)); //Display main menu interface to choose which system.
                    break;
                case 2:
                    client_System(cars, clients); //entering the admin system
                    m.print_menus(cars.get(0)); 
                    break;
                case 3: // Exit the whole program
                    break;
                default:
                    System.out.println("Wrong choice! Choose again: ");
            }
        } while (opt != 3); // this loop is used to maintain the system from exiting 
    }
    static void welcome(){
        System.out.println("" +
"                       ____________________\n" +
"                     //|           |        \\\n" +
"                   //  |           |          \\\n" +
"      ___________//____|___________|__________()\\__________________\n" +
"    /__________________|_=_________|_=___________|_________________{}\n" +
"    [           ______ |           | .           | ==  ______      { }\n" +
"  __[__        /##  ##\\|           |             |    /##  ##\\    _{# }_\n" +
" {_____)______|##    ##|___________|_____________|___|##    ##|__(______}\n" +
"             /  ##__##                              /  ##__##        \\\n" +
"----------------------------------------------------------------------------\n" +
                "\t\t\tWELCOME TO OUR CAR RENTAL SYSTEM \n");
    }
    static void admin_System(ArrayList<Cars> cars, ArrayList<Clients> clients) {
        Scanner input = new Scanner(System.in);
        Admins ceo = new Admins(); // we created a predefined admin to control the system
        
        int opt; //used to choose in admin menu

        m.print_menus(ceo); //Display menu for admins option by polymorphism
        do {
            opt = input.nextInt(); // to choose between options for admins 

            switch (opt) {
                case 1: //Display cars option
                    ceo.display(cars); //this call the display method 
                    m.print_menus(ceo); 
                    break;
                case 2: //Display client option
                    ceo.display_Clients(clients); //this call the display Clients method
                    break;
                case 3: //set Price option 
                    ceo.display(cars);
                    System.out.print("Number of car | new price: ");
                    cars.get(input.nextInt() - 1).setPrice(input.nextDouble()); // we take the car option from admin (-1 for index in the list) then set the car price
                    System.out.println("Your price is updated!");
                    m.print_menus(ceo);
                    break;
                case 4: // Add car
                    ceo.addCars(cars); // call addCars method
                    m.print_menus(ceo);
                    break;
                case 5:// Remove Car
                    System.out.println("Which car do you to remove?: ");
                    ceo.display(cars);
                    ceo.removeCar(cars); //call removeCar method
                    System.out.println("The car has been removed successfully!");
                    m.print_menus(ceo);
                    break;
                case 6://return 
                    break;
                default:
                    System.out.println("Wrong choice! Choose again: ");
            }

        } while (opt != 6); // to loop the admin inside admin interface 

    }

    static void client_System(ArrayList<Cars> cars, ArrayList<Clients> clients) {
        Scanner input = new Scanner(System.in);
        int opt;
         
        System.out.println("Provide your information ");
        System.out.print("Enter your name: ");
        String clientName = input.nextLine();
        System.out.print("Enter your age: ");
        int clientAge = input.nextInt();
        input.nextLine();
        System.out.println("Enter your Mobile Phone");
        String phone = input.nextLine();
        System.out.println("Enter your E-mail");
        String email = input.nextLine();
        System.out.print("I have driving licence (true)|(false): ");
        boolean drivingLicence = input.nextBoolean();

        //create clients with info provided above
        clients.add(new Clients(clientName, clientAge, phone, email, drivingLicence)); 

        m.print_menus(clients.get(0)); //Display menu for clients services by polymorphisim 
        do {
            opt = input.nextInt();// to choose between options for clients 

            switch (opt) {
                case 1: // Display Cars for the client
                    clients.get(Clients.numOfClients - 1).display(cars);
                    m.print_menus(clients.get(0));
                            
                    break;
                case 2://rent car for the client
                    clients.get(Clients.numOfClients - 1).rent(cars, clients);
                    opt = 3;
                    break;
                case 3://return to main interface
                    break;
                default:
                    System.out.println("Wrong choice! Choose again: ");
            }
        } while (opt != 3); // to loop client inside client interface 
        
    }
}
