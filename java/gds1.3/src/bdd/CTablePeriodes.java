package bdd;

import objets.CPeriode;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CTablePeriodes {
    
    CBdd conn = new CBdd();
    Statement stm;
    ResultSet result;
    DefaultTableModel model = new DefaultTableModel();

    /***************************************************************
    *         Récupérer toutes les données de la table             *
    ***************************************************************/
    
    public ArrayList<CPeriode> selectPeriode(){
        
        ArrayList<CPeriode> listePeriode = new ArrayList ();
        
        try {
            stm = conn.obtenirconnexion().createStatement();
            
            ResultSet result = stm.executeQuery("SELECT * FROM periode");
            
            while(result.next()){
                //construction d'une instance periode
                CPeriode periode = new CPeriode(result.getInt("id"),result.getString("dateDebut"), result.getString("dateFin"), result.getString("dateVisite"), result.getString("poste"), result.getString("activite") , result.getString("noteFormateur") , result.getString("visiteEffectue") , result.getString("idFormateur") , result.getString("idStagiaire") , result.getString("idEntreprise") , result.getString("idTuteur"));
                // ajout de l'instance dans la liste période
                listePeriode.add(periode);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listePeriode;
    }
    
    /***************************************************************
    *               Ajouter une nouvelle ligne                     *
    ***************************************************************/
    
    public void ajoutPeriode(ArrayList<String> listeNouvellePeriode){
        
        try {
            stm = conn.obtenirconnexion().createStatement();
            
            String query = " insert into periode (dateDebut, dateFin, dateVisite, poste, activite , noteFormateur , visiteEffectue, idFormateur, idStagiaire, Entreprise, idTuteur)"
            + " value (?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareCall(query);
            
            int i = 0;
            for (String liste : listeNouvellePeriode) {
                preparedStmt.setString (i+1, listeNouvellePeriode.get(i));
                i++;
            }
            
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    /***************************************************************
    *                      Modifier une ligne                      *
    ***************************************************************/
    
    public void modifPeriode(ArrayList<String> donnee, int id){
        try {
            stm = conn.obtenirconnexion().createStatement();
            
            String query = "update periode set dateDebut = ?, dateFin = ?, dateVisite = ?, poste = ?, activite = ?, noteFormateur = ?, visiteEffectue = ?, idFormateur = ?, idStagiaire = ?, Entreprise = ?, idTuteur = ?";
            
            // Creation de la requete d'insertion dans la base de donnée
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            preparedStmt.setString(1, donnee.get(0));
            preparedStmt.setString(2, donnee.get(1));
            preparedStmt.setString(3, donnee.get(2));
            preparedStmt.setString(4, donnee.get(3));
            preparedStmt.setString(5, donnee.get(4));
            preparedStmt.setString(6, donnee.get(5));
            preparedStmt.setString(7, donnee.get(6));
            preparedStmt.setString(8, donnee.get(7));
            preparedStmt.setString(9, donnee.get(8));           
            preparedStmt.setString(10, donnee.get(9));
            preparedStmt.setInt(11, id);
            
            // execution de la requete
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    /***************************************************************
    *                      Supprimer une ligne                     *
   ***************************************************************/
    
    public void suppPeriode(int id){
        try {
            stm = conn.obtenirconnexion().createStatement();
            
            String query = "delete from periode where id = ?";
            
            // Création de la requête sql de suppression selon l'id
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareCall(query);
            
            preparedStmt.setInt(1, id);
            
            // execution de la requête sql de suppression selon l'id
            preparedStmt.execute();
        } catch (Exception e){
            System.err.println(e);
        }
    }
           
    
    
}
