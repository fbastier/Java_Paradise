import dao.jdbc.JdbcPlaceDao;
import model.Place;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        MainMenu();
        Scanner kb = new Scanner(System.in);
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        int choice = kb.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Name : ");
                Scanner kb1 = new Scanner(System.in);
                String name = kb1.nextLine();
                Long id = jdbcPlaceDao.createPlace(new Place(name));
                System.out.printf("Place added with the ID-%d.\n", id);
                System.out.println("---------------------------\n");
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
            case 6 -> {

            }
            case 7 -> {

            }
            case 8 -> {
                System.out.println("Bye, see you next time !");
                System.exit(0);
            }
            default -> {
                System.out.println("Please, choose a number between 1 to 8 !");
                System.out.println("---------------------------");
                MainMenu();
            }
        }



    }

    // Main menu
    private static void MainMenu() {
        System.out.println("Welcome aboard !");
        System.out.println("\nWhat do you want to do ?");

        System.out.println("1 - Add a place");
        System.out.println("2 - Find a place");
        System.out.println("3 - Edit a place");
        System.out.println("4 - Edit a place");
        System.out.println("5 - Add a trip");
        System.out.println("6 - Find a trip");
        System.out.println("7 - Remove a trip");
        System.out.println("8 - Quit\n");

    }

}
