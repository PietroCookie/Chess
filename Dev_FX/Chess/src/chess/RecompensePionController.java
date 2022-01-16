package chess;

import piece.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Classe permettant de gerer la fenetre de recompense d'un pion
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class RecompensePionController {
    /**
     * Le controller de la fenetre de jeux
     */
    private JeuxController gameController;
    /**
     * La fenetre que controlle cette classe
     */
    private Stage window;
    /**
     * Le pion a recompenser
     */
    private Pion pion;
    
    /**
     * l'ImageView qui affiche une piece de type reine
     */
    @FXML
    private ImageView Reine;
    /**
     * l'ImageView qui affiche une piece de type tour
     */
    @FXML
    private ImageView Tour;
    /**
     * l'ImageView qui affiche une piece de type fou
     */
    @FXML
    private ImageView Fou;
    /**
     * l'ImageView qui affiche une piece de type cavalier
     */
    @FXML
    private ImageView Cavalier;
    
    /**
     * Charge les images dans les ImageView correspondant
     */
    @FXML
    public void afficher(){
        FileInputStream fichier = null;
        try {
            if(gameController.getCamp().equals(Camp.blanc)){
                String chemin = "images" + File.separator + gameController.getTexture() + File.separator + "reineBlanc.png";
                fichier = new FileInputStream(new File(chemin));
                Image image = new Image(fichier);
                Reine.setImage(image) ;
                fichier.close();
                
                chemin = "images" + File.separator + gameController.getTexture() + File.separator + "tourBlanc.png";
                fichier = new FileInputStream(new File(chemin));
                image = new Image(fichier);
                Tour.setImage(image) ;
                fichier.close();
                
                chemin = "images" + File.separator + gameController.getTexture() + File.separator + "fouBlanc.png";
                fichier = new FileInputStream(new File(chemin));
                image = new Image(fichier);
                Fou.setImage(image) ;
                fichier.close();
                
                chemin = "images" + File.separator + gameController.getTexture() + File.separator + "cavalierBlanc.png";
                fichier = new FileInputStream(new File(chemin));
                image = new Image(fichier);
                Cavalier.setImage(image) ;
                fichier.close();
            }
            else{
                String chemin = "images" + File.separator + gameController.getTexture() + File.separator + "reineNoir.png";
                fichier = new FileInputStream(new File(chemin));
                Image image = new Image(fichier);
                Reine.setImage(image) ;
                fichier.close();
                
                chemin = "images" + File.separator + gameController.getTexture() + File.separator + "tourNoir.png";
                fichier = new FileInputStream(new File(chemin));
                image = new Image(fichier);
                Tour.setImage(image) ;
                fichier.close();
                
                chemin = "images" + File.separator + gameController.getTexture() + File.separator + "fouNoir.png";
                fichier = new FileInputStream(new File(chemin));
                image = new Image(fichier);
                Fou.setImage(image) ;
                fichier.close();
                
                chemin = "images" + File.separator + gameController.getTexture() + File.separator + "cavalierNoir.png";
                fichier = new FileInputStream(new File(chemin));
                image = new Image(fichier);
                Cavalier.setImage(image) ;
                fichier.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permet de changer le controller de la fenetre de jeux
     * @param gameController le controller de la fenetre de jeux
     */
    public void setGameController(JeuxController gameController){
        this.gameController = gameController;
    }
    
    /**
     * Permet de modifier le pion a recompenser
     * @param pion le pino a recompenser
     */
    public void setPion(Pion pion){
        this.pion = pion;
    }
    
    /**
     * Permet de modifier l'attribut qui contient la fenetre que gere cette classe
     * @param window la fenetre que gere cette classe
     */
    public void setWindow(Stage window){
        this.window = window;
    }
    
    /**
     * Permet de choisir comme recompense une piece de type reine et ferme la fenetre de recompense de pion
     */
    @FXML
    private void recompenseReine(){
        if(gameController.getCamp().equals(Camp.blanc)){
            gameController.recompenserPion(pion, TypePiece.reineBlanc);
        }
        else{
            gameController.recompenserPion(pion, TypePiece.reineNoir);
        }
        window.close();
    }
    
    /**
     * Permet de choisir comme recompense une piece de type tour et ferme la fenetre de recompense de pion
     */
    @FXML
    private void recompenseTour(){
        if(gameController.getCamp().equals(Camp.blanc)){
            gameController.recompenserPion(pion, TypePiece.tourBlanc);
        }
        else{
            gameController.recompenserPion(pion, TypePiece.tourNoir);
        }
        window.close();
    }
    
    /**
     * Permet de choisir comme recompense une piece de type fou et ferme la fenetre de recompense de pion
     */
    @FXML
    private void recompenseFou(){
        if(gameController.getCamp().equals(Camp.blanc)){
            gameController.recompenserPion(pion, TypePiece.fouBlanc);
        }
        else{
            gameController.recompenserPion(pion, TypePiece.fouNoir);
        }
        window.close();
    }
    
    /**
     * Permet de choisir comme recompense une piece de type cavalier et ferme la fenetre de recompense de pion
     */
    @FXML
    private void recompenseCavalier(){
        if(gameController.getCamp().equals(Camp.blanc)){
            gameController.recompenserPion(pion, TypePiece.cavalierBlanc);
        }
        else{
            gameController.recompenserPion(pion, TypePiece.cavalierNoir);
        }
        window.close();
    }
}
