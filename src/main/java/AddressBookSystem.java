import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {
    private static Scanner scan = new Scanner(System.in);
    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to New Address Book");
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Adding\n2. Editing\n3. Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter first name to check for duplicate");
                    if (!isPersonExist(getName())) {
                        personList.add(addPerson());
                        System.out.println(personList.toString());
                    } else {
                        System.out.println("Already exists");
                    }
                    break;
                case 2:
                    System.out.println("Enter name to edit");
                    for (Person p : personList) {
                        System.out.println(p.getFirstName());
                    }
                    Person person = findPerson(getName());
                    if (person != null) {
                        editPerson(person);
                    }
                    System.out.println(personList.toString());
                    break;
                default:
                    isExit = true;
                    break;
            }
        }
    }

        private static boolean isPersonExist(String name){
            return personList.stream()
                    .anyMatch(p -> p.getFirstName().equals(name) || p.getLastName().equals(name));
        }

        private static Person findPerson(String name){
            Person person = personList.stream().filter(personElement -> personElement.getFirstName().equals(name) || personElement.getLastName().equals(name)).findFirst().orElse(null);
            if (person == null){
                System.out.println("Not matched");
                return null;
            }else {
                return person;
            }
        }

        private static String getName(){
            String name = scan.next();
            return name;
        }

        private static Person editPerson(Person person) {
            System.out.println("What you wanna change\n1. First Name\n2. Last Name\n3. City\n4. State\n5. Zip Code\n6. Phone Number\n7. Email");
            Integer userChoice = scan.nextInt();
            switch (userChoice){
                case 1:
                    System.out.println("Enter new First Name");
                    String newInput1 = scan.next();
                    person.setFirstName(newInput1);
                    break;
                case 2:
                    System.out.println("Enter new Last Name");
                    String newInput2 = scan.next();
                    person.setLastName(newInput2);
                    break;
                case 3:
                    System.out.println("Enter new City Name");
                    String newInput3 = scan.next();
                    person.setCity(newInput3);
                    break;
                case 4:
                    System.out.println("Enter new State Name");
                    String newInput4 = scan.next();
                    person.setState(newInput4);
                    break;
                case 5:
                    System.out.println("Enter new Zip Code");
                    String newInput5 = scan.next();
                    person.setPhoneNum(newInput5);
                    break;
                case 6:
                    System.out.println("Enter new Phone Number");
                    String newInput6 = scan.next();
                    person.setPhoneNum(newInput6);
                    break;
                case 7:
                    System.out.println("Enter new Email");
                    String newInput7 = scan.next();
                    person.setEmail(newInput7);
                    break;
                }
            return person;
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
