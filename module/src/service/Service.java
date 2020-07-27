package service;

import user.User;

import java.util.HashMap;
import java.util.Map;

public class Service {
    private static Map<Integer, User> userMap = new HashMap<>();
    private static int userId = 1;

    public static void addUser(String name, String country, int age) {
        userMap.put(userId++, new User(name, country, age));
    }

    public static void deleteUser(int userId) {
        userMap.remove(userId);
    }

    public static void editUser() {
        userMap.get(userId);
        userMap.get(userId);
        userMap.get(userId);
    }

    public static void userList() {
        userMap.forEach((key, value) -> System.out.println(key + ", " + value));
    }
}
