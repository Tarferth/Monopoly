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
    private HashMap<Integer,String> achetables;  // Numero de cellule puis nom de la cellule

    public Plateau() {
        this.cellules = new ArrayList<>();

        int i = 0;
        for (NomCellule n: NomCellule.values()){

            cellules.add(new Cellule(n.toString(),i));
            System.out.println(cellules.get(i).getNomCellule());
            if (this.achetables.containsValue(n)) {
                this.cellules.get(i).setPropriete(new Propriete(i, null, null));
            }
            i++;
        }
        
        
        this.achetables = new HashMap<>();
        achetables.put(1, "Boulevard_de_Belleville");
        achetables.put(3, "Rue_Lecourbe");
        achetables.put(5, "Gare_Montparnasse");
        achetables.put(6, "Rue_de_Vaugirard");
        achetables.put(9, "Rue_de_Courcelles");
        achetables.put(10, "Avenue_de_la_République");
        achetables.put(11, "Boulevard_de_la_Villette");
        achetables.put(12, "Compagnie_de_Distribution_d_electricite");
        achetables.put(13, "Avenue_de_Neuilly");
        achetables.put(14, "Rue_de_Paris");
        achetables.put(15, "Gare_de_Lyon");
        achetables.put(16, "Avenue_Mozart");
        achetables.put(18, "Boulevard_Saint_Michel");
        achetables.put(19, "Place_Pigalle");
        achetables.put(21, "Avenue_Matignon");
        achetables.put(23, "Boulevard_Malesherbes");
        achetables.put(24, "Avenue_Henri_Martin");
        achetables.put(25, "Gare_du_Nord");
        achetables.put(26, "Faubourg_Saint_Honore");
        achetables.put(27, "Place_de_la_Bourse");
        achetables.put(28, "Compagnie_de_distribution_de_l_eau");
        achetables.put(29, "Rue_la_Fayette");
        achetables.put(31, "Avenue_de_Breteuil");
        achetables.put(32, "Avenue_Foch");
        achetables.put(34, "Boulevard_Saint_Lazare");
        achetables.put(35, "Gare_Saint_Lazare");
        achetables.put(37, "Avenue_des_Champs_Elysees");
        achetables.put(39, "Rue_de_la_Paix");    
    }

    public HashMap<Integer, String> getAchetables() {
        return achetables;
    }

    public Cellule getCellule(int nb){
        return this.cellules.get(nb);
    }

    public ArrayList<Cellule> getCellules() {
        return cellules;
    }
    
}
