import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {
    private static Scanner scan = new Scanner(System.in);
    private static List<Person> personList = new ArrayList<>();
    private static Map<String, AddressBookSystem> addressBookMap = new HashMap<>();


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        addressBookSystem.personList = personList;
    }

    public void curdPerson() {
        System.out.println("Welcome to New Address Book");

        boolean isExist = false;
        while (!isExist) {
            System.out.println("1. Adding\n2. Editing\n3. Delete\n4. Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter first name");
                    String fName = getName();
                    //Checking whether person already exists or not. If does not exist, then adding new person
                    if (!isPersonExist(fName)){
                        personList.add(addPerson(fName));
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
                case 3:
                    System.out.println("Please enter name to Delete");
                    for(Person p:personList){
                        System.out.println(p.getFirstName());
                    }
                    Person person1 = findPerson(getName());
                    if (person1 != null) {
                        personList.remove(person1); //to delete a person details
                    }
                    System.out.println(personList.toString());
                    break;
                default:
                    isExist = true;
                    break;
            }
        }
    }

//    method to check person entered is already existing or not
    private boolean isPersonExist(String name){
        return personList.stream()
                .anyMatch(p -> p.getFirstName().equals(name) || p.getLastName().equals(name));
    }

//    method to find a person in the person list
    private Person findPerson(String name){
        Person person = personList.stream().filter(personElement -> personElement.getFirstName().equals(name) || personElement.getLastName().equals(name)).findFirst().orElse(null);
        if (person == null){
            System.out.println("Not matched");
            return null;
        }else {
            return person;
        }
    }

//    method to take person name from the user
    private static String getName(){
        String name = scan.next();
        return name;
    }

//    method to edit person details
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

//    method to add person details
    private static Person addPerson(String name) {
        Person person = new Person();

        String fName = name;
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

    /**
     *
     * @param cityOrState
     * @return
     */
    public List<Person> searchByCityOrState(String cityOrState) {
        System.out.println(personList.size());
        for (Person p : personList){
            System.out.println(p.getCity() +" " + p.getState());
        }
        List<Person> newPersonList = personList.stream().filter(personElement -> personElement.getCity().equals(cityOrState) | personElement.getState().equals(cityOrState)).collect(Collectors.toList());
        return newPersonList;
    }

    /**
     *
     */
    public void sortByName(){
        List<Person> list = personList.stream().sorted(Comparator.comparing(person -> person.getFirstName())).collect(Collectors.toList());
        for (Person person : list ){
            System.out.println(person.toString());
        }
    }

}
