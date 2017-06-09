
package bdd;

import java.sql.*;

public class CBdd {
    
   Connection con;
    public CBdd(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException e){
    System.err.println(e);
//pour afficher l erreur
    }
    try{
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gds","root","");
    }catch(SQLException e){System.err.println(e);}
    }
    
    Connection obtenirconnexion(){return con;}

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    


