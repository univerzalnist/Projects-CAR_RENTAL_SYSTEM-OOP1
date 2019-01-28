package cars;

import java.util.ArrayList;
import java.util.Scanner;

public class Clients extends Cars {

    Scanner input = new Scanner(System.in);

    static int ID;
    static double totalPrice = 0;
    private String clientName;
    private int clientAge;
    private String clientPhone;
    private String clientEmail;
    private int numOfRentDays = 0; //how many days the client want to rent the car
    private boolean drivingLicence = true;
    int numOfRenting = 0; // used for discounts 
    public static int numOfClients = 0;
    private String clientCar; //choosen car

    Clients() {
    }

    Clients(String clientName, int clientAge, String phone, String email, boolean drivingLicence) {
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientPhone = phone;
        this.clientEmail = email;
        this.drivingLicence = drivingLicence;
        this.clientCar = "none";
        numOfClients++;
    }

    //Display the Client interface
    @Override
    public void menu() {

        System.out.println("CLIENTS MENU");
        System.out.println("-----------------------------");
        System.out.println("1.Display Cars");
        System.out.println("2.Rent a car");
        System.out.println("3.Return");

    }

    //Display receipit for the client
    public void checkout(ArrayList<Cars> cars, ArrayList<Clients> clients, int ID, double total) {
        System.out.println("Your order details");
        System.out.println("------------------------------------------");
        System.out.println("NAME: " + clients.get(numOfClients - 1).clientName);
        System.out.println("AGE: " + clients.get(numOfClients - 1).clientAge);
        System.out.println("PHONE NUMBER: " + clients.get(numOfClients - 1).clientPhone);

        System.out.println("CAR: " + cars.get(ID - 1).getCompanyCar());
        System.out.println("MODEL: " + cars.get(ID - 1).getModel());
        System.out.println("FUEL TYPE: " + cars.get(ID - 1).getFuelType());
        System.out.println("GEAR: " + cars.get(ID - 1).getTransmissionType());
        System.out.println("PRICE/DAY: " + cars.get(ID - 1).getPrice());
        System.out.println("NO.RENT DAYS: " + this.numOfRentDays);
        System.out.println("TOTAL PRICE: " + total);
        System.out.println("NO.RENTING: " + this.numOfRenting);
    }

    //used to check if the client legal to rent a car
    public void check(ArrayList<Cars> cars, ArrayList<Clients> clients) {//, ArrayList<Clients> clients){

        System.out.println("RENT MENU");

        if (this.drivingLicence && this.clientAge >= 18) {
            rent(cars, clients);
        } else {
            System.out.println("Sorry! You are not allowed to rent a car.");
        }
    }

    // this method to allow client to rent a car
    public void rent(ArrayList<Cars> cars, ArrayList<Clients> clients) {
        Admins ceo = new Admins();
        if (this.drivingLicence && this.clientAge >= 18) {
        System.out.println("Which car do you want to rent: ");
        System.out.println("Available cars");
        ceo.display(cars);
        ID = input.nextInt();

        if (cars.get(ID - 1).available) { // if the car the client entered available it will ask proceed to next steps
            this.clientCar = cars.get(ID - 1).getCompanyCar();
            System.out.println("How many time did you rent a car from our service");
            this.numOfRenting = input.nextInt();

            System.out.println("The renting price for " + cars.get(ID - 1).getCompanyCar() + " is: " + cars.get(ID - 1).getPrice() + " SAR");
            System.out.println("How many days you want to rent it?: ");
            this.numOfRentDays = input.nextInt();

            //if client has rented before than he gets 20% Discount from total price 
            if (this.numOfRenting < 2) {
                totalPrice = cars.get(ID - 1).getPrice() * numOfRentDays;
            } else {
                totalPrice = cars.get(ID - 1).getPrice() * numOfRentDays - (cars.get(ID - 1).getPrice() * numOfRentDays * 0.20);
            }
            
            checkout(cars, clients, ID, totalPrice);
            cars.get(ID - 1).available = false; //client rented a car from a list
            System.out.println("\nThank you for renting! \n");
        } else {
            System.out.println("Sorry! The car is rented!");

            System.out.println("Do you want to rent another one? YES|NO: ");
            input.nextLine();
            String choice = input.nextLine(); 

            //used to call rent method again if client picked a rented car
            if (choice.equalsIgnoreCase("yes")) {
                rent(cars, clients);
            }
        }

    }
        else {
            System.out.println("Sorry! You are not allowed to rent a car.");
        }
    }
    //print each client from ArrayList
    @Override
    void display(ArrayList<Cars> clients) {

        for (int i = 0; i < clients.size(); i++) {
            System.out.print("-----------------------------------------\n");
            System.out.print((i + 1) + ".");
            System.out.println(clients.get(i).toString());
            System.out.print("-----------------------------------------\n");
        }
    }

    //Print each attribute for client object
    @Override
    public String toString() {
        System.out.println("NAME: "+this.clientName);
        System.out.println("AGE: "+this.clientAge);
        System.out.println("PHONE NUMBER: "+this.clientPhone);
        System.out.println("E-MAIL: "+this.clientEmail);
        System.out.println("RENTED CAR: "+ this.clientCar);
        return "";
    }

    //getters
    public String getClientName() {
        return clientName;
    }

    public int getClientAge() {
        return clientAge;
    }

    public int getNumOfRentDays() {
        return numOfRentDays;
    }

    public boolean getDrivingLicence() {
        return drivingLicence;
    }

    public String getPhone() {
        return clientPhone;
    }

    public String getEmail() {
        return clientEmail;
    }

    public String getClientCar() {
        return clientCar;
    }

    //setters
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public void setPhone(String phone) {
        this.clientPhone = phone;
    }

    public void setEmail(String email) {
        this.clientEmail = email;
    }

    public void setNumOfRentDays(int numOfRentDays) {
        this.numOfRentDays = numOfRentDays;
    }

    public void setDrivingLicence(boolean drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public void setClientCar(String clientCar) {
        this.clientCar = clientCar;
    }

}
