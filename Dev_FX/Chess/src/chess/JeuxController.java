package chess;
import piece.*;
import regle.*;
import exceptions.*;


import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.event.*;

import javax.sound.sampled.*;

/**
 * Classe qui permet de gerer la fenetre de jeux
 * @author Pierre CHEMIN
 */
public class JeuxController {
    /**
     * La fenetre de jeux
     */
    private Stage window;
    /**
     * Le point de vue depuis lequel on voit le jeux
     */
    private Camp pointVue;
    /**
     * Le camp dans lequel on joue
     */
    private Camp camp;
    /**
     * Permet de savoir si la partie est en cours ou non
     */
    private boolean jouer;
    /**
     * Permet de savoir si on joue sur plusieurs interfaces ou non
     */
    private boolean dualInterface;
    /**
     * Le Gestionnaire d'un echiquier, gère une partie d'échec
     */
    private Echiquier jeux;
    /**
     * Une piece que l'on veut jouer
     */
    private APiece jouerPiece;
    /**
     * Le gestionnaire du chrono Blanc
     */
    private CustomTimer chronoBlanc;
    /**
     * Le gestionnaire du chrono Noir
     */
    private CustomTimer chronoNoir;
    /**
     * Le pack de texture a utilise
     */
    private String texture;
    
    /**
     * L'ImageView de la case1
     */
    @FXML
    private ImageView case1;
    /**
     * L'ImageView de la case2
     */
    @FXML
    private ImageView case2;
    /**
     * L'ImageView de la case3
     */
    @FXML
    private ImageView case3;
    /**
     * L'ImageView de la case4
     */
    @FXML
    private ImageView case4;
    /**
     * L'ImageView de la case5
     */
    @FXML
    private ImageView case5;
    /**
     * L'ImageView de la case6
     */
    @FXML
    private ImageView case6;
    /**
     * L'ImageView de la case7
     */
    @FXML
    private ImageView case7;
    /**
     * L'ImageView de la case8
     */
    @FXML
    private ImageView case8;
    /**
     * L'ImageView de la case9
     */
    @FXML
    private ImageView case9;
    /**
     * L'ImageView de la case10
     */
    @FXML
    private ImageView case10;
    /**
     * L'ImageView de la case11
     */
    @FXML
    private ImageView case11;
    /**
     * L'ImageView de la case12
     */
    @FXML
    private ImageView case12;
    /**
     * L'ImageView de la case13
     */
    @FXML
    private ImageView case13;
    /**
     * L'ImageView de la case14
     */
    @FXML
    private ImageView case14;
    /**
     * L'ImageView de la case15
     */
    @FXML
    private ImageView case15;
    /**
     * L'ImageView de la case16
     */
    @FXML
    private ImageView case16;
    /**
     * L'ImageView de la case17
     */
    @FXML
    private ImageView case17;
    /**
     * L'ImageView de la case18
     */
    @FXML
    private ImageView case18;
    /**
     * L'ImageView de la case19
     */
    @FXML
    private ImageView case19;
    /**
     * L'ImageView de la case20
     */
    @FXML
    private ImageView case20;
    /**
     * L'ImageView de la case21
     */
    @FXML
    private ImageView case21;
    /**
     * L'ImageView de la case22
     */
    @FXML
    private ImageView case22;
    /**
     * L'ImageView de la case23
     */
    @FXML
    private ImageView case23;
    /**
     * L'ImageView de la case24
     */
    @FXML
    private ImageView case24;
    /**
     * L'ImageView de la case25
     */
    @FXML
    private ImageView case25;
    /**
     * L'ImageView de la case26
     */
    @FXML
    private ImageView case26;
    /**
     * L'ImageView de la case27
     */
    @FXML
    private ImageView case27;
    /**
     * L'ImageView de la case28
     */
    @FXML
    private ImageView case28;
    /**
     * L'ImageView de la case29
     */
    @FXML
    private ImageView case29;
    /**
     * L'ImageView de la case30
     */
    @FXML
    private ImageView case30;
    /**
     * L'ImageView de la case31
     */
    @FXML
    private ImageView case31;
    /**
     * L'ImageView de la case32
     */
    @FXML
    private ImageView case32;
    /**
     * L'ImageView de la case33
     */
    @FXML
    private ImageView case33;
    /**
     * L'ImageView de la case34
     */
    @FXML
    private ImageView case34;
    /**
     * L'ImageView de la case35
     */
    @FXML
    private ImageView case35;
    /**
     * L'ImageView de la case36
     */
    @FXML
    private ImageView case36;
    /**
     * L'ImageView de la case37
     */
    @FXML
    private ImageView case37;
    /**
     * L'ImageView de la case38
     */
    @FXML
    private ImageView case38;
    /**
     * L'ImageView de la case39
     */
    @FXML
    private ImageView case39;
    /**
     * L'ImageView de la case40
     */
    @FXML
    private ImageView case40;
    /**
     * L'ImageView de la case41
     */
    @FXML
    private ImageView case41;
    /**
     * L'ImageView de la case42
     */
    @FXML
    private ImageView case42;
    /**
     * L'ImageView de la case43
     */
    @FXML
    private ImageView case43;
    /**
     * L'ImageView de la case44
     */
    @FXML
    private ImageView case44;
    /**
     * L'ImageView de la case45
     */
    @FXML
    private ImageView case45;
    /**
     * L'ImageView de la case46
     */
    @FXML
    private ImageView case46;
    /**
     * L'ImageView de la case47
     */
    @FXML
    private ImageView case47;
    /**
     * L'ImageView de la case48
     */
    @FXML
    private ImageView case48;
    /**
     * L'ImageView de la case49
     */
    @FXML
    private ImageView case49;
    /**
     * L'ImageView de la case50
     */
    @FXML
    private ImageView case50;
    /**
     * L'ImageView de la case51
     */
    @FXML
    private ImageView case51;
    /**
     * L'ImageView de la case52
     */
    @FXML
    private ImageView case52;
    /**
     * L'ImageView de la case53
     */
    @FXML
    private ImageView case53;
    /**
     * L'ImageView de la case54
     */
    @FXML
    private ImageView case54;
    /**
     * L'ImageView de la case55
     */
    @FXML
    private ImageView case55;
    /**
     * L'ImageView de la case56
     */
    @FXML
    private ImageView case56;
    /**
     * L'ImageView de la case57
     */
    @FXML
    private ImageView case57;
    /**
     * L'ImageView de la case58
     */
    @FXML
    private ImageView case58;
    /**
     * L'ImageView de la case59
     */
    @FXML
    private ImageView case59;
    /**
     * L'ImageView de la case60
     */
    @FXML
    private ImageView case60;
    /**
     * L'ImageView de la case61
     */
    @FXML
    private ImageView case61;
    /**
     * L'ImageView de la case62
     */
    @FXML
    private ImageView case62;
    /**
     * L'ImageView de la case63
     */
    @FXML
    private ImageView case63;
    /**
     * L'ImageView de la case64
     */
    @FXML
    private ImageView case64;
    /**
     * Le plateur de jeux
     */
    @FXML
    private GridPane plateau;
    /**
     * L'affichage du chrono adverse
     */
    @FXML
    private Label chronoAdverse;
    /**
     * L'affichage du chrono du joueur
     */
    @FXML
    private Label chronoMoi;
    /**
     * Les infos de partie sur les pieces que l'adversaire a prises
     */
    @FXML
    private GridPane infoAdverse;
    /**
     * Les infos de partie sur les pieces que le joueur a prises
     */
    @FXML
    private GridPane infoMoi;
    /**
     * Le menu deroulant des packs de texture
     */
    @FXML
    private Menu menuPack;
    
    /**
     * Permet d'initialiser la fenetre avec toutes les informations qu'il faut, notamment la liste des packs de texture
     */
    @FXML
    public void initialize(){
        int a=0;
        int b=0;
        for(int i=1; i<129; i+=2){
            ((ImageView)plateau.getChildren().get(i)).setX(a);
            ((ImageView)plateau.getChildren().get(i)).setY(b);
            b++;
            if(b==8){
                a++;
                b=0;
            }
        }
        
        texture = "basique";
        camp = Camp.blanc;
        pointVue = Camp.blanc;
        chronoBlanc = new CustomTimer(300, "chronoBlanc");
        chronoNoir = new CustomTimer(300, "chronoNoir");
        chronoAdverse.setText("No Chrono");
        chronoMoi.setText("No Chrono");
        
        jeux = new Echiquier();
        jouer = true;
        dualInterface = false;
        jouerPiece = null;
        actualiserEchiquier();
        actualiserPackTexture();
    }
    
    /**
     * Permet de savoir si la partie est en cours
     * @return vrai si la partie est en cours, faux sinon
     */
    public boolean getJouer(){
        return jouer;
    }
    
    /**
     * Permet de savoir le camp dans lequel on joue
     * @return le camp dans lequel on joue
     */
    public Camp getCamp(){
        return camp;
    }
    
    /**
     * Permet de savoir le pack de texture a utilise
     * @return le pack de texture a utilise
     */
    public String getTexture(){
        return texture;
    }
    
    /**
     * Permet d'obtenir le gestionnaire de regle d'une partie d'echec
     * @return le gestionnaire de regle d'une partie d'echec
     */
    public Echiquier getJeux(){
        return jeux;
    }
    
