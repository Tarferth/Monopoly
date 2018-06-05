/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fourrieq
 */

public class Plateau {
    private ArrayList<Cellule> cellules;
    private HashMap<Integer,Propriete> achetables;

    public Plateau(ArrayList<Cellule> cellules) {
        this.cellules = cellules;
        
    }

    public Plateau() {
    }
    
}
