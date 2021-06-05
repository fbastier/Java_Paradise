import dao.jdbc.JdbcPlaceDao;
import dao.jdbc.JdbcTripDao;
import model.Place;
import model.Trip;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        MainMenu();

        Scanner kb = new Scanner(System.in);
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        JdbcTripDao jdbcTripDao = new JdbcTripDao();
        int choice = kb.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Name : ");
                Scanner kb1 = new Scanner(System.in);
                String name = kb1.nextLine();
                try {
                    Long id = jdbcPlaceDao.createPlace(new Place(name));
                    System.out.printf("Place added with the ID-%d.\n", id);
                    System.out.println("---------------------------\n");
                } catch (Exception e){
                    System.out.printf("Something goes wrong. Can't add this place\n");
                    System.out.println("---------------------------\n");
                    e.printStackTrace();
                }
                Launcher.main(args);
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {
                System.out.print("Departure : Please enter the id of the place : ");
                Scanner kb5 = new Scanner(System.in);
                Long idDep = kb5.nextLong();
                Place placeDep = jdbcPlaceDao.findPlaceById(idDep);
                System.out.printf("Place : %s\n", placeDep.getName());
                System.out.print("Destination : Please enter the id of the place : ");
                Scanner kb5b = new Scanner(System.in);
                Long idArr = kb5b.nextLong();
                Place placeArr = jdbcPlaceDao.findPlaceById(idArr);
                System.out.printf("Place : %s\n", placeArr.getName());
                System.out.print("Price : ");
                Scanner kb5c = new Scanner(System.in);
                Float price = kb5c.nextFloat();

                try {
                    Long idTrip = jdbcTripDao.createTrip(new Trip(placeDep, placeArr, price));
                    System.out.printf("Trip added with the ID-%d\n", idTrip);
                    System.out.println("---------------------------\n");
                } catch (Exception e) {
                    System.out.printf("Something goes wrong. Can't add this trip\n");
                    System.out.println("---------------------------\n");
                    e.printStackTrace();
                }
                Launcher.main(args);
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
                Launcher.main(args);
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
