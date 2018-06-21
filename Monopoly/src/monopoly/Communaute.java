/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author crosv
 */
public class Communaute {
    
    private ArrayList<Carte> cartes = new ArrayList<>();

    public Communaute() {
        cartes.add(new Carte("Liberer prison Co"));
        cartes.add(new Carte("Payer 10"));
        cartes.add(new Carte("Tout le monde vous donne 10"));
        cartes.add(new Carte("Gagner 200"));
        cartes.add(new Carte("Aller a Belleville"));
        cartes.add(new Carte("Payer 50"));
        cartes.add(new Carte("Gagner 20"));
        cartes.add(new Carte("Payer 100"));
        cartes.add(new Carte("Gagner 100"));
        cartes.add(new Carte("Aller en prison"));
        cartes.add(new Carte("Payer 50"));
        cartes.add(new Carte("Gagner 50"));
        cartes.add(new Carte("Aller au depart"));
        cartes.add(new Carte("Gagner 25"));
        cartes.add(new Carte("Gagner 100"));
        cartes.add(new Carte("Gagner 10"));
        Collections.shuffle(cartes);
        
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
    
    
    
    
    
}
