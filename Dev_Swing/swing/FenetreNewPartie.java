package swing;

import javax.swing.*;

import piece.Camp;

import java.awt.GridLayout;
import java.util.Vector;

/**
 * Classe qui permet de creer une fenetre pour creer une nouvelle partie
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class FenetreNewPartie extends JFrame{

    /**
     * Constructeur par initialisation d'une fenetre qui permet de creer une nouvelle partie
     * @param windows la fenetre principal du jeux
     * @see FenetreJeux
     */
    public FenetreNewPartie(FenetreJeux windows){
        super();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));


        JPanel panelChoixCamp = new JPanel();
        panelChoixCamp.setLayout(new GridLayout(1, 2));
        Vector<Camp> camp = new Vector<Camp>(2, 0);
        JLabel textCamp = new JLabel("Votre camp ?");
        textCamp.setHorizontalAlignment(JLabel.CENTER);
        camp.add(Camp.blanc);
        camp.add(Camp.noir);
        JComboBox<Camp> choixCamp = new JComboBox<Camp>(camp);
        panelChoixCamp.add(textCamp);
        panelChoixCamp.add(choixCamp);


        JPanel panelChrono = new JPanel();
        panelChrono.setLayout(new GridLayout(1, 2));
        Vector<Integer> time = new Vector<Integer>();
        for(int i=15; i<=600; i+=15){
            time.add(i);
        }
        JComboBox<Integer> choixChrono = new JComboBox<Integer>(time);
        choixChrono.setSelectedIndex(19);
        JLabel textChrono = new JLabel("Temps du chrono : (en secondes)");
        textChrono.setHorizontalAlignment(JLabel.CENTER);
        panelChrono.add(textChrono);
        panelChrono.add(choixChrono);

        
        JPanel panelInterface = new JPanel();
        JPanel choixInterface = new JPanel();
        panelInterface.setLayout(new GridLayout(1, 2));
        choixInterface.setLayout(new GridLayout(1, 2));
        JLabel textInterface = new JLabel("Jouer avec deux interfaces ? (Demarrer bien la deuxieme)");
        textInterface.setHorizontalAlignment(JLabel.CENTER);
        ButtonGroup groupChoixInterface = new ButtonGroup();
        JRadioButton buttonTrue = new JRadioButton("oui");
        JRadioButton buttonFalse = new JRadioButton("non");
        groupChoixInterface.add(buttonTrue);
        groupChoixInterface.add(buttonFalse);
        buttonTrue.setSelected(true);
        choixInterface.add(buttonTrue);
        choixInterface.add(buttonFalse);
        panelInterface.add(textInterface);
        panelInterface.add(choixInterface);


        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 2));
        JButton commencer = new JButton("Commencer la partie");
            commencer.addActionListener(e -> {
                 windows.setCamp((Camp)choixCamp.getSelectedItem()); 
                 windows.getInfoPartie().modifierChrono((int)choixChrono.getSelectedItem());
                 if(buttonTrue.isSelected()){
                     windows.getEchiquier().setDualInterface(true);
                 }
                 else if(buttonFalse.isSelected()){
                    windows.getEchiquier().setDualInterface(false);
                 }
                 windows.getEchiquier().restart();
                 windows.getInfoPartie().restart();
                 dispose();
            });
        JButton fermer = new JButton("Fermer");
            fermer.addActionListener(e -> {dispose();});
        JButton quitter = new JButton("Exit");
            quitter.addActionListener(e -> System.exit(0));
        panelButton.add(commencer);
        panelButton.add(fermer);
        panelButton.add(quitter);


        panel.add(panelChoixCamp);
        panel.add(panelChrono);
        panel.add(panelInterface);
        panel.add(panelButton);
        getContentPane().add(panel);

        setSize(700, 250);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setTitle("Nouvelle Partie");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
