package chess;

import piece.Camp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


/**
 * Classe qui controle la fenetre pour creer une nouvelle partie
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class NewPartieController {
    /**
     * Le controller de la fenetre de jeux
     */
    private JeuxController gameController;
    /**
     * La fenetre que gere ce controller
     */
    private Stage window;
    /**
     * La fenetre de jeux
     */
    private Stage globalWindow;
    
    /**
     * Bouton qui lance une nouvelle partie
     */
    @FXML
    private Button buttonNewPartie;
    /**
     * Bouton qui ferme la fenetre de creation de nouvelle partie
     */
    @FXML
    private Button buttonClose;
    /**
     * Bouton qui quitte l'application
     */
    @FXML
    private Button buttonExit;
    /**
     * Liste deroulante pour choisir un camp
     */
    @FXML
    private ComboBox choixCamp;
    /**
     * Liste deroulante pour choisir le temps des chronos
     */
    @FXML
    private ComboBox choixTime;
    /**
     * RadioButton pour choisir "oui" pour l'utilisation de deux interfaces
     */
    @FXML
    private RadioButton interfacesYes;
    /**
     * RadioButton pour choisir "non" pour l'utilisation de deux interfaces
     */
    @FXML
    private RadioButton interfacesNo;
    
    /**
     * Permet de remplir tous les champs de la fenetre de creation de partie
     */
    @FXML
    public void initialize(){
        ToggleGroup groupe = new ToggleGroup();
        
        interfacesYes.setToggleGroup(groupe);
        interfacesYes.setSelected(true);
        interfacesNo.setToggleGroup(groupe);
        
        for(int i=15; i<=600; i+=15){
            choixTime.getItems().add(i);
        }
        choixTime.setValue(300);
        
        choixCamp.getItems().add(Camp.blanc);
        choixCamp.getItems().add(Camp.noir);
        choixCamp.setValue(Camp.blanc);
    }
    
    /**
     * Permet de changer le controller de la fenetre de jeux
     * @param gameController le controller de la fenetre de jeux
     */
    public void setGameController(JeuxController gameController){
        this.gameController = gameController;
    }
    
    /**
     * Permet de changer la fenetre que gere cette classe
     * @param window la fenetre que gere cette classe
     */
    public void setWindow(Stage window){
        this.window = window;
    }
    
    /**
     * Permet de changer la fenetre de jeux
     * @param globalWindow la fenetre de jeux
     */
    public void setGlobalWindow(Stage globalWindow){
        this.globalWindow = globalWindow;
    }
    
    /**
     * permet d'initialiser la fenetre de creation d'une nouvelle partie
     */
    @FXML
    private void newPartie(){
        int time = (int) choixTime.getValue();
        Camp camp = (Camp) choixCamp.getValue();
        boolean dualInterface;
        
        if(interfacesYes.isSelected()){
            dualInterface = true;
        }
        else{
            dualInterface = false;
        }
        
        gameController.setCamp(camp);
        gameController.setDualInterface(dualInterface);
        gameController.getChronoBlanc().setTimeBase(time);
        gameController.getChronoNoir().setTimeBase(time);
        gameController.restart();
        
        window.close();
    }
    
    /**
     * ferme la fenetre de creation d'une nouvelle partie
     */
    @FXML
    private void close(){
        if(window != null){
            window.close();
        }
    }
    
    /**
     * Quitte l'application
     */
    @FXML
    private void exit(){
        if(gameController != null){
            window.close();
            globalWindow.close();
        }
    }
}
