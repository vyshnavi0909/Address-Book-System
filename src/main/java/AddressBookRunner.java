import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.util.*;

public class AddressBookRunner {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, AddressBookSystem> addressBookMap = new HashMap<>();
    private List<Person> personList = new ArrayList<>();


    public static void main(String[] args) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        System.out.println("Welcome to New Address Book");

        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Add book\n2. Add to existing book\n3. Search a person by city or state name\n4. Sort by options\n5. Write into a file\n6. Read from file\n7. Write to CSV file\n8. Read from CSV file\n9. Write to JSON file\n10. Read from JSON file\n11. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter address book name");
                    AddressBookSystem addressBookSystem = new AddressBookSystem();
                    addressBookMap.put(scanner.next(), addressBookSystem);
                    break;
                case 2:
                    Iterator<String> itr2 = addressBookMap.keySet().iterator();
                    while (itr2.hasNext()) {
                        System.out.println(itr2.next());
                    }
                    System.out.println("Enter address book name to add person");
                    String addressBookName = scanner.next();
                    if (addressBookMap.containsKey(addressBookName)){
                        AddressBookSystem bookSystem = addressBookMap.get(addressBookName);
                        bookSystem.curdPerson();
                    }else {
                        System.out.println("Address book is not present");
                    }
                    break;
                case 3:
                    System.out.println("Enter a city or state name to search person");
                    String cityOrState = scanner.next();

                    AddressBookSystem addressBookSystem1 = new AddressBookSystem();
                    List<Person> list = addressBookSystem1.searchByCityOrState(cityOrState);
                    System.out.println("Persons list found by city or state name provided");
                    for (Person p: list){
                        System.out.println( p.getFirstName() + " " + p.getLastName() );
                    }
                    break;
                case 4:
                    System.out.println("Sort by options\n1. By name\n2. By city\n3. By state\n4. By zip");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1:
                            System.out.println("Sorting by name");
                            addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByName());
                            break;
                        case 2:
                            System.out.println("Sorting by city");
                            addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByCity());
                            break;
                        case 3:
                            System.out.println("Sorting by state");
                            addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByState());
                            break;
                        case 4:
                            System.out.println("Sorting by zip");
                            addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByZip());
                            break;
                        default:
                            System.out.println("invalid option");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Writing into file");
                    AddressBookSystem.writeDataToFile();
                    break;
                case 6:
                    System.out.println("Reading data from file ");
                    AddressBookSystem.readDataFromFile();
                    break;
                case 7:
                    System.out.println("Writing data to CSV file");
                    AddressBookSystem.writeDataToCSVFile();
                    break;
                case 8:
                    System.out.println("Reading Data from CSV file");
                    AddressBookSystem.readDataFromCSVFile();
                    break;
                case 9:
                    System.out.println("Writing data to JSON file");
                    AddressBookSystem.writeDataToJSon();
                    break;
                case 10:
                    System.out.println("Read data from JSON file");
                    AddressBookSystem.readDataFromJson();
                    break;
                default:
                    isExit = true;
                    break;
            }

        }
    }
}
