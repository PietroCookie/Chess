package piece;
import regle.*;
import exceptions.*;

/**
 * Classe permettant de gérer les pieces. Elle implemente IPiece.
 * 
 * @see Camp
 * @see Reine
 * @see Roi
 * @see Cavalier
 * @see Tour
 * @see Fou
 * @see Pion
 * @see IPiece
 * @author Pierre CHEMIN
 */
public abstract class APiece implements IPiece, java.io.Serializable{
    /**
     * La ligne dans laquelle la piece se situe sur l'echiquier
     */
    private int x;
    /**
     * La colonne dans laquelle la piece se situe sur l'echiquier
     */
    private int y;
    /**
     * Le camp dans lequel est la piece
     */
    private Camp camp;
    
    /**
     * Constructeur par initialisation d'une Piece
     * @param x La ligne dans laquelle se situe la piece
     * @param y La colonne dans laquelle se situe la piece
     * @param camp Le camp dans lequel est la piece
     */
    public APiece(int x, int y, Camp camp){
        this.x = x;
        this.y = y;
        this.camp = camp;
    }
    
    /**
     * Permet de connaitre la ligne de la piece
     * @return La ligne de la piece
     */
    @Override
    public int getX(){
        return x;
    }
    
    /**
     * Permet de connaitre la colonne de la piece
     * @return la colonne de la piece
     */
    @Override
    public int getY(){
        return y;
    }
    
    /**
     * Permet de connaitre le camp d'une piece
     * @return le camp de la piece
     */
    @Override
    public Camp getCamp(){
        return camp;
    }
    
    /**
     * Permet de deplacer la piece sur l'echiquier. Modifie la ligne et la colonne seulement si la case ou l'on souhaite deplacer la piece est libre et est dans les deplacements possibles de la piece
     * @param echiquier l'echiquier dans lequel il faut effectuer le deplacement
     * @param x La ligne dans laquelle on va deplacer la piece
     * @param y La colonne dans laquelle on va deplacer la piece
     * @see Echiquier
     * @return Vrai si le deplacement a bien ete effectue, faux sinon
     * @throws EchiquierException Si une piece n'existe pas sur l'echiquier
     */
    @Override
    public boolean deplacer(Echiquier echiquier, int x, int y) throws EchiquierException{
        boolean[][] verif;
        try{
            verif = deplacementsPossibles(echiquier);
        }
        catch(PieceException e){
            throw new EchiquierException("Un des roi n'existe pas sur l'echiquier");
        }
        
        boolean deplacementEffectue = false;
        if(verif[x][y]){
            if(this instanceof Roi){
                if(y == 6 && ((Roi)this).getRoque()){
                    try{
                        APiece copie = echiquier.getPiece(x, 7);
                        echiquier.supprimerPiece(x, 7);
                        copie.y = 5;
                        echiquier.ajouterPiece(copie);
                    }catch(PieceException e){
                        throw new EchiquierException(e.toString());
                    }
                }
                else if(y==2 && ((Roi)this).getRoque()){
                    try{
                        APiece copie = echiquier.getPiece(x, 0);
                        echiquier.supprimerPiece(x, 0);
                        copie.y = 3;
                        echiquier.ajouterPiece(copie);
                    }catch(PieceException e){
                        throw new EchiquierException(e.toString());
                    }
                }
            }

            this.x = x;
            this.y = y;

            if(this instanceof Tour){
                ((Tour)this).roque = false;
            }
            else if(this instanceof Roi){
                ((Roi)this).roque = false;
                ((Roi)this).attaquant = null;
            }
            deplacementEffectue = true;
        }
        
        return deplacementEffectue;
    }

    /**
     * Permet de determiner les deplacements de base d'une APiece dans un Echiquier, cette methode ne verifie pas si le Roi est en situation d'echec
     * @param etatJeux l'Echiquier sur lequel on test les deplacements possibles de base d'une APiece
     * @return Tableau 8*8 des deplacements de base de d'une APiece
     * @see Echiquier
     * @throws PieceException Si une piece n'existe pas sur l'echiquier
     */
    @Override
    public abstract boolean[][] deplacementsBase(Echiquier etatJeux) throws PieceException;
    
    /**
     * Permet de connaitre les deplacements possibles d'une piece dans un echiquier
     * @param etatJeux l'echiquier dans lequel il faut regarder les deplacements possibles d'une piece
     * @see Echiquier
     * @return Un tableau a 2 dimensions de boolean reprensentant les deplacements possibles de la piece sur un echiquier, les cases "true" sont les cases sur lesquelles peuvent aller la piece et "false" les cases ou elle ne peut pas aller
     * @throws PieceException Si une piece n'existe pas sur l'echiquier
     */
    @Override
    public boolean[][] deplacementsPossibles(Echiquier etatJeux) throws PieceException{
        boolean[][] tableau = new boolean[8][8];
        //On récupère le roi du camp de la piece
        Roi roi = etatJeux.getRoi(getCamp());
        
        if(roi == null){
            throw new PieceException("Le roi n'existe pas sur l'echiquier");
        }
        //On vérifie que le roi ne soit pas en echec et si c'est le cas on modifie notre tableau de deplacements
        if(roi.getEchec()){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    tableau[i][j] = deplacementsBase(etatJeux)[i][j] && roi.ligneEchecAttaquant()[i][j];
                }
            }
            APiece copie = roi.getAttaquant();
            etatJeux.supprimerPiece(copie.getX(), copie.getY());
            roi.setCaseEchec(etatJeux);
            if(roi.getEchec()){
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        tableau[i][j]= false;
                    }
                }
            }
            try{
                etatJeux.ajouterPiece(copie);
            }catch(EchiquierException e){
                throw new PieceException(e.toString());
            }
            roi.setCaseEchec(etatJeux);
        }
        else{
            etatJeux.supprimerPiece(getX(), getY());
            roi.setCaseEchec(etatJeux);
            if(roi.getEchec()){
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        tableau[i][j] = deplacementsBase(etatJeux)[i][j] && roi.ligneEchecAttaquant()[i][j];
                    }
                }
            }
            else{
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        tableau[i][j] = deplacementsBase(etatJeux)[i][j];
                    }
                }
            }
            try{
                etatJeux.ajouterPiece(this);
            }catch(EchiquierException e){
                throw new PieceException(e.toString());
            }
            roi.setCaseEchec(etatJeux);
        }

        return tableau;
    }
}
