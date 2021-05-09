import java.util.*;

public class AddressBookRunner {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, AddressBookSystem> addressBookMap = new HashMap<>();
    private List<Person> personList = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Welcome to New Address Book");


        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Add book\n2. Add to existing book\n3. Search a person by city or state name\n4. Sort contacts by name\n5. Sort contacts by city\n6. Sort contacts by state\n7. Sort contacts by zip\n8. Exit");
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

                    System.out.println("Sorting by name");
                    addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByName());
                    break;
                case 5:
                    System.out.println("Sorting by ctiy");
                    addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByCity());
                    break;
                case 6:
                    System.out.println("Sorting by state");
                    addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByState());
                    break;
                case 7:
                    System.out.println("Sorting by zip");
                    addressBookMap.entrySet().stream().forEach(value -> value.getValue().sortByZip());
                    break;
                default:
                    isExit = true;
                    break;
            }

        }
    }
}
