package AdminMainPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminMainModel {

    public AdminMainModel() {
        this.connection = DataBaseConnection.getConnection();

        if (this.connection == null) {
            System.exit(0);
        }
}

    Connection connection = null;
    private ObservableList<EmployeeData> employeeData;
    
    public boolean isDBConnected() {
        return this.connection != null;
    }

    public ObservableList<EmployeeData> getEmployees() {
    

        this.connection = DataBaseConnection.getConnection();
        if (connection == null) {
            System.exit(0);
        }

        String query = "SELECT * FROM teachers_tbl";

        try {
            this.employeeData = FXCollections.observableArrayList();

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {

                // Database: id 1|created 2| username 3| password 4| fullname 5| address 6|phonenumber 7|  email 8| subjectsOfStudying 9|  classnumber 10| jobtype 11
                // Pojo: id 1|created 2| username 3| password 4| fullname 5| address 6|phonenumber 7| email 8|subjectsOfStudying 9|classnumber 10|  jobtype 11) {

                this.employeeData.add(new EmployeeData(resultSet.getString(1), // id
                        resultSet.getString(2), // date
                        resultSet.getString(3), // username
                        resultSet.getString(4), // password
                        resultSet.getString(5), // full name
                        resultSet.getString(6), // phone number
                        resultSet.getString(7), // address
                        resultSet.getString(8), // email
                        resultSet.getString(10), // class number
                        resultSet.getString(9), // subjectofstudying
                        resultSet.getString(11))); // Job type 
            }

                        return employeeData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addEmployee(String username,String password, String fullname,String address
    ,String phonenumber,String email, String subjectsofstudying,String classnumber,String jobtype) {

        String query = "INSERT INTO teachers_tbl (username,password,fullname,phone_number,address,email,class_number,subject_of_studying,job_type) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);

                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, fullname);
                statement.setString(4, phonenumber);
                statement.setString(5, address);
                statement.setString(6, email);
                statement.setString(7, classnumber);
                statement.setString(8, subjectsofstudying);
                statement.setString(9, jobtype);

                statement.execute();
  
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteEmployee(String id){

        String sql = "DELETE FROM teachers_tbl WHERE id = ?";
        PreparedStatement statement = null;

        try {
            Connection connection = DataBaseConnection.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, Integer.parseInt(id));

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void editEmployee(String id,String fullname,String address
    ,String phonenumber,String email, String subjectsofstudying,String classnumber,String jobtype) { // Method to edit emplyee details
        String sql = "UPDATE teachers_tbl SET fullname = ?, phone_number = ?,address = ?, email = ?,class_number = ?, subject_of_studying = ?,job_type = ? WHERE id = ?";
        PreparedStatement statement = null;

        try {
            Connection conn = DataBaseConnection.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, fullname);
            statement.setString(2, phonenumber);
            statement.setString(3, address);
            statement.setString(4, email);
            statement.setString(5, classnumber);
            statement.setString(6, subjectsofstudying);
            statement.setString(7, jobtype);
            statement.setInt(8, Integer.parseInt(id));

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void editEmployee1(String id, String username,String password) { // Method to edit emplyee login user
        String sql = "UPDATE teachers_tbl SET username = ?, password = ? WHERE id = ?";
        PreparedStatement statement = null;

        try {
            Connection conn = DataBaseConnection.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, Integer.parseInt(id));

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}