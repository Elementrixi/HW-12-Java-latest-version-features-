package user;

public class User {
    private String name;
    private String country;
    private int age;

    public User(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name : '" + name + '\'' +
                ", country : '" + country + '\'' +
                ", age : " + age +
                '}';
    }
}
