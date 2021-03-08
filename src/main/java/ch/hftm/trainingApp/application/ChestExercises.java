package ch.hftm.trainingApp.application;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChestExercises implements Exercises {

    // Setting the Exercises for chest 
    public static ObservableList<String> setList() {
        
        return FXCollections
                .observableList(Stream.of(
                    "Bench press (DB)",
                    "Butterfly",
                    "Bench press (BB)",
                    "Incline bench press (BB)",
                    "Incline bench press (DB)",
                    "Cable press (middle)",
                    "Cable press (down-up)",
                    "Cegative bench press (BB)",
                    "Push-ups")
                .sorted().collect(Collectors.toList()));
    }
}
