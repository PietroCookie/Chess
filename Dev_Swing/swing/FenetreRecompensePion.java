package swing;

import piece.*;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

/**
 * Classe qui permet de creer une fenetre de recompense de pion
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class FenetreRecompensePion extends JFrame{
    /**
     * Le pion a recompenser
     */
    private Pion piece;
    /**
     * L'echiquier qui appelle cette classe
     */
    private JPanelEchiquier echiquier;

    /**
     * Constructeur par initialisation d'une fenetre de recompense d'un pion
     * @param pion le pion a recompenser
     * @param echiquier L'echiquier qui appelle cette classe
     */
    public FenetreRecompensePion(Pion pion, JPanelEchiquier echiquier){
        super();

        piece = pion;
        this.echiquier = echiquier;
        JPanel panel = new JPanel();
        JPanel recompenses = new JPanel();

        recompenses.setLayout(new GridLayout(1, 4));
        ClicSouris clic = new ClicSouris();
        if(pion.getCamp().equals(Camp.blanc)){
            Case tour = new Case(0, 0, TypePiece.tourBlanc);
                tour.addMouseListener(clic);
            recompenses.add(tour);
            Case fou = new Case(0, 0, TypePiece.fouBlanc);
                fou.addMouseListener(clic);
            recompenses.add(fou);
            Case cavalier = new Case(0, 0, TypePiece.cavalierBlanc);
                cavalier.addMouseListener(clic);
            recompenses.add(cavalier);
            Case reine = new Case(0, 0, TypePiece.reineBlanc);
                reine.addMouseListener(clic);
            recompenses.add(reine);
        }
        else{
            Case tour = new Case(0, 0, TypePiece.tourNoir);
                tour.addMouseListener(clic);
            recompenses.add(tour);
            Case fou = new Case(0, 0, TypePiece.fouNoir);
                fou.addMouseListener(clic);
            recompenses.add(fou);
            Case cavalier = new Case(0, 0, TypePiece.cavalierNoir);
                cavalier.addMouseListener(clic);
            recompenses.add(cavalier);
            Case reine = new Case(0, 0, TypePiece.reineNoir);
                reine.addMouseListener(clic);
            recompenses.add(reine);
        }

        JLabel info = new JLabel("Choisissez la recompense du pion");
        info.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new BorderLayout());
        panel.add(info, BorderLayout.NORTH);
        panel.add(recompenses);

        getContentPane().add(panel);

        setAlwaysOnTop(true);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setTitle("Recompenser le pion");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Classe anonyme qui permet de gerer les evenements de la souris
     */
    class ClicSouris implements java.awt.event.MouseListener{

        /**
         * Permet de recompenser le pion en appelant la fonction recompenserPion de l'echiquier en lui donnant la piece choisit en recompense puis ferme la fenetre
         * @see JPanelEchiquier
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            echiquier.recompenserPion(piece, ((Case)e.getSource()).getPiece());
            dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

    }
}
