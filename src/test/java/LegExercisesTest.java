import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ch.hftm.trainingApp.application.LegExercises;

public class LegExercisesTest{

    // Testing the sorting of the Exercises
    @Test
    public void setList() {

        List<String> sortingList = List.of(
            "Back squat", 
            "Beinpresse horinzontal", 
            "Beinpresse vertikal", 
            "Hamstring curl",
            "Hip Thrust", 
            "Leg extension", 
            "Lunges", 
            "Romanian deadlift");
        
        assertEquals(LegExercises.setList(), sortingList);
    }
}