import java.util.*;
import java.util.stream.Collectors;

public class AddressBookRunner {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, AddressBookSystem> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to New Address Book");

        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Add book\n2. Add to existing book\n3. Search a person by city or state name\n4. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter address book name");
                    AddressBookSystem addressBookSystem = new AddressBookSystem();
                    addressBookMap.put(scanner.next(), addressBookSystem);

                    Iterator<String> itr = addressBookMap.keySet().iterator();
                    while (itr.hasNext()) {
                        System.out.println(itr.next());
                    }
                    break;
                case 2:
                    System.out.println("Enter address book name to add person");
                    String addressBookName = scanner.next();
                    if (addressBookMap.containsKey(addressBookName)){
                        AddressBookSystem bookSystem = addressBookMap.get(addressBookName);
                        bookSystem.curdPerson();
                    }else {
                        System.out.println("Address book is not present");
                    }

                    Iterator<String> itr2 = addressBookMap.keySet().iterator();
                    while (itr2.hasNext()) {
                        System.out.println(itr2.next());
                    }
                    break;
                case 3:
                    System.out.println("Enter a city or state name to search person");
                    String cityOrState = scanner.next();

                    List<Person> list = AddressBookSystem.searchByCityOrState(cityOrState);
                    System.out.println("Number of people with " + cityOrState + " name: " + list.size());
//                    System.out.println("Persons list found by city or state name provided");
//                    for (Person p: list){
//                        System.out.println( p.getFirstName() + " " + p.getLastName() );
//                    }
                    break;
                default:
                    isExit = true;
                    break;
            }
        }
    }
}
