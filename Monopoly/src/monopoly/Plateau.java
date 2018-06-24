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
        cellules.get(0).setNom("Départ");
        cellules.get(1).setPropriete(new Terrain("PINK",2,60,50,"Boulevard de Belleville",cellules.get(1),10,30,90,160,250));
        cellules.get(2).setNom("Caisse de communauté");
        cellules.get(3).setPropriete(new Terrain ("PINK",4,60,50,"Rue Lecourbe",cellules.get(3),20,60,180,320,450));
        cellules.get(4).setImpot(new Impôt ("Impôts sur le revenu",200));
        cellules.get(5).setPropriete(new Gare (200,"Gare MontParnasse",cellules.get(5)));
        cellules.get(6).setPropriete(new Terrain ("CYAN",6,100,50,"Rue de Vaugirard",cellules.get(6),30,90,270,400,550));
        cellules.get(7).setNom("Chance");
        cellules.get(8).setPropriete(new Terrain ("CYAN",6,100,50,"Rue de Courcelles",cellules.get(8),30,90,270,400,550));
        cellules.get(9).setPropriete(new Terrain ("CYAN",8,120,50,"Avenue de la République",cellules.get(9),40,100,300,450,600));
        cellules.get(10).setNom("Prison");
        cellules.get(11).setPropriete(new Terrain ("PURPLE",10,140,100,"Boulevard de la Villette",cellules.get(11),50,150,450,625,750));
        cellules.get(12).setPropriete(new Compagnie (150,"Compagnie de distribution d'electricité",cellules.get(12)));
        cellules.get(13).setPropriete(new Terrain ("PURPLE",10,140,100,"Avenue de Neuilly",cellules.get(13),50,150,450,625,750));
        cellules.get(14).setPropriete(new Terrain ("PURPLE",12,160,100,"Rue de Paradis",cellules.get(14),60,180,500,700,900));
        cellules.get(15).setPropriete(new Gare (200,"Gare de Lyon",cellules.get(15)));
        cellules.get(16).setPropriete(new Terrain ("ORANGE",14,180,100,"Avenue Mozart",cellules.get(16),70,200,550,750,950));
        cellules.get(17).setNom("Caisse de communauté");
        cellules.get(18).setPropriete(new Terrain ("ORANGE",14,180,100,"Boulevard Saint-Michel",cellules.get(18),70,200,550,750,950));
        cellules.get(19).setPropriete(new Terrain ("ORANGE",16,200,100,"Place Pigalle",cellules.get(19),80,220,600,800,1000));
        cellules.get(20).setNom("Parc gratuit");
        cellules.get(21).setPropriete(new Terrain ("RED",18,220,150,"Avenue Matignon",cellules.get(21),90,250,700,875,1050));
        cellules.get(22).setNom("Chance");
        cellules.get(23).setPropriete(new Terrain ("RED",18,220,150,"Boulevard Malherbes",cellules.get(23),90,250,700,875,1050));
        cellules.get(24).setPropriete(new Terrain ("RED",20,240,150,"Avenue Henri-Martin",cellules.get(24),100,300,750,925,1100));
        cellules.get(25).setPropriete(new Gare (200,"Gare du Nord",cellules.get(25)));
        cellules.get(26).setPropriete(new Terrain ("YELLOW",22,260,150,"Faubourg Saint-Honoré",cellules.get(26),110,330,800,975,1150));
        cellules.get(27).setPropriete(new Terrain ("YELLOW",22,260,150,"Place de la bourse",cellules.get(27),110,330,800,975,1150));
        cellules.get(28).setPropriete(new Compagnie (150,"Compagnie de distribution d'eau",cellules.get(28)));
        cellules.get(29).setPropriete(new Terrain ("YELLOW",24,280,150,"Rue La Fayette",cellules.get(29),120,360,850,1025,1200));
        cellules.get(30).setNom("Allez en prison");
        cellules.get(31).setPropriete(new Terrain ("GREEN",26,300,200,"Avenue de Breteuil",cellules.get(31),130,390,900,1100,1275));
        cellules.get(32).setPropriete(new Terrain ("GREEN",26,300,200,"Avenue Foch",cellules.get(32),130,390,900,1100,1275));
        cellules.get(33).setNom("Caisse de Communauté");
        cellules.get(34).setPropriete(new Terrain ("GREEN",28,320,200,"Boulevard des Capucines",cellules.get(34),150,450,1000,1200,1400));
        cellules.get(35).setPropriete(new Gare (200,"Gare Saint-Lazarre",cellules.get(35)));
        cellules.get(36).setNom("Chance");
        cellules.get(37).setPropriete(new Terrain ("BLUE",35,350,200,"Avenue des Champs-Elysées",cellules.get(37),175,500,1100,1300,1500));
        cellules.get(38).setImpot(new Impôt("Taxe de luxe",100));
        cellules.get(39).setPropriete(new Terrain ("BLUE",50,400,200,"Rue de la Paix",cellules.get(39),200,600,1400,1700,2000));
        
        
        
        
        
        
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
