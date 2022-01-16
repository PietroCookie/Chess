package chess;

import piece.*;
import regle.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Classe qui permet de controller une fenetre de fin de partie
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class GagnantController {
    /**
     * Le controller qui gere la fenetre de jeux
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
     * Le bouton qui permet de recommencer une partie
     */
    @FXML
    private Button buttonRestart;
    /**
     * Le bouton qui ferme la fenetre que gere ce controller
     */
    @FXML
    private Button buttonClose;
    /**
     * Le bouton qui permet de quitter l'application
     */
    @FXML
    private Button buttonExit;
    /**
     * Le message de fin de partie a afficher
     */
    @FXML
    private Label message;
    /**
     * Les infos sur les pieces prises par l'adversaire
     */
    @FXML
    private GridPane infoAdverse;

    /**
     * Les infos sur les pieces prises par le joueur
     */
    @FXML
    private GridPane infoMoi;
    
    /**
     * Permet d'initialiser la fenetre de fin de partie avec les infos qu'il faut
     * @param gagnant le camp qui a gagne ou s'il y a egalite
     */
    @FXML
    public void afficher(Vainqueur gagnant){
        
        String msg = "MESSAGE";
        
        if(gagnant.equals(Vainqueur.blanc)){
            msg = "Le camp Blanc remporte la partie !";
        }else if(gagnant.equals(Vainqueur.noir)){
            msg = "Le camp Noir remporte la partie";
        }else if(gagnant.equals(Vainqueur.egalite)){
            msg = "Personne n'a sur remporte la partie ... Reessayez !";
        }
        
        msg += "\nIl aura fallu " + gameController.getJeux().getTour()/2 + " tours";
        
        message.setText(msg);
        
        String texture = gameController.getTexture();
        Echiquier jeux = gameController.getJeux();
        if(gameController.getCamp().equals(Camp.blanc)){
            for(int i=0; i<jeux.getPieceBlancMorte().size(); i++){
                try{
                    APiece piece = gameController.getJeux().getPieceBlancMorte().get(i);
                    if(piece instanceof Tour){
                        String chemin = "images" + File.separator + texture + File.separator + "tourBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            for(int i=0; i<jeux.getPieceNoireMorte().size(); i++){
                try{
                    APiece piece = jeux.getPieceNoireMorte().get(i);
                    if(piece instanceof Tour){
                        String chemin = "images" + File.separator + texture + File.separator + "tourNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        else{
            for(int i=0; i<jeux.getPieceBlancMorte().size(); i++){
                try{
                    APiece piece = jeux.getPieceBlancMorte().get(i);
                    if(piece instanceof Tour){
                        String chemin = "images" + File.separator + texture + File.separator + "tourBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionBlanc.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            for(int i=0; i<jeux.getPieceNoireMorte().size(); i++){
                try{
                    APiece piece = jeux.getPieceNoireMorte().get(i);
                    if(piece instanceof Tour){
                        String chemin = "images" + File.separator + texture + File.separator + "tourNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionNoir.png";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                }catch(FileNotFoundException e){
                   e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Permet de connaitre le controller de la fenetre de jeux
     * @param gameController le controller de la fenetre de jeux
     */
    public void setGameController(JeuxController gameController){
        this.gameController = gameController;
    }
    
    /**
     * Permet de connaitre la fenetre que gere ce controller
     * @param window La fenetre que gere ce controller
     */
    public void setWindow(Stage window){
        this.window = window;
    }
    
    /**
     * La fenetre que gere le controller de jeux
     * @param globalWindow
     */
    public void setGlobalWindow(Stage globalWindow){
        this.globalWindow = globalWindow;
    }
    
    /**
     * Permet de redemarrer une partie
     */
    @FXML
    private void restart(){
        if(gameController != null && window != null){
            gameController.restart();
            window.close();
        }
    }
    
    /**
     * Permet de fermer la fenetre que gere ce controller
     */
    @FXML
    private void close(){
        if(window != null){
            window.close();
        }
    }
    
    /**
     * Permet de quitter l'application
     */
    @FXML
    private void Exit(){
        if(gameController != null){
            window.close();
            globalWindow.close();
        }
    }
}
