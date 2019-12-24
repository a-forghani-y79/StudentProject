package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    JFXButton btnLogIn;
    @FXML
    JFXPasswordField txtPassword;
    @FXML
    JFXTextField txtUsername;
    
    String User = "jafar";
    String pass = "1234";
    double x = 0;
    double y = 0;
    private Object MainMenuController;


    public void onClickLogIn() {
        if (txtPassword.getText().equals(pass)&&txtUsername.getText().equals(User)){
            try{
            Parent root;
            Stage stage = (Stage) btnLogIn.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/MainMenu.fxml"));

            root = loader.load();
            loader.setController(MainMenuController);
            stage = new Stage();
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            Stage finalStage = stage;
            root.setOnMouseDragged(event -> {
                finalStage.setX(event.getScreenX() - x);
                finalStage.setY(event.getScreenY() - y);
            });
            finalStage.setResizable(false);
            finalStage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
                System.out.println(e.getMessage());        
            }
        }
        

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
