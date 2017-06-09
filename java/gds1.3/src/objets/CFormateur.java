/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

import java.util.ArrayList;

/**
 *
 * @author antoine
 */
public class CFormateur {
      private final int id;
    private final String nom;
    private final String prenom;
    private final String mail;
    private final String tel;
    private final String login;
    private final String password;
    private final String[] donneesTab; 



 //Constructeur ************************************************************
    
    public CFormateur(int id,String nom, String prenom, String mail, String tel, String login, String password) {
        
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.login = login;
        this.password = password;
        this.donneesTab = new String[6];
        donneesTab[0]=nom;
        donneesTab[1]=prenom;
        donneesTab[2]=mail;
        donneesTab[3]=tel;
        donneesTab[4]=login; 
        donneesTab[5]=password; 
    }

public CFormateur(int id,ArrayList<String> donneeFormateur) {
        this.id = id;  
        this.nom = donneeFormateur.get(0);
        this.prenom = donneeFormateur.get(1);
        this.mail = donneeFormateur.get(2);
        this.tel = donneeFormateur.get(3);
        this.login = donneeFormateur.get(4);
        this.password = donneeFormateur.get(5);
        this.donneesTab = new String[6];
        donneesTab[0]= donneeFormateur.get(0);
        donneesTab[1]=donneeFormateur.get(1);
        donneesTab[2]=donneeFormateur.get(2);
        donneesTab[3]=donneeFormateur.get(3);
        donneesTab[4]=donneeFormateur.get(4);
        donneesTab[5]=donneeFormateur.get(5);
    }

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