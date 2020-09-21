import java.util.Scanner;

public class Main {
    boolean exit;

    public static void main(String[] args) {
        String namn = "Jonssoncargo";
        Ship boat = new Ship(namn, 50, 5, 20, 666, 2, 2, "B", 100, true, "A", 1);
        boat.start();
        boat.printInfo();
        Main main = new Main();
        main.runMenu();

    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|          Welcome operator!        |");
        System.out.println("+-----------------------------------+");
    }

    private void printMenu() {
        System.out.println("\nMake your selection");
        System.out.println("[1] Ship");
        System.out.println("[2] Order");
        System.out.println("[3] Map");
        System.out.println("[4] Status");
        System.out.println("[0] Exit");
    }

    private int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 4) {
            try {
                System.out.print("\nEnter your choice: ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again");
            }
        }
        kb.close();
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
        case 0:
            exit = true;
            System.out.println("Thank your for using our simulator");
            break;
        case 1:
            // Ship();

            break;
        case 2:
            // Order();
            break;
        case 3:
            // Map();
        case 4:
            // Status();
        default:
            System.out.println("Unknown error has occured");
        }
    }
}
