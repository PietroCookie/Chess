package swing;
import regle.*;
import piece.*;
import exceptions.*;

import javax.swing.*;
import javax.sound.sampled.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe permettant la gestion de l'échiquier dans la fenetre de jeux.
 * Cette classe etend JPanel.
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class JPanelEchiquier extends JPanel{
    /**
     * La fenetre de jeux contenant le JPanelEchiquier
     */
    private FenetreJeux windowsJeux;
    /**
     * Le Gestionnaire d'un echiquier, gère une partie d'échec
     */
    private Echiquier jeux;
    /**
     * désigne cet objet
     */
    private JPanel echiquier;
    /**
     * Le point de vue depuis lequel on voit le jeux
     */
    private Camp pointVue;
    /**
     * Le camp dans lequel on joue
     */
    private Camp camp;
    /**
     * Le gestionnaire du chrono Blanc
     */
    private CustomTimer chronoBlanc;
    /**
     * Le gestionnaire du chrono Noir
     */
    private CustomTimer chronoNoir;
    /**
     * Permet de savoir si la partie est en cours ou non
     */
    private boolean jouer;
    /**
     * Permet de savoir si on joue sur plusieurs interfaces ou non
     */
    private boolean dualInterface;


    /**
     * Constructeur par initialisation d'un JPanelEchiquier
     * @param windows la fenetre qui va contenir le JPanelEchiquier
     * @param jeux Le gestionnaire des règles du jeux
     * @param camp Le camp dans lequel on joue
     * @param chronoBlanc Le gestionaires du chrono Blanc
     * @param chronoNoir Le gestionnaire du chrono Noir
     */
    public JPanelEchiquier(FenetreJeux windows, Echiquier jeux, Camp camp, CustomTimer chronoBlanc, CustomTimer chronoNoir){
        super();
        
        this.pointVue = Camp.blanc;
        this.camp = camp;
        this.chronoBlanc = chronoBlanc;
        this.chronoNoir = chronoNoir;
        this.jouer = true;
        this.windowsJeux = windows;
        this.dualInterface = true;
        setLayout(new GridLayout(8, 8));
        
        this.jeux = jeux;

        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + "jeux.txt")));
            ecriture.writeObject(jeux);
            ecriture.close();
        } catch (IOException e) {
            messageErreur(e.toString() + "\n Erreur d'ecriture dand le fichier de jeux");
        }

        ClicSouris clic = new ClicSouris();
        int x=0;
        int y=0;
        while(x<8){
            Case ajout = new Case(x, y, TypePiece.aucun);
            ajout.addMouseListener(clic);
            this.add(ajout);
            y++;
            if(y==8){
                y=0;
                x++;
            }
        }
        
        baseEchiquier();

        actualiserEchiquier();
        setVisible(true);
        echiquier = this;

    }

    /**
     * Permet de récupérer le gestionnaire des règles du jeux
     * @return Le gestionnaire des règles du jeux
     */
    public Echiquier getJeux(){
        return jeux;
    }

    /**
     * Permet de savoir si la partie est en cours ou non
     * @return Vrai si la partie est en cours, Faus sinon
     */
    public boolean getJouer(){
        return jouer;
    }

    /**
     * Permet de connaitre le point de vue depuis lequel on regarde le jeux
     * @return Le Camp du point de vue
     * @see Camp
     */
    public Camp getPointVue(){
        return pointVue;
    }

    /**
     * Permet de connaitre le camp dans lequel on joue
     * @return Le camp dans lequel on joue
     * @see Camp
     */
    public Camp getCamp(){
        return camp;
    }

    /**
     * Permet de modifier le camp dans lequel on joue.
     * Change egalement le point de vue. 
     * @param camp Le camp dans lequel on joue
     * @see Camp
     */
    public void setCamp(Camp camp){
        this.camp = camp;
        setPointVue(camp);
    }

    /**
     * Permet de modifier si on joue sur une ou plusieurs interfaces
     * @param dualInterface Vrai si on veut jouer sur plusieurs interfaces, Faux sinon
     */
    public void setDualInterface(Boolean dualInterface){
        this.dualInterface = dualInterface;
    }

    /**
     * Permet de savoir si quelqu'un a gagné la partie.
     * Si une erreur survient dans la recuperation du gagnant du gestionnaire des regles cree une fenetre d'erreur
     * @return Le gagnant du jeux
     * @see Echiquier
     * @see FenetreErreur
     */
    public Vainqueur gagnant(){
        Vainqueur retour = Vainqueur.aucun;

        try{
            retour = jeux.gagnant();
        }catch(PieceException e){
            messageErreur(e.toString());
        }

        return retour;
    }

    /**
     * Permet de modifier le point de vue depuis lequel on regarde le jeux.
     * Une fois le point de vue change, appelle la fonction baseEchiquier et actualiserEchiquier
     * @param camp Le camp depuis lequel on regarde le jeux
     * @see Camp
     */
    public void setPointVue(Camp camp){
        pointVue = camp;
        
        if(pointVue.equals(Camp.blanc)){
            int i=0;
            for(int x=0; x<8; x++){
                for(int y=0; y<8; y++){
                    ((Case)this.getComponent(i)).setX(x);
                    ((Case)this.getComponent(i)).setY(y);
                    i++;
                }
            }
        }
        else{
            int i=0;
            for(int x=7; x>-1; x--){
                for(int y=7; y>-1; y--){
                    ((Case)this.getComponent(i)).setX(x);
                    ((Case)this.getComponent(i)).setY(y);
                    i++;
                }
            }
        }
        
        baseEchiquier();
        actualiserEchiquier();
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
            messageErreur(e.toString());
        }catch(IOException e){
            messageErreur(e.toString() + "\nErreur dans la lecture du fichier du jeux");
        }
    }

    /**
     * Actualise l'echiquier, change les images des cases pour qu'elles correspondent aux pieces qui y sont dans le jeux.
     */
    public void actualiserEchiquier(){
        int x=0;
        int y=0;
        int i=0;

        if(pointVue.equals(Camp.blanc)){
            while(x<8 && i<64){
                if(!jeux.estLibre(x, y)){
                    try{
                        APiece piece = jeux.getPiece(x, y);
                        if(piece.getCamp().equals(Camp.blanc)){
                            if(piece instanceof Tour){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.tourBlanc);
                            }
                            else if(piece instanceof Fou){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.fouBlanc);
                            }
                            else if(piece instanceof Cavalier){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.cavalierBlanc);
                            }
                            else if(piece instanceof Pion){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.pionBlanc);
                            }
                            else if(piece instanceof Reine){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.reineBlanc);
                            }
                            else if(piece instanceof Roi){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.roiBlanc);
                                if(((Roi)piece).getEchec()){
                                    ((Case)this.getComponent(i)).setBackground(Color.RED);
                                }
                            }
                        }
                        else{
                            if(piece instanceof Tour){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.tourNoir);
                            }
                            else if(piece instanceof Fou){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.fouNoir);
                            }
                            else if(piece instanceof Cavalier){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.cavalierNoir);
                            }
                            else if(piece instanceof Pion){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.pionNoir);
                            }
                            else if(piece instanceof Reine){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.reineNoir);
                            }
                            else if(piece instanceof Roi){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.roiNoir);
                                if(((Roi)piece).getEchec()){
                                    ((Case)this.getComponent(i)).setBackground(Color.RED);
                                }
                            }
                        }
                            
                    }
                    catch(PieceException ev){
                        messageErreur(ev.toString());
                    }
                    
                }
                else{
                    ((Case)this.getComponent(i)).setEtat(TypePiece.aucun);
                }
                i++;
                y++;
                if(y==8){
                    y=0;
                    x++;
                }
            }
        }
        else{
            x=7;
            y=7;
            while(x>-1 && i<64){
                if(!jeux.estLibre(x, y)){
                    try{
                        APiece piece = jeux.getPiece(x, y);
                        if(piece.getCamp().equals(Camp.blanc)){
                            if(piece instanceof Tour){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.tourBlanc);
                            }
                            else if(piece instanceof Fou){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.fouBlanc);
                            }
                            else if(piece instanceof Cavalier){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.cavalierBlanc);
                            }
                            else if(piece instanceof Pion){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.pionBlanc);
                            }
                            else if(piece instanceof Reine){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.reineBlanc);
                            }
                            else if(piece instanceof Roi){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.roiBlanc);
                                if(((Roi)piece).getEchec()){
                                    ((Case)this.getComponent(i)).setBackground(Color.RED);
                                }
                            }
                        }
                        else{
                            if(piece instanceof Tour){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.tourNoir);
                            }
                            else if(piece instanceof Fou){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.fouNoir);
                            }
                            else if(piece instanceof Cavalier){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.cavalierNoir);
                            }
                            else if(piece instanceof Pion){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.pionNoir);
                            }
                            else if(piece instanceof Reine){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.reineNoir);
                            }
                            else if(piece instanceof Roi){
                                ((Case)this.getComponent(i)).setEtat(TypePiece.roiNoir);
                                if(((Roi)piece).getEchec()){
                                    ((Case)this.getComponent(i)).setBackground(Color.RED);
                                }
                            }
                        }
                            
                    }
                    catch(PieceException ev){
                        messageErreur(ev.toString());
                    }
                    
                }
                else{
                    ((Case)this.getComponent(i)).setEtat(TypePiece.aucun);
                }
                i++;
                y--;
                if(y==-1){
                    y=7;
                    x--;
                }
            }
        }
    }

    /**
     * Permet de mettre la bonne couleur sur chaque case, cree l'alternance gris/blanc
     */
    public void baseEchiquier(){
        for(int i=1; i<64; i+=2){
            if(i==16 || i==32 || i==48){
                i++;
            }
            ((Case)this.getComponent(i)).setBackground(Color.GRAY);
            if(i==7 || i==23 || i==39 || i==55){
                i--;
            }
        }
        for(int i=0; i<64; i++){
            if(!((Case)this.getComponent(i)).getBackground().equals(Color.GRAY)){
                ((Case)this.getComponent(i)).setBackground(Color.WHITE);
            }
        }
    }

    /**
     * Permet de redemarrer une partie, remet le jeux a son ete de base, appelle la fonction baseEchiquier et actualiseEchiquier
     * @see Echiquier
     * @see CustomTimer
     */
    public void restart(){
        jeux.restart();
        jouer = true;
        chronoBlanc.Restart();
        chronoNoir.Restart();
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + "jeux.txt")));
            ecriture.writeObject(jeux);
            ecriture.close();
        } catch (IOException e) {
            messageErreur(e.toString() + "\nErreur dans l'ecriture du fichier du jeux");
        }
        if(!dualInterface){
            setCamp(Camp.blanc);
        }
        baseEchiquier();
        actualiserEchiquier();
    }

    /**
     * Gere lorsqu'un joueur gagne la partie. Cree la fenetre de fin de partie lorsque la partie est termine
     * @see FenetreFinPartie
     */
    public void gagner(){
        try{
            if(!jeux.gagnant().equals(Vainqueur.aucun)){
                new FenetreFinPartie(this, jeux.gagnant());
                jouer = false;
            }
            else if(chronoBlanc.getDecompte() <= 0){
                try{
                    File file = new File("music" + File.separator +  "sonnerie.wav");
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException ev) {
                    ev.printStackTrace();
                } catch (LineUnavailableException ev) {
                    ev.printStackTrace();
                } catch(IOException ev){
                    ev.printStackTrace();
                }
                new FenetreFinPartie(this, Vainqueur.noir);
                jouer = false;
            }
            else if(chronoNoir.getDecompte() <= 0){
                try{
                    File file = new File("music" + File.separator + "sonnerie.wav");
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException ev) {
                    ev.printStackTrace();
                } catch (LineUnavailableException ev) {
                    ev.printStackTrace();
                } catch(IOException ev){
                    ev.printStackTrace();
                }
                new FenetreFinPartie(this, Vainqueur.blanc);
                jouer = false;
            }
        }catch(PieceException ev){
            messageErreur(ev.toString());
        }
    }

    /***
     * Si un pion est recompensable (il a atteint l'autre cote du plateau) cree une fenetre pour savoir avec qu'elle piece on va le recompenser
     * @param piece Le pion a recompenser
     * @see Pion
     * @see FenetreRecompensePion
     */
    public void recompenserPion(Pion piece){
        new FenetreRecompensePion(piece, this);
    }

    /**
     * Permet de recompenser un pion
     * @param piece le pion a recompenser
     * @param pieceRecompense le type de piece en laquelle va se transformer le pion
     */
    public void recompenserPion(Pion piece, TypePiece pieceRecompense){
        APiece recompense = null;

        if(pieceRecompense.equals(TypePiece.tourBlanc)){
            recompense = new Tour(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.cavalierBlanc)){
            recompense = new Cavalier(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.fouBlanc)){
            recompense = new Fou(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.reineBlanc)){
            recompense = new Reine(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.tourNoir)){
            recompense = new Tour(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.cavalierNoir)){
            recompense = new Cavalier(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.fouNoir)){
            recompense = new Fou(piece.getX(), piece.getY(), piece.getCamp());
        }
        else if(pieceRecompense.equals(TypePiece.reineNoir)){
            recompense = new Reine(piece.getX(), piece.getY(), piece.getCamp());
        }

        try {
            Pion pion = (Pion)jeux.getPiece(piece.getX(), piece.getY());
            jeux.recompenserPion(pion, recompense);
        } catch (PieceException e) {
            messageErreur(e.toString());
        }

        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + "jeux.txt")));
            ecriture.writeObject(jeux);
            ecriture.close();
        } catch (IOException ev) {
        messageErreur(ev.toString() + "\nErreur dans l'ecriture du fichier du jeux");
        }

        baseEchiquier();
        actualiserEchiquier();
    } 

    /**
     * Cree une nouvelle Fenetre d'erreur avec un message personnalise
     * @param message le message a afficher dans la fenetre d'erreur
     * @see FenetreErreur
     */
    public void messageErreur(String message){
        new FenetreErreur(windowsJeux, message);
    }

    /**
     * Classe anonyme permettant la gestion de la souris sur le JPanel et les cases.
     */
    class ClicSouris implements java.awt.event.MouseListener{
        /**
         * Une piece que l'on veut jouer
         */
        private APiece piece = null;
    
        /**
         * Fonction qui permet de gerer lors du clique sur une case de l'echiquier
         * @param e l'element sur lequel on a clique
         */
		@Override
		public void mouseClicked(MouseEvent e) {
            if(!jouer){
                return;
            }
            int x = ((Case)e.getSource()).x;
            int y = ((Case)e.getSource()).y;
                if(piece != null){
                    try{
                        piece = jeux.getPiece(piece.getX(), piece.getY());
                    }catch(PieceException ev){
                        new FenetreErreur(ev.toString());
                    }
                    if(piece.getX() == ((Case)e.getSource()).x && piece.getY() == ((Case)e.getSource()).y){
                        baseEchiquier();
                        piece = null;
                    }
                    else{
                        try{
                            if(piece.deplacementsPossibles(jeux)[x][y]){
                                jeux.deplacerPiece(piece, x, y);

                                try{
                                    File file = new File("music" + File.separator + "deplacementPiece.wav");
                                    Clip clip = AudioSystem.getClip();
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                                    clip.open(ais);
                                    clip.loop(0);
                                } catch (UnsupportedAudioFileException ev) {
                                    ev.printStackTrace();
                                } catch (LineUnavailableException ev) {
                                    ev.printStackTrace();
                                } catch(IOException ev){
                                    ev.printStackTrace();
                                }

                                ObjectOutputStream ecriture;
                                try {
                                    ecriture = new ObjectOutputStream(
                                        new FileOutputStream(
                                            new File("game" + File.separator + "jeux.txt")));
                                    ecriture.writeObject(jeux);
                                    ecriture.close();
                                } catch (IOException ev) {
                                    messageErreur(ev.toString());
                                }

                                baseEchiquier();

                                if(piece instanceof Pion){
                                    if(((Pion)piece).recompensable()){
                                        recompenserPion((Pion)piece);
                                    }
                                }
                                if(camp.equals(Camp.blanc)){
                                    chronoBlanc.Pause();
                                    chronoNoir.Play();
                                }
                                else{
                                    chronoNoir.Pause();
                                    chronoBlanc.Play();
                                }

                                if(!dualInterface){
                                    if(camp.equals(Camp.blanc)){
                                        setCamp(Camp.noir);
                                    }
                                    else{
                                        setCamp(Camp.blanc);
                                    }
                                }

                                piece = null;
                            }
                            else{
                                
                                try{
                                    if(jeux.getPiece(x, y) != null){
                                        if(jeux.getTour()%2==0 && jeux.getPiece(x, y).getCamp().equals(Camp.noir)){
                                            piece = jeux.getPiece(x, y);
                                        }
                                        else if(jeux.getTour()%2!=0 && jeux.getPiece(x, y).getCamp().equals(Camp.blanc)){
                                            piece = jeux.getPiece(x, y);
                                        }
                                        else{
                                            piece = null;
                                        }
                                    }
                                    
                                    baseEchiquier();
                                    if(piece != null){
                                        int a=0;
                                        int b=0;
                                        int i=0;
                                        if(pointVue.equals(Camp.blanc)){
                                            while(a<8 && i<64){
                                                if(piece.deplacementsPossibles(jeux)[a][b]){
                                                    ((Case)echiquier.getComponent(i)).setBackground(Color.BLUE);;
                                                }
                                                i++;
                                                b++;
                                                if(b==8){
                                                    b=0;
                                                    a++;
                                                }
                                            }
                                        }
                                        else{
                                            a=7; 
                                            b=7;
                                            while(a>-1 && i<64){
                                                if(piece.deplacementsPossibles(jeux)[a][b]){
                                                    ((Case)echiquier.getComponent(i)).setBackground(Color.BLUE);;
                                                }
                                                i++;
                                                b--;
                                                if(b==-1){
                                                    b=7;
                                                    a--;
                                                }
                                            }
                                        }
                                    }
                                }catch(PieceException ev){
                                    messageErreur(ev.toString());
                                }
                            }
                        }
                        catch(PieceException ev){
                            messageErreur(ev.toString());
                        }
                        catch(EchiquierException ev){
                            messageErreur(ev.toString());
                        }
                    
                    }
                }
                else{
                    try{
                        if(jeux.getPiece(x, y) != null){
                            if(jeux.getTour()%2==0 && jeux.getPiece(x, y).getCamp().equals(Camp.noir) && camp.equals(Camp.noir)){
                                piece = jeux.getPiece(x, y);
                            }
                            else if(jeux.getTour()%2!=0 && jeux.getPiece(x, y).getCamp().equals(Camp.blanc) && camp.equals(Camp.blanc)){
                                piece = jeux.getPiece(x, y);
                            }
                            else{
                                piece = null;
                            }
                        }
                        baseEchiquier();
                        if(piece != null){
                            int a=0;
                            int b=0;
                            int i=0;
                            if(pointVue.equals(Camp.blanc)){
                                while(a<8 && i<64){
                                    if(piece.deplacementsPossibles(jeux)[a][b]){
                                        ((Case)echiquier.getComponent(i)).setBackground(Color.BLUE);;
                                    }
                                    i++;
                                    b++;
                                    if(b==8){
                                        b=0;
                                        a++;
                                    }
                                }
                            }
                            else{
                                a=7; 
                                b=7;
                                while(a>-1 && i<64){
                                    if(piece.deplacementsPossibles(jeux)[a][b]){
                                        ((Case)echiquier.getComponent(i)).setBackground(Color.BLUE);;
                                    }
                                    i++;
                                    b--;
                                    if(b==-1){
                                        b=7;
                                        a--;
                                    }
                                }
                            }
                        }
                    }catch(PieceException ev){
                        messageErreur(ev.toString());
                    }
                }

            actualiserEchiquier();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

        /**
         * Modifie les bordures de la case que la souris survole
         * @param e la case que l'on survol
         */
		@Override
		public void mouseEntered(MouseEvent e) {
            if(jeux.getTour()%2==0){
			    ((Case)e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));	
            }
            else{
                ((Case)e.getSource()).setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));	
            }
		}

        /**
         * Remet les bordures a l'original lorsque l'on sort de la case
         * @param e la case que l'on quitte
         */
		@Override
		public void mouseExited(MouseEvent e) {
			((Case)e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}

	}
}
