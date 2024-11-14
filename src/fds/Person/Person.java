package fds.Person;

public class Person
{
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    public Person(String name, int age, String address, String phoneNumber)
    {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String toString()
    {
        return "Name: " + name + "\nAge: " + age + "\nAddress: " + address + "\nPhone Number: " + phoneNumber;
    }

    public static void main(String[] args) {
        Person person = new Person("John Doe", 30, "1234 Elm St", "555-555-5555");
        System.out.println(person);
    }
}
