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
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contacts SET city=?, state=? WHERE first_name=?;");
            preparedStatement.setString(1, "Hyderabad");
            preparedStatement.setString(2, "Telangana");
            preparedStatement.setString(3, "sai");
            int rowsAffected = preparedStatement.executeUpdate();
            Statement statement = connection.createStatement();
            statement.executeUpdate("ALTER TABLE contacts ADD date_added date;");
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE contacts SET date_added=? WHERE first_name=?");
            preparedStatement1.setString(1,"2016-01-02");
            preparedStatement1.setString(2, "Sundeep");
            preparedStatement1.executeUpdate();
            preparedStatement1.setString(1, "2019-02-01");
            preparedStatement1.setString(2, "Akshar");
            preparedStatement1.executeUpdate();
            preparedStatement1.setString(1, "2018-09-05");
            preparedStatement1.setString(2, "Roshini");
            preparedStatement1.executeUpdate();
            preparedStatement1.setString(1,"2019-08-06");
            preparedStatement1.setString(2, "Vyshnavi");
            preparedStatement1.executeUpdate();
            preparedStatement1.setString(1, "2015-03-08");
            preparedStatement1.setString(2, "Sai");
            preparedStatement1.executeUpdate();
            preparedStatement1.setString(1, "2016-02-05");
            preparedStatement1.setString(2, "Preethi");
            preparedStatement1.executeUpdate();

            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            ResultSet resultSet = statement2.executeQuery("SELECT * FROM contacts WHERE date_added BETWEEN CAST('2017-01-01' AS DATE) AND DATE(NOW());");
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