    /**
     * Permet d'obtenir le chrono Blanc
     * @return le chrono Blanc
     */
    public CustomTimer getChronoBlanc(){
        return chronoBlanc;
    }
    
    /**
     * Permet d'obtenir le chrono Noir
     * @return le chrono Noir
     */
    public CustomTimer getChronoNoir(){
        return chronoNoir;
    }
    
    /**
     * Permet de modifier si l'on joue sur une ou plusieurs interfaces
     * @param dualInterface vrai si on veut jouer sur plusieurs interfaces, faux sinon
     */
    public void setDualInterface(boolean dualInterface){
        this.dualInterface = dualInterface;
    }
    
    /**
     * Permet de modifier la fenetre que gere cette classe
     * @param window la fenetre que gere cette classe
     */
    public void setWindow(Stage window){
        this.window = window;
    }
    
    /**
     * Permet de modifier le camp dans lequel on joue
     * @param camp le camp dans lequel on joue
     */
    public void setCamp(Camp camp){
        if(camp.equals(Camp.blanc)){
            setCampBlanc();
        }
        else{
            setCampNoir();
        }
    }
    
    /**
     * Permet de modifier le menu deroulant des packs de texture
     */
    @FXML
    private void actualiserPackTexture(){
        String ligne;
        menuPack.getItems().clear();
        
        try{
            BufferedReader listePack = new BufferedReader(new FileReader("images"+File.separator+"ListePack.txt"));
            while((ligne = listePack.readLine()) != null){
                MenuItem pack = new MenuItem(ligne);
                menuPack.getItems().add(pack);
                
                pack.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event){
                        texture = pack.getText();
                        actualiserEchiquier();
                        actualiserInfo();
                    }
                });
            }
            listePack.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * Permet de mettre la bonne couleur sur chaque case, cree l'alternance gris/blanc 
     */
    @FXML
    private void baseEchiquier(){
        for(int i=0; i<128; i+=4){
            if(i==16 || i==48 || i==80 || i==112){
                i+=2;
            }
            ((Label)plateau.getChildren().get(i)).setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), CornerRadii.EMPTY, Insets.EMPTY)));
            if(i==30 || i==62 || i==94){
                i-=2;
            }
        }
        for(int i=0; i<128; i+=2){
            if(! (((Label) plateau.getChildren().get(i)).getBackground().equals(new Background(new BackgroundFill(Paint.valueOf("white"), CornerRadii.EMPTY, Insets.EMPTY))) ) ){
                ((Label)plateau.getChildren().get(i)).setBackground(new Background(new BackgroundFill(Paint.valueOf("gray"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }
    
    /**
     * Permet de modifier l'affichage des chronos
     */
    @FXML
    public void actualiserTime(){
        ObjectInputStream lectureChronoNoir;
        ObjectInputStream lectureChronoBlanc;
        CustomTimer lecteurChronoNoir = null;
        CustomTimer lecteurChronoBlanc = null;
        
        try{
            File fichierChronoBlanc = new File("game" + File.separator + "chronoBlanc.txt");
            File fichierChronoNoir = new File("game" + File.separator + "chronoNoir.txt");

            if(fichierChronoBlanc.exists() && fichierChronoNoir.exists()){
                
                lectureChronoNoir = new ObjectInputStream(
                    new FileInputStream(
                        fichierChronoNoir));
                    
                lecteurChronoNoir = (CustomTimer) lectureChronoNoir.readObject();

                lectureChronoBlanc = new ObjectInputStream(
                    new FileInputStream(
                        fichierChronoBlanc));
                    
                lecteurChronoBlanc = (CustomTimer) lectureChronoBlanc.readObject();
                
                if(camp.equals(Camp.blanc)){
                    chronoAdverse.setText(lecteurChronoNoir.getTime());
                    chronoMoi.setText(lecteurChronoBlanc.getTime());
                }
                else{
                    chronoAdverse.setText(lecteurChronoBlanc.getTime());
                    chronoMoi.setText(lecteurChronoNoir.getTime());
                }
                
                lectureChronoBlanc.close();
                lectureChronoNoir.close();
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Permet de modifier le gestionnaire de regle et d'actualiser l'etat du jeux
     */
    public void actualiserJeux(){
        ObjectInputStream lecture;
        try{
            lecture = new ObjectInputStream(
                new FileInputStream(
                    new File("game" + File.separator + "jeux.txt")));
                
            jeux = (Echiquier) lecture.readObject();

            lecture.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * Permet de modifier l'echiquier pour qu'il corresponde a l'etat du jeux
     */
    @FXML
    public void actualiserEchiquier(){
        if(pointVue.equals(Camp.blanc)){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(!jeux.estLibre(i, j)){
                        try{
                            APiece piece = jeux.getPiece(i, j);
                            if(piece.getCamp().equals(Camp.blanc)){
                                if(piece instanceof Tour){
                                    String chemin = "images" + File.separator + texture + File.separator + "tourBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Cavalier){
                                    String chemin = "images" + File.separator + texture + File.separator + "cavalierBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Fou){
                                    String chemin = "images" + File.separator + texture + File.separator + "fouBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Reine){
                                    String chemin = "images" + File.separator + texture + File.separator + "reineBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Roi){
                                    String chemin = "images" + File.separator + texture + File.separator + "roiBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Pion){
                                    String chemin = "images" + File.separator + texture + File.separator + "pionBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                
                                if(piece instanceof Roi){
                                    if(((Roi)piece).getEchec()){
                                        ((Label)plateau.getChildren().get((i*8+j)*2)).setBackground(new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    }
                                }
                            }
                            else{
                                if(piece instanceof Tour){
                                    String chemin = "images" + File.separator + texture + File.separator + "tourNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Cavalier){
                                    String chemin = "images" + File.separator + texture + File.separator + "cavalierNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Fou){
                                    String chemin = "images" + File.separator + texture + File.separator + "fouNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Reine){
                                    String chemin = "images" + File.separator + texture + File.separator + "reineNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Roi){
                                    String chemin = "images" + File.separator + texture + File.separator + "roiNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Pion){
                                    String chemin = "images" + File.separator + texture + File.separator + "pionNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(image) ;
                                }
                                
                                if(piece instanceof Roi){
                                    if(((Roi)piece).getEchec()){
                                        ((Label)plateau.getChildren().get((i*8+j)*2)).setBackground(new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    }
                                }
                            }

                        }catch(PieceException e){
                            e.printStackTrace();
                        }catch(FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                    else{
                        ((ImageView) plateau.getChildren().get( (i*8+j)*2+1)).setImage(null) ;
                    }
                }
            }
        }
        else{
            int a =0;
            int b=0;
            for(int i=7; i>-1; i--){
                for(int j=7; j>-1; j--){
                    if(!jeux.estLibre(i, j)){
                        try{
                            APiece piece = jeux.getPiece(i, j);
                            if(piece.getCamp().equals(Camp.blanc)){
                                if(piece instanceof Tour){
                                    String chemin = "images" + File.separator + texture + File.separator + "tourBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Cavalier){
                                    String chemin = "images" + File.separator + texture + File.separator + "cavalierBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Fou){
                                    String chemin = "images" + File.separator + texture + File.separator + "fouBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Reine){
                                    String chemin = "images" + File.separator + texture + File.separator + "reineBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Roi){
                                    String chemin = "images" + File.separator + texture + File.separator + "roiBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Pion){
                                    String chemin = "images" + File.separator + texture + File.separator + "pionBlanc.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                
                                if(piece instanceof Roi){
                                    if(((Roi)piece).getEchec()){
                                        ((Label)plateau.getChildren().get((a*8+b)*2)).setBackground(new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    }
                                }
                            }
                            else{
                                if(piece instanceof Tour){
                                    String chemin = "images" + File.separator + texture + File.separator + "tourNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Cavalier){
                                    String chemin = "images" + File.separator + texture + File.separator + "cavalierNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Fou){
                                    String chemin = "images" + File.separator + texture + File.separator + "fouNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Reine){
                                    String chemin = "images" + File.separator + texture + File.separator + "reineNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Roi){
                                    String chemin = "images" + File.separator + texture + File.separator + "roiNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                else if(piece instanceof Pion){
                                    String chemin = "images" + File.separator + texture + File.separator + "pionNoir.png";
                                    FileInputStream fichier = new FileInputStream(new File(chemin));
                                    Image image = new Image(fichier);
                                    ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(image) ;
                                }
                                
                                if(piece instanceof Roi){
                                    if(((Roi)piece).getEchec()){
                                        ((Label)plateau.getChildren().get((a*8+b)*2)).setBackground(new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    }
                                }
                            }

                        }catch(PieceException e){
                            e.printStackTrace();
                        }catch(FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                    else{
                        ((ImageView) plateau.getChildren().get( (a*8+b)*2+1)).setImage(null) ;
                    }
                    b++;
                }
                b=0;
                a++;
            }
        }
    }
    
    /**
     * Permet de modifier le camp dans lequel on joue pour le camp Blanc
     */
    @FXML
    private void setCampBlanc(){
        camp = Camp.blanc;
        
        setPointVueBlanc();
    }
    
    /**
     * Permet de modifier le camp dans lequel on joue pour le camp Noir
     */
    @FXML
    private void setCampNoir(){
        camp = Camp.noir;
        
        setPointVueNoir();
    }
    
    /**
     * Permet de modifier le point de vue depuis lequel on voit le jeux pour le camp Blanc
     */
    @FXML
    private void setPointVueBlanc(){
        pointVue = Camp.blanc;
        
        baseEchiquier();
        actualiserEchiquier();
    }
    
    /**
     * Permet de modifier le point de vue depuis lequel on voit le jeux pour le camp Noir
     */
    @FXML
    private void setPointVueNoir(){
        pointVue = Camp.noir;
        
        baseEchiquier();
        actualiserEchiquier();
    }
    
    /**
     * Permet de redemarrer une partie, remet le jeux a son etat initial
     */
    @FXML
    public void restart(){
        jouer = true;
        baseEchiquier();
        jeux.restart();
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + "jeux.txt")));
            ecriture.writeObject(jeux);
            ecriture.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        actualiserJeux();
        chronoBlanc.Restart();
        chronoNoir.Restart();
        actualiserTime();
        if(!dualInterface){
            setCampBlanc();
        }
        else{
            actualiserEchiquier();
        }
    }
    
    /**
     * Permet de gerer le cas lorsqu'un joueur gagne la partie
     */
    @FXML
    public void gagner(){
        try{
            if(!jeux.gagnant().equals(Vainqueur.aucun)){
                FXMLLoader fenGagnantLoader = new FXMLLoader(getClass().getResource("FenetreGagnant.fxml"));
                Scene fenetreGagnant = new Scene(fenGagnantLoader.load());
                GagnantController gagnantController = fenGagnantLoader.getController();
                
                Stage windowGagnant = new Stage();
                windowGagnant.setScene(fenetreGagnant);
                windowGagnant.setTitle("Partie terminee !");
                windowGagnant.show();
                
                gagnantController.setGameController(this);
                gagnantController.setWindow(windowGagnant);
                gagnantController.setGlobalWindow(window);
                gagnantController.afficher(jeux.gagnant());
                jouer = false;
            }
        }catch(PieceException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permet de gerer lorsqu'un pion est recompensable
     * @param pion le pion a recompenser
     */
    @FXML
    private void recompenserPion(Pion pion){
        try {
            FXMLLoader fenRecompensePion = new FXMLLoader(getClass().getResource("FenetreRecompensePion.fxml"));
            Scene fenetreRecompensePion = new Scene(fenRecompensePion.load());
            RecompensePionController recompensePionController = fenRecompensePion.getController();
            
            Stage windowRecompensePion = new Stage();
            windowRecompensePion.setScene(fenetreRecompensePion);
            windowRecompensePion.setTitle("Recompense Pion");
            windowRecompensePion.show();
            
            recompensePionController.setGameController(this);
            recompensePionController.setWindow(windowRecompensePion);
            recompensePionController.setPion(pion);
            recompensePionController.afficher();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permet de recompenser un pion de l'echiquier
     * @param piece le pion a recompenser
     * @param pieceRecompense le type de piece qui sera la recompense du pion
     */
    @FXML
    public void recompenserPion(Pion piece, TypePiece pieceRecompense){
        APiece recompense = null;
        
        if(pieceRecompense.equals(TypePiece.reineBlanc)){
            recompense = new Reine(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.tourBlanc)){
            recompense = new Tour(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.fouBlanc)){
            recompense = new Fou(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.cavalierBlanc)){
            recompense = new Cavalier(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.reineNoir)){
            recompense = new Reine(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.tourNoir)){
            recompense = new Tour(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.fouNoir)){
            recompense = new Fou(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.cavalierNoir)){
            recompense = new Cavalier(piece.getX(), piece.getY(), piece.getCamp());
        }
        
        try{
            Pion pion = (Pion) jeux.getPiece(piece.getX(), piece.getY());
            jeux.recompenserPion(pion, recompense);
        } catch (PieceException e) {
            e.printStackTrace();
        }
        
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + "jeux.txt")));
            ecriture.writeObject(jeux);
            ecriture.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        baseEchiquier();
        actualiserEchiquier();
    }
    
    /**
     * Permet de creer une nouvelle fenetre d'une nouvelle partie
     */
    @FXML
    private void nouvellePartie(){
        try {
            FXMLLoader fenNewPartie = new FXMLLoader(getClass().getResource("FenetreNewPartie.fxml"));
            Scene fenetreNewPartie = new Scene(fenNewPartie.load());
            NewPartieController newPartieController = fenNewPartie.getController();
            
            Stage windowNewPartie = new Stage();
            windowNewPartie.setScene(fenetreNewPartie);
            windowNewPartie.setTitle("Creer Nouvelle Partie");
            windowNewPartie.show();
            
            newPartieController.setGameController(this);
            newPartieController.setGlobalWindow(window);
            newPartieController.setWindow(windowNewPartie);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permet d'actualiser les informations de la partie : les chronos et les pieces prises par les joueurs
     */
    @FXML
    public void actualiserInfo(){
        
        for(int i=0; i<infoAdverse.getChildren().size()-1; i++){
            ((ImageView) infoAdverse.getChildren().get(i)).setImage(null) ;
        }
        for(int i=0; i<infoMoi.getChildren().size()-1; i++){
            ((ImageView) infoMoi.getChildren().get(i)).setImage(null) ;
        }
        
        if(camp.equals(Camp.blanc)){
            for(int i=0; i<jeux.getPieceBlancMorte().size(); i++){
                try{
                    APiece piece = jeux.getPieceBlancMorte().get(i);
                    if(piece instanceof Tour){
                        String chemin = "images" + File.separator + texture + File.separator + "tourBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionBlanc.jpg";
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
                        String chemin = "images" + File.separator + texture + File.separator + "tourNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionNoir.jpg";
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
                        String chemin = "images" + File.separator + texture + File.separator + "tourBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiBlanc.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoMoi.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionBlanc.jpg";
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
                        String chemin = "images" + File.separator + texture + File.separator + "tourNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Cavalier){
                        String chemin = "images" + File.separator + texture + File.separator + "cavalierNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Fou){
                        String chemin = "images" + File.separator + texture + File.separator + "fouNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Reine){
                        String chemin = "images" + File.separator + texture + File.separator + "reineNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Roi){
                        String chemin = "images" + File.separator + texture + File.separator + "roiNoir.jpg";
                        FileInputStream fichier = new FileInputStream(new File(chemin));
                        Image image = new Image(fichier);
                        ((ImageView) infoAdverse.getChildren().get(i)).setImage(image) ;
                    }
                    else if(piece instanceof Pion){
                        String chemin = "images" + File.separator + texture + File.separator + "pionNoir.jpg";
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
     * Permet de modifier l'echiquier en mettant en evidence les cases sur lesquels une piece peut se deplacer
     * @param piece la piece dont il faut afficher les deplacements
     */
    @FXML
    private void deplacementsPossibles(APiece piece){
        try{
            if(piece != null){
                if(pointVue.equals(Camp.blanc)){
                    for(int i=0; i<8; i++){
                        for(int j=0; j<8; j++){
                            if(piece.deplacementsPossibles(jeux)[i][j]){
                                ((Label)plateau.getChildren().get((i*8+j)*2 )).setBackground(new Background(new BackgroundFill(Paint.valueOf("blue"), CornerRadii.EMPTY, Insets.EMPTY)));
                            }
                        }
                    }
                }
                else{
                    int a=0;
                    int b=0;
                    for(int i=7; i>-1; i--){
                        for(int j=7; j>-1; j--){
                            if(piece.deplacementsPossibles(jeux)[i][j]){
                                ((Label)plateau.getChildren().get((a*8+b)*2 )).setBackground(new Background(new BackgroundFill(Paint.valueOf("blue"), CornerRadii.EMPTY, Insets.EMPTY)));
                            }
                            b++;
                        }
                        a++;
                        b=0;
                    }
                }
            }
        }catch(PieceException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Permet de jouer une piece de l'echiquier
     * @param piece la piece a jouer
     * @param x la ligne dans laquelle la piece va se deplacer
     * @param y la colonne dans laquelle la piece va se deplacer
     */
    @FXML
    private void jouerCoup(APiece piece, int x, int y){
        try{
            APiece pieceJouer;
            pieceJouer = jeux.getPiece(piece.getX(), piece.getY());
            jeux.deplacerPiece(pieceJouer, x, y);
            
            File file = new File("music" + File.separator + "deplacementPiece.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.loop(0);
            
            if(pieceJouer instanceof Pion){
                if( ((Pion)pieceJouer).recompensable() ){
                    recompenserPion((Pion)pieceJouer);
                }
            }
            
            jouerPiece = null;
            if(camp.equals(Camp.noir)){
                chronoNoir.Pause();
                chronoBlanc.Play();
            }
            else{
                chronoBlanc.Pause();
                chronoNoir.Play();
            }
            
            if(!dualInterface){
                if(camp.equals(Camp.blanc)){
                    setCampNoir();
                }
                else{
                    setCampBlanc();
                }
            }
        }catch(EchiquierException e){
            e.printStackTrace();
        } catch (PieceException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + "jeux.txt")));
            ecriture.writeObject(jeux);
            ecriture.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        baseEchiquier();
        actualiserEchiquier();
    }
    
    /**
     * Gere lorsque l'on clique sur une case, si aucune piece n'a encore ete selectionne alors en selectionne une et affiche ses deplacements, sinon si c'est possible deplace la piece selectionne
     * @param x la ligne dont on a selectionne la case
     * @param y la colonne dont on a selectionne la case
     */
    @FXML
    private void clickCase(int x, int y){
        if(pointVue.equals(Camp.noir)){
            x = 7-x;
            y = 7-y;
        }
        try{
            if(jouerPiece == null){
                if(jeux.getPiece(x, y) != null){
                    if(jeux.getTour()%2 == 0 && jeux.getPiece(x, y).getCamp().equals(Camp.noir) && camp.equals(Camp.noir)){
                        jouerPiece = jeux.getPiece(x, y);
                    }
                    else if(jeux.getTour()%2!=0 && jeux.getPiece(x, y).getCamp().equals(Camp.blanc) && camp.equals(Camp.blanc)){
                        jouerPiece = jeux.getPiece(x, y);
                    }
                }
                else{
                    jouerPiece = null;
                }

                if(jouerPiece != null){
                    deplacementsPossibles(jouerPiece);
                }
            }
            else{
                if(jouerPiece.deplacementsPossibles(jeux)[x][y]){
                    jouerCoup(jouerPiece, x, y);
                }
                else{
                    baseEchiquier();
                    if(jeux.getPiece(x, y) != null){
                        if(jeux.getTour()%2 == 0 && jeux.getPiece(x, y).getCamp().equals(Camp.noir)){
                            jouerPiece = jeux.getPiece(x, y);
                        }
                        else if(jeux.getTour()%2!=0 && jeux.getPiece(x, y).getCamp().equals(Camp.blanc)){
                            jouerPiece = jeux.getPiece(x, y);
                        }
                    }
                    else{
                        jouerPiece = null;
                    }
                    if(jouerPiece != null){
                        deplacementsPossibles(jouerPiece);
                    }
                }
            }
        }catch(PieceException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case1
     */
    @FXML
    private void clickCase1(){
        int x = (int)case1.getX();
        int y = (int)case1.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case2
     */
    @FXML
    private void clickCase2(){
        int x = (int)case2.getX();
        int y = (int)case2.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case3
     */
    @FXML
    private void clickCase3(){
        int x = (int)case3.getX();
        int y = (int)case3.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case4
     */
    @FXML
    private void clickCase4(){
        int x = (int)case4.getX();
        int y = (int)case4.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case5
     */
    @FXML
    private void clickCase5(){
        int x = (int)case5.getX();
        int y = (int)case5.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case6
     */
    @FXML
    private void clickCase6(){
        int x = (int)case6.getX();
        int y = (int)case6.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case7
     */
    @FXML
    private void clickCase7(){
        int x = (int)case7.getX();
        int y = (int)case7.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case8
     */
    @FXML
    private void clickCase8(){
        int x = (int)case8.getX();
        int y = (int)case8.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case9
     */
    @FXML
    private void clickCase9(){
        int x = (int)case9.getX();
        int y = (int)case9.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case10
     */
    @FXML
    private void clickCase10(){
        int x = (int)case10.getX();
        int y = (int)case10.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case11
     */
    @FXML
    private void clickCase11(){
        int x = (int)case11.getX();
        int y = (int)case11.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case12
     */
    @FXML
    private void clickCase12(){
        int x = (int)case12.getX();
        int y = (int)case12.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case13
     */
    @FXML
    private void clickCase13(){
        int x = (int)case13.getX();
        int y = (int)case13.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case14
     */
    @FXML
    private void clickCase14(){
        int x = (int)case14.getX();
        int y = (int)case14.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case15
     */
    @FXML
    private void clickCase15(){
        int x = (int)case15.getX();
        int y = (int)case15.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case16
     */
    @FXML
    private void clickCase16(){
        int x = (int)case16.getX();
        int y = (int)case16.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case17
     */
    @FXML
    private void clickCase17(){
        int x = (int)case17.getX();
        int y = (int)case17.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case18
     */
    @FXML
    private void clickCase18(){
        int x = (int)case18.getX();
        int y = (int)case18.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case19
     */
    @FXML
    private void clickCase19(){
        int x = (int)case19.getX();
        int y = (int)case19.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case20
     */
    @FXML
    private void clickCase20(){
        int x = (int)case20.getX();
        int y = (int)case20.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case21
     */
    @FXML
    private void clickCase21(){
        int x = (int)case21.getX();
        int y = (int)case21.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case22
     */
    @FXML
    private void clickCase22(){
        int x = (int)case22.getX();
        int y = (int)case22.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case23
     */
    @FXML
    private void clickCase23(){
        int x = (int)case23.getX();
        int y = (int)case23.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case24
     */
    @FXML
    private void clickCase24(){
        int x = (int)case24.getX();
        int y = (int)case24.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case25
     */
    @FXML
    private void clickCase25(){
        int x = (int)case25.getX();
        int y = (int)case25.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case26
     */
    @FXML
    private void clickCase26(){
        int x = (int)case26.getX();
        int y = (int)case26.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case27
     */
    @FXML
    private void clickCase27(){
        int x = (int)case27.getX();
        int y = (int)case27.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case28
     */
    @FXML
    private void clickCase28(){
        int x = (int)case28.getX();
        int y = (int)case28.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case29
     */
    @FXML
    private void clickCase29(){
        int x = (int)case29.getX();
        int y = (int)case29.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case30
     */
    @FXML
    private void clickCase30(){
        int x = (int)case30.getX();
        int y = (int)case30.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case31
     */
    @FXML
    private void clickCase31(){
        int x = (int)case31.getX();
        int y = (int)case31.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case32
     */
    @FXML
    private void clickCase32(){
        int x = (int)case32.getX();
        int y = (int)case32.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case33
     */
    @FXML
    private void clickCase33(){
        int x = (int)case33.getX();
        int y = (int)case33.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case34
     */
    @FXML
    private void clickCase34(){
        int x = (int)case34.getX();
        int y = (int)case34.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case35
     */
    @FXML
    private void clickCase35(){
        int x = (int)case35.getX();
        int y = (int)case35.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case36
     */
    @FXML
    private void clickCase36(){
        int x = (int)case36.getX();
        int y = (int)case36.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case37
     */
    @FXML
    private void clickCase37(){
        int x = (int)case37.getX();
        int y = (int)case37.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case38
     */
    @FXML
    private void clickCase38(){
        int x = (int)case38.getX();
        int y = (int)case38.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case39
     */
    @FXML
    private void clickCase39(){
        int x = (int)case39.getX();
        int y = (int)case39.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case40
     */
    @FXML
    private void clickCase40(){
        int x = (int)case40.getX();
        int y = (int)case40.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case41
     */
    @FXML
    private void clickCase41(){
        int x = (int)case41.getX();
        int y = (int)case41.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case42
     */
    @FXML
    private void clickCase42(){
        int x = (int)case42.getX();
        int y = (int)case42.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case43
     */
    @FXML
    private void clickCase43(){
        int x = (int)case43.getX();
        int y = (int)case43.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case44
     */
    @FXML
    private void clickCase44(){
        int x = (int)case44.getX();
        int y = (int)case44.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case45
     */
    @FXML
    private void clickCase45(){
        int x = (int)case45.getX();
        int y = (int)case45.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case46
     */
    @FXML
    private void clickCase46(){
        int x = (int)case46.getX();
        int y = (int)case46.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case47
     */
    @FXML
    private void clickCase47(){
        int x = (int)case47.getX();
        int y = (int)case47.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case48
     */
    @FXML
    private void clickCase48(){
        int x = (int)case48.getX();
        int y = (int)case48.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case49
     */
    @FXML
    private void clickCase49(){
        int x = (int)case49.getX();
        int y = (int)case49.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case50
     */
    @FXML
    private void clickCase50(){
        int x = (int)case50.getX();
        int y = (int)case50.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case51
     */
    @FXML
    private void clickCase51(){
        int x = (int)case51.getX();
        int y = (int)case51.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case52
     */
    @FXML
    private void clickCase52(){
        int x = (int)case52.getX();
        int y = (int)case52.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case53
     */
    @FXML
    private void clickCase53(){
        int x = (int)case53.getX();
        int y = (int)case53.getY();
        
        clickCase(x, y);
    }

    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case54
     */
    @FXML
    private void clickCase54(){
        int x = (int)case54.getX();
        int y = (int)case54.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case55
     */
    @FXML
    private void clickCase55(){
        int x = (int)case55.getX();
        int y = (int)case55.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case56
     */
    @FXML
    private void clickCase56(){
        int x = (int)case56.getX();
        int y = (int)case56.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case57
     */
    @FXML
    private void clickCase57(){
        int x = (int)case57.getX();
        int y = (int)case57.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case58
     */
    @FXML
    private void clickCase58(){
        int x = (int)case58.getX();
        int y = (int)case58.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case59
     */
    @FXML
    private void clickCase59(){
        int x = (int)case59.getX();
        int y = (int)case59.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case60
     */
    @FXML
    private void clickCase60(){
        int x = (int)case60.getX();
        int y = (int)case60.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case61
     */
    @FXML
    private void clickCase61(){
        int x = (int)case61.getX();
        int y = (int)case61.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case62
     */
    @FXML
    private void clickCase62(){
        int x = (int)case62.getX();
        int y = (int)case62.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case63
     */
    @FXML
    private void clickCase63(){
        int x = (int)case63.getX();
        int y = (int)case63.getY();
        
        clickCase(x, y);
    }
    
    /**
     * Appelle la fonction clickCase en lui donnant les coordonnes de la case64
     */
    @FXML
    private void clickCase64(){
        int x = (int)case64.getX();
        int y = (int)case64.getY();
        
        clickCase(x, y);
    }

}
