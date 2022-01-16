package swing;
import regle.*;
import piece.*;
import javax.swing.*;
import java.util.Timer;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * Classe qui permet la gestion des infos de partie.
 * Elle etend JPanel
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class JPanelInfoPartie extends JPanel{
    /**
     * Le gestionnaire de l'echiquier
     */
    private JPanelEchiquier echiquier;
    /**
     * Les infos de l'adversaire
     */
    private JPanel adversaire;
    /**
     * Les infos du joueur
     */
    private JPanel moi;
    /**
     * Le chrono adverse
     */
    private CustomTimer timerAdversaire;
    /**
     * Le chrono du joueur
     */
    private CustomTimer timerMoi;
    /**
     * L'affichage du chrono adverse
     */
    private JLabel decompteAdversaire;
    /**
     * L'affichage du chrono du joueur
     */
    private JLabel decompteMoi;

    /**
     * Constructeur par initialisation des infos de la partie
     * @param echiquier Le gestionnaire de l'echiquier
     * @param timerBlanc le chrono Blanc
     * @param timerNoir le chrono Noir
     */
    public JPanelInfoPartie(JPanelEchiquier echiquier, CustomTimer timerBlanc, CustomTimer timerNoir){
        super();

        setLayout(new BorderLayout());

        this.echiquier = echiquier;
        this.timerAdversaire = timerNoir;
        this.timerMoi = timerBlanc;
        JPanel infoPieces = new JPanel();
        infoPieces.setLayout(new GridLayout(4, 1));

        adversaire = new JPanel();
        adversaire.setLayout(new GridLayout(2, 8));
        moi = new JPanel();
        moi.setLayout(new GridLayout(2, 8));

        for(int i=0; i<16; i++){
            Case ajout = new Case(0, 0, TypePiece.aucun);
            adversaire.add(ajout);
        }
        for(int i=0; i<16; i++){
            Case ajout = new Case(0, 0, TypePiece.aucun);
            moi.add(ajout);
        }

        JLabel text1 = new JLabel("Adversaire");
        text1.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel text2 = new JLabel("Moi");
        text2.setHorizontalAlignment(JLabel.CENTER);

        infoPieces.add(text1);
        infoPieces.add(adversaire);
        infoPieces.add(text2);
        infoPieces.add(moi);

        JPanel chrono = new JPanel();
        chrono.setLayout(new GridLayout(4, 1));
        JLabel text1Copie = new JLabel("Adversaire");
        text1Copie.setHorizontalAlignment(JLabel.CENTER);
        JLabel text2Copie = new JLabel("Moi");
        text2Copie.setHorizontalAlignment(JLabel.CENTER);

        // Initialisation des chronos
        Timer chronoAdversaire = new Timer();
        chronoAdversaire.schedule(timerAdversaire, 0, 1000);
        Timer chronoMoi = new Timer();
        chronoMoi.schedule(timerMoi, 0, 1000);

        //Mise en place des chronos dans des JLabel
        decompteAdversaire = new JLabel(timerAdversaire.getTime());
        decompteAdversaire.setHorizontalAlignment(JLabel.CENTER);
        decompteMoi = new JLabel(timerMoi.getTime());
        decompteMoi.setHorizontalAlignment(JLabel.CENTER);

        //Modification de la police des JLabel des chronos
        Font police = new Font("Arial", Font.BOLD, 30);
        decompteAdversaire.setFont(police);
        decompteMoi.setFont(police);
        
        chrono.add(text1Copie);
        chrono.add(decompteAdversaire);
        chrono.add(text2Copie);
        chrono.add(decompteMoi);

        JSplitPane panel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, chrono, infoPieces);
        panel.setResizeWeight( 0.1 );

        add(panel);
        
        setVisible(true);
    }

    /**
     * retourne les informations des pieces prises par l'adversaire
     * @return les informations des pieces prises par l'adversaire
     */
    public JPanel getPieceAdversaire(){
        return adversaire;
    }

    /**
     * retourne les informations des pieces prises par le joueur
     * @return les informations des pieces prises par le joueur
     */
    public JPanel getPieceMoi(){
        return moi;
    }

    /**
     * Actualise les infos de la partie
     */
    public void actualiser(){
        for(int i=0; i<16; i++){
            ((Case)adversaire.getComponent(i)).setEtat(TypePiece.aucun);
            ((Case)moi.getComponent(i)).setEtat(TypePiece.aucun);
        }

        if(echiquier.getCamp().equals(Camp.blanc) ){

            for(int i=0; i<echiquier.getJeux().getPieceBlancMorte().size(); i++){
                APiece piece = echiquier.getJeux().getPieceBlancMorte().get(i);
                if(piece instanceof Tour){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.tourBlanc);
                }
                else if(piece instanceof Fou){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.fouBlanc);
                }
                else if(piece instanceof Cavalier){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.cavalierBlanc);
                }
                else if(piece instanceof Pion){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.pionBlanc);
                }
                else if(piece instanceof Reine){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.reineBlanc);
                }
                else{
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.aucun);
                }
            }

            for(int i=0; i<echiquier.getJeux().getPieceNoireMorte().size(); i++){
                APiece piece = echiquier.getJeux().getPieceNoireMorte().get(i);
                if(piece instanceof Tour){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.tourNoir);
                }
                else if(piece instanceof Fou){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.fouNoir);
                }
                else if(piece instanceof Cavalier){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.cavalierNoir);
                }
                else if(piece instanceof Pion){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.pionNoir);
                }
                else if(piece instanceof Reine){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.reineNoir);
                }
                else{
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.aucun);
                }
            }
        }else{
            for(int i=0; i<echiquier.getJeux().getPieceBlancMorte().size(); i++){
                APiece piece = echiquier.getJeux().getPieceBlancMorte().get(i);
                if(piece instanceof Tour){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.tourBlanc);
                }
                else if(piece instanceof Fou){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.fouBlanc);
                }
                else if(piece instanceof Cavalier){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.cavalierBlanc);
                }
                else if(piece instanceof Pion){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.pionBlanc);
                }
                else if(piece instanceof Reine){
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.reineBlanc);
                }
                else{
                    ((Case)moi.getComponent(i)).setEtat(TypePiece.aucun);
                }
            }

            for(int i=0; i<echiquier.getJeux().getPieceNoireMorte().size(); i++){
                APiece piece = echiquier.getJeux().getPieceNoireMorte().get(i);
                if(piece instanceof Tour){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.tourNoir);
                }
                else if(piece instanceof Fou){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.fouNoir);
                }
                else if(piece instanceof Cavalier){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.cavalierNoir);
                }
                else if(piece instanceof Pion){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.pionNoir);
                }
                else if(piece instanceof Reine){
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.reineNoir);
                }
                else{
                    ((Case)adversaire.getComponent(i)).setEtat(TypePiece.aucun);
                }
            }
        }

        actualiserTime();
    }

    /**
     * Change la valeur initial des chrono et les restart
     * @param time le nouveau temps des chronos
     * @see CustomTimer
     */
    public void modifierChrono(int time){
        timerAdversaire.setTimeBase(time);
        timerAdversaire.Restart();
        timerMoi.setTimeBase(time);
        timerMoi.Restart();
    }

    /**
     * Permet d'afficher le temps des chronos et de le modifier
     */
    public void actualiserTime(){
        ObjectInputStream lectureChronoNoir;
        ObjectInputStream lectureChronoBlanc;
        CustomTimer chronoNoir = null;
        CustomTimer chronoBlanc = null;
        try{
            File fichierChronoBlanc = new File("game" + File.separator + "chronoBlanc.txt");
            File fichierChronoNoir = new File("game" + File.separator + "chronoNoir.txt");

            if(fichierChronoBlanc.exists() && fichierChronoNoir.exists()){
                lectureChronoNoir = new ObjectInputStream(
                    new FileInputStream(
                        fichierChronoNoir));
                    
                chronoNoir = (CustomTimer) lectureChronoNoir.readObject();

                lectureChronoBlanc = new ObjectInputStream(
                    new FileInputStream(
                        fichierChronoBlanc));
                    
                chronoBlanc = (CustomTimer) lectureChronoBlanc.readObject();
                
                if(echiquier.getCamp().equals(Camp.blanc)){
                    decompteAdversaire.setText(chronoNoir.getTime());
                    decompteMoi.setText(chronoBlanc.getTime());
                }
                else{
                    decompteAdversaire.setText(chronoBlanc.getTime());
                    decompteMoi.setText(chronoNoir.getTime());
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
     * Reinitialise les infos de partie a leur etat initial
     */
    public void restart(){
        for(int i=0; i<16; i++){
            ((Case)adversaire.getComponent(i)).setEtat(TypePiece.aucun);
            ((Case)moi.getComponent(i)).setEtat(TypePiece.aucun);
        }
        timerAdversaire.Restart();
        timerMoi.Restart();
    }
}
