/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

import java.util.ArrayList;

/**
 *
 * @author Kévin Le Saint
 */
public class CStagiaire {
    

    private final int id;
    private final String nom;
    private final String prenom;
    private final String mail;
    private final String tel;
    private final String login;
    private final String password;
    private final String[] donneesTab; 

    //Constructeur ************************************************************
    
    public CStagiaire(int id,String nom, String prenom, String mail, String tel, String login, String password) {
        
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.donneesTab = new String[4];
        donneesTab[0]=nom;
        donneesTab[1]=prenom;
        donneesTab[2]=mail;
        donneesTab[3]=tel;        
        donneesTab[4]=login;
        donneesTab[5]=password;
    
    }
    
      public CStagiaire(int id,ArrayList<String> donneeStagiaire) {
        this.id = id;  
        this.nom = donneeStagiaire.get(0);
        this.prenom = donneeStagiaire.get(1);
        this.mail = donneeStagiaire.get(2);
        this.tel = donneeStagiaire.get(3);
        this.login = donneeStagiaire.get(4);
        this.password = donneeStagiaire.get(5);
  
        this.donneesTab = new String[6];
        donneesTab[0]= donneeStagiaire.get(0);
        donneesTab[1]=donneeStagiaire.get(1);
        donneesTab[2]=donneeStagiaire.get(2);
        donneesTab[3]=donneeStagiaire.get(3);
        donneesTab[4]=donneeStagiaire.get(4);
        donneesTab[5]=donneeStagiaire.get(5);
      
      }
    
    //Getter *****************************************************************

    public String[] getDonneesTab() {
        return donneesTab;
    }

    public int getId() {
        return id;
    }
      
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

     
}




