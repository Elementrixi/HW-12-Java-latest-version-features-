package service;

import user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {
    static Scanner scr = new Scanner(System.in);
    private static Map<Integer, User> userMap = new HashMap<>();
    private static int userId = 1;

    public static void addUser(String name, String country, int age) {
        userMap.put(userId++, new User(name, country, age));
    }

    public static void deleteUser(int userId) {
        userMap.remove(userId);
    }

    public static void editUser() {
        Service.userList();
        System.out.println("Enter id of user who you will edit");
        int userId = scr.nextInt();
        System.out.println("Edited name : ");
        String name = scr.next();

        System.out.println("Edited country: ");
        String country = scr.next();

        try {
            System.out.println("Edited full age as number: ");
            int age = Integer.parseInt(scr.next());
            Service.deleteUser(userId);
            Service.addUser(name, country, age);
            System.out.println("Account updated");
        } catch (Exception e) {
            System.out.println("It's not number. Try another time");
        }
    }

    public static void userList() {
        userMap.forEach((key, value) -> System.out.println(key + ", " + value));
    }

}
