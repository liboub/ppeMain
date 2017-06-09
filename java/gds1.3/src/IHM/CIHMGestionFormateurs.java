package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CIHMGestionFormateurs {
    
    CIHMGestionFormateurs instance;
    private JPanel panneauPrincipal;
    private JTable tableau;

     /****************************************
    *           Constructeur                * 
    ****************************************/
    
    public CIHMGestionFormateurs(){
        instance=this;
        //construction du panneau
        this.pannneauPrincipal();
        //construction du tableau
        this.tableau(); 
    }
    
     /****************************************
    *        Panneau principal              * 
    ****************************************/
    
    private JPanel pannneauPrincipal(){
        panneauPrincipal = new JPanel();
        panneauPrincipal.setBackground(Color.MAGENTA);
        
        JLabel titre = new JLabel("Gestion des formateurs");
        
        panneauPrincipal.add(titre);
         
        return panneauPrincipal;
    }
    
     /****************************************
    *           Tableau                     * 
    ****************************************/
    
    private JTable tableau(){
        tableau = new JTable();
        
        return tableau;
    }
    
    
     /****************************************
    *           Getters                      * 
    ****************************************/
    

    public CIHMGestionFormateurs getInstance() {
        return instance;
    }

    public JPanel getPanneauPrincipal() {
        return panneauPrincipal;
    }

    public JTable getTableau() {
        return tableau;
    }
   
}
