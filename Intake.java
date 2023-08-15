import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates an Intake object to intake a new RescueAnimal
 * @author patrickrivers
 * @version 1
 * @lastUpdate 08/13/2023
 */
public class Intake {
    Intake(){};

    /**
     * Creates and adds new Dog object.
      * @param scanner
     * @param <list>
     */
    public <list> void intakeNewDog(Scanner scanner) throws IOException {
        String name;
        String breed;
        String gender;
        String age;
        int parseAge;
        String weight;
        double parseWeight;
        String acquisitionDate;
        String acquisitionCountry;
        String trainingStatus;
        boolean reserved;
        String inServiceCountry;

        // Gets User Input information for a new Dog object
        System.out.println("Enter the dog's info. You can cancel intake at any time by typing \"Cancel.\"");
        System.out.println();


        System.out.println("What is the dog's name?: ");
        name = scanner.nextLine().toLowerCase();
        if (name.equalsIgnoreCase("cancel")){return;};

        System.out.println("What is the dog's breed?: ");
        breed = scanner.nextLine().toLowerCase();
        if (breed.equalsIgnoreCase("cancel")){return;};


        System.out.println("What is the dog's gender?: ");
        gender = scanner.nextLine().toLowerCase();
        if (gender.equalsIgnoreCase("cancel")){return;}


        System.out.println("What is the dog's age?: ");
        age = scanner.nextLine();
        if (age.equalsIgnoreCase("cancel")){return;}
        parseAge = Integer.parseInt(age);

        System.out.println("What is the dog's weight?: ");
        weight = scanner.nextLine();
        if (age.equalsIgnoreCase("cancel")){return;}
        parseWeight = Double.parseDouble(weight);


        System.out.println("When was this dog's acquisition date?: ");
        acquisitionDate = scanner.nextLine().toLowerCase();
        if (acquisitionDate.equalsIgnoreCase("cancel")){return;}


        System.out.println("Where was this dog acquired?: ");
        acquisitionCountry = scanner.nextLine().toLowerCase();
        if (acquisitionCountry.equalsIgnoreCase("cancel")){return;}



        trainingStatus = "intake";
        reserved = false;
        inServiceCountry = "none";

        Dog newDog = new Dog(name, breed, gender, parseAge, parseWeight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        // Import JSON Array from dogs.json
        Gson gson = new Gson();
        FileReader myReader = new FileReader("out/dogs.json");
        JsonReader jsonReader = new JsonReader(myReader);
        ArrayList<Dog> dogs = gson.fromJson(jsonReader, new TypeToken<ArrayList<Dog>>(){}.getType());

        // Checks to verify that newDog is not already in the system.
        for (Dog dog : dogs){
            if (dog.getName().equals(newDog.getName()) && dog.getAge() == newDog.getAge()){
                System.out.println("It seems this dog may already be in our system!");
                return;
            }
        };
        // Adds new Dog object to JSON Array
        dogs.add(newDog);

        // Write updated array to dogs.json
        FileWriter fileWriter = new FileWriter("out/dogs.json");
        gson.toJson(dogs, fileWriter);
        fileWriter.close();
        System.out.println("Dog added successfully!");
    };

    /**
     * Creates and adds a new Monkey Object
      * @param scanner
     * @param <list>
     */
    public <list> void intakeNewMonkey(Scanner scanner) throws IOException {
        String name;
        String gender;
        String age;
        int parseAge;
        String weight;
        double parseWeight;
        String acquisitionDate;
        String acquisitionCountry;
        String species;
        String trainingStatus;
        boolean reserved;
        String inServiceCountry;
        String bodyLength;
        double parseBodyLength;
        String height;
        double parseHeight;
        String tailLength;
        double parseTailLength;


        System.out.println("Enter the monkey's info. You can cancel intake at any time by typing \"Cancel.\"");
        System.out.println();


        System.out.println("What is the monkey's name?: ");
        name = scanner.nextLine().toLowerCase();
        if (name.equalsIgnoreCase("cancel")){return;};

        System.out.println("What is the monkey's species?: ");
        species = scanner.nextLine().toLowerCase();
        if (species.equalsIgnoreCase("cancel")){return;};


        System.out.println("What is the monkey's gender?: ");
        gender = scanner.nextLine().toLowerCase();
        if (gender.equalsIgnoreCase("cancel")){return;}


        System.out.println("What is the monkey's age?: ");
        age = scanner.nextLine();
        if (age.equalsIgnoreCase("cancel")){return;}
        parseAge = Integer.parseInt(age);

        System.out.println("What is the monkey's weight?: ");
        weight = scanner.nextLine();
        if (age.equalsIgnoreCase("cancel")){return;}
        parseWeight = Double.parseDouble(weight);

        System.out.println("What is the monkey's body length?: ");
        bodyLength = scanner.nextLine();
        if (bodyLength.equalsIgnoreCase("cancel")){return;}
        parseBodyLength = Double.parseDouble(bodyLength);

        System.out.println("What is the monkey's tail length?: ");
        tailLength = scanner.nextLine();
        if (tailLength.equalsIgnoreCase("cancel")){return;}
        parseTailLength = Double.parseDouble(tailLength);

        System.out.println("What is the monkey's total height?: ");
        height = scanner.nextLine();
        if (tailLength.equalsIgnoreCase("cancel")){return;}
        parseHeight = Double.parseDouble(height);

        System.out.println("When was this monkey's acquisition date?: ");
        acquisitionDate = scanner.nextLine().toLowerCase();
        if (acquisitionDate.equalsIgnoreCase("cancel")){return;}


        System.out.println("Where was this monkey acquired?: ");
        acquisitionCountry = scanner.nextLine().toLowerCase();
        if (acquisitionCountry.equalsIgnoreCase("cancel")){return;}



        trainingStatus = "intake";
        reserved = false;
        inServiceCountry = "none";


        Monkey newMonkey = new Monkey(name, gender, parseAge, parseWeight, acquisitionDate, acquisitionCountry, species, trainingStatus, reserved, inServiceCountry, parseBodyLength, parseHeight, parseTailLength);


        // Import JSON Array from monkeys.json
        Gson gson = new Gson();
        FileReader myReader = new FileReader("out/monkeys.json");
        JsonReader jsonReader = new JsonReader(myReader);
        ArrayList<Monkey> monkeys = gson.fromJson(jsonReader, new TypeToken<ArrayList<Monkey>>(){}.getType());

        // Checks to verify that newDog is not already in the system.
        for (Monkey monkey : monkeys){
            if (monkey.getName().equals(newMonkey.getName()) && monkey.getAge() == newMonkey.getAge()){
                System.out.println("It seems this monkey may already be in our system!");
                return;
            }
        };

        // Adds new Monkey object to JSON Array
        monkeys.add(newMonkey);

        // Write updated array to dogs.json
        FileWriter fileWriter = new FileWriter("out/monkeys.json");
        gson.toJson(monkeys, fileWriter);
        fileWriter.close();
        System.out.println("Monkey added successfully!");
    };


    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Scanner scnr = new Scanner(System.in);

        Intake intake = new Intake();
        intake.intakeNewDog(scnr);

        FileReader myReader = new FileReader("out/dogs.json");
        JsonReader jsonReader = new JsonReader(myReader);
        ArrayList<Dog> dogs = gson.fromJson(jsonReader, new TypeToken<ArrayList<Dog>>(){}.getType());
        for (Dog dog : dogs){
            System.out.println(dog.getName());
        };
    }
}
