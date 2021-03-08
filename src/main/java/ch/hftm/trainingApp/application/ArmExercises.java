package ch.hftm.trainingApp.application;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArmExercises implements Exercises{

    // Setting the Exercises for arm 
    public static ObservableList<String> setList() {
        
        return FXCollections
                .observableList(Stream.of(
                    "Arnie Dips", 
                    "Cable press-down", 
                    "Biceps curl (DB)", 
                    "Biceps curl (BB)",
                    "Cable biceps curl", 
                    "Concentration curl (DB)", 
                    "Spidel curl (DB)", 
                    "Spider curl (BB)",
                    "One-arm tricep extension", 
                    "EZ-bar skullcrusher")
                    .sorted().collect(Collectors.toList()));
    }

}
