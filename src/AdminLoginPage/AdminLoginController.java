package AdminLoginPage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLoginController implements Initializable {
    
    AdminLoginModel loginModel = new AdminLoginModel();
    
    @FXML
    private Label Connection_Status;
    @FXML
    private Label Login_Status;
    @FXML
    private TextField Username_fieldBox;
    @FXML
    private PasswordField Password_fieldBox;
    @FXML
    private Button Login_Button;
    @FXML
    private Button Exit_Program;

    @Override
    public void initialize(URL location, ResourceBundle resources) { // Method checking if dataBase Connected

    
        if (loginModel.isDBConnected()){
            this.Connection_Status.setText("Connected");
        } else {
            this.Connection_Status.setText("Not Connected");
        }
    }

    @FXML
    public void admin_Login(ActionEvent event) { // Method to Login as admin

        Stage stage =  (Stage) this.Login_Button.getScene().getWindow();
        if(this.loginModel.admin_login(this.Username_fieldBox.getText().trim(),this.Password_fieldBox.getText().trim())){
            stage.close();
            admin_Main_Page();    
        } else {
            this.Login_Status.setText("Wrong Admin Credentials");
        }
    }

    public void admin_Main_Page() { // Moving to admin main page

        Stage mainAdminPage = new Stage();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AdminMainPage/AdminMainPage.fxml")));

            mainAdminPage.setScene(scene);
            mainAdminPage.setTitle("Admin Login Page");
            mainAdminPage.setResizable(false);
            mainAdminPage.close();
            mainAdminPage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Exit_Program() throws IOException { // Method to exit the program

    Stage exit = new Stage();
    exit.close();
    System.exit(0);
}
}