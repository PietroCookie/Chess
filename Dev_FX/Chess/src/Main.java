import chess.JeuxController;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal qui lance une application de jeux d'echec
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Main extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        FXMLLoader configurationLoader = new FXMLLoader(getClass().getResource("chess" + File.separator + "FenetreJeux.fxml"));
        Scene configScene = new Scene(configurationLoader.load());
        
        JeuxController controller = configurationLoader.getController();
        controller.setWindow(primaryStage);
        
        primaryStage.setTitle("Chess");
        primaryStage.setScene(configScene);

        primaryStage.show();
        
        var timeline = new javafx.animation.Timeline(new javafx.animation.KeyFrame(javafx.util.Duration.millis(500), (var e) -> { 
            if(controller.getJouer()){
                controller.actualiserJeux();
                controller.actualiserEchiquier();
                controller.actualiserTime();
                controller.actualiserInfo();
                controller.gagner();
            }
        }));
        timeline.setCycleCount(timeline.INDEFINITE);

        timeline.play();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
