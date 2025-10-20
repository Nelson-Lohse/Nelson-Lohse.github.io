import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
   // Instance variables (if needed)
   private static ArrayList<Dog> dogList = new ArrayList<Dog>();
   private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

   public static void main(String[] args) {
      initializeDogList();
      initializeMonkeyList();

      // Allows for menu options to be selected and initializes a scanner to take inputs
      boolean acceptingInput = true;
      Scanner input = new Scanner(System.in);

      do {
         displayMenu();
         String option = input.nextLine().trim().toLowerCase();

         switch(option) {
            case "1":
               // New dog
               intakeNewDog(input);
               break;

            case "2":
               // New Monkey
               intakeNewMonkey(input);
               break;

            case "3":
               // Makes a new reservation
               reserveAnimal(input);
               break;

            case "4":
               // Lists all dogs
               printAnimals("dog");
               break;

            case "5":
               // Lists all monkeys
               printAnimals("monkey");
               break;

            case "6":
               // Print all available animals
               printAnimals("available");
               break;

            case "q":
               // Quit
               acceptingInput = false;
               break;
               // If no valid input is made the default case is used
            default:
               System.out.println("Invalid option, please input a valid option");
               break;
         }
      } while(acceptingInput);

      System.out.println("Goodbye");
   }

   // This method prints the menu options
   public static void displayMenu() {
      System.out.println("\n\n");
      System.out.println("\t\t\t\tRescue Animal System Menu");
      System.out.println("[1] Intake a new dog");
      System.out.println("[2] Intake a new monkey");
      System.out.println("[3] Reserve an animal");
      System.out.println("[4] Print a list of all dogs");
      System.out.println("[5] Print a list of all monkeys");
      System.out.println("[6] Print a list of all animals that are not reserved");
      System.out.println("[q] Quit application");
      System.out.println();
      System.out.println("Enter a menu selection");
   }

   public static void initializeDogList() {
      Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
      Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
      Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
      // Adds dogs to dogList
      dogList.add(dog1);
      dogList.add(dog2);
      dogList.add(dog3);
   }

   // Adds a monkey to the list
   public static void initializeMonkeyList() {

      Monkey monkey1 = new Monkey("Sampson", "Capuchin", "male", "3", "6.1", "06-21-2020", "United States", "intake", false, "United States");

      monkeyList.add(monkey1);
   }

   // Adds a new dog to `dogList`
   public static void intakeNewDog(Scanner scanner) {
      System.out.println("What is the dog's name?");
      String name = scanner.nextLine().trim();

      // Checks if dog is already in dogList
      for(Dog dog : dogList)
         if(dog.getName().equalsIgnoreCase(name)) {
            System.out.println("\n\nThis dog is already in our system\n\n");
            return;
         }

      // Prompt for new information on dog to be added
      System.out.println("What is " + name + "'s breed?");
      String breed = scanner.nextLine().trim();
      
      System.out.println(name + "'s gender? (\"male\", \"female\")");
      String gender = scanner.nextLine().trim().toLowerCase();

      System.out.println(name + "'s age?");
      String age = scanner.nextLine().trim();

      System.out.println(name + "'s weight? (in pounds)");
      String weight = scanner.nextLine().trim();

      System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
      String acquisitionDate = scanner.nextLine().trim();

      System.out.println("Where was " + name + "'s acquired? (Country)");
      String acquisitionCountry = scanner.nextLine().trim();

      System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"Phase I/II/III\")");
      String trainingStatus = scanner.nextLine().trim();

      System.out.println("Is " + name + " reserved? (Y/N)");
      boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");

      System.out.println("What is " + name + "'s service country?");
      String inServiceCountry = scanner.nextLine().trim();

      Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

      dogList.add(newDog);
   }

   // Adds a new monkey to monkeyList
   public static void intakeNewMonkey(Scanner scanner) {
      System.out.println("What is the monkey's name?");
      String name = scanner.nextLine().trim();
      // Checks if the monkey is already in monkeyList
      for(Monkey monkey : monkeyList)
         if(monkey.getName().equalsIgnoreCase(name)) {
            System.out.println("\n\nThis monkey is already in our system\n\n");
            return;
         }
      // Set the breed as invalid initially
      boolean invalidBreed = true;
      // If the breed proves to be valid then the loop will exit
      String breed;
      do {
         System.out.println("What is " + name + "'s breed?");
         breed = scanner.nextLine().trim();

         for(String validBreed : Monkey.VALID_BREEDS)
            if(breed.equalsIgnoreCase(validBreed))
               invalidBreed = false;

         if(invalidBreed)
            System.out.println("Invalid breed option");
      } while(invalidBreed);
      // Enter all information on new monkey
      System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
      String gender = scanner.nextLine().trim().toLowerCase();

      System.out.println(name + "'s age?");
      String age = scanner.nextLine().trim();

      System.out.println(name + "'s weight? (in pounds)");
      String weight = scanner.nextLine().trim();

      System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
      String acquisitionDate = scanner.nextLine().trim();

      System.out.println("Where was " + name + "'s acquired? (Country)");
      String acquisitionCountry = scanner.nextLine().trim();

      System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"Phase I/II/III\")");
      String trainingStatus = scanner.nextLine().trim();

      System.out.println("Is " + name + " reserved? (Y/N)");
      boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");

      System.out.println("What is " + name + "'s service country?");
      String inServiceCountry = scanner.nextLine().trim();

      Monkey newMonkey = new Monkey(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

      monkeyList.add(newMonkey);
   }

   // Reserves an animal
   public static void reserveAnimal(Scanner scanner) {
      System.out.println("What type of animal will be needed? (\"dog\", \"monkey\")");
      String animalType = scanner.nextLine().trim();

      System.out.println("Where will the animal be serving? (Country)");
      String animalServiceCountry = scanner.nextLine().trim();

      // Search for available Dogs
      if(animalType.equalsIgnoreCase("dog"))
         for(Dog dog : dogList)
            if(true && dog.getInServiceLocation().equalsIgnoreCase(animalServiceCountry) && !dog.getReserved()) {
               dog.setReserved(true);

               System.out.println(dog.getName() + " has been reserved");
               return;
            }

      // Search for available monkeys
      if(animalType.equalsIgnoreCase("monkey"))
         for(Monkey monkey : monkeyList)
            if(true && monkey.getInServiceLocation().equalsIgnoreCase(animalServiceCountry)&& !monkey.getReserved()) {
               monkey.setReserved(true);

               System.out.println(monkey.getName() + " has been reserved");
               return;
            }

      System.out.println("Unable to reserve a " + animalType + " from " + animalServiceCountry + " at this time");
   }

   // Prints a list of animals
   public static void printAnimals(String outputType) {
      // Print the animal's name, status, acquisition country
      // and reserve status
      System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t| %s%n%n", "Name", "Status", "Acq. Country", "Reserved");

      switch(outputType) {
         case "dog":
            for(Dog dog : dogList) {
               String name = dog.getName();
               String status = dog.getTrainingStatus();
               String acquisitionCountry = dog.getAcquisitionLocation();
               boolean reserved = dog.getReserved();

               System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t| %s%n%n",name, status, acquisitionCountry, reserved);
            }
            break;

         case "monkey":
        	 for (Monkey monkey : monkeyList) {
        	    String name = monkey.getName();
        	    String status = monkey.getTrainingStatus();
        	    String acquisitionCountry = monkey.getAcquisitionLocation();
        	    boolean reserved = monkey.getReserved();

        	    System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t| %s%n%n",name, status, acquisitionCountry, reserved);
        	    }
        	    break;

         case "available":
            // Prints all non-reserved dogs
            for(Dog dog : dogList) {
               String name = dog.getName();
               String status = dog.getTrainingStatus();
               String acquisitionCountry = dog.getAcquisitionLocation();
               boolean reserved = dog.getReserved();

               boolean available = !reserved && status.equalsIgnoreCase("in service");
               if(!available)
                  continue;

               System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t| %s%n%n",name, status, acquisitionCountry, reserved);
            }

            // Prints all non-reserved monkeys
            for(Monkey monkey : monkeyList) {
               String name = monkey.getName();
               String status = monkey.getTrainingStatus();
               String acquisitionCountry = monkey.getAcquisitionLocation();
               boolean reserved = monkey.getReserved();

               boolean available = !reserved && status.equalsIgnoreCase("in service");
               if(!available)
                  continue;

               System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t| %s%n%n",name, status, acquisitionCountry, reserved);
            }
            break;

      }
   }
}