package ch.hftm.trainingApp.presentation;

import java.util.Arrays;
import java.util.List;

import ch.hftm.trainingApp.MainApp;
import ch.hftm.trainingApp.application.ArmExercises;
import ch.hftm.trainingApp.application.BackExercises;
import ch.hftm.trainingApp.application.ChestExercises;
import ch.hftm.trainingApp.application.LegExercises;
import ch.hftm.trainingApp.application.MuscleGroup;
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

public class KraftController {

    private MainApp mainApp;

    // Information of Trainingsession
    @FXML
    private ChoiceBox<MuscleGroup> muscleChoice;
    @FXML
    private DatePicker datePicker;

    // Overview of the Exercises
    @FXML
    private ChoiceBox<String> exOne;
    @FXML
    private ChoiceBox<String> exTwo;
    @FXML
    private ChoiceBox<String> exThree;
    @FXML
    private ChoiceBox<String> exFour;
    @FXML
    private ChoiceBox<String> exFive;
    @FXML
    private ChoiceBox<String> exSix;
    @FXML
    private ChoiceBox<String> exSeven;

    // Textfield for weight
    @FXML
    private TextField weightOne;
    @FXML
    private TextField weightTwo;
    @FXML
    private TextField weightThree;
    @FXML
    private TextField weightFour;
    @FXML
    private TextField weightFive;
    @FXML
    private TextField weightSix;
    @FXML
    private TextField weightSeven;

    // Textfield for sets
    @FXML
    public TextField setsOne;
    @FXML
    private TextField setsTwo;
    @FXML
    private TextField setsThree;
    @FXML
    private TextField setsFour;
    @FXML
    private TextField setsFive;
    @FXML
    private TextField setsSix;
    @FXML
    private TextField setsSeven;

    // Textfield for reps
    @FXML
    public TextField repsOne;
    @FXML
    private TextField repsTwo;
    @FXML
    private TextField repsThree;
    @FXML
    private TextField repsFour;
    @FXML
    private TextField repsFive;
    @FXML
    private TextField repsSix;
    @FXML
    private TextField repsSeven;

    // Button for Confirmation
    @FXML
    private Button confirmButton;

    // Information for the serizalation
    @FXML
    private Text actualPath;
    @FXML
    private TextField dataPath;
    @FXML
    private TextArea showDetailsArea;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    // Set the ENUM to the CheckBox
    public void setMuscleChoiseBox() {
        this.muscleChoice.setItems(FXCollections.observableArrayList(MuscleGroup.values()));
    }

    // Set the List of the Chest Exercises CheckBoxes
    public void setChestExerciseChoiceBox() {
        this.exOne.setItems(ChestExercises.setList());
        this.exTwo.setItems(ChestExercises.setList());
        this.exThree.setItems(ChestExercises.setList());
        this.exThree.setItems(ChestExercises.setList());
        this.exFour.setItems(ChestExercises.setList());
        this.exFive.setItems(ChestExercises.setList());
        this.exSix.setItems(ChestExercises.setList());
        this.exSeven.setItems(ChestExercises.setList());
    }

    // Set the List of the Back Exercises CheckBoxes
    public void setBackExerciseChoiceBox() {
        this.exOne.setItems(BackExercises.setList());
        this.exTwo.setItems(BackExercises.setList());
        this.exThree.setItems(BackExercises.setList());
        this.exThree.setItems(BackExercises.setList());
        this.exFour.setItems(BackExercises.setList());
        this.exFive.setItems(BackExercises.setList());
        this.exSix.setItems(BackExercises.setList());
        this.exSeven.setItems(BackExercises.setList());
    }

    // Set the List of the Legs Exercises CheckBoxes
    public void setLegsExerciseChoiceBox() {
        this.exOne.setItems(LegExercises.setList());
        this.exTwo.setItems(LegExercises.setList());
        this.exThree.setItems(LegExercises.setList());
        this.exThree.setItems(LegExercises.setList());
        this.exFour.setItems(LegExercises.setList());
        this.exFive.setItems(LegExercises.setList());
        this.exSix.setItems(LegExercises.setList());
        this.exSeven.setItems(LegExercises.setList());
    }

