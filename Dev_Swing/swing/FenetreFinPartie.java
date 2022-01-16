package swing;
import piece.*;

import javax.swing.*;

import regle.Vainqueur;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Classe qui permet de gerer la fenetre de fin de partie
 * Elle etend JFrame
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class FenetreFinPartie extends JFrame{
    /**
     * Constructeur par initialisation d'une Fenetre de fin de partie
     * @param echiquier le jpanel qui cree une fenetre de fin de partie
     * @param gagnant le camp qui a gagne la partie ou s'il y a egalite
     */
    public FenetreFinPartie(JPanelEchiquier echiquier, Vainqueur gagnant){
        super();

        JPanel panel = new JPanel();
        JPanel button = new JPanel();
        JPanel centre = new JPanel();
        JLabel annonce;
        if(gagnant.equals(Vainqueur.egalite)){
            annonce = new JLabel("Personne n'a sur remporte la partie ... Reessayer !");
        }
        else{
            annonce = new JLabel("Le camp " + gagnant.toString() + " remportent la partie !");
        }
        annonce.setHorizontalAlignment(JLabel.CENTER);

        button.setLayout(new GridLayout(1, 2));

        JButton restart = new JButton("Recommencer");
            restart.addActionListener(e -> {echiquier.restart(); dispose(); });
        JButton fermer = new JButton("Fermer");
            fermer.addActionListener(e -> {dispose();});
        JButton quitter = new JButton("Exit");
            quitter.addActionListener(e -> System.exit(0));

        button.add(restart);
        button.add(fermer);
        button.add(quitter);
        
        centre.setLayout(new BorderLayout());
        JLabel infoTour = new JLabel("Il aura fallu " + echiquier.getJeux().getTour()/2 + " tours" );
        infoTour.setHorizontalAlignment(JLabel.CENTER);

        JPanel pieceBlanc = new JPanel();
        pieceBlanc.setLayout(new GridLayout(2, 1));
        JLabel infoBlanc = new JLabel("Piece(s) prise(s) par les noirs");
        infoBlanc.setHorizontalAlignment(JLabel.CENTER);
        JPanel pieceBlancMorte = new JPanel();
        pieceBlancMorte.setLayout(new GridLayout(2, 8));
        for(int i=0; i<16; i++){
            Case ajout = new Case(0, 0, TypePiece.aucun);
            pieceBlancMorte.add(ajout);
        }
        
        for(int i=0; i<echiquier.getJeux().getPieceBlancMorte().size(); i++){
            APiece piece = echiquier.getJeux().getPieceBlancMorte().get(i);
            if(piece instanceof Tour){
                ((Case)pieceBlancMorte.getComponent(i)).setEtat(TypePiece.tourBlanc);
            }
            else if(piece instanceof Fou){
                ((Case)pieceBlancMorte.getComponent(i)).setEtat(TypePiece.fouBlanc);
            }
            else if(piece instanceof Cavalier){
                ((Case)pieceBlancMorte.getComponent(i)).setEtat(TypePiece.cavalierBlanc);
            }
            else if(piece instanceof Pion){
                ((Case)pieceBlancMorte.getComponent(i)).setEtat(TypePiece.pionBlanc);
            }
            else if(piece instanceof Reine){
                ((Case)pieceBlancMorte.getComponent(i)).setEtat(TypePiece.reineBlanc);
            }
        }

        pieceBlanc.add(infoBlanc);
        pieceBlanc.add(pieceBlancMorte);

        JPanel pieceNoir = new JPanel();
        pieceNoir.setLayout(new GridLayout(2, 1));
        JLabel infoNoir = new JLabel("Piece(s) prise(s) par les blancs");
        infoNoir.setHorizontalAlignment(JLabel.CENTER);
        JPanel pieceNoirMorte = new JPanel();
        pieceNoirMorte.setLayout(new GridLayout(2, 8));
        for(int i=0; i<16; i++){
            Case ajout = new Case(0, 0, TypePiece.aucun);
            pieceNoirMorte.add(ajout);
        }
        
        for(int i=0; i<echiquier.getJeux().getPieceNoireMorte().size(); i++){
            APiece piece = echiquier.getJeux().getPieceNoireMorte().get(i);
            if(piece instanceof Tour){
                ((Case)pieceNoirMorte.getComponent(i)).setEtat(TypePiece.tourNoir);
            }
            else if(piece instanceof Fou){
                ((Case)pieceNoirMorte.getComponent(i)).setEtat(TypePiece.fouNoir);
            }
            else if(piece instanceof Cavalier){
                ((Case)pieceNoirMorte.getComponent(i)).setEtat(TypePiece.cavalierNoir);
            }
            else if(piece instanceof Pion){
                ((Case)pieceNoirMorte.getComponent(i)).setEtat(TypePiece.pionNoir);
            }
            else if(piece instanceof Reine){
                ((Case)pieceNoirMorte.getComponent(i)).setEtat(TypePiece.reineNoir);
            }
        }
        pieceNoir.add(infoNoir);
        pieceNoir.add(pieceNoirMorte);
        
        JPanel infos = new JPanel();
        infos.setLayout(new GridLayout(2, 1));
        infos.add(pieceBlanc);
        infos.add(pieceNoir);
        centre.add(infoTour, BorderLayout.NORTH);
        centre.add(infos);

        panel.setLayout(new BorderLayout());
        
        panel.add(annonce, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);
        panel.add(centre);

        getContentPane().add(panel);

        setAlwaysOnTop(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setTitle("Fin Partie");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}