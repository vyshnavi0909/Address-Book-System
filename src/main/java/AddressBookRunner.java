import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookRunner {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, AddressBookSystem> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to New Address Book");

        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Add book\n2. Add to existing book\n3. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter address book name");
                    AddressBookSystem addressBookSystem = new AddressBookSystem();
                    addressBookMap.put(scanner.next(), addressBookSystem);
                    System.out.println(addressBookMap.toString());
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
                    System.out.println(addressBookMap.toString());
                    break;
                default:
                    isExit = true;
                    break;
            }
        }
    }
}
