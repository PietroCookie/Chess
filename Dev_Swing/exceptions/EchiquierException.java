package exceptions;

/**
 * Exception personnalise EchiquierException, leve lorsqu'il y a un probleme sur l'echiquier
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class EchiquierException extends Exception {

    /**
     * Constructeur par defaut d'une Exception
     */
    public EchiquierException() {
        super();
    }

    /**
     * Construit une Exception avec un message specifique
     *
     * @param msg Le message specifique
     */
    public EchiquierException(String msg) {
        super(msg);
    }
    
    /**
     * Permet de connaitre l'erreur qu'il y a eu, le contenu de l'exception
     * @return un message de l'exception
     */
    public String toString(){
        return("Il y a une erreur sur l'echiquier : " + getMessage());
    }
}
