package piece;
import regle.*;
import exceptions.*;

/**
 * Classe permetteant la gestion d'une piece de type Cavalier
 * @see APiece
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Cavalier extends APiece{
    
    /**
     * Constructeur par initialisation d'un Cavalier
     * @param x La ligne dans laquelle se situe le Cavalier
     * @param y La colonne dans laquelle se situe le Cavalier
     * @param camp Le camp dans lequle se situe le Cavalier
     */
    public Cavalier(int x, int y, Camp camp){
        super(x, y, camp);
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
        
        int x = super.getX()+2;
        int y = super.getY()+1;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()+2;
        y = super.getY()-1;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()+1;
        y = super.getY()+2;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()-1;
        y = super.getY()+2;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()-2;
        y = super.getY()+1;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()-2;
        y = super.getY()-1;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()+1;
        y = super.getY()-2;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        x = super.getX()-1;
        y = super.getY()-2;
        if(x<8 && y<8 && x>=0 && y>=0){
            tableau[x][y] = etatJeux.estLibre(x, y);
            if(!etatJeux.estLibre(x, y)){
                if(!etatJeux.getPiece(x, y).getCamp().equals(super.getCamp())){
                    tableau[x][y] = true;
                }
            }
        }

        return tableau;
    }
}
