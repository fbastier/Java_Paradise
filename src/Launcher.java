import com.sun.source.tree.DoWhileLoopTree;
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
 //       JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        JdbcTripDao jdbcTripDao = new JdbcTripDao();

        switch (choice) {
            case 1 -> {
                menu.menu1();
                menu.mainMenu();
                break;
            }
            case 2 -> {
                menu.menu2();
                break;
            }
            case 3 -> {
                break;
            }
            case 4 -> {
                break;
            }
            case 5 -> {
//                System.out.print("Departure : Please enter the id of the place : ");
//                Scanner kb5 = new Scanner(System.in);
//                Long idDep = kb5.nextLong();
//                Place placeDep = jdbcPlaceDao.findPlaceById(idDep);
//                System.out.printf("Place : %s\n", placeDep.getName());
//                System.out.print("Destination : Please enter the id of the place : ");
//                Scanner kb5b = new Scanner(System.in);
//                Long idArr = kb5b.nextLong();
//                Place placeArr = jdbcPlaceDao.findPlaceById(idArr);
//                System.out.printf("Place : %s\n", placeArr.getName());
//                System.out.print("Price : ");
//                Scanner kb5c = new Scanner(System.in);
//                Float price = kb5c.nextFloat();
//
//                try {
//                    Long idTrip = jdbcTripDao.createTrip(new Trip(placeDep, placeArr, price));
//                    System.out.printf("Trip added with the ID-%d\n", idTrip);
//                    System.out.println("---------------------------\n");
//                } catch (Exception e) {
//                    System.out.println("Something goes wrong. Can't add this trip");
//                    System.out.println("---------------------------\n");
//                    e.printStackTrace();
//                }
//                kb5.close();
//                kb5b.close();
//                kb5c.close();
                break;
            }
            case 6 -> {
                break;
            }
            case 7 -> {
                break;
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
}
