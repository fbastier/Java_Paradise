
import dao.jdbc.JdbcPlaceDao;
import dao.jdbc.JdbcTripDao;
import menu.Menu;
import model.Place;
import model.Trip;

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
            case 3 -> {
                // Edit a place
            }
            case 4 -> {
                // remove a place
            }
            case 5 -> // Add a trip
                    menu.menu5();
            case 6 -> {
                // Find a trip
            }
            case 7 -> {
                // Remove a trip
            }
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
