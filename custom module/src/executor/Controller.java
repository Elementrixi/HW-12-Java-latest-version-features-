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
        String command;
        String name;
        String country;
        int age;
        double userId;
        Scanner scanner = new Scanner(System.in);
        do {
            command = scanner.nextLine();
            if (command.equals("add")) {
                System.out.println("Write name ");
                name = scanner.nextLine();
                System.out.println("Write country");
                country = scanner.nextLine();
                System.out.println("Write age");
                age = scanner.nextInt();
                Service.addUser(name, country, age);
                Service.userList();
                opportunities();
            }
            if (command.equals("delete")) {
                System.out.println("Choose id of user to delete him");
                Service.userList();
                userId = Integer.parseInt(scanner.nextLine());
                Service.deleteUser((int) userId);
                Service.userList();
                opportunities();
            }
            if (command.equals("edit")) {
                System.out.println("Unable opportunity, choose other");
                opportunities();
            }
            if (command.equals("list")) {
                Service.userList();
                opportunities();
            }
        } while (!command.equals("exit"));
    }
}
