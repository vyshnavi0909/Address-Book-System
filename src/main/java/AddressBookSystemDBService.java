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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contacts(first_name, last_name, city, state, phone_number, pin_code, email) VALUES(?,?,?,?,?,?,?);");
            preparedStatement.setString(1,"Likitha");
            preparedStatement.setString(2,"Abbula");
            preparedStatement.setString(3, "Chennai");
            preparedStatement.setString(4, "Tamil Nadu");
            preparedStatement.setString(5, "9900889900");
            preparedStatement.setInt(6, 600010);
            preparedStatement.setString(7, "likku@gmail.com");
            preparedStatement.executeUpdate();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()) {
                System.out.println("{");
                for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    String columnValue = resultSet.getString(i);
                    System.out.print( "   " + resultSetMetaData.getColumnName(i) + ": " +columnValue + ",");
                }
                System.out.println("\n}");
            }
            connection.close();
        } catch (ClassNotFoundException exception){
            System.out.println(exception);
        }
    }
}
