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

                // Database: id 1|created 2| username 3| password 4| fullname 5| address 6|phonenumber 7|  email 8| subjectsOfStudying 9|  classnumber 10| jobtype 11| lastname 12
                // Pojo: id 1|created 2| username 3| password 4| firstname 5| lastname 6| address 7|phonenumber 8| email 9|subjectsOfStudying 10|classnumber 11|  jobtype 12) {

                this.employeeData.add(new EmployeeData(resultSet.getString(1), // id
                        resultSet.getString(2), // date
                        resultSet.getString(3), // username
                        resultSet.getString(4), // password
                        resultSet.getString(5), // first name
                        resultSet.getString(12), // last name
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

    public void addEmployee(String username,String password, String firstname,String lastname,String address
    ,String phonenumber,String email, String subjectsofstudying,String classnumber,String jobtype) {

        String query = "INSERT INTO teachers_tbl (username,password,first_name,last_name,phone_number,address,email,class_number,subject_of_studying,job_type) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);

                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, firstname);
                statement.setString(4, lastname);
                statement.setString(5, phonenumber);
                statement.setString(6, address);
                statement.setString(7, email);
                statement.setString(9, classnumber);
                statement.setString(8, subjectsofstudying);
                statement.setString(10, jobtype);

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

    public void editEmployee(String id,String firstname,String lastname,String address
    ,String phonenumber,String email, String subjectsofstudying,String classnumber,String jobtype) { // Method to edit emplyee details
        String sql = "UPDATE teachers_tbl SET first_name = ?,last_name =?, phone_number = ?,address = ?, email = ?,class_number = ?, subject_of_studying = ?,job_type = ? WHERE id = ?";
        PreparedStatement statement = null;

        try {
            Connection conn = DataBaseConnection.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, phonenumber);
            statement.setString(4, address);
            statement.setString(5, email);
            statement.setString(6, classnumber);
            statement.setString(7, subjectsofstudying);
            statement.setString(8, jobtype);
            statement.setInt(9, Integer.parseInt(id));

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