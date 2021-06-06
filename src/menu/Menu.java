package menu;

import dao.jdbc.JdbcPlaceDao;
import model.Place;

import java.util.Scanner;

public class Menu {

    /**
     * Main menu
     */
    public void mainMenu() {
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

    /**
     * Create a place in the DB ParadiseSQL
     */
    public void menu1() {
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        System.out.println("Name : ");
        Scanner kb1 = new Scanner(System.in);
        String name = kb1.nextLine();
        Long id = jdbcPlaceDao.createPlace(new Place(name));
        System.out.printf("Place added with the ID-%d.\n", id);
        System.out.println("---------------------------\n");

//        try {
//            Long id = jdbcPlaceDao.createPlace(new Place(name));
//            System.out.printf("Place added with the ID-%d.\n", id);
//            System.out.println("---------------------------\n");
//        } catch (Exception e) {
//            System.out.println("Something goes wrong. Can't add this place");
//            System.out.println("---------------------------\n");
//            e.printStackTrace();
//        }
        kb1.close();
    }

    /**
     * Find a place name with an id in the DB ParadiseSQL.
     */
    public void menu2() {
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        System.out.print("Which id ? : ");
        Scanner kb2 = new Scanner(System.in);
        Long id = kb2.nextLong();

        try {
            String name = jdbcPlaceDao.findPlaceById(id).getName();
            if (jdbcPlaceDao.findPlaceById(id) != null) {
                System.out.printf("Place with ID-%d is %s.\n", id, name);
            } else {
                System.out.printf("There is no place with ID-%d.\n", id);
            }
            System.out.println("---------------------------\n");
        } catch (Exception e) {
            System.out.println("Something goes wrong. Can't find this place");
            System.out.println("---------------------------\n");
            e.printStackTrace();
        }
        kb2.close();
    }
}
