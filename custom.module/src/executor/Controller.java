package executor;

import service.Service;

import java.util.Scanner;

public class Controller {

    static {
        Service service = new Service();
        service.addUser("Vasya", "German", 43);
        service.addUser("Katya", "Ukraine", 16);
        service.addUser("Tom", "England", 25);
        service.addUser("Den", "Denmark", 9);
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
        do {
            commandChoice = scanner.nextLine();
            if (commandChoice.equals("add")) {
                System.out.println("Write name ");
                name = scanner.nextLine();
                System.out.println("Write country");
                country = scanner.nextLine();
                System.out.println("Write age");
                age = Integer.parseInt(scanner.nextLine());
                Service.addUser(name, country, age);
                Service.userList();
                opportunities();
            }
            if (commandChoice.equals("delete")) {
                System.out.println("Choose id of user to delete him");
                Service.userList();
                userId = Integer.parseInt(scanner.nextLine());
                Service.deleteUser((int) userId);
                Service.userList();
                opportunities();
            }
            if (commandChoice.equals("edit")) {
                Service.editUser();
                opportunities();
            }
            if (commandChoice.equals("list")) {
                Service.userList();
                opportunities();
            }
        } while (!commandChoice.equals("exit"));
    }
}
