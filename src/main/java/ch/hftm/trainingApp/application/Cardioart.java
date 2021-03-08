package ch.hftm.trainingApp.application;

public enum Cardioart {

    // ENUM (For the ChoiceBox)
    BIKE(1), RUNNING(2), STAIRMASTER(3), SWIMMING(4);

    // Fields
    private int number;

    // Constructor
    private Cardioart(int number) {
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
