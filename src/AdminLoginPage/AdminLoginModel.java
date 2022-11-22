package AdminLoginPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.DataBaseConnection;

public class AdminLoginModel {
    
    Connection connection = null;

    public boolean isDBConnected(){
        return this.connection != null;
    }

    public AdminLoginModel() { // Method To Show Connecting to DataBase

        this.connection = DataBaseConnection.getConnection();
        if(connection == null){
            System.exit(0);
        }
    }


    public boolean admin_login(String string, String password){
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM admin_tbl WHERE username = ? AND password = ?";

        try {
            statement = this.connection.prepareStatement(query);
            statement.setString(1, string);
            statement.setString(2, password);
            
            resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean admin_login(boolean b) {
        return false;
    }
}