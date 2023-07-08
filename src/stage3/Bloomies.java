package stage3;

//needed imports 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bloomies {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // customer information
        String customerId;
        String firstName;
        String lastName;
        String phoneNumber;

        // delivery address
        String region;
        String city;
        String street;
        String buildingNumber;
        String zipCode;

        // delivery date
        String deliveryDate = "";
        // Initialize price
        double price = 0.0;

        //welcoming messages 
        System.out.println("\t\t        *");
        System.out.println("\t\t       ***");
        System.out.println("\t\t      *****");
        System.out.println("\t\t     *******");
        System.out.println("\t\t    *********");
        System.out.println("\t\t   ***********");
        System.out.println("\t\t  *************");
        System.out.println("\t\t ***************");
        System.out.println("\t\t       * *");
        System.out.println("\t\t       * *");
        System.out.println("\t\t       * *");
        System.out.println("\t\t       * *");

        System.out.println("\n\n \tWelcome to Bloomies onilne system");

        // Ask user for which type of plant
        System.out.println("\n\nWhich type of plant would you like to order? " + "\n\n1. Flowering Plants \n2. Non-flowering Plants");
        int plantTypeChoice = getValidChoice(scanner, 1, 2);
        String plantType = (plantTypeChoice == 1) ? "flowering" : "non-flowering";

        // Ask user to choose a specific plant based on the plant type 
        System.out.println("\nHere are the available " + plantType + " plants: ");
        ArrayList<String> plantsList = (plantTypeChoice == 1) ? new FloweringPlant(0, "").getFlower() : new NonFloweringPlant(0, "").getPlant();

        for (int i = 0; i < plantsList.size(); i++) {
            System.out.println((i + 1) + ". " + plantsList.get(i));
        }
        System.out.println("Please choose one of these plants: ");
        int plantChoice = getValidChoice(scanner, 1, plantsList.size());
        String chosenPlant = plantsList.get(plantChoice - 1);

        // Ask user to choose a quantity of plants to purchase
        System.out.println("\nHow many " + chosenPlant + " plants would you like to purchase? ");
        System.out.println("Note: you can order maximum 5 plants");
        int quantityChoice = getValidChoice(scanner, 1, 5);

        // Output the chosen plant and quantity
        System.out.println(" \n*** You have chosen to purchase " + quantityChoice + " " + chosenPlant + " " + plantType + " plants *** ");

        System.out.println("\n\n-----------------------------------------------" + "Please now complete your personal information"
                + "-----------------------------------------------");

        // Prompt the user to enter thier information.
        //do-while to get the customer ID.
        do {
            System.out.println("\nEnter customer ID: ");
            customerId = scanner.nextLine();
            if (!isValidCustomerId(customerId)) {
                System.out.println("Invalid ID! the ID should contain 8 digits.");
            }
        } while (!isValidCustomerId(customerId));

        //do-while to get the customer First name.
        do {
            System.out.print("\nEnter your first name: ");
            firstName = scanner.nextLine();
            if (!isValidInformation(firstName)) {
                System.out.println("Invalid name! the name should contain only letters.");
            }
        } while (!isValidInformation(firstName));

        //do-while to get the customer Last name.
        do {
            System.out.print("\nEnter your last name: ");
            lastName = scanner.nextLine();
            if (!isValidInformation(lastName)) {
                System.out.println("Invalid name! the name should contain only letters.");
            }
        } while (!isValidInformation(lastName));

        //do-while to get the customer Phone Number.
        do {
            System.out.print("\nEnter your phone number (966XXXXXXXX): ");
            phoneNumber = scanner.nextLine();
            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid PhoneNumber! the Number should be in this pattern (966XXXXXXXX) .");
            }
        } while (!isValidPhoneNumber(phoneNumber));

        System.out.println("\n\n-----------------------------------------------" + "Please now complete your Address information"
                + "-----------------------------------------------");

        // Prompt the user to enter address information
        //do-while to get the customer region.
        do {
            System.out.print("\nEnter your Region: ");
            region = scanner.nextLine();
            if (!isValidInformation(region)) {
                System.out.println("Invalid Region name! the region name should contain only letters.");
            }
        } while (!isValidInformation(region));

        //do-while to get the customer city.
        do {
            System.out.print("\nEnter Your city: ");
            city = scanner.nextLine();
            if (!isValidInformation(city)) {
                System.out.println("Invalid City name! the city name should contain only letters.");
            }
        } while (!isValidInformation(city));

        //do-while to get the customer strret.
        do {
            System.out.print("\nEnter your street name: ");
            street = scanner.nextLine();
            if (!isValidInformation(street)) {
                System.out.println("Invalid street name! the street name should contain only letters.");
            }
        } while (!isValidInformation(street));

        //do-while to get the customer building number.
        do {
            System.out.print("\nEnter your building number: ");
            buildingNumber = scanner.nextLine();
            if (!isValidBuildingNumber(buildingNumber)) {
                System.out.println("Invalid building Number! the building name should contain only digits and maximum 4.");
            }
        } while (!isValidBuildingNumber(buildingNumber));

        //do-while to get the customer zip code.
        do {
            System.out.print("\nEnter your zip code: ");
            zipCode = scanner.nextLine();
            if (!isValidZipCode(zipCode)) {
                System.out.println("Invalid zip code! the zip code should contain only digits and maximum 6.");
            }
        } while (!isValidZipCode(zipCode));

        // Create the objects
        Customer customer = new Customer(customerId, firstName, lastName, phoneNumber);
        Address address = new Address(street, region, city, buildingNumber, zipCode);
        int plantPrice = (plantTypeChoice == 1) ? new FloweringPlant(0, "").getPriceForPlant(chosenPlant) : new NonFloweringPlant(0, "").getPriceForPlant(chosenPlant);
        Order order = new Order(plantType, chosenPlant, quantityChoice, plantPrice, deliveryDate);
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = formatter.format(currentDate);
        order.setDeliveryDate(currentDateString);
        
        //add the coustomer to the order as an observers
        order.addObserver(customer);

         System.out.println("\n\n---------------------------------------------------" + "Here is your order details"
                + "--------------------------------------------------------------");
        // Printing the details
        System.out.println(customer);
        System.out.println(address);
        System.out.println(order);
        System.out.println("Total Bill: $" + order.calcPrice2());
        System.out.println("\nThank you for your Order!");
        scanner.close();
    }

    //methods to validate the user inputs
    private static boolean isValidCustomerId(String customerId) {
        return customerId.matches("\\d{8}");
    }

    private static boolean isValidInformation(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("966\\d{9}");
    }

    private static boolean isValidBuildingNumber(String buildingNumber) {
        return buildingNumber.matches("\\d{1,4}");
    }

    private static boolean isValidZipCode(String zipCode) {
        return zipCode.matches("\\d{1,6}");
    }

    public static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = 0;
        boolean validInput = false;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            }
        } while (!validInput);
        return choice;
    }

}
