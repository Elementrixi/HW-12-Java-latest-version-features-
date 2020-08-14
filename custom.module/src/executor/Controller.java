package executor;

import service.Service;

import java.util.Scanner;

import static service.Service.addUser;
import static service.Service.userList;

public class Controller {
    static {
        Service service = new Service();
        service.addUser("Vasya", "German", 43);
        service.addUser("Katya", "Ukraine", 16);
        service.addUser("Tom", "England", 25);
        service.addUser("Den", "Denmark", 9);

    }

    public static void control() {
        while (true) {
            homeworkSolution();
        }
    }

    public static void opportunities() {
        System.out.println("You have next opportunities with users : " +
                "add, " +
                "delete, " +
                "edit, " +
                "see list of users " +
                "and also you can exit.");
    }

    public static void homeworkSolution() {
        opportunities();
        String commandChoice;
        String name;
        String country;
        int age;
        double userId;
        Scanner scanner = new Scanner(System.in);
        commandChoice = scanner.nextLine();
        switch (commandChoice) {
            case "add":
                System.out.println("Write name ");
                name = scanner.nextLine();
                System.out.println("Write country");
                country = scanner.nextLine();
                System.out.println("Write full age");
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    addUser(name, country, age);
                    userList();
                } catch (Exception e) {
                    System.out.println("It's not number. Try another time");
                }
                break;
            case "delete":
                System.out.println("Choose id of user to delete him");
                userList();
                userId = Integer.parseInt(scanner.nextLine());
                Service.deleteUser((int) userId);
                userList();
                break;
            case "edit":
                Service.editUser();
                break;
            case "list":
                userList();
                break;
        }
    }
}
