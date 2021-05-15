import java.sql.*;

public class AddressBookSystemDBService {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/address_book_service";
        String user = "vyshu";
        String password = "vyshu@11";
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(city) AS rowcount FROM contacts;");
            resultSet.next();
            int countByCity = resultSet.getInt("rowcount");
            resultSet.close();
            System.out.println("Number of contacts: " + countByCity);
            connection.close();
        } catch (ClassNotFoundException exception){
            System.out.println(exception);
        }
    }
}
