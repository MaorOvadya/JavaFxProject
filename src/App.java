import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Password - rlhGZiKevCK1ACf7

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
        }

    @Override
    public void start(Stage stage) throws Exception {
    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AdminLoginPage/AdminLoginPage.fxml")));
    stage.setTitle("Employee's Management System");
    stage.setScene(scene);
    stage.show();        
    }
}
