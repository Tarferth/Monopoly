/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import monopoly.Propriete;

/**
 *
 * @author crosv
 */
public class Vue_Est extends JPanel {

    private JFrame f;
    private List liste;

    public Vue_Est() {
        //  f = new JFrame();
        //  f.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4, Toolkit.getDefaultToolkit().getScreenSize().height);
        liste = new List();
        this.setLayout(new BorderLayout());

        //f.add(this);
    }

    public List getListe() {
        return liste;
    }
    

    public void afficher() {
        f.setVisible(true);
    }



    public void setListe(ArrayList<Propriete> listePropriete) {
        if (this.getListe().getItemCount() > 0) {
            this.getListe().removeAll();
        }
        for (int i = 0; i < listePropriete.size(); i++) {

            this.liste.add(listePropriete.get(i).getNom());
        }
        this.add(liste);

    }
    

    
}
