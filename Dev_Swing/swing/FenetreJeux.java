package swing;
import regle.*;
import piece.*;
import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Classe qui permet de gerer une fenetre de jeux
 * Elle etend JFrame
 * @author Pierer CHEMIN
 * @version 1.0
 */
public class FenetreJeux extends JFrame{
    /**
     * L'affichage de l'echiquier
     */
    private JPanelEchiquier echiquier;
    /**
     * L'affichage des informations de la partie
     */
    private JPanelInfoPartie infoPartie;
    /**
     * Le gestionnaire des regles du jeux qui permet 
     */
    private Echiquier jeux;
    /**
     * Le camp dans lequel on joue
     */
    private Camp camp;

    /**
     * Constructeur par defaut d'une fenetre de jeux
     * Cree les chronos des deux camps, l'echiquier, le gestionnaire des regles, les infos de partie.
     * Cree egalement une tache de fond pour actualiser les chronos et l'etat du jeux
     * @see Echiquier
     * @see CustomTimer
     * @see JPanelEchiquier
     * @see JPanelInfoPartie
     */
    public FenetreJeux(){
        super();

        camp = Camp.blanc;
        jeux = new Echiquier();
        JPanel panel = new JPanel();
        CustomTimer chronoNoir = new CustomTimer(300, "chronoNoir");
        CustomTimer chronoBlanc = new CustomTimer(300, "chronoBlanc");
        echiquier = new JPanelEchiquier(this, jeux, camp, chronoBlanc, chronoNoir);
        infoPartie = new JPanelInfoPartie(echiquier, chronoBlanc, chronoNoir);

        JMenuBar menu = new JMenuBar();
        JMenu partie = new JMenu("Partie");
            JMenuItem nouvelle = new JMenuItem("Nouvelle partie");
                nouvelle.addActionListener(e -> new FenetreNewPartie(this));

            JMenuItem restart = new JMenuItem("Restart");
                restart.addActionListener( ev -> {echiquier.restart(); infoPartie.restart();} );

            partie.add(nouvelle);
            partie.add(restart);
        
        JMenu personnalisation = new JMenu("Personnalisation");
            JMenuItem nouvelleTexture = new JMenuItem("Actualiser les packs de Texture");
            JMenu packTexture = new JMenu("Packs de Texture");
                actualiserPackTexture(packTexture);
            
            nouvelleTexture.addActionListener(e -> actualiserPackTexture(packTexture));
            
            personnalisation.add(nouvelleTexture);
            personnalisation.add(packTexture);

        JMenu option = new JMenu("Option");
            JMenu camp = new JMenu("Modifier le point de vue");
                JMenuItem blanc = new JMenuItem("Camp pieces blanches");
                blanc.addActionListener(e -> echiquier.setPointVue(Camp.blanc));
                JMenuItem noir = new JMenuItem("Camp pieces noires");
                noir.addActionListener(e -> echiquier.setPointVue(Camp.noir));
            camp.add(blanc);
            camp.add(noir);
            JMenu camp2 = new JMenu("Changer de camp");
                JMenuItem blanc2 = new JMenuItem("Blanc");
                blanc2.addActionListener(e -> echiquier.setCamp(Camp.blanc));
                JMenuItem noir2 = new JMenuItem("Noir");
                noir2.addActionListener(e -> echiquier.setCamp(Camp.noir));
            camp2.add(blanc2);
            camp2.add(noir2);
            
        option.add(camp);
        option.add(camp2);

        menu.add(partie);
        menu.add(option);
        menu.add(personnalisation);
        menu.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.setLayout(new BorderLayout());
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, echiquier, infoPartie);
        jsp.setResizeWeight( 0.8 );
        panel.add(jsp);

        getContentPane().add(panel);
        
        String chemin = "images" + File.separator + "basique" + File.separator + "pionNoir.png";
        File fichier = new File(chemin);
        BufferedImage buffer;
        if(!fichier.exists()){
            new FenetreErreur("Le fichier n'existe pas : " + chemin);
        }

        try{
            buffer = ImageIO.read(fichier);
            setIconImage(buffer);
        }catch(IOException ex){
            new FenetreErreur("Erreur acces fichier");
        }
        setJMenuBar(menu);
        
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setTitle("Echecs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Timer actualisation = new Timer();
        actualisation.schedule(new TimerTask(){

            @Override
            public void run() {
                if(echiquier.getJouer()){
                    echiquier.actualiserJeux();
                    infoPartie.actualiser();
                    echiquier.actualiserEchiquier();
                    echiquier.gagner();
                }
            }
            
        }, 0, 500);
    }

    /**
     * Permet de modifier le camp dans lequel on jouer
     * @param camp le camp dans lequel on joue
     */
    public void setCamp(Camp camp){
        this.camp = camp;
        echiquier.setCamp(this.camp);
    }

    /**
     * Permet de recuperer la gestion d'un echiquier
     * @return le JPanelEchiquier qui gere l'affichage de l'echiquier
     * @see JPanelEchiquier
     */
    public JPanelEchiquier getEchiquier(){
        return echiquier;
    }

    /**
     * Permet de recuperer la gestion des infos de partie
     * @return le JPanelInfoPartie qui gere l'affichage des infos de la partie
     * @see JPanelInfoPartie
     */
    public JPanelInfoPartie getInfoPartie(){
        return infoPartie;
    }

    /**
     * Permet de modifier le menu deroulant contenant la liste des packs de texture
     * @param packTexture le menu des packs de texture
     */
    public void actualiserPackTexture(JMenu packTexture){
        String ligne;
        packTexture.removeAll();
        try {
            BufferedReader listePack = new BufferedReader(new FileReader("images"+File.separator+"ListePack.txt"));
            while ((ligne = listePack.readLine()) != null) {
                JMenuItem pack = new JMenuItem(ligne);
                packTexture.add(pack);
                pack.addActionListener(ev -> {
                    for(int i=0; i<64; i++){
                        ((Case)echiquier.getComponent(i)).setResourcePack(pack.getText());
                    }
                    for(int i=0; i<16; i++){
                        ((Case)infoPartie.getPieceAdversaire().getComponent(i)).setResourcePack(pack.getText());
                    }
                    for(int i=0; i<16; i++){
                        ((Case)infoPartie.getPieceMoi().getComponent(i)).setResourcePack(pack.getText());
                    }
                    echiquier.actualiserEchiquier();
                    infoPartie.actualiser();
                });
            }
            listePack.close();
        }catch (FileNotFoundException e) {
            new FenetreErreur(this, e.toString());
        }catch (IOException e) {
            new FenetreErreur(this, e.toString());
        }
    }
}
