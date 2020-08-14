package service;

import user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, User> userMap = new HashMap<>();
    private static int userId = 1;
    private String name;
    private String country;
    private int age;

    public static void addUser(String name, String country, int age) {
        userMap.put(userId++, new User(name, country, age));
    }

    public static void deleteUser(int userId) {
        userMap.remove(userId);
    }

    public static void editUser() {
        User user;
        userList();
        System.out.println("Enter id of user who you will edit");
        try {
            int userId = scanner.nextInt();
            user = userMap.get(userId);
            System.out.println("Edited name : ");
            String name = scanner.next();
            System.out.println("Edited country: ");
            String country = scanner.next();
            System.out.println("Edited full age as number: ");
            int age = Integer.parseInt(scanner.next());
            user.setName(name);
            user.setCountry(country);
            user.setAge(age);
            System.out.println("Account updated");
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }

    public static void userList() {
        userMap.forEach((key, value) -> System.out.println(key + ", " + value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return age == service.age &&
                Objects.equals(name, service.name) &&
                Objects.equals(country, service.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, age);
    }
}
