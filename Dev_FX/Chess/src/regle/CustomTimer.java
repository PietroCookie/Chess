package regle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TimerTask;

/**
 * Classe permettant la gestion d'un chronometre a l'aide d'un Timer. Cette classe etend la classe TimerTask
 * 
 * @author Pierre CHEMIN
 * @version 1.0
 */
public class CustomTimer extends TimerTask implements Serializable{

    /**
     * Entier contenant la valeur en seconde du chrono initial
     */
    private int timeBase;
    /**
     * Entier permettant de savoir ou on en ait dans le decompte
     */
    private int decompte;
    /**
     * Booleen qui permet de savoir si le chrono doit defiler ou non
     */
    private boolean defiler;
    /**
     * Le nom du chrono
     */
    private String name;

    /**
     * Constructeur par initialisation permettant de creer un chrono avec un nom et son temps.
     * Ecrie dans le fichier txt au nom du chrono dans le dossier "game" l'objet CustomTimer
     * @param time temps du decompte
     * @param name nom du chrono
     */
    public CustomTimer(int time, String name){
        this.timeBase = time;
        this.decompte = time;
        this.defiler = false;
        this.name = name;
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + name + ".txt")));
            ecriture.writeObject(this);
            ecriture.close();
        } catch (IOException ev) {
            ev.printStackTrace();
        }
    }

    /**
     * Permet de modifier le temps initial du chrono
     * Ecrie dans le fichier txt au nom du chrono dans le dossier "game" l'objet CustomTimer
     * @param time le nouveau temps initial
     */
    public void setTimeBase(int time){
        this.timeBase = time;
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + name + ".txt")));
            ecriture.writeObject(this);
            ecriture.close();
        } catch (IOException ev) {
            ev.printStackTrace();
        }
    }

    /**
     * Permet de mettre en route le defilement du chrono
     * Ecrie dans le fichier txt au nom du chrono dans le dossier "game" l'objet CustomTimer
     */
    public void Play(){
        defiler = true;

        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + name + ".txt")));
            ecriture.writeObject(this);
            ecriture.close();
        } catch (IOException ev) {
            ev.printStackTrace();
        }
    }

    /**
     * Permet de mettre en pause le defilement du chrono
     * Ecrie dans le fichier txt au nom du chrono dans le dossier "game" l'objet CustomTimer
     */
    public void Pause(){
        defiler = false;

        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + name + ".txt")));
            ecriture.writeObject(this);
            ecriture.close();
        } catch (IOException ev) {
            ev.printStackTrace();
        }
    }

    /**
     * Remet le chrono a la valeur du temps initial et stop le defilement
     * Ecrie dans le fichier txt au nom du chrono dans le dossier "game" l'objet CustomTimer
     */
    public void Restart(){
        decompte = timeBase;
        defiler = false;
        ObjectOutputStream ecriture;
        try {
            ecriture = new ObjectOutputStream(
                new FileOutputStream(
                    new File("game" + File.separator + name + ".txt")));
            ecriture.writeObject(this);
            ecriture.close();
        } catch (IOException ev) {
            ev.printStackTrace();
        }
    }

    /**
     * Permet de connaitre ou en est le decompte du chrono
     * @return le decompte du chrono
     */
    public int getDecompte() {
        return decompte;
    }

    /**
     * Permet d'avoir le temps restant en minutes et secondes dans une chaine de caractere
     * @return une chaine contenant le temps restant en minutes et secondes
     */
    public String getTime(){
        String chaine = ""; 

        int min = (int) decompte/60;
        int s = decompte - min*60;
        chaine += min + " : " + s;

        return chaine;
    }

    /**
     * Fonction qui tourne en boucle et qui permet le defilement du chrono
     * Elle lit le fichier txt au nom du chrono dans le dossier "game"
     * Si l'attribut defiler a la valeur true alors le chrono defile et ecrie dans le fichier txt au nom du chrono dans le dossier "game" l'objet CustomTimer sinon ne fait rien
     * Une fois que le chrono arrive a 0 il ne defilera plus
     */
    @Override
    public void run() {
        ObjectInputStream lecture;
        try{
            lecture = new ObjectInputStream(
                new FileInputStream(
                    new File("game" + File.separator + name + ".txt")));
                
            CustomTimer ref = (CustomTimer) lecture.readObject();

            if(timeBase != ref.timeBase){
                this.timeBase = ref.timeBase;
                this.Restart();
            }
            
            defiler = ref.defiler;

            lecture.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        if(defiler){

            decompte--;
            
            if(decompte <= 0){
                defiler = false;
            }

            ObjectOutputStream ecriture;
            try {
                ecriture = new ObjectOutputStream(
                    new FileOutputStream(
                        new File("game" + File.separator + name + ".txt")));
                ecriture.writeObject(this);
                ecriture.close();
            } catch (IOException ev) {
                ev.printStackTrace();
            }
            
        }
    }
}
