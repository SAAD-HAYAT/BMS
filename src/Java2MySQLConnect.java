import java.sql.*;

public class Java2MySQLConnect {

    public static void insert(String query) {
        Connection connection;
        PreparedStatement insert;
        String db = "banking_management_system";
        String username = "local";
        String password = "maryam";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, username, password);
            insert = connection.prepareStatement(query);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet read(String query) {
        Connection connection;
        String db = "banking_management_system";
        String username = "local";
        String password = "maryam";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String db = "banking_management_system";
        String username = "local";
        String password = "maryam";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db,
                    username, password);

            System.out.println("Connected to SQL Server");

            String query = "select * from bank";
            ResultSet rs = read(query);
            while (rs.next()) {
                System.out.println("Code: " + rs.getString("code")
                        + "\nName: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Oops! There is an error!");
            e.printStackTrace();
        }


    }
}