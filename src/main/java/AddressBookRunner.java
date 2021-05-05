import java.util.*;
import java.util.stream.Collectors;

public class AddressBookRunner {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, AddressBookSystem> addressBookMap = new HashMap<>();
    private static AddressBookSystem addrBookSys;

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

                    //to check person with the desired city or state
                    List<Map.Entry<String, AddressBookSystem>> list = addressBookMap.entrySet().stream().filter(value -> (value.getValue().searchByCityOrState(cityOrState))).collect(Collectors.toList());
                    System.out.println(list);
                    break;
                default:
                    isExit = true;
                    break;
            }
        }
    }
}
