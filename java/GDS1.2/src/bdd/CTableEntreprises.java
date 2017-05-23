
package bdd;
import objets.CEntreprise;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CTableEntreprises {
    
    CBdd conn = new CBdd();
    Statement stm;
    ResultSet result;
    DefaultTableModel model = new DefaultTableModel();

     /***************************************************************
    *         Récupérer toutes les données de la table             *
   ***************************************************************/
    
    public ArrayList<CEntreprise> selectEntreprise() {
        
        ArrayList<CEntreprise> listeEntreprises = new ArrayList(); 

        try {
            stm = conn.obtenirconnexion().createStatement();
            
            ResultSet result = stm.executeQuery("SELECT * FROM entreprise");

            while(result.next()){  
                //contruction d'une instance entreprise
                CEntreprise entreprise = new CEntreprise(result.getInt("id"),result.getString("nom"), result.getString("adNum"), result.getString("adRue"), result.getString("adVille"), result.getString("adCP"), result.getString("tel"), result.getString("mail"), result.getString("siret"), result.getString("ape") );
                //ajout de l'instance dans la liste d'entreprises
                listeEntreprises.add(entreprise);
           }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
          return listeEntreprises;
    }
    
     /***************************************************************
    *               Ajouter une nouvelle ligne                     *
   ***************************************************************/
    
    public void ajoutEntreprise(ArrayList<String> listeNouvelleEntreprise){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

            String query = " insert into entreprise (nom,adnum,adrue,adville,adcp,tel,mail,siret,ape)"
              + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.obtenirconnexion().prepareStatement(query);
            
            int i =0;
            for (String liste : listeNouvelleEntreprise){
                preparedStmt.setString (i+1, listeNouvelleEntreprise.get(i));
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
    
    public void modifEntreprise(ArrayList<String> donnee, int id){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

           String query = "update entreprise set nom = ?, adnum = ?, adrue = ?, adville = ?, adcp = ?, tel = ?, mail = ?, siret = ?, ape = ? where id = ?";

            // create the mysql insert preparedstatement
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
            preparedStmt.setInt(10, id);
            

            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (Exception e) {
            System.err.println(e);
        }
 
    }    

     /***************************************************************
    *                      Supprimer une ligne                     *
   ***************************************************************/
    
    public void suppEntreprise(int id){
           
        try {
            stm = conn.obtenirconnexion().createStatement();

            String query = " delete from entreprise where id = ?";
              

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
    
