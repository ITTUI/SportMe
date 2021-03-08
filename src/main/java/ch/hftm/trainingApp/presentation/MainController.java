package ch.hftm.trainingApp.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {

    // Button "Cardio" is showing the CardioView
    @FXML
    private void onCardio(ActionEvent event) throws Exception{
        try {
            Parent view2 = FXMLLoader.load(getClass().getResource("/fxml/CardioView.fxml"));
    
            Scene sceneCardio = new Scene(view2);
    
            Stage window = new Stage();
            window.setTitle("Cardio training");
            window.setScene(sceneCardio);
            window.show();
            
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.getClass();
            e.printStackTrace();
        }
    }

    // Button "Kraft" is showing the KraftView
    @FXML
    private void onKraft(ActionEvent event) throws Exception{
        try {
            Parent view3 = FXMLLoader.load(getClass().getResource("/fxml/KraftView.fxml"));
    
            Scene sceneBrust = new Scene(view3);
    
            Stage window = new Stage();
            window.setTitle("Weight training");
            window.setScene(sceneBrust);
            window.show();
            
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.getClass();
            e.printStackTrace();
        }
    }
}

