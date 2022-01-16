package swing;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe qui gere une fenetre d'erreur
 * Elle etend JFrame
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class FenetreErreur extends JFrame{
    /**
     * Constructeur par initialisation d'une fenetre d'erreur qui doit s'afficher sur une FenetreJeux
     * @param windowsJeux la fenetre de jeux
     * @param message le message a afficher dans la fenetre
     * @see FenetreJeux
     */
    public FenetreErreur(FenetreJeux windowsJeux, String message){

        try{
            File file = new File("music" + File.separator + "error.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.loop(0);
        } catch (UnsupportedAudioFileException ev) {
            ev.printStackTrace();
        } catch (LineUnavailableException ev) {
            ev.printStackTrace();
        } catch(IOException ev){
            ev.printStackTrace();
        }
        
        JButton[] options = {new JButton("Ok")};
        ((JButton) options[0]).addActionListener(e -> {windowsJeux.getEchiquier().restart(); windowsJeux.getInfoPartie().restart(); dispose(); });
        JOptionPane.showOptionDialog(this,
        message,
        "Erreur",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.ERROR_MESSAGE, null,
        options, options[0]);
        
    }

    /**
     * Constructeur par initialisation qui permet de creer une fenetre d'erreur avec un message specifique
     * @param message le message a afficher
     */
    public FenetreErreur(String message){

        try{
            File file = new File("music" + File.separator + "error.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.loop(0);
        } catch (UnsupportedAudioFileException ev) {
            ev.printStackTrace();
        } catch (LineUnavailableException ev) {
            ev.printStackTrace();
        } catch(IOException ev){
            ev.printStackTrace();
        }

        JOptionPane.showMessageDialog(this,
        message,
        "Erreur",
        JOptionPane.ERROR_MESSAGE);
        
    }
}
