package piece;
import exceptions.*;
import regle.*;

/**
 * Classe permettant la gestion d'une piece de type Tour
 * @see APiece
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Tour extends APiece{
    /**
     * Permet de savoir si la Tour peut roquer
     */
    protected boolean roque;
    
    /**
     * Constructeur par initialisation d'une Tour
     * @param x La ligne dans laquelle se situe la Tour
     * @param y La colonne dans laquelle se situe la Tour
     * @param camp Le camp dans lequel se situe la Tour
     */
    public Tour(int x, int y, Camp camp){
        super(x, y, camp);
        roque = true;
    }
    
    /**
     * Permet de savoir si la Tour peut roquer
     * @return vrai si la tour peut roquer, faux sinon
     */
    public boolean getRoque(){
        return roque;
    }

    /**
     * Permet de determiner les deplacements de base d'une APiece dans un Echiquier, cette methode ne verifie pas si le Roi est en situation d'echec
     * @param etatJeux l'Echiquier sur lequel on test les deplacements possibles de base d'une APiece
     * @return Tableau 8*8 des deplacements de base de d'une APiece
     * @see Echiquier
     * @throws PieceException Si une piece n'existe pas sur l'echiquier
     */
    @Override
    public boolean[][] deplacementsBase(Echiquier etatJeux) throws PieceException {
        boolean[][] tableau = new boolean[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                tableau[i][j] = false;
            }
        }

        boolean verif;
        int x = super.getX();
        int y = super.getY();
        do{
            x++;
            if(x == 8){
                verif = false;
            }
            else{
                tableau[x][y] = etatJeux.estLibre(x, y);
                if(tableau[x][y]){
                    verif = true;
                }
                else{
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                    verif = false;
                }
            }
        }while(verif);

        x = super.getX();
        do{
            x--;
            if(x == -1){
                verif = false;
            }
            else{
                tableau[x][y] = etatJeux.estLibre(x, y);
                if(tableau[x][y]){
                    verif = true;
                }
                else{
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                    verif = false;
                }
            }
        }while(verif);
        
        x = super.getX();
        do{
            y++;
            if(y == 8){
                verif = false;
            }
            else{
                tableau[x][y] = etatJeux.estLibre(x, y);
                if(tableau[x][y]){
                    verif = true;
                }
                else{
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                    verif = false;
                }
            }
        }while(verif);

        y = super.getY();
        do{
            y--;
            if(y == -1){
                verif = false;
            }
            else{
                tableau[x][y] = etatJeux.estLibre(x, y);
                if(tableau[x][y]){
                    verif = true;
                }
                else{
                    if(!etatJeux.getPiece(x, y).getCamp().equals(getCamp())){
                        tableau[x][y] = true;
                    }
                    verif = false;
                }
            }
        }while(verif);

        return tableau;
    }

}
