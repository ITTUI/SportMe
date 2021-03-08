package ch.hftm.trainingApp.business;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NoMuscleTypeChoiced extends Exception {

    private static final long serialVersionUID = 1L;

    // Errormessage 
    public NoMuscleTypeChoiced() {
        super();
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fehlermeldung");
        alert.setHeaderText(null);
        alert.setContentText("Bitte wählen Sie die Muskelgruppe und das Datum aus!");
        alert.showAndWait();
    }
}