package piece;
import regle.*;
import exceptions.*;

/**
 * Interface pour la classe APiece
 * @see APiece
 * @author Pierre CHEMIN
 * @version 1.0
 */
public interface IPiece{
    /**
     * Permet de connaitre la ligne dans laquelle se situe la piece
     * @return La ligne dans laquelle se situe la piece
     */
    public int getX();

    /**
     * Permet de connaitre la colonne dans laquelle se situe la piece
     * @return La colonne dans laquelle se situe la piece
     */
    public int getY();

    /**
     * Permet de connaitre le camp de la piece
     * @return Le camp dans lequel appartient la piece
     */
    public Camp getCamp();

    /**
     * Permet de deplacer la piece sur l'echiquier. Modifie la ligne et la colonne seulement si la case ou l'on souhaite deplacer la piece est libre et est dans les deplacements possibles de la piece
     * @param echiquier l'echiquier dans lequel il faut effectuer le deplacement
     * @param x La ligne dans laquelle on va deplacer la piece
     * @param y La colonne dans laquelle on va deplacer la piece
     * @see Echiquier
     * @return Vrai si le deplacement a bien ete effectue, faux sinon
     * @throws EchiquierException si un des rois n'existent pas sur l'echiquier
     */
    public boolean deplacer(Echiquier echiquier, int x, int y) throws EchiquierException;

    /**
     * Permet de determiner les deplacements de base d'une APiece dans un Echiquier, cette methode ne verifie pas si le Roi est en situation d'echec
     * @param etatJeux l'Echiquier sur lequel on test les deplacements possibles de base d'une APiece
     * @return Tableau 8*8 des deplacements de base de d'une APiece
     * @see Echiquier
     * @throws PieceException Si une piece n'existe pas sur l'echiquier
     */
    public boolean[][] deplacementsBase(Echiquier etatJeux) throws PieceException;

    /**
     * Permet de connaitre les deplacements possibles d'une piece dans un echiquier
     * @param etatJeux l'echiquier dans lequel il faut regarder les deplacements possibles d'une piece
     * @see Echiquier
     * @return Un tableau a 2 dimensions de boolean reprensentant les deplacements possibles de la piece sur un echiquier, les cases "true" sont les cases sur lesquelles peuvent aller la piece et "false" les cases ou elle ne peut pas aller
     * @throws PieceException Si un piece n'existe pas sur l'echiquier
     */
    public boolean[][] deplacementsPossibles(Echiquier etatJeux) throws PieceException;
}