import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {
    private static Scanner scan = new Scanner(System.in);
    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to New Address Book");
        personList.add(addPerson());
        System.out.println(personList.toString());
    }

    private static Person addPerson() {
        Person person = new Person();

        System.out.println("Enter First Name:");
        String fName = scan.next();
        person.setFirstName(fName);
        System.out.println("Enter Last Name:");
        String lName = scan.next();
        person.setLastName(lName);
        System.out.println("Enter City Name:");
        String city = scan.next();
        person.setCity(city);
        System.out.println("Enter State Name:");
        String state = scan.next();
        person.setState(state);
        System.out.println("Enter Zip Code:");
        Integer zip = scan.nextInt();
        person.setZip(zip);
        System.out.println("Enter Phone Number:");
        String phoneNum = scan.next();
        person.setPhoneNum(phoneNum);
        System.out.println("Enter Email Id:");
        String email = scan.next();
        person.setEmail(email);
        return person;
    }
}
