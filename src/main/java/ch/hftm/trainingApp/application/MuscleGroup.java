package ch.hftm.trainingApp.application;


public enum MuscleGroup {

    // ENUM (For the ChoiceBox)
    CHEST(1), BACK(2), ARM(3), LEG(4);

    // Fields
    private int number;

    // Constructor
    private MuscleGroup(int number) {
        this.number = number;
    }

    // Getter und Setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
