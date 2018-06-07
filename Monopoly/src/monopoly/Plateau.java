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
        
        for(int i = 0;i<41;i++)
        {
            cellules.add(new Cellule(i));
        }
        
        cellules.get(1).setPropriete(new Terrain ("rose",2,60,"Boulevard_de_Belleville",cellules.get(1)));
        cellules.get(3).setPropriete(new Terrain ("rose",4,60,"Rue_Lecourbe",cellules.get(3)));
        cellules.get(5).setPropriete(new Gare (200,"Gare_MontParnasse",cellules.get(5)));
        cellules.get(6).setPropriete(new Terrain ("bleu_clair",6,100,"Rue_de_Vaugirard",cellules.get(6)));
        cellules.get(8).setPropriete(new Terrain ("bleu_clair",6,100,"Rue_de_Courcelles",cellules.get(8)));
        cellules.get(9).setPropriete(new Terrain ("bleu_clair",8,120,"Avenue_de_la_République",cellules.get(9)));
        cellules.get(11).setPropriete(new Terrain ("violet",10,140,"Boulevard_de_la_Villette",cellules.get(11)));
        cellules.get(12).setPropriete(new Compagnie (150,"Compagnie_de_distribution_d'electricité",cellules.get(12)));
        cellules.get(13).setPropriete(new Terrain ("violet",10,140,"Avenue_de_Neuilly",cellules.get(13)));
        cellules.get(14).setPropriete(new Terrain ("violet",12,160,"Rue_de_Paradis",cellules.get(14)));
        cellules.get(15).setPropriete(new Gare (200,"Gare_de_Lyon",cellules.get(15)));
        cellules.get(16).setPropriete(new Terrain ("orange",14,180,"Avenue_Mozart",cellules.get(16)));
        cellules.get(18).setPropriete(new Terrain ("orange",14,180,"Boulevard_Saint-Michel",cellules.get(18)));
        cellules.get(19).setPropriete(new Terrain ("orange",16,200,"Place_Pigalle",cellules.get(19)));
        cellules.get(21).setPropriete(new Terrain ("rouge",18,220,"Avenue_Matignon",cellules.get(21)));
        cellules.get(23).setPropriete(new Terrain ("rouge",18,220,"Boulevard_Malherbes",cellules.get(23)));
        cellules.get(24).setPropriete(new Terrain ("rouge",20,240,"Avenue_Henri-Martin",cellules.get(24)));
        cellules.get(25).setPropriete(new Gare (200,"Gare_du_Nord",cellules.get(25)));
        cellules.get(26).setPropriete(new Terrain ("jaune",22,260,"Faubourg_Saint-Honoré",cellules.get(26)));
        cellules.get(27).setPropriete(new Terrain ("jaune",22,260,"Place_de_la_bourse",cellules.get(27)));
        cellules.get(28).setPropriete(new Compagnie (150,"Compagnie_de_distribution_d'eau",cellules.get(28)));
        cellules.get(29).setPropriete(new Terrain ("jaune",24,280,"Rue_La_Fayette",cellules.get(29)));
        cellules.get(31).setPropriete(new Terrain ("vert",26,300,"Avenue_de_Breteuil",cellules.get(31)));
        cellules.get(32).setPropriete(new Terrain ("vert",26,300,"Avenue_Foch",cellules.get(32)));
        cellules.get(34).setPropriete(new Terrain ("vert",28,320,"Boulevard_des_Capucines",cellules.get(34)));
        cellules.get(35).setPropriete(new Gare (200,"Gare_Saint-Lazarre",cellules.get(35)));
        cellules.get(37).setPropriete(new Terrain ("bleu_fonce",35,350,"Avenue_des_Champs-Elysées",cellules.get(37)));
        cellules.get(39).setPropriete(new Terrain ("bleu_fonce",50,400,"Rue_de_la_Paix",cellules.get(39)));
        
        
        
        
        
        
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
