package ch.hftm.trainingApp;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    
    private static final Logger LOG =  Logger.getLogger(Logging.class.getName());

	public MainApp() {
	}
	
	public Stage getPrimeryStage() {
		return this.primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/fxml/MainView.fxml"));
            
            Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
                primaryStage.setTitle("Overview of the training");
                primaryStage.setMinWidth(500);
                primaryStage.setMinHeight(300);
                primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getClass();
        }
	}

	public static void main(String[] args) {

        FileHandler fh;  
    
        try {  
    
            fh = new FileHandler("Logg.log");  
            LOG.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
    
            LOG.info("LOGGING TEST!"); 
    
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    
		launch(args);
	}
}

















