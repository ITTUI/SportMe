package ch.hftm.trainingApp.business;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextFieldIsEmpty extends Exception {

    private static final long serialVersionUID = 1L;
    
    // Errormessage 
    public TextFieldIsEmpty(){
        super();
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fehlermeldung");
        alert.setHeaderText(null);
        alert.setContentText("Bitte füllen Sie alle Textfelder aus!");
        alert.showAndWait();
    }
}
