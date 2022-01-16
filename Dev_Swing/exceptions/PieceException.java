package exceptions;

/**
 * Exception personnalise PieceException, leve lorsqu'il y a un probleme avec une Piece
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class PieceException extends Exception {

    /**
     * Construit une PieceException sans message specifique
     */
    public PieceException() {
        super();
    }

    /**
     * Construit une PieceException avec une message specifique
     *
     * @param msg le message specifique.
     */
    public PieceException(String msg) {
        super(msg);
    }
    
    /**
     * Donne l'erreur lie a l'exception
     * @return le message expliquant l'exception
     */
    public String toString(){
        return("Impossible de creer ou d'utiliser cette piece : " + getMessage());
    }
}
