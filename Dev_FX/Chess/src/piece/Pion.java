package piece;
import regle.*;
import exceptions.*;

/**
 * Classe permettant de gerer une peice de type Pion
 * @see APiece
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Pion extends APiece{
    
    /**
     * Constructeur par initialisation d'un Pion
     * @param x La ligne dans laquelle se situe le Pion
     * @param y La colonne dans laquelle se situe le Pion
     * @param camp Le camp dans lequel se situe le Pion
     */
    public Pion(int x, int y, Camp camp){
        super(x, y, camp);
    }
    
    /**
     * Permet de savoir si un pion est recompensable
     * @return vrai si le pion est recompensable, faux sinon
     */
    public boolean recompensable(){
        boolean verif = false;
        if(getCamp().equals(Camp.blanc)){
            if(getX() == 0){
                verif= true;
            }
        }
        else{
            if(getX() == 7){
                verif = true;
            }
        }
        return verif;
    }
    
    /**
     * Permet de determiner les deplacements de base d'une APiece dans un Echiquier, cette methode ne verifie pas si le Roi est en situation d'echec
     * @param etatJeux l'Echiquier sur lequel on test les deplacements possibles de base d'une APiece
     * @return Tableau 8*8 des deplacements de base de d'une APiece
     * @see Echiquier
     * @throws PieceException Si une piece n'existe pas sur l'echiquier
     */
    @Override
    public boolean[][] deplacementsBase(Echiquier etatJeux) throws PieceException{
        boolean[][] tableau = new boolean[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                tableau[i][j] = false;
            }
        }
        
        
        if(getCamp().equals(Camp.blanc) && getX() == 6){
            if(etatJeux.estLibre(getX()-1, getY())){
                tableau[getX()-1][getY()] = true;
                if(etatJeux.estLibre(getX()-2, getY())){
                    tableau[getX()-2][getY()] = true;
                }
            }
        }
        else if(getCamp().equals(Camp.noir) && getX() == 1){
            if(etatJeux.estLibre(getX()+1, getY())){
                tableau[getX()+1][getY()] = true;
                if(etatJeux.estLibre(getX()+2, getY())){
                    tableau[getX()+2][getY()] = true;
                }
            }
        }
        else if(getCamp().equals(Camp.blanc) && etatJeux.estLibre(getX()-1, getY())){
            tableau[getX()-1][getY()] = true;
        }
        else if(getCamp().equals(Camp.noir) && etatJeux.estLibre(getX()+1, getY())){
            tableau[getX()+1][getY()] = true;
        }
            
        int x = getX()-1;
        int y = getY()+1;
    
        if(getCamp().equals(Camp.blanc)){
            
            if(x>-1 && y<8){
                if(!etatJeux.estLibre(x, y)){
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                }
            }
            y = getY()-1;
            if(y>-1){
                if(!etatJeux.estLibre(x, y)){
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                }
            }
        }
        else if(getCamp().equals(Camp.noir)){
            x = getX()+1;
            y = getY()+1;
            if(x<8 && y<8){
                if(!etatJeux.estLibre(x, y)){
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                }
            }
            
            y = getY()-1;
            if(y>-1){
                if(!etatJeux.estLibre(getX()+1, getY()-1)){
                    if(!etatJeux.getPiece(getX()+1, getY()-1).getCamp().equals(getCamp())){
                        tableau[getX()+1][getY()-1] = true;
                    }
                }
            }
        }

        return tableau;
    }
}
