package ch.hftm.trainingApp.application;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BackExercises implements Exercises{

    // Setting the Exercises for back 
    public static ObservableList<String> setList() {
        
        return FXCollections
                .observableList(Stream.of(
                    "Pull-ups",
                    "Lat pull-down",
                    "T-Bar",
                    "Deadlift",
                    "Row (Machine)",
                    "Row (BB)",
                    "One-arm row (DB)",
                    "Pullover cable press")
                .sorted().collect(Collectors.toList()));
    }
}
