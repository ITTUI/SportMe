package ch.hftm.trainingApp.presentation;

import ch.hftm.trainingApp.MainApp;
import ch.hftm.trainingApp.application.Cardioart;
import ch.hftm.trainingApp.business.NoMuscleTypeChoiced;
import ch.hftm.trainingApp.business.TextFieldIsEmpty;
import ch.hftm.trainingApp.data.FileAccess;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class CardioController {

    private MainApp mainApp;

    @FXML
    private ChoiceBox<Cardioart> trainingChoice;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField distance;
    @FXML
    private TextField duration;
    @FXML
    private Button confirmButton;

    @FXML
    private Text actualPath;
    @FXML
    private TextField dataPath;
    @FXML
    private TextArea showDetailsArea;
    @FXML
    private Button saveButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    // Set the ENUM to the CheckBox
    public void setTrainingsChoiceBox() {
        this.trainingChoice.setItems(FXCollections.observableArrayList(Cardioart.values()));
    }

    // Set the Text with the selected choice and date
    public void setTrainingInformation() throws NoMuscleTypeChoiced {

        if (trainingChoice.getSelectionModel().getSelectedItem() != null && datePicker.getValue() != null) {
            this.showDetailsArea.appendText("*******************");
            this.showDetailsArea.appendText("\n*******************\n");
            this.showDetailsArea.appendText(trainingChoice.getSelectionModel().getSelectedItem().toString() + "\n");
            this.showDetailsArea.appendText(datePicker.getValue().toString() + "\n");
            this.showDetailsArea.appendText("*******************\n");
        } else {
            throw new NoMuscleTypeChoiced();
        }
    }

    // Set the input of the textfields to the TextArea
    public void setConfirmText() throws TextFieldIsEmpty {

        if (!distance.getText().isEmpty() && !duration.getText().isEmpty()) {
            this.showDetailsArea.appendText(distance.getText() + "km (" + duration.getText() + "min) \n");
        } else {
            throw new TextFieldIsEmpty();
        }
    }

    @FXML
    public void initialize() {
        setTrainingsChoiceBox();

        trainingChoice.setOnAction(e -> {
            if (trainingChoice.getSelectionModel().getSelectedItem().equals(Cardioart.BIKE)) {
                this.dataPath.setText("bike.txt");
            } else if (trainingChoice.getSelectionModel().getSelectedItem().equals(Cardioart.RUNNING)) {
                this.dataPath.setText("running.txt");
            } else if (trainingChoice.getSelectionModel().getSelectedItem().equals(Cardioart.STAIRMASTER)) {
                this.dataPath.setText("stairmaster.txt");
            } else if (trainingChoice.getSelectionModel().getSelectedItem().equals(Cardioart.SWIMMING)) {
                this.dataPath.setText("swimming.txt");
            }
        });
        this.actualPath.setText(FileAccess.getActualDirectoryString());
    }

    // Set the selected choices to the TextArea for saving the informations
    @FXML
    public void onConfirm(ActionEvent event) {
        try {
            setTrainingInformation();
            setConfirmText();
        } catch (TextFieldIsEmpty | NoMuscleTypeChoiced e) {
        }
    }

    // loading ig the file already exist
    @FXML
    public void onLoad() {
        try {
            String content = FileAccess.readFile(dataPath.getText());
            this.showDetailsArea.setText(content);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Exception: " + e.getClass().getName());
            alert.setHeaderText(null);
            alert.setContentText("Error-Message: " + e.getMessage());
            alert.showAndWait();
        }
        this.actualPath.setText("Actual Path: " + FileAccess.getActualDirectoryString());
    }

    // saving the traininginformation on textfile
    @FXML
    public void onSave() {
        try {
            FileAccess.saveFile(dataPath.getText(), showDetailsArea.getText());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Exception: " + e.getClass().getName());
            alert.setHeaderText(null);
            alert.setContentText("Error-Message: " + e.getMessage());
            alert.showAndWait();
        }
        this.actualPath.setText("Actual Path: " + FileAccess.getActualDirectoryString());
    }
}
