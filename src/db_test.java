import java.sql.*;
/**
 * Created by eiyasushiki on 15/11/5.
 */
public class db_test {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement state = conn.createStatement();
            String query = "SELECT * FROM TEST_TABLE";
            ResultSet result = state.executeQuery(query);
            while (result.next()) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
