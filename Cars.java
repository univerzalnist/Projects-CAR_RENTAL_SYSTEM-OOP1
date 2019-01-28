package cars;

import java.util.ArrayList;
import java.util.Scanner;

public class Cars {

    static Scanner input = new Scanner(System.in);

    private String companyCar;
    private String model;
    private int modelYear;
    private double price;
    private String transmissionType;
    private String fuelType;
    public boolean available = true;
   

    Cars() {}

    Cars(String companyCar, String model, int modelYear, double price, String transmissionType, String fuelType) {
        this.companyCar = companyCar;
        this.model = model;
        this.modelYear = modelYear;
        this.price = price;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
       
    }
    
    //this method used to add cars in the ArrayList
    void addCars(ArrayList<Cars> cars) {
        System.out.println("Add cars details: ");
        
        // recieve inputs from admin 
        System.out.print("Company Brand: ");
        String company = input.nextLine();
        System.out.print("Car Model: ");
        String model = input.nextLine();
        System.out.print("Model Year: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.print("Renting Price: ");
        double renting_price = input.nextDouble();
        input.nextLine();
        System.out.print("Transmission Type: ");
        String transimission = input.nextLine();
        System.out.print("Fuel Type: ");
        String fuel = input.nextLine();
        
        //add new cars to the list by constructing new object with inputs recived above
        cars.add(new Cars(company, model, year, renting_price, transimission, fuel));

        System.out.println("Your Car has successfully added");
        System.out.println("Choose another option");

    }

    //remove a car from ArrayList
    void removeCar(ArrayList<Cars> cars) {
        cars.remove(input.nextInt() - 1);
    }

    // access each Car in the list to Display its informations 
    void display(ArrayList<Cars> cars) {

        for (int i = 0; i < cars.size(); i++) {
            System.out.print("----------------------------------------------\n");
            System.out.print((i + 1) + "."); // this is printed to make it user friendly
            cars.get(i).toString(); //access object by its refrence to print cars information
            System.out.println();
            System.out.print("----------------------------------------------\n");
        }

    }

    //Display Main menu for the Car Rental System
    
    public void menu() {

        System.out.println("**CAR RENTAL SYSTEM**");
        System.out.println("-----------------------------");
        System.out.println("1.Administration");
        System.out.println("2.Clients");
        System.out.println("3.Exit");
    }

    @Override // Print each attribute for car object
    public String toString() {
        //if the car is available the informations will be printed otherwise it will print the car is rented
        if (available) { 
            System.out.print(this.companyCar + " "); 
            System.out.print(this.model + " ");
            System.out.print(this.modelYear + " ");
            System.out.print(this.price + " ");
            System.out.print(this.transmissionType + " ");
            System.out.print(this.fuelType + " ");
        } else {
            System.out.println(this.companyCar + " is rented");
        }
        return "";
    }

    
    //getters
    public String getCompanyCar() {
        return companyCar;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getPrice() {
        return price;
    }

    //setters
    public void setCompanyCar(String companyCar) {
        this.companyCar = companyCar;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
 