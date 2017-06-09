/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import objets.CStagiaire;

/**
 *
 * @author Kévin Le Saint
 */
public class CTableStagiaire {
    

  CBdd conn = new CBdd();
    Statement stm;
    ResultSet result;
    DefaultTableModel model = new DefaultTableModel();

     /***************************************************************
    *         Récupérer toutes les données de la table             *
   ***************************************************************/
    
    public ArrayList<CStagiaire> selectStagiaire() {
        
        ArrayList<CStagiaire> listeStagiaire = new ArrayList(); 

        try {
            stm = conn.obtenirconnexion().createStatement();
            
            ResultSet result = stm.executeQuery("SELECT * FROM stagiaire");

            while(result.next()){  
                //contruction d'une instance entreprise
                CStagiaire stagiaire = new CStagiaire(result.getInt("id"),result.getString("nom"), result.getString("prenom"), result.getString("mail"), result.getString("tel"), result.getString("login"), result.getString("password") );
                //ajout de l'instance dans la liste d'entreprises
                listeStagiaire.add(stagiaire);
           }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
          return listeStagiaire;
    }
    
     /***************************************************************
    *               Ajouter une nouvelle ligne                     *
   ***************************************************************/
    
    public void ajoutStagiaire(ArrayList<String> listeNouveauStagiaire){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

            String query = " insert into stagiaire (nom,prenom,mail,tel,login,password)"
              + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            
            int i =0;
            for (String liste : listeNouveauStagiaire){
                preparedStmt.setString (i+1, listeNouveauStagiaire.get(i));
                i++;
            }

            // execute the preparedstatement
            preparedStmt.execute();     
        } catch (Exception e) {
            System.err.println(e);
        }
 
    }

     /***************************************************************
    *                      Modifier une ligne                      *
   ***************************************************************/
    
    public void modifStagiaire(ArrayList<String> donnee, int id){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

           String query = "update stagiaire set nom = ?, prenom = ?, mail = ?, tel = ?, login = ?, password = ? where id = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            preparedStmt.setString(1, donnee.get(0));
            preparedStmt.setString(2, donnee.get(1));
            preparedStmt.setString(3, donnee.get(2));
            preparedStmt.setString(4, donnee.get(3));
            preparedStmt.setString(5, donnee.get(4));
            preparedStmt.setString(6, donnee.get(5));

            preparedStmt.setInt(6, id);
            

            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (Exception e) {
            System.err.println(e);
        }
 
    }    

     /***************************************************************
    *                      Supprimer une ligne                     *
   ***************************************************************/
    
    public void suppStagiaire(int id){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

            String query = " delete from stagiaire where id = ?";
              

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            
            preparedStmt.setInt(1, id);

            // execute the preparedstatement
            preparedStmt.execute();     
        } catch (Exception e) {
            System.err.println(e);
        }
 
    }    
 
}