    // Set the List of the Arms Exercises CheckBoxes
    public void setArmsExerciseChoiceBox() {
        this.exOne.setItems(ArmExercises.setList());
        this.exOne.setItems(ArmExercises.setList());
        this.exTwo.setItems(ArmExercises.setList());
        this.exThree.setItems(ArmExercises.setList());
        this.exThree.setItems(ArmExercises.setList());
        this.exFour.setItems(ArmExercises.setList());
        this.exFive.setItems(ArmExercises.setList());
        this.exSix.setItems(ArmExercises.setList());
        this.exSeven.setItems(ArmExercises.setList());
    }

    // Set the Text with the selected choice and date
    public void setTrainingInformation() throws NoMuscleTypeChoiced {

        if (muscleChoice.getSelectionModel().getSelectedItem() != null && datePicker.getValue() != null) {
            this.showDetailsArea.appendText("*******************");
            this.showDetailsArea.appendText("\n*******************\n");
            this.showDetailsArea.appendText(muscleChoice.getSelectionModel().getSelectedItem().toString() + "\n");
            this.showDetailsArea.appendText(datePicker.getValue().toString() + "\n");
            this.showDetailsArea.appendText("*******************\n");
        } else {
            throw new NoMuscleTypeChoiced();
        }
    }

    // Set the Text from the selected ChoiceBoxes and the Input of the textField to the TextArea
    public void setConfirmText() throws TextFieldIsEmpty {
        List<ChoiceBox> exercises = Arrays.asList(exOne, exTwo, exThree, exFour, exFive, exSix, exSeven);
        List<TextField> weights = Arrays.asList(weightOne, weightTwo, weightThree, weightFour, weightFive, weightSix, weightSeven);
        List<TextField> sets = Arrays.asList(setsOne, setsTwo, setsThree, setsFour, setsFive, setsSix, setsSeven);
        List<TextField> reps = Arrays.asList(repsOne, repsTwo, repsThree, repsFour, repsFive, repsSix, repsSeven);

        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getSelectionModel().getSelectedItem() != null) {
                if (!weights.get(i).getText().isEmpty() && !sets.get(i).getText().isEmpty()
                        && !reps.get(i).getText().isEmpty()) {
                    this.showDetailsArea.appendText(
                            exercises.get(i).getSelectionModel().getSelectedItem() + " [" + weights.get(i).getText()
                                    + "kg] - " + "Sets: " + sets.get(i).getText() + " (" + reps.get(i).getText() + ")\n");
                } else {
                    throw new TextFieldIsEmpty();
                }
            }
        }
    }

    @FXML
    public void initialize() {
        setMuscleChoiseBox();

        muscleChoice.setOnAction(e -> {
            if (muscleChoice.getSelectionModel().getSelectedItem().equals(MuscleGroup.CHEST)) {
                setChestExerciseChoiceBox();
                this.dataPath.setText("chest.txt");
            } else if (muscleChoice.getSelectionModel().getSelectedItem().equals(MuscleGroup.BACK)) {
                setBackExerciseChoiceBox();
                this.dataPath.setText("back.txt");
            } else if (muscleChoice.getSelectionModel().getSelectedItem().equals(MuscleGroup.LEG)) {
                setLegsExerciseChoiceBox();
                this.dataPath.setText("leg.txt");
            } else if (muscleChoice.getSelectionModel().getSelectedItem().equals(MuscleGroup.ARM)) {
                setArmsExerciseChoiceBox();
                this.dataPath.setText("arm.txt");
            }
        });
        this.actualPath.setText(FileAccess.getActualDirectoryString());
    }

    // Set the selected choices to the TextArea for saving the informations
    @FXML
    public void onConfirm(ActionEvent event) {
        try {
            setTrainingInformation();
        } catch (NoMuscleTypeChoiced e) {
        }
        try {
            setConfirmText();
        } catch (TextFieldIsEmpty e) {
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
