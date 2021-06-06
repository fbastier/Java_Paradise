package menu;

import dao.jdbc.JdbcPlaceDao;
import dao.jdbc.JdbcTripDao;
import model.Place;
import model.Trip;

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

    /**
     * Edit a place with an id from the DB ParadiseSQL.
     */
    public void menu3() {
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();

        System.out.print("Id of the Place you wish update ? : ");
        Scanner kb3 = new Scanner(System.in);
        Long id = kb3.nextLong();
        Place placetoUpdate = jdbcPlaceDao.findPlaceById(id);

        System.out.printf("Enter the new name of the place with ID-%d : ", placetoUpdate.getId());
        Scanner kb3b = new Scanner(System.in);
        String newPlaceName = kb3b.nextLine();
        String oldName = placetoUpdate.getName();
        placetoUpdate.setName(newPlaceName);
        jdbcPlaceDao.updatePlace(placetoUpdate);
        System.out.printf("Done, %s replace with %s\n", oldName, newPlaceName);
        kb3.close();
        kb3b.close();
    }

    /**
     * Remove a place with an id from the DB ParadiseSQL.
     * Have to delete all the trips which have this place on departure or arrival
     */
    public void menu4() {
        // TODO - remove a place
    }

    /**
     * Create a trip in the DB ParadiseSQL.
     */
    public void menu5() {
        JdbcTripDao jdbcTripDao = new JdbcTripDao();
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
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
            System.out.println("Something goes wrong. Can't add this trip");
            System.out.println("---------------------------\n");
            e.printStackTrace();
        }
        kb5.close();
        kb5b.close();
        kb5c.close();
    }

    /**
     * Find a trip with an id from the DB ParadiseSQL.
     */
    public void menu6() {
        JdbcTripDao  jdbcTripDao = new JdbcTripDao();

        System.out.print("Which trip id ? : ");
        Scanner kb6 = new Scanner(System.in);
        Long id = kb6.nextLong();

        try {
            String depart = jdbcTripDao.findTrip(id).getDeparturePlace().getName();
            String arriv = jdbcTripDao.findTrip(id).getArrivalPlace().getName();
            Float price = jdbcTripDao.findTrip(id).getPrice();
            if (jdbcTripDao.findTrip(id) != null) {
                System.out.printf("Trip with ID-%d : Departure - %s / Arrival - %s / Price - %.2f.\n", id, depart, arriv, price);
            } else {
                System.out.printf("There is no trip with ID-%d.\n", id);
            }
            System.out.println("---------------------------\n");
        } catch (Exception e) {
            System.out.println("Something goes wrong. Can't find this trip");
            System.out.println("---------------------------\n");
            e.printStackTrace();
        }
        kb6.close();
    }

    /**
     * Remove a trip with an id from the DB ParadiseSQL.
     */
    public void menu7() {
        JdbcTripDao  jdbcTripDao = new JdbcTripDao();

        System.out.print("Id of the trip you want to delete ? : ");
        Scanner kb7 = new Scanner(System.in);
        Long id = kb7.nextLong();

        try {
                Trip tripToErase = jdbcTripDao.findTrip(id);
            if (jdbcTripDao.findTrip(id) != null) {
                jdbcTripDao.removeTrip(tripToErase);
                System.out.printf("Trip with ID-%d removed.\n", id);
            } else {
                System.out.printf("There is no trip with ID-%d.\n", id);
            }
            System.out.println("---------------------------\n");
        } catch (Exception e) {
            System.out.println("Something goes wrong. No action done");
            System.out.println("---------------------------\n");
            e.printStackTrace();
        }
        kb7.close();
    }
}
