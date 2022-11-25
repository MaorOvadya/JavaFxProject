package AdminMainPage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminMainController implements Initializable {
    
    AdminMainModel adminMainModel = null;

    // Admin Interface Buttons  
    @FXML
    private Button LogOut_Button;
    @FXML
    private Button Modify_Employee_Button;
    @FXML
    private Button Modify_User_Button;
    @FXML
    private Button Remove_Button;
    @FXML
    private Label Alert;

    @FXML
    private TextField SearchField;

    // Add Employee buttons
    @FXML
    private Button Submit_Button;
    @FXML
    private Button Clear_Button;

    //  Add Employee Fields
    @FXML
    private TextField Username_Field;
    @FXML
    private TextField Password_Field;
    @FXML
    private TextField Firstname_Field;
    @FXML
    private TextField Lastname_Field;
    @FXML
    private TextField Address_Field;
    @FXML
    private TextField Phone_Number_Field;
    @FXML
    private TextField Email_Field;
    @FXML
    private TextField Class_Number_Field;
    @FXML
    private ComboBox<String> Subjects_ComboBox;
    @FXML
    private ComboBox<String> Job_Type;

    // Table List View
    @FXML
    private TableView<EmployeeData> employeeTableView;
    @FXML
    private TableView<EmployeeData> employeeTableView1;
    @FXML
    private TableView<EmployeeData> employeeTableView2;

    // EmployeeTableView
    @FXML
    private TableColumn<EmployeeData, String> ID_column; // employeeTableView
    @FXML
    private TableColumn<EmployeeData, String> Username_column; // employeeTableView
    @FXML
    private TableColumn<EmployeeData, String> Password_column; // employeeTableView
    @FXML
    private TableColumn<EmployeeData, String> Register_column; // employeeTableView

    // EmployeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> ID_column1; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Firstname_column; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Lastname_column; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Job_type_column; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Phone_number_column; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Email_column; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Address_column; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Subjects_column;  // employeeTableView1
    @FXML
    private TableColumn<EmployeeData,String> job_type; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData,String> Class_column; // employeeTableView1

    // EmployeeTableView2
    @FXML
    private TableColumn<EmployeeData, String> ID_column2; // employeeTableView2
    @FXML
    private TableColumn<EmployeeData, String> Username_column1; // employeeTableView2
    @FXML
    private TableColumn<EmployeeData, String> Firstname_column1; // employeeTableView2
    @FXML
    private TableColumn<EmployeeData, String> Lastname_column1; // employeeTableView1
    @FXML
    private TableColumn<EmployeeData, String> Phone_column1; // employeeTableView2
    @FXML
    private TableColumn<EmployeeData, String> Email_column1; // employeeTableView2

    // ComboBox With options to choose:
    ObservableList<String> settingSub;
    ObservableList<String> settingJob;

    // Dialog Pane:
    Dialog<ButtonType> dialog = null;
    Dialog<ButtonType> dialog1 = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.adminMainModel = new AdminMainModel();
        settingSub = FXCollections.observableArrayList("English","Math","Art","Science","History","Music","Geography","P.E (Physical Education)","Drama","Biology","Chemistry","Physics","I.T (Information Technology)","Foreign languages","Social studies","Technology","Philosophy","Graphic design","Literature","Algebra","Geometry");
        Subjects_ComboBox.setItems(settingSub);
        settingJob = FXCollections.observableArrayList("Full-time","Part-time");
        Job_Type.setItems(settingJob);

               //disable delete and edit buttons
               Remove_Button.setDisable(true);
               Modify_Employee_Button.setDisable(true);
               Modify_User_Button.setDisable(true);

               // When select Table Button valid 
               employeeTableView2.setOnMouseClicked(e -> {
                   EmployeeData selected = employeeTableView2.getSelectionModel().getSelectedItem();

                   if(selected != null){
                    Remove_Button.setDisable(false);
                    Modify_Employee_Button.setDisable(false);  
                    Modify_User_Button.setDisable(false);
                }
            });
        }
        public void logOut() { // Moving to Logout to admin login page

            Stage mainLoginAdminPage = new Stage();
            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AdminLoginPage/AdminLoginPage.fxml")));
    
                mainLoginAdminPage.setScene(scene);
                mainLoginAdminPage.setTitle("Admin Management System");
                mainLoginAdminPage.setResizable(false);
                mainLoginAdminPage.show();
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean validPassword(){
            Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12})");
            Matcher m = p.matcher(this.Password_Field.getText());
            if(m.find() && m.group().equals(this.Password_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("Password Must Contain Digits and Characters");
            alert01.setContentText("Password leanght Must be between 6 - 12. Characters: LowerCase,UperCase and digits)");
            alert01.showAndWait();
            return false;
        }
        private boolean validClassNumber(){
            Pattern p = Pattern.compile("[0-9]{3}+");
            Matcher m = p.matcher(this.Class_Number_Field.getText());
            if(m.find() && m.group().equals(this.Class_Number_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("Class Number Must Contain only Digits");
            alert01.setContentText("class number need to contain 3 digits: xxx");
            alert01.showAndWait();
            return false;
        }

        private boolean validPhoneNumber(){
            Pattern p = Pattern.compile("([0-9]{3}[-][0-9]{3}[-][0-9]{4})+");
            Matcher m = p.matcher(this.Phone_Number_Field.getText());
            if(m.find() && m.group().equals(this.Phone_Number_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("Phone Number Must Contain only Digits");
            alert01.setContentText("Phone number need to contain 10 digits: xxx-xxx-xxxx");
            alert01.showAndWait();
            return false;
        }

        private boolean validEmail(){
            Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
            Matcher m = p.matcher(this.Email_Field.getText());
            if(m.find() && m.group().equals(this.Email_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("Email Must Contain @ and can contain '_','.','0-9' ");
            alert01.setContentText("Email example: test@example.com");
            alert01.showAndWait();
            return false;
        }

        private boolean validFirstName(){
            Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(this.Firstname_Field.getText());
            if(m.find() && m.group().equals(this.Firstname_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("First name Must Contain only String ");
            alert01.setContentText("Enter Valid first name");
            alert01.showAndWait();
            return false;
        }


        private boolean validLastName(){
            Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(this.Lastname_Field.getText());
            if(m.find() && m.group().equals(this.Lastname_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("Last name Must Contain only String ");
            alert01.setContentText("Enter Valid last name");
            alert01.showAndWait();
            return false;
        }

        private boolean validUserName(){
            Pattern p = Pattern.compile("[a-zA-Z0-9]+");
            Matcher m = p.matcher(this.Username_Field.getText());
            if(m.find() && m.group().equals(this.Username_Field.getText())){
                return true;
            }
            Alert alert01 = new Alert(AlertType.WARNING);
            alert01.setTitle("Information Message");
            alert01.setHeaderText("User name Contain String and Numbers ");
            alert01.setContentText("User example: test,test123");
            alert01.showAndWait();
            return false;
        }

    public void loadEmployeeData(ActionEvent event) { // load employee data

        //table 1: employeeTableView
        this.ID_column.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.Username_column.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        this.Password_column.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        this.Register_column.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        this.employeeTableView.setItems(null);
        this.employeeTableView.setItems(adminMainModel.getEmployees());

        //table 2: employeeTableView1
        this.ID_column1.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.Firstname_column.setCellValueFactory(cellData -> cellData.getValue().firstnamePropery());
        this.Lastname_column.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
        this.Address_column.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        this.Job_type_column.setCellValueFactory(cellData -> cellData.getValue().jobtypeProperty());
        this.Phone_number_column.setCellValueFactory(cellData -> cellData.getValue().phonenumberProperty());
        this.Email_column.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        this.Job_type_column.setCellValueFactory(cellData -> cellData.getValue().jobtypeProperty());
        this.Subjects_column.setCellValueFactory(cellData -> cellData.getValue().subjectsofstudyingProperty());
        this.Class_column.setCellValueFactory(cellData -> cellData.getValue().classnumberProperty());

        this.employeeTableView1.setItems(null);
        this.employeeTableView1.setItems(adminMainModel.getEmployees());

        //table 2: employeeTableView2
        this.ID_column2.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.Username_column1.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        this.Firstname_column1.setCellValueFactory(cellData -> cellData.getValue().firstnamePropery());
        this.Lastname_column1.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
        this.Phone_column1.setCellValueFactory(cellData -> cellData.getValue().phonenumberProperty());
        this.Email_column1.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        this.employeeTableView2.setItems(null);
        this.employeeTableView2.setItems(adminMainModel.getEmployees());

    }

    @FXML
    private void addEmployee(ActionEvent event) { // Add employee Method

        if(this.Username_Field.getText() != null && validUserName() &&  this.Password_Field.getText() != null && validPassword() && this.Firstname_Field.getText() != null && validFirstName()
           && this.Lastname_Field != null && validLastName() && this.Address_Field.getText() != null && this.Phone_Number_Field.getText() != null && validPhoneNumber() && this.Email_Field.getText() != null
            && validEmail() && this.Class_Number_Field.getText() != null && validClassNumber() && this.Subjects_ComboBox.getValue() != null && this.Job_Type.getValue() != null) {

            adminMainModel.addEmployee(this.Username_Field.getText(), this.Password_Field.getText(),this.Firstname_Field.getText()
            ,this.Lastname_Field.getText(),this.Address_Field.getText(),this.Phone_Number_Field.getText(),this.Email_Field.getText()
            ,this.Subjects_ComboBox.getValue(),this.Class_Number_Field.getText(),this.Job_Type.getValue());

            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Information Message");
            alert1.setHeaderText("User added successfully to the list");
            alert1.setContentText("To view, update the list");
            alert1.showAndWait();
            this.loadEmployeeData(event);
            this.clearFields(event);
        }  else {
            this.Alert.setText("Please fill all form");
        }
    }

    public void clearFields(ActionEvent event) { // Method to clear fields
        this.Class_Number_Field.setText("");
        this.Firstname_Field.setText("");
        this.Lastname_Field.setText("");
        this.Address_Field.setText("");
        this.Phone_Number_Field.setText("");
        this.Email_Field.setText("");
        this.Username_Field.setText("");
        this.Password_Field.setText("");
        this.Subjects_ComboBox.setValue(null);;
        this.Job_Type.setValue(null);
        this.Alert.setText(null);
    }
  
    private boolean pressOK() { // Confiramtion remove user
        boolean pressOK = false;
        Alert alert2 = new Alert(AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation Message");
        alert2.setHeaderText("Delete User Press Ok else Cancel.");
        alert2.setContentText("User will be deleted permanently ");
        Optional <ButtonType> pressOkButton = alert2.showAndWait();
        if(pressOkButton.isPresent() && pressOkButton.get() == ButtonType.OK){
            pressOK = true;
        } 
        return pressOK;
    }

    @FXML
    private void deleteEmployee(ActionEvent event){ // Method to delete employee
        
        EmployeeData selectedItem = employeeTableView2.getSelectionModel().getSelectedItem();
        if(pressOK()) {
            employeeTableView2.getItems().remove(selectedItem); // delete from Local 
            adminMainModel.deleteEmployee(selectedItem.idProperty().getValue());  //delete from Database
        }
     
    }

    TextField editUserNameString = new TextField();
    TextField editPasswordtString = new TextField();
    TextField editFirstNameString = new TextField();
    TextField editLastNameString = new TextField();
    TextField editAddressString = new TextField();
    TextField editPhoneNumberString = new TextField();
    TextField editEmailString = new TextField();
    TextField editClassNumberString = new TextField();

    ComboBox<String> Job;
    ComboBox<String> Study;

    @FXML
    private void editEmployee(ActionEvent event){ // Method to Edit employee

        EmployeeData teacherEdit = employeeTableView2.getSelectionModel().getSelectedItem();
        String editId = teacherEdit.idProperty().getValue();

        createModal(); //create modal


        dialog.showAndWait().ifPresent(response -> { //call the modal


                if(response.getButtonData().equals(ButtonData.OK_DONE)){    
                    if (editFirstNameString.getText() != null && validFirstName1() && editLastNameString.getText() != null && validLastName1() && editAddressString.getText() != null && editPhoneNumberString.getText() != null &&  validPhoneNumber1() && editEmailString.getText() != null
                       && validEmail1() && editClassNumberString.getText() != null && validClassNumber1() && Job.getValue() != null && Study.getValue() != null) {



                            adminMainModel.editEmployee(editId ,editFirstNameString.getText(),editLastNameString.getText(), editAddressString.getText(), editPhoneNumberString.getText(), editEmailString.getText()
                            ,editClassNumberString.getText(), Job.getValue(),Study.getValue());

                            Alert alert1 = new Alert(AlertType.INFORMATION);
                            alert1.setTitle("Information Message");
                            alert1.setHeaderText("User edited successfully");
                            alert1.setContentText("To view, update the list");
                            alert1.showAndWait();     
                            this.loadEmployeeData(event);

                        } else {

                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("Warning Message");
                            alert.setHeaderText("User cannot be modify");
                            alert.setContentText("Please fill all empty fields");
                            alert.showAndWait();
                        }
                }
        }   );
    }

    private String editFirstName;
    private String editLastName;
    private String editAddress;
    private String editPhoneNumber;
    private String editEmail;
    private String editClassNumber;

    private void createModal(){

        dialog = new Dialog<ButtonType>();

        dialog.setTitle("TMS");
        ButtonType editModalBtn = new ButtonType("Edit", ButtonData.OK_DONE);
        ButtonType cancelModalBtn = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        //set the content
        GridPane gridPane = new GridPane();
        gridPane.setHgap(30);   
        gridPane.setVgap(30);   
        gridPane.setPadding(new Insets(20, 10, 10, 10));

        editUserNameString.setText(editUserName);
        editPasswordtString.setText(editPassword);
        editFirstNameString.setText(editFirstName);
        editLastNameString.setText(editLastName);
        editAddressString.setText(editAddress);
        editPhoneNumberString.setText(editPhoneNumber);
        editEmailString.setText(editEmail);
        editClassNumberString.setText(editClassNumber);
    

        gridPane.add(new Label("Modify Employee Form"), 0,0);
        gridPane.add(new Label("First name"), 0, 1);
        gridPane.add(editFirstNameString, 1, 1);
        gridPane.add(new Label("Last name"), 0, 2);
        gridPane.add(editLastNameString, 1, 2);
        gridPane.add(new Label("Address"), 0, 3);
        gridPane.add(editAddressString, 1, 3);
        gridPane.add(new Label("Phone"), 0, 4);
        gridPane.add(editPhoneNumberString, 1, 4);
        gridPane.add(new Label("Email"), 0, 5);
        gridPane.add(editEmailString, 1, 5);
        gridPane.add(new Label("Class number"), 0, 6);
        gridPane.add(editClassNumberString, 1, 6);
        gridPane.add(new Label("Subject of study"), 0, 7);
        gridPane.add(Job = new ComboBox<String>(settingSub), 1, 7);
        gridPane.add(new Label("Job type"), 0, 8);
        gridPane.add(Study = new ComboBox<String>(settingJob), 1, 8);

        dialog.getDialogPane().setContent(gridPane);

        dialog.getDialogPane().getButtonTypes().add(editModalBtn);
        dialog.getDialogPane().getButtonTypes().add(cancelModalBtn);
    }

    @FXML
    private void editEmployee1(ActionEvent event){ // Method to Edit employee

        EmployeeData teacherEdit = employeeTableView2.getSelectionModel().getSelectedItem();
        String editId = teacherEdit.idProperty().getValue();

        createModal1(); //create modal

        dialog.showAndWait().ifPresent(response -> { //call the modal

                if(response.getButtonData().equals(ButtonData.OK_DONE)) {    

                    if (editUserNameString.getText() != null && validUserName1() && editPasswordtString.getText() != null && validPassword1() ) {

                            adminMainModel.editEmployee1(editId , editUserNameString.getText(), editPasswordtString.getText());
                            Alert alert1 = new Alert(AlertType.INFORMATION);
                            alert1.setTitle("Information Message");
                            alert1.setHeaderText("Login user edited successfully");
                            alert1.setContentText("To view, update the list");
                            alert1.showAndWait();
                            this.loadEmployeeData(event);
                        } else {
                            System.out.println("Fill all the fields");
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("Warning Message");
                            alert.setHeaderText("User cannot be modify");
                            alert.setContentText("Please fill all empty fields");
                            alert.showAndWait();
                        }
                    }              
        }   );
    }

    private String editUserName;
    private String editPassword;

    private void createModal1(){

        dialog = new Dialog<ButtonType>();

        dialog.setTitle("TMS");
        ButtonType editModalBtn = new ButtonType("Edit", ButtonData.OK_DONE);
        ButtonType cancelModalBtn = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        //set the content
        GridPane gridPane = new GridPane();
        gridPane.setHgap(30);   
        gridPane.setVgap(30);   
        gridPane.setPadding(new Insets(20, 10, 10, 10));

        editUserNameString.setText(editUserName);
        editPasswordtString.setText(editPassword);

        gridPane.add(new Label("Modify Employee User Form"), 0,0);
        gridPane.add(new Label("User name"), 0, 1);
        gridPane.add(editUserNameString, 1, 1);
        gridPane.add(new Label("Password"), 0, 2);
        gridPane.add(editPasswordtString, 1, 2);

        dialog.getDialogPane().setContent(gridPane);

        dialog.getDialogPane().getButtonTypes().add(editModalBtn);
        dialog.getDialogPane().getButtonTypes().add(cancelModalBtn);
    }
        
    private boolean validPassword1(){
        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12})");
        Matcher m = p.matcher(editPasswordtString.getText());
        if(m.find() && m.group().equals(editPasswordtString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("Password Must Contain Digits and Characters");
        alert01.setContentText("Password leanght Must be between 6 - 12. Characters: LowerCase,UperCase and digits)");
        alert01.showAndWait();
        return false;
    }
    private boolean validClassNumber1(){
        Pattern p = Pattern.compile("[0-9]{3}+");
        Matcher m = p.matcher(editClassNumberString.getText());
        if(m.find() && m.group().equals(editClassNumberString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("Class Number Must Contain only Digits");
        alert01.setContentText("class number need to contain 3 digits: xxx");
        alert01.showAndWait();
        return false;
    }

    private boolean validPhoneNumber1(){
        Pattern p = Pattern.compile("([0-9]{3}[-][0-9]{3}[-][0-9]{4})+");
        Matcher m = p.matcher(editPhoneNumberString.getText());
        if(m.find() && m.group().equals(editPhoneNumberString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("Phone Number Must Contain only Digits");
        alert01.setContentText("Phone number need to contain 10 digits: xxx-xxx-xxxx");
        alert01.showAndWait();
        return false;
    }

    private boolean validEmail1(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(editEmailString.getText());
        if(m.find() && m.group().equals(editEmailString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("Email Must Contain @ and can contain '_','.','0-9' ");
        alert01.setContentText("Email example: test@example.com");
        alert01.showAndWait();
        return false;
    }

    private boolean validFirstName1(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(editFirstNameString.getText());
        if(m.find() && m.group().equals(editFirstNameString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("First name Must Contain only String ");
        alert01.setContentText("Enter Valid first name");
        alert01.showAndWait();
        return false;
    }


    private boolean validLastName1(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(editLastNameString.getText());
        if(m.find() && m.group().equals(editLastNameString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("Last name Must Contain only String ");
        alert01.setContentText("Enter Valid last name");
        alert01.showAndWait();
        return false;
    }

    private boolean validUserName1(){
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = p.matcher(editUserNameString.getText());
        if(m.find() && m.group().equals(editUserNameString.getText())){
            return true;
        }
        Alert alert01 = new Alert(AlertType.WARNING);
        alert01.setTitle("Information Message");
        alert01.setHeaderText("User name Contain String and Numbers ");
        alert01.setContentText("User example: test,test123");
        alert01.showAndWait();
        return false;
    }
}