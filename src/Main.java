import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static MorseCodeTree tree = new MorseCodeTree();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        printMenu();
    }

    /**
     * Function printMenu() prints four menu options for the user to select from: display morse code
     * values, translate a morse code file, translate a text input, or exit. printMenu() switches
     * between various functions based on userChoice.
     */
    public static void printMenu() {
        String userChoice;


        System.out.println("~Welcome to the Morse Code Translator~");
        System.out.println("Select one of the following options (1-4):");
        System.out.println();
        System.out.println("1) Display Morse Code Values");
        System.out.println("2) Translate File");
        System.out.println("3) Translate Text Input");
        System.out.println("4) Exit");


        userChoice = scan.nextLine();


        switch(userChoice) {
            case "1":
                System.out.println("\n");
                printMenu();
                break;

            case "2":
                System.out.println(translateFile() + "\n");
                printMenu();
                break;

            case "3":
                System.out.println(translateLine() + "\n");
                printMenu();
                break;

            case "4":
                break;

            default:
                System.out.println("Invalid option.\n");
                printMenu();
                break;
        }

    }

    private static String translateFile() {
        System.out.println("File name to translate: ");
        String fileName = scan.nextLine();
        String translation = "";

        try {
            Scanner file = new Scanner(new File(fileName));

            while (file.hasNext()) {
                translation += tree.translateFromMorseCode(file.nextLine());
            }

            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return translation;
    }

    private static String translateLine() {

        System.out.println("\nEnter morse to translate. 1 - Menu: ");
        String userInput = scan.nextLine();
        String translation = "";

        try {
            translation = tree.translateFromMorseCode(userInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return translation;
    }

}