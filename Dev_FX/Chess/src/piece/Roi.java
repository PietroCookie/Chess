package piece;
import exceptions.*;
import regle.*;
import java.util.Vector;

/**
 * Classe permettant la gestion d'une piece de type Roi
 * @see APiece
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Roi extends APiece{
    /**
     * Permet de savoir si le Roi peut roquer
     */
    protected boolean roque = true;
    /**
     * Tableau à deux dimensions contenant les cases sur lesquelles le roi est echec
     */
    private boolean[][] caseEchec;
    /**
     * La piece qui met echec le Roi
     */
    protected APiece attaquant;
    /**
     * Permet de savoir si le Roi est en situation d'echec ou non
     */
    private boolean echec;
    
    /**
     * Constructeur par initialisation d'un Roi
     * @param x La ligne dans laquelle se situe le Roi
     * @param y La colonne dans laquelle se situe le Roi
     * @param camp La camp dans lequel est le Roi
     */
    public Roi(int x, int y, Camp camp){
        super(x, y, camp);
        caseEchec = new boolean[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                caseEchec[i][j] = false;
            }
        }
        attaquant = null;
        echec = false;
    }
    
    /**
     * Permet de savoir si le Roi peut roquer
     * @return vrai si le roi peut roquer, faux sinon
     */
    public boolean getRoque(){
        return roque;
    }
    
    /**
     * Permet de connaitre les cases sur lesquels le roi est echec
     * @return un tableau a deux dimensions permettant les cases sur lesquels le Roi est echec ou non
     */
    public boolean[][] getCaseEchec(){
        return caseEchec;
    }

    /**
     * Permet de savoir quelle piece met echec le Roi
     * @return La piece qui met echec le Roi
     */
    public APiece getAttaquant(){
        return attaquant;
    }

    /**
     * Permet de modifier l'etat d'echec du Roi
     * @param echec le nouvel etat d'echec du Roi
     */
    public void setEchec(boolean echec){
        this.echec = echec;
    }

    /**
     * Permet de connaitre l'etat d'echec du Roi
     * @return l'etat d'echec du roi (Vrai si le Roi est echec, faux sinon)
     */
    public boolean getEchec(){
        return echec;
    }

    /**
     * Permet de modifier le tableau des cases qui mettent echec le Roi en fonction d'un echiquier
     * @param etatJeux L'echiquier sur lequel il faut verifier si le Roi est en echec
     * @see Echiquier
     * @see APiece
     * @throws PieceException Propage l'exception leve par la methode deplacementsPossibles d'une APiece
     */
    public void setCaseEchec(Echiquier etatJeux) throws PieceException{
        attaquant = null;
        Vector<APiece> pieces;
        if(getCamp().equals(Camp.noir)){
            pieces = etatJeux.getPieceBlanc();
        }
        else{
            pieces = etatJeux.getPieceNoire();
        }
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                caseEchec[i][j] = false;
            }
        }

        for(int a=0; a<pieces.size(); a++){
            if(pieces.get(a) instanceof Pion){
                APiece pion = pieces.get(a);
                int x = pion.getX()-1;
                int y = pion.getY()+1;
                if(pion.getCamp().equals(Camp.blanc)){
                    
                    if(x>-1 && y<8 && x<8 && y>-1){
                        caseEchec[x][y] = true;
                    }
                    y = pion.getY()-1;
                    if(x>-1 && y<8 && x<8 && y>-1){
                        caseEchec[x][y] = true;
                    }
                }
                else if(pion.getCamp().equals(Camp.noir)){
                    x = pion.getX()+1;
                    y = pion.getY()+1;
                    if(x>-1 && y<8 && x<8 && y>-1){
                        caseEchec[x][y] = true;
                    }
                    
                    y = pion.getY()-1;
                    if(x>-1 && y<8 && x<8 && y>-1){
                        caseEchec[x][y] = true;
                    }
                }
            }
        }

        for(int a=0; a<pieces.size(); a++){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(!caseEchec[i][j]){
                        if(!(pieces.get(a) instanceof Pion)){
                            caseEchec[i][j] = pieces.get(a).deplacementsBase(etatJeux)[i][j];
                        }
                    }
                }
            }
        }

        boolean verif = false;
        int x=0;
        int y=0;
        while(x<8 && !verif){
            if(caseEchec[x][y] && x==getX() && y==getY()){
                verif = true;
            }
            y++;
            if(y==8){
                x++;
                y=0;
            }
        }

        echec = verif;
        if(echec){
            int a=0;
            while(attaquant==null && a<pieces.size()){
                if(pieces.get(a).deplacementsBase(etatJeux)[getX()][getY()]){
                    attaquant = pieces.get(a);
                }
                a++;
            }
            roque = false;
        }
        if(attaquant != null){
            etatJeux.supprimerPiece(attaquant.getX(), attaquant.getY());
            if(getCamp().equals(Camp.noir)){
                pieces = etatJeux.getPieceBlanc();
            }
            else{
                pieces = etatJeux.getPieceNoire();
            }
            for(int a=0; a<pieces.size(); a++){
                if(pieces.get(a) instanceof Pion){
                    APiece pion = pieces.get(a);
                    x = pion.getX()-1;
                    y = pion.getY()+1;
                    if(pion.getCamp().equals(Camp.blanc)){
                        
                        if(x>-1 && y<8 && x<8 && y>-1){
                            caseEchec[x][y] = true;
                        }
                        y = pion.getY()-1;
                        if(x>-1 && y<8 && x<8 && y>-1){
                            caseEchec[x][y] = true;
                        }
                    }
                    else if(pion.getCamp().equals(Camp.noir)){
                        x = pion.getX()+1;
                        y = pion.getY()+1;
                        if(x>-1 && y<8 && x<8 && y>-1){
                            caseEchec[x][y] = true;
                        }
                        
                        y = pion.getY()-1;
                        if(x>-1 && y<8 && x<8 && y>-1){
                            caseEchec[x][y] = true;
                        }
                    }
                }
            }
            for(int a=0; a<pieces.size(); a++){
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        if(!caseEchec[i][j]){
                            if(!(pieces.get(a) instanceof Pion)){
                                caseEchec[i][j] = pieces.get(a).deplacementsBase(etatJeux)[i][j];
                            }
                        }
                    }
                }
            }
            try{
                etatJeux.ajouterPiece(attaquant);
            }catch(EchiquierException e){
                throw new PieceException(e.toString());
            }
        }
    }

    /**
     * Permet de connaitre les cases sur lesquels il faut placer une piece pour defendre le Roi d'un echec
     * @return Un tableau de boolean des cases sur lesquels il faut defendre le Roi
     */
    public boolean[][] ligneEchecAttaquant(){
        boolean[][] tableau = new boolean[8][8];

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                tableau[i][j] = false;
            }
        }
        if(attaquant != null){
            tableau[attaquant.getX()][attaquant.getY()] = true;

            if(attaquant instanceof Tour){
                if(getX()-attaquant.getX()==0){
                    int y = attaquant.getY();
                    if(getY()-y>0){
                        do{
                            y++;
                            tableau[getX()][y] = true;
                        }while(getY() != y);
                    }
                    else{
                        do{
                            y--;
                            tableau[getX()][y] = true;
                        }while(getY() != y);
                    }
                }
                else if(getY()-attaquant.getY()==0){
                    int x = attaquant.getX();
                    if(getX()-x>0){
                        do{
                            x++;
                            tableau[x][getY()] = true;
                        }while(getX() != x);
                    }
                    else{
                        do{
                            x--;
                            tableau[x][getY()] = true;
                        }while(getX() != x);
                    }
                }
            }
            else if(attaquant instanceof Fou){
                int x = attaquant.getX();
                int y = attaquant.getY();
                if(getX()-attaquant.getX()>0){
                    if(getY()-y>0){
                        do{
                            x++;
                            y++;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                    else{
                        do{
                            x++;
                            y--;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                }
                else{
                    if(getY()-y>0){
                        do{
                            x--;
                            y++;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                    else{
                        do{
                            x--;
                            y--;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                }
            }
            else if(attaquant instanceof Reine){
                int x = attaquant.getX();
                int y = attaquant.getY();
                if(getX()-x==0){
                    if(getY()-y>0){
                        do{
                            y++;
                            tableau[getX()][y] = true;
                        }while(getY() != y);
                    }
                    else{
                        do{
                            y--;
                            tableau[getX()][y] = true;
                        }while(getY() != y);
                    }
                }
                else if(getY()-y==0){
                    if(getX()-x>0){
                        do{
                            x++;
                            tableau[x][getY()] = true;
                        }while(getX() != x);
                    }
                    else{
                        do{
                            x--;
                            tableau[x][getY()] = true;
                        }while(getX() != x);
                    }
                }
                else if(getX()-x>0){
                    if(getY()-y>0){
                        do{
                            x++;
                            y++;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                    else{
                        do{
                            x++;
                            y--;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                }
                else{
                    if(getY()-y>0){
                        do{
                            x--;
                            y++;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                    else{
                        do{
                            x--;
                            y--;
                            tableau[x][y] = true;
                        }while(getX() != x && getY() != y);
                    }
                }
            }
        }

        return tableau;
    }

    /**
     * Permet de determiner les deplacements de base d'une APiece dans un Echiquier, cette methode ne verifie pas si le Roi est en situation d'echec
     * @param etatJeux l'Echiquier sur lequel on test les deplacements possibles de base d'une APiece
     * @return Tableau 8*8 des deplacements de base de d'une APiece
     * @see Echiquier
     * @throws PieceException Si une piece n'existe pas sur l'echiquier
     */
    public boolean[][] deplacementsBase(Echiquier etatJeux) throws PieceException{
        boolean[][] tableau = new boolean[8][8];

        tableau[getX()][getY()] = true;

        int x = super.getX()+1;
        int y = super.getY();
        if(x<8){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        y = super.getY()+1;
        if(x<8 && y<8){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        y = super.getY()-1;
        if(x<8 && y>-1){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX();
        y = super.getY()-1;
        if(y>-1){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        y = super.getY()+1;
        if(y<8){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()-1;
        y = super.getY();
        if(x>-1){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        y = super.getY()+1;
        if(x>-1 && y<8){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        y = super.getY()-1;
        if(x>-1 && y>-1){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX();
        y = super.getY();
        Vector<APiece> pieces = etatJeux.getPieceBlanc();
        if(super.getCamp().equals(Camp.noir)){
            pieces = etatJeux.getPieceNoire();
        }

        if(roque){
            for(int i=0; i<pieces.size(); i++){
                if(pieces.get(i) instanceof Tour){
                    if(((Tour)pieces.get(i)).getRoque()){
                        if(pieces.get(i).getY()-y>0){
                            if(etatJeux.estLibre(x, y+1) && etatJeux.estLibre(x, y+2)){
                                tableau[x][y+2] = true;
                            }
                        }
                        else{
                            if(etatJeux.estLibre(x, getY()-1) && etatJeux.estLibre(x, getY()-2) && etatJeux.estLibre(x, getY()-3)){
                                tableau[x][y-2] = true;
                            }
                        }
                    }
                }
            }
        }

        return tableau;
    }
    
    /**
     * Permet de connaitre les deplacements possibles du Roi dans un echiquier donne
     * @param etatJeux l'echiquier dans lequel il faut regarder les deplacements possibles du Roi
     * @see Echiquier
     * @return Un tableau a 2 dimensions de boolean reprensentant les deplacements possibles de la piece sur un echiquier, les cases "true" sont les cases sur lesquelles peuvent aller la piece et "false" les cases ou elle ne peut pas aller
     * @throws PieceException Propage l'exception de la methode deplacements
     */
    @Override
    public boolean[][] deplacementsPossibles(Echiquier etatJeux) throws PieceException{
        boolean[][] tableau = new boolean[8][8];
        this.setCaseEchec(etatJeux);
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(deplacementsBase(etatJeux)[i][j]){
                    Echiquier simulation = new Echiquier(etatJeux);
                    try{
                        simulation.supprimerPiece(getX(), getY());
                        APiece roiSimualtion = new Roi(i, j, getCamp());
                        if(simulation.getPiece(i, j) != null){
                            simulation.supprimerPiece(i, j);
                        }
                        simulation.ajouterPiece(roiSimualtion);
                    }catch(EchiquierException e){
                        throw new PieceException(e.toString());
                    }
                    simulation.getRoi(getCamp()).setCaseEchec(simulation);
                    if(simulation.getRoi(getCamp()).getEchec()){
                        tableau[i][j] = false;
                    }
                    else{
                        tableau[i][j] = true;
                    }
                }
            }
        }
        tableau[getX()][getY()] = false;

        return tableau;
    }
}
