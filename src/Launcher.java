// TODO - implementation du retour au menu principal
// TODO - implementations du menu Remove a place
import menu.Menu;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.mainMenu();
        Scanner kb = new Scanner(System.in);
        int choice = kb.nextInt();

        switch (choice) {
            case 1 -> // Add a place
                    menu.menu1();
            case 2 -> // Find a place
                    menu.menu2();
            case 3 -> // Edit a place
                    menu.menu3();
            case 4 -> // remove a place
                    menu.menu4();
            case 5 -> // Add a trip
                    menu.menu5();
            case 6 -> // Find a trip
                    menu.menu6();
            case 7 -> // Remove a trip
                    menu.menu7();
            case 8 -> {
                // Quit
                System.out.println("Bye, see you next time !");
                System.exit(0);
            }
            default -> {
                System.out.println("Please, choose a number between 1 to 8 !");
                System.out.println("---------------------------");
                Launcher.main(args);
            }
        }
    }
}
