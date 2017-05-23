package objets;

import java.util.ArrayList;

public class CEntreprise {
    
    private final int id;
    private final String nom;
    private final String adNum;
    private final String adRue;
    private final String adVille;
    private final String adCP;
    private final String tel;
    private final String mail;
    private final String siret;
    private final String ape;
    private final String[] donneesTab; 

    //Constructeur ************************************************************
    
    public CEntreprise(int id,String nom, String adNum, String adRue, String adVille, String adCP, String tel, String mail, String siret, String ape) {
        
        this.id = id;
        this.nom = nom;
        this.adNum = adNum;
        this.adRue = adRue;
        this.adVille = adVille;
        this.adCP = adCP;
        this.tel = tel;
        this.mail = mail;
        this.siret = siret;
        this.ape = ape;
        this.donneesTab = new String[4];
        donneesTab[0]=nom;
        donneesTab[1]=adVille;
        donneesTab[2]=adCP;
        donneesTab[3]=tel;        
    }
    
      public CEntreprise(int id,ArrayList<String> donneeEntreprise) {
        this.id = id;  
        this.nom = donneeEntreprise.get(0);
        this.adNum = donneeEntreprise.get(1);
        this.adRue = donneeEntreprise.get(2);
        this.adVille = donneeEntreprise.get(3);
        this.adCP = donneeEntreprise.get(4);
        this.tel = donneeEntreprise.get(5);
        this.mail = donneeEntreprise.get(6);
        this.siret = donneeEntreprise.get(7);
        this.ape = donneeEntreprise.get(8);
        this.donneesTab = new String[4];
        donneesTab[0]= donneeEntreprise.get(0);
        donneesTab[1]=donneeEntreprise.get(3);
        donneesTab[2]=donneeEntreprise.get(4);
        donneesTab[3]=donneeEntreprise.get(5);
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

    public String getAdNum() {
        return adNum;
    }

    public String getAdRue() {
        return adRue;
    }

    public String getAdVille() {
        return adVille;
    }

    public String getAdCP() {
        return adCP;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getSiret() {
        return siret;
    }

    public String getApe() {
        return ape;
    }
    
     
}
