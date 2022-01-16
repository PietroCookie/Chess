package swing;

import piece.*;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * Classe qui permet la gestion d'une case.
 * Elle etent JLabel
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class Case extends JLabel{
    /**
     * l'image a afficher dans la case
     */
    private BufferedImage buffer;
    /**
     * Le type de piece qu'il y a dans la case
     */
    private TypePiece piece;
    /**
     * La ligne dans laquelle se situe la case
     */
    protected int x;
    /**
     * La colonne dans laquelle se situe la case
     */
    protected int y;
    /**
     * Le pack de ressource a utiliser
     */
    private String resourcePack;

    /**
     * Le constructeur par initialisation d'un case
     * @param x la ligne dans laquelle se situe la case
     * @param y la colonne dans laquelle se situe la case
     * @param piece le type de piece qu'il y a dans la case
     * @see TypePiece
     */
    public Case(int x, int y, TypePiece piece){
        
        super();
        this.piece = piece;
        this.x = x;
        this.y = y;
        resourcePack = "basique";
        
        load(piece);
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
    }

    /**
     * Permet de savoir qu'elle piece il y a dans la case
     * @return le type de piece qu'il y a dans la case
     */
    public TypePiece getPiece(){
        return piece;
    }

    /**
     * Permet de modifier la ligne de la case
     * @param x la ligne de la case
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * Permet de modifier la colonne de la case
     * @param y la colonne de la case
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Permet de modifier le pack de ressource a utiliser
     * @param nom le nom du pack de ressource
     */
    public void setResourcePack(String nom){
        resourcePack = nom;
    }

    /**
     * Permet de charger l'image a utiliser qu'il faut afficher dans la case
     * @param piece le type de piece qu'il y a dans la case
     * @see TypePiece
     */
    private void load(TypePiece piece){
        if(!piece.equals(TypePiece.aucun)){
            String repertoire = "images";
            String extension = ".png";
            String chemin = repertoire + File.separator + resourcePack + File.separator + piece.toString() + extension;
            

            File fichier = new File(chemin);
            
            if(!fichier.exists()){
                new FenetreErreur("Le fichier n'existe pas : " + chemin);
            }

            try{
                buffer = ImageIO.read(fichier);
            }catch(IOException ex){
                new FenetreErreur("Erreur acces fichier");
            }
        }
        else{
            buffer = null;
        }
    }

    /**
     * Permet d'afficher la piece qu'il y a dans la case, rien sinon
     */
    @Override
    public void paint(java.awt.Graphics g){
        super.paint(g);
        java.awt.Graphics2D g2 = (java.awt.Graphics2D)g;
        int largeur = getWidth()-60;
        int hauteur = getHeight()-14;
        if(!piece.equals(TypePiece.aucun)){
            g2.drawImage(buffer, 30, 7, largeur, hauteur, null);
        }
    }

    /**
     * Permet de changer la piece qu'il y a dans la case
     * @param piece le type de piece qu'il y a dans la case
     * @see TypePiece
     */
    public void setEtat(TypePiece piece){
        this.piece = piece;
        load(piece);
        repaint();
    }
}
