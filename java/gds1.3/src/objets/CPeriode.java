package objets;

import java.util.ArrayList;

public class CPeriode {
    
    private final int id;
    private final String dateDebut;
    private final String dateFin;
    private final String dateVisite;
    private final String poste;
    private final String activite;
    private final String noteFormateur;
    private final String visiteEffectue;
    private final String idFormateur;
    private final String idStagiaire;
    private final String idEntreprise;
    private final String idTuteur;
    private final String[] donneesTab; 

    
    //Constructeur ************************************************************
    
    public CPeriode (int id, String dateDebut, String dateFin, String dateVisite, String poste, String activite, String noteFormateur, String visiteEffectue, String idFormateur, String idStagiaire, String idEntreprise, String idTuteur) {
      this.id = id;
      this.dateDebut = dateDebut;
      this.dateFin = dateFin;
      this.dateVisite = dateVisite;
      this.poste = poste;
      this.activite = activite;
      this.noteFormateur = noteFormateur;
      this.visiteEffectue = visiteEffectue;
      this.idFormateur = idFormateur;
      this.idEntreprise = idEntreprise;
      this.idStagiaire = idStagiaire;
      this.idTuteur = idTuteur;
      this.donneesTab = new String[4];
      donneesTab[0]=dateDebut;
      donneesTab[1]=dateFin;
      donneesTab[2]=poste;      
      donneesTab[3]=activite;
    }
    
     public CPeriode (int id, ArrayList<String> donneePeriode) {
      this.id = id;
      this.dateDebut = donneePeriode.get(0);
      this.dateFin = donneePeriode.get(1);
      this.dateVisite = donneePeriode.get(2);
      this.poste = donneePeriode.get(3);
      this.activite = donneePeriode.get(4);
      this.noteFormateur = donneePeriode.get(5);
      this.visiteEffectue = donneePeriode.get(6);
      this.idFormateur = donneePeriode.get(7);
      this.idEntreprise = donneePeriode.get(8);
      this.idStagiaire = donneePeriode.get(9);
      this.idTuteur = donneePeriode.get(10);
      this.donneesTab = new String[4];
      donneesTab[0]=donneePeriode.get(0);
      donneesTab[1]=donneePeriode.get(1);
      donneesTab[2]=donneePeriode.get(3);
      donneesTab[3]=donneePeriode.get(4);
    }

    public int getId() {
        return id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String getDateVisite() {
        return dateVisite;
    }

    public String getPoste() {
        return poste;
    }

    public String getActivite() {
        return activite;
    }

    public String getNoteFormateur() {
        return noteFormateur;
    }

    public String getVisiteEffectue() {
        return visiteEffectue;
    }

    public String getIdFormateur() {
        return idFormateur;
    }

    public String getIdStagiaire() {
        return idStagiaire;
    }

    public String getIdEntreprise() {
        return idEntreprise;
    }

    public String getIdTuteur() {
        return idTuteur;
    }

    public String[] getDonneesTab() {
        return donneesTab;
    }
     
}
