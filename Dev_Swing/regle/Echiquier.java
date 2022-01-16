package regle;
import piece.*;
import exceptions.*;
import java.util.Vector;

/**
 * Classe permettant la gestion d'un echiquier (tableau a deux dimensions 8*8)
 * Cette classe utilise le package piece et exceptions
 * 
 * @see APiece
 * @see Roi
 * @see Reine
 * @see Fou
 * @see Cavalier
 * @see Tour
 * @see Pion
 * @see EchiquierException
 * @see PieceException
 * @see Camp
 * @see Vainqueur
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Echiquier implements java.io.Serializable{
    /**
     * Tableau a deux dimensions de taille 8*8 contenant l'etat de l'echiquier
     */
    private APiece[][] echiquier;
    /**
     * Compte le nombre de tour joue
     */
    private int tour;
    /**
     * Collection contenant toutes les pieces blanches presentent sur l'echiquier
     */
    private Vector<APiece> pieceBlanc;
    /**
     * Collection contenant toutes les pieces noires presentent sur l'echiquier
     */
    private Vector<APiece> pieceNoire;
    /**
     * Collection contenant toutes les pieces blanches prises par l'adversaire
     */
    private Vector<APiece> pieceBlancMorte;
    /**
     * Collection contenant toutes les pieces noires prises par l'adversaire
     */
    private Vector<APiece> pieceNoireMorte;
    
    /**
     * Constructeur par defaut permettant la creation d'un echiquier avec les pieces des deux camps
     */
    public Echiquier(){
        echiquier = new APiece[8][8];
        pieceBlanc = new Vector<APiece>(16, 1);
        pieceNoire = new Vector<APiece>(16, 1);
        pieceBlancMorte = new Vector<APiece>(0, 1);
        pieceNoireMorte = new Vector<APiece>(0, 1);
        restart();
    }

    /**
     * Constructeur par copie d'un Echiquier
     * @param ref l'Echiquier qu'il faut copier
     */
    public Echiquier(Echiquier ref){
        echiquier = new APiece[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                echiquier[i][j] = ref.echiquier[i][j];
            }
        }
        pieceBlanc = new Vector<APiece>(16, 1);
        for(int i=0; i<ref.pieceBlanc.size(); i++){
            pieceBlanc.add(ref.pieceBlanc.get(i));
        }
        pieceNoire = new Vector<APiece>(16, 1);
        for(int i=0; i<ref.pieceNoire.size(); i++){
            pieceNoire.add(ref.pieceNoire.get(i));
        }
        pieceBlancMorte = new Vector<APiece>(0, 1);
        for(int i=0; i<ref.pieceBlancMorte.size(); i++){
            pieceBlancMorte.add(ref.pieceBlancMorte.get(i));
        }
        pieceNoireMorte = new Vector<APiece>(0, 1);
        for(int i=0; i<ref.pieceNoireMorte.size(); i++){
            pieceNoireMorte.add(ref.pieceNoireMorte.get(i));
        }
    }
    
    /**
     * Permet de connaitre le nombre de coup joue
     * @return le nombre de coup joue
     */
    public int getTour(){
        return tour;
    }
    
    /**
     * Permet d'avoir la collection de pieces des blancs
     * @return la collection des pieces blanches
     */
    public Vector<APiece> getPieceBlanc(){
        return pieceBlanc;
    }
    
    /**
     * Permet d'avoir la collection de pieces des noires
     * @return la collection des pieces noires
     */
    public Vector<APiece> getPieceNoire(){
        return pieceNoire;
    }

    /**
     * Permet d'avoir la collection de pieces blanches prises par l'adversaire
     * @return la collection des pieces blanches prises par l'adversaire
     */
    public Vector<APiece> getPieceBlancMorte(){
        return pieceBlancMorte;
    }

    /**
     * Permet d'avoir la collection de pieces noires prises par l'adversaire
     * @return la collection des pieces noires prises par l'adversaire
     */
    public Vector<APiece> getPieceNoireMorte(){
        return pieceNoireMorte;
    }

    /**
     * Permet de connaitre la piece en position x et y sur l'echiquier
     * @param x la ligne souhaite
     * @param y la colonne souhaite
     * @return La piece de la position souhaite ou null s'il n'y a aucune piece à cette position
     * @throws PieceException En cas de saisi d'une position impossible sur l'echiquier (l'echiquier est de taille 8*8)
     */
    public APiece getPiece(int x, int y) throws PieceException{
        if(x<0 || x>7 || y<0 || y>7){
            throw new PieceException("Cette piece ne peut exister sur l'echiquier");
        }

        return echiquier[x][y];
    }

    /**
     * Permet de supprimer une piece de l'echiquier avec la position x et y de l'echiquier
     * @param x la ligne souhaite
     * @param y la colonne souhaite
     * @throws PieceException En cas de saisi d'une position impossible sur l'echiquier (l'echiquier est de taille 8*8)
     */
    public void supprimerPiece(int x, int y) throws PieceException{   
        if(x<0 || x>7 || y<0 || y>7){
            throw new PieceException("Cette piece ne peut exister sur l'echiquier");
        }

        APiece piece = echiquier[x][y];
        echiquier[x][y] = null;
        if(piece.getCamp().equals(Camp.blanc)){
            pieceBlanc.remove(piece);
        }
        else{
            pieceNoire.remove(piece);
        }
    }

    /**
     * Permet d'ajouter une piece sur l'echiquier
     * @param piece la piece a ajouter sur l'echiquier
     * @see APiece
     * @throws EchiquierException Si la case pour la piece que l'on souhaite ajouter est deja prise
     */
    public void ajouterPiece(APiece piece) throws EchiquierException{
        int x = piece.getX();
        int y = piece.getY();
        if(echiquier[x][y] != null){
            throw new EchiquierException("La case souhaitee pour placer la piece n'est pas disponible");
        }
        else{
            echiquier[x][y] = piece;
            if(piece.getCamp().equals(Camp.blanc)){
                pieceBlanc.add(piece);
            }
            else{
                pieceNoire.add(piece);
            }
        }
    }
    
    /**
     * Permet de connaitre le roi du camp donne
     * @param camp le camp dont on souhaite avoir le roi
     * @return le roi du camp souhaite
     * @see Camp
     */
    public Roi getRoi(Camp camp){

        Roi roi = null;
        if(camp.equals(Camp.blanc)){
            boolean verif = false;
            int i=0;
            do{
                if(this.getPieceBlanc().get(i) instanceof Roi ){
                    roi = (Roi)this.getPieceBlanc().get(i);
                    verif = true;
                }
                else{
                    i++;
                }
            }while(verif == false && i<this.getPieceBlanc().size());
        }
        else{
            boolean verif = false;
            int i=0;
            do{
                if(this.getPieceNoire().get(i) instanceof Roi ){
                    roi = (Roi)this.getPieceNoire().get(i);
                    verif = true;
                }
                else{
                    i++;
                }
            }while(verif == false && i<this.getPieceNoire().size());
        }
        
        return roi;
    }
    
    /**
     * Permet de remettre l'echiquier a son etat initial, supprime toutes les pieces des collections pieceBlanc, pieceNoire, pieceBlancMorte, pieceNoireMorte et remet le compteur de tour a 1
     */
    public void restart(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                echiquier[i][j] = null;
            }
        }

        pieceBlanc.removeAllElements();
        pieceNoire.removeAllElements();
        pieceBlancMorte.removeAllElements();
        pieceNoireMorte.removeAllElements();
        
        echiquier[0][0] = new Tour(0, 0, Camp.noir);
        pieceNoire.add(echiquier[0][0]);
        echiquier[0][1] = new Cavalier(0, 1, Camp.noir);
        pieceNoire.add(echiquier[0][1]);
        echiquier[0][2] = new Fou(0, 2, Camp.noir);
        pieceNoire.add(echiquier[0][2]);
        echiquier[0][3] = new Reine(0, 3, Camp.noir);
        pieceNoire.add(echiquier[0][3]);
        echiquier[0][4] = new Roi(0, 4, Camp.noir);
        pieceNoire.add(echiquier[0][4]);
        echiquier[0][5] = new Fou(0, 5, Camp.noir);
        pieceNoire.add(echiquier[0][5]);
        echiquier[0][6] = new Cavalier(0, 6, Camp.noir);
        pieceNoire.add(echiquier[0][6]);
        echiquier[0][7] = new Tour(0, 7, Camp.noir);
        pieceNoire.add(echiquier[0][7]);
        for(int i=0; i<8; i++){
            echiquier[1][i] = new Pion(1, i, Camp.noir);
            pieceNoire.add(echiquier[1][i]);
        }
        
        echiquier[7][0] = new Tour(7, 0, Camp.blanc);
        pieceBlanc.add(echiquier[7][0]);
        echiquier[7][1] = new Cavalier(7, 1, Camp.blanc);
        pieceBlanc.add(echiquier[7][1]);
        echiquier[7][2] = new Fou(7, 2, Camp.blanc);
        pieceBlanc.add(echiquier[7][2]);
        echiquier[7][3] = new Reine(7, 3, Camp.blanc);
        pieceBlanc.add(echiquier[7][3]);
        echiquier[7][4] = new Roi(7, 4, Camp.blanc);
        pieceBlanc.add(echiquier[7][4]);
        echiquier[7][5] = new Fou(7, 5, Camp.blanc);
        pieceBlanc.add(echiquier[7][5]);
        echiquier[7][6] = new Cavalier(7, 6, Camp.blanc);
        pieceBlanc.add(echiquier[7][6]);
        echiquier[7][7] = new Tour(7, 7, Camp.blanc);
        pieceBlanc.add(echiquier[7][7]);
        for(int i=0; i<8; i++){
            echiquier[6][i] = new Pion(6, i, Camp.blanc);
            pieceBlanc.add(echiquier[6][i]);
        }
        
        tour = 1;
    }
    
    /**
     * Permet de savoir si une case est libre ou non
     * @param x la ligne de la case
     * @param y la colonne de la case
     * @return vrai si la case est libre, faux sinon
     */
    public boolean estLibre(int x, int y){
        boolean verif = false;
        
        if(x>-1 && x<8 && y>-1 && y<8){
            if(echiquier[x][y] == null){
                verif = true;
            }
        }
        
        return verif;
    }
    
    /**
     * Permet de deplacer une piece de l'echiquier
     * @param piece la piece a deplacer
     * @param x la ligne ou il faut deplacer la piece
     * @param y la colonne ou il faut deplacer la piece
     * @return vrai si le deplacement a bien ete effectue, faus sinon
     * @see APiece
     * @see Roi
     * @throws EchiquierException si la piece donne en parametre vaut null ou n'existe pas sur l'echiquier ou encore s'il manque un roi sur l'echiquier. Peut egalement propager l'expetion de la methode setCaseEchec du Roi
     */
    public boolean deplacerPiece(APiece piece, int x, int y) throws EchiquierException {
        
        if(piece == null || echiquier[piece.getX()][piece.getY()] != piece){
            throw new EchiquierException("Il n'y a aucune piece à déplacer passe en parametre");
        }
            int xDepart = piece.getX();
            int yDepart = piece.getY();
            boolean verif = false;
            
            if(piece.deplacer(this, x, y)){
                if(echiquier[x][y] != null){
                    if(echiquier[x][y].getCamp().equals(Camp.blanc)){
                        pieceBlanc.remove(pieceBlanc.indexOf(echiquier[x][y]));
                        pieceBlancMorte.add(echiquier[x][y]);
                    }
                    else{
                        pieceNoire.remove(pieceNoire.indexOf(echiquier[x][y]));
                        pieceNoireMorte.add(echiquier[x][y]);
                    }
                }
                
                echiquier[x][y] = piece;
                echiquier[xDepart][yDepart] = null;
                try{
                    getRoi(Camp.blanc).setCaseEchec(this);
                    getRoi(Camp.noir).setCaseEchec(this);
                }catch(PieceException e){
                    throw new EchiquierException(e.toString());
                }
                verif = true;
                tour++;
            }
    
        return verif;
    }
    
    /**
     * Permet de recompenser un pion s'il a atteint le fond de l'echiquier
     * @param pion Le pion a recompenser
     * @param recompense La recompense (piece en laquelle va etre changer le pion) : une Reine, une Tour, un Cavalier ou un Fou
     * @see Pion
     * @see APiece
     * @throws PieceException Si le pion passe en parametre n'existe pas sur l'echiquier ou vaut null ou si la piece passe en parametre n'est pas une piece possible en recompense
     */
    public void recompenserPion(Pion pion, APiece recompense) throws PieceException{
        if(pion == null || echiquier[pion.getX()][pion.getY()] != pion){
            throw new PieceException("Le pion passe en parametre n'existe pas (Objet null)");
        }
        
        if(pion.recompensable()){
            APiece retour;
            
            if(recompense instanceof Tour){
                retour = new Tour(pion.getX(), pion.getY(), pion.getCamp());
            }
            else if(recompense instanceof Cavalier){
                retour = new Cavalier(pion.getX(), pion.getY(), pion.getCamp());
            }
            else if(recompense instanceof Fou){
                retour = new Fou(pion.getX(), pion.getY(), pion.getCamp());
            }
            else if(recompense instanceof Reine){
                retour = new Reine(pion.getX(), pion.getY(), pion.getCamp());
            }
            else{
                throw new PieceException("la piece passe en parametre n'est pas une piece possible en recompense pour un pion");
            }
            
            echiquier[pion.getX()][pion.getY()] = retour;
            if(retour.getCamp().equals(Camp.blanc)){
                pieceBlanc.remove(pieceBlanc.indexOf(pion));
                pieceBlanc.add(retour);
            }
            else{
                pieceNoire.remove(pieceNoire.indexOf(pion));
                pieceNoire.add(retour);
            }
        }
    }

    /**
     * Permet de savoir s'il y a un gagnant, une egalite ou si la partie peut continuer
     * @return Une valeur de l'enumeration Vainqueur : soit Blanc (si les blancs sont vainqueurs), soit Noir (si les noires sont vainqueurs), soit Egalite, soit Aucun si on peut continuer de jouer
     * @see Vainqueur
     * @see Roi
     * @throws PieceException Propage l'exception leve par la classe Roi (Si une piece n'existe pas sur l'echiquier)
     */
    public Vainqueur gagnant() throws PieceException{
        Vainqueur verif;
        
        if(getRoi(Camp.blanc).getEchec()){
            int i=0;
            boolean caseDispo;
            int x=0;
            int y=0;
            do{
                caseDispo = getRoi(Camp.blanc).deplacementsPossibles(this)[x][y];
                y++;
                if(y==8){
                    y=0;
                    x++;
                }
            }while(!caseDispo && x<8);

            while(!caseDispo && i<pieceBlanc.size()){
                boolean[][] test = new boolean[8][8];

                test = pieceBlanc.get(i).deplacementsPossibles(this);
                

                x=0;
                y=0;
                
                do{
                    caseDispo = getRoi(Camp.blanc).ligneEchecAttaquant()[x][y] && test[x][y];
                    y++;
                    if(y == 8){
                        y = 0;
                        x++;
                    }
                }while(!caseDispo && x<8);

                i++;
            }

            if(caseDispo){
                verif = Vainqueur.aucun;
            }
            else{
                verif = Vainqueur.noir;
            }
        }
        else if(getRoi(Camp.noir).getEchec()){
            int i=0;
            boolean caseDispo;
            int x=0;
            int y=0;
            do{
                caseDispo = getRoi(Camp.noir).deplacementsPossibles(this)[x][y];
                y++;
                if(y==8){
                    y=0;
                    x++;
                }
            }while(!caseDispo && x<8);

            while(!caseDispo && i<pieceNoire.size()){
                boolean[][] test = new boolean[8][8];

                test = pieceNoire.get(i).deplacementsPossibles(this);

                x=0;
                y=0;
                
                do{
                    caseDispo = getRoi(Camp.noir).ligneEchecAttaquant()[x][y] && test[x][y];
                    y++;
                    if(y == 8){
                        y = 0;
                        x++;
                    }
                }while(!caseDispo && x<8);

                i++;
            }

            if(caseDispo){
                verif = Vainqueur.aucun;
            }
            else{
                verif = Vainqueur.blanc;
            }
        }
        else{
            boolean test = false;
            int i=0;
            boolean[][] tableau = new boolean[8][8];
            do{
                tableau = pieceBlanc.get(i).deplacementsPossibles(this);
                int x=0;
                int y=0;
                do{
                    test = tableau[x][y];
                    y++;
                    if(y==8){
                        x++;
                        y=0;
                    }
                }while(!test && x<8);
                i++;
            }while(!test && i<pieceBlanc.size());
            
            if(!test){
                i=0;
                do{
                    tableau = pieceNoire.get(i).deplacementsPossibles(this);
                    int x=0;
                    int y=0;
                    do{
                        test = tableau[x][y];
                        y++;
                        if(y==8){
                            x++;
                            y=0;
                        }
                    }while(!test && x<8);
                    i++;
                }while(!test && i<pieceNoire.size());
            }

            if(test){
                verif = Vainqueur.aucun;
            }
            else{
                verif = Vainqueur.egalite;
            }
            
        }
        
        return verif;
    }
}
