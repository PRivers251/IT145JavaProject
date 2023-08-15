import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static ArrayList<Dog> loadDogsJSONFile(){
        /**
         * Loads dogs.JSON into an ArrayList
         */
        //Reads in file data from dogs.json
         Gson gson = new Gson();
         FileReader dogJsonReader;

            try {
                dogJsonReader = new FileReader("out/dogs.json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

         JsonReader jsonReaderForDog = new JsonReader(dogJsonReader);
            return gson.fromJson(jsonReaderForDog, new TypeToken<ArrayList<Dog>>(){}.getType());
    }

    public static ArrayList<Monkey> loadMonkeysJSONFile(){
        /**
         * Loads monkeys.JSON into an ArrayList
         */
        Gson gson = new Gson();
        //Reads in file data from monkeys.json
        FileReader monkeyJsonReader;

            try {
                monkeyJsonReader = new FileReader("out/monkeys.json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
       JsonReader jsonReaderForMonkey = new JsonReader(monkeyJsonReader);
            return gson.fromJson(jsonReaderForMonkey, new TypeToken<ArrayList<Monkey>>(){}.getType());
    }

    public static void saveArraytoJSONFile(String filePath, ArrayList arrayList) throws IOException {
        Gson gson = new Gson();

        FileWriter fileWriter = new FileWriter(filePath);
        gson.toJson(arrayList, fileWriter);
        fileWriter.close();
        System.out.println();
        System.out.println("File updated successfully!");
        System.out.println();
    }




    //Assigns dogList & monkeyList to corresponding json data files
    public static ArrayList<Dog> dogList = loadDogsJSONFile();
    public static ArrayList<Monkey> monkeyList = loadMonkeysJSONFile();

    public Driver() throws FileNotFoundException {
    }
    // Instance variables (if needed)

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        //Declare a new Intake object
        Intake intake = new Intake();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        displayMenu();

        String userInput = scnr.nextLine();
        while (!userInput.equals("q")){

              switch (userInput) {
                case "1":
                    intake.intakeNewDog(scnr);
                    break;
                case "2":
                    intake.intakeNewMonkey(scnr);
                    break;
                case "3":
                    reserveAnimal(scnr);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "7":
                    System.out.println("FIXME: Add function to remove monkey!****");
                    break;
                case "8":
                    System.out.print("FIXME: Add function to remove dog!****");
                    break;
                case "9":
                    System.out.println("FIXME: Add function to update Rescue Animal!****");
                default:
                    System.out.println("Invalid Entry!");
                    break;
            }
            System.out.println();
            System.out.println("Press Enter/Return to continue.");
            scnr.nextLine();
            displayMenu();
            userInput = scnr.nextLine();

            // Reloads the JSON files to show updates
            dogList = loadDogsJSONFile();
            monkeyList = loadMonkeysJSONFile();
        };

	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

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


        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) throws IOException {
            //Look up Animal by AnimalType and In Service Country
            System.out.println();
            System.out.println("What type of anminal do you want to reserve dog / monkey?: ");
            String animalType = scanner.nextLine();
            if (animalType.equalsIgnoreCase("dog")){

                    dogList = loadDogsJSONFile();
                    System.out.println();

                    System.out.println("Enter the Service Country: ");
                    String inServiceCountry = scanner.nextLine().toLowerCase();
                    System.out.println();

                    //Searches through dogList and returns the Dog objects
                    System.out.printf("%-10s | %-10s | %-15s\n","Name", "Reserved", "InService Country");
                System.out.println("________________________________________________________");
                int counter = 0;
                for (Dog dog : dogList){
                    if (dog.getInServiceLocation().equals(inServiceCountry) && !dog.getReserved()){
                        System.out.printf("%-10s | %-10s | %-15s\n",dog.getName(), dog.getReserved(), dog.getInServiceLocation());
                        ++counter;
                    }
                }
                if (counter == 0) {
                    System.out.println("No animals matched your criteria.");
                    return;
                }
                System.out.println();
                System.out.println("Which animal do you want to reserve?: ");
                String reservedAnimal = scanner.nextLine().toLowerCase();

                for (Dog dog : dogList){
                    if (dog.getName().equalsIgnoreCase(reservedAnimal) && dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)){
                        dog.setReserved(true);
                    }
                };
                saveArraytoJSONFile("out/dogs.json", dogList);
            }

            // Searches through Monkeys
            else if (animalType.equalsIgnoreCase("monkey")){
                monkeyList = loadMonkeysJSONFile();
                System.out.println("Enter the Service Country: ");
                String inServiceCountry = scanner.nextLine().toLowerCase();

                //Searches through monkeyList and returns the corresponding Monkey objects
                System.out.printf("%-10s | %-10s | %-15s\n","Name", "Reserved", "InService Country");
                System.out.println("________________________________________________________");
                int counter = 0;
                for (Monkey monkey : monkeyList){
                    if (monkey.getInServiceLocation().equals(inServiceCountry) && !monkey.getReserved()){
                        System.out.printf("%-10s | %-10s | %-15s\n",monkey.getName(), monkey.getReserved(), monkey.getInServiceLocation());
                        ++counter;
                    }
                }
                if (counter == 0) {
                    System.out.println("No animals matched your criteria.");
                    return;
                }

                System.out.println("Which animal do you want to reserve?: ");
                String reservedAnimal = scanner.nextLine().toLowerCase();

                for (Monkey monkey : monkeyList){
                    if (monkey.getName().equalsIgnoreCase(reservedAnimal) && monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)){
                        monkey.setReserved(true);
                    }
                };
                saveArraytoJSONFile("out/monkeys.json", monkeyList);

            }
            else {
                System.out.println("Invalid Entry!");
                return;
            }
        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String list) {
            if (list.equals("dog")){

                System.out.printf("%-10s | %-10s | %-15s\n","Name", "Status", "InService Country");
                System.out.println("________________________________________________________");
                for (Dog dog: dogList){
                    System.out.printf("%-10s | %-10s | %-15s\n",dog.getName(), dog.getTrainingStatus(), dog.getInServiceLocation());
                };
            }
            else if (list.equals("monkey")){

                System.out.printf("%-10s | %-10s | %-15s\n","Name", "Status", "InService Country");
                System.out.println("________________________________________________________");
                for (Monkey monkey: monkeyList){
                    System.out.printf("%-10s | %-10s | %-15s\n",monkey.getName(), monkey.getTrainingStatus(), monkey.getInServiceLocation());
                }
            }
            else if (list.equals("available")){
                ArrayList<RescueAnimal> animals = new ArrayList<RescueAnimal>(dogList);
                animals.addAll(monkeyList);

                System.out.printf("%-10s | %-10s | %-15s\n","Name", "Age", "InService Country");
                System.out.println("________________________________________________________");
                for (RescueAnimal animal: animals){
                    if (animal.getTrainingStatus().equals("in service") && !animal.getReserved()){
                        System.out.printf("%-10s | %-10s | %-15s\n",animal.getName(), animal.getAge(), animal.getInServiceLocation());
                    }
                };
            }

        }
}

