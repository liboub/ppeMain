/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objets.CFormateur;
/**
 *
 * @author antoine
 */
public class CTableFormateur {
     CBdd conn = new CBdd();
    Statement stm;
    ResultSet result;
    DefaultTableModel model = new DefaultTableModel();

     /***************************************************************
    *         Récupérer toutes les données de la table             *
   ***************************************************************/
    
    public ArrayList<CFormateur> selectFormateur() {
        
        ArrayList<CFormateur> listeFormateurs = new ArrayList(); 

        try {
            stm = conn.obtenirconnexion().createStatement();
            
            ResultSet result = stm.executeQuery("SELECT * FROM formateur");

            while(result.next()){  
                //contruction d'une instance formateur
                CFormateur formateur = new CFormateur(result.getInt("id"),result.getString("nom"), result.getString("prenom")
                        , result.getString("mail") , result.getString("tel") , result.getString("login"), result.getString("password") );
                //ajout de l'instance dans la liste de formateurs
                listeFormateurs.add(formateur);
           }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
          return listeFormateurs;
    }
    
     /***************************************************************
    *               Ajouter une nouvelle ligne                     *
   ***************************************************************/
    
    public void ajoutFormateur(ArrayList<String> listeNouveauFormateur){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

            String query = " insert into formateur (nom,prenom,mail,tel,login,password)"
              + " values (?, ?,?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            
            int i =0;
            for (String liste : listeNouveauFormateur){
                preparedStmt.setString (i+1, listeNouveauFormateur.get(i));
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
    
    public void modifFormateur(ArrayList<String> donnee, int id){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

           String query = "update formateur set nom = ?, prenom = ?, mail = ?, tel = ?, login = ?,  password = ? where id = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            preparedStmt.setString(1, donnee.get(0));
            preparedStmt.setString(2, donnee.get(1));
            preparedStmt.setString(3, donnee.get(2));
            preparedStmt.setString(4, donnee.get(3));
            preparedStmt.setString(5, donnee.get(4));
            preparedStmt.setString(6, donnee.get(5));
            preparedStmt.setInt(7, id);
            

            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (Exception e) {
            System.err.println(e);
        }
 
    }    

     /***************************************************************
    *                      Supprimer une ligne                     *
   ***************************************************************/
    
    public void suppFormateur(int id){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

            String query = " delete from formateur where id = ?";
              

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
