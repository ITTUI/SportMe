package ch.hftm.trainingApp.application;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LegExercises implements Exercises{


    // Setting the Exercises for leg 
    public static ObservableList<String> setList() {
        
        return FXCollections
                .observableList(Stream.of(
                    "Leg press vertical",
                    "Leg extension",
                    "Back squat",
                    "Lunges",
                    "Leg press horinzontal",
                    "Hamstring curl",
                    "Hip Thrust",
                    "Romanian deadlift")
                .sorted().collect(Collectors.toList()));
    }

}



