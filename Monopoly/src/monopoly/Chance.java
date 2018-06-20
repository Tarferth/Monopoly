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
public class Chance {
    private ArrayList<Carte> cartes = new ArrayList<>();

    public Chance() {
        cartes.add(new Carte("Liberer prison"));
        cartes.add(new Carte("Reculez de 3 cases"));
        cartes.add(new Carte("Payer 15"));
        cartes.add(new Carte("Reparations"));
        cartes.add(new Carte("Payer 20"));
        cartes.add(new Carte("Aller au depart"));
        cartes.add(new Carte("Aller en prison"));
        cartes.add(new Carte("Deplacer Henri-Martin"));
        cartes.add(new Carte("Deplacer gare de lyon"));
        cartes.add(new Carte("Payer 150"));
        cartes.add(new Carte("Gagner 100"));
        cartes.add(new Carte("Gagner 50"));
        cartes.add(new Carte("Aller rue de la paix"));
        cartes.add(new Carte("Gagner 150"));
        cartes.add(new Carte("Deplacer Villette"));
        cartes.add(new Carte("Impots voirie"));
        Collections.shuffle(cartes);
        
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
    
   
}
