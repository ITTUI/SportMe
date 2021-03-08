package ch.hftm.trainingApp.application;

import javafx.collections.ObservableList;

public interface Exercises {

    // methode for the setting of Lists 
    public default void setList(ObservableList<String> Liste) {
    }
}
