import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        MainMenu();
        Scanner kb = new Scanner(System.in);
        int choice = kb.nextInt();

        //System.out.println("Mon choix : " + choice);



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
