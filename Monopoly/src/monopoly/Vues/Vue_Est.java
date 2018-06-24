/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        this.setLayout(new BorderLayout());

        //f.add(this);
    }

    public void afficher() {
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Vue_Est exemple1 = new Vue_Est();
        exemple1.afficher();

    }

    public void setListe(ArrayList<Propriete> listePropriete) {
        liste = new List();
        for (int i = 0; i < listePropriete.size(); i++) {

            this.liste.add(listePropriete.get(i).getNom());
        }
        this.add(liste);
    }
}
