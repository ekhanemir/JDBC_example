import java.util.Scanner;

public class Student {

    private int id;
    private String name;
    private String lastname;
    private String city;
    private int age;

    public Student() {
    }

    public Student(int id,String name, String lastname, String city, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }

    public Student(String name, String lastname, String city, int age) {

        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID = " + id +
                ", Name= " + name +
                ", Last Name= " + lastname +
                ", City= " + city +
                ", Age= " + age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
