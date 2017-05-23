
package IHM;

import objets.CEntreprise;
import bdd.CTableEntreprises;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public final class CIHMGestionEntreprises {
    
    //accès à la table entreprise de la base de donnée
    private final CTableEntreprises tableBDD = new CTableEntreprises();

    //Collection des entreprises
    private final ArrayList<CEntreprise> collectionEntreprises = new CTableEntreprises().selectEntreprise();
    
    //tableau
    private DefaultTableModel model;
    private JTable tableauEntreprise;
    private final JPanel panneauTableauEntreprise = new JPanel();
    
    //Fenêtres
    private JFrame ihmAjoutEntreprise = new JFrame();
    private JFrame ihmAfficherEntreprise = new JFrame();
    private JFrame ihmEditerEntreprise = new JFrame();
    private JFrame ihmSuppEntreprise = new JFrame();
    private JPanel panneauPrincipal = new JPanel();
    
    //Message en haut de page indiquant les différentes actions 
    private final JLabel message = new JLabel("");
    
    //Champs pour formulaires création et modification d'entreprise
    private final JTextField nomR = new JTextField(30);
    private final JTextField adNumR = new JTextField(30);
    private final JTextField adRueR = new JTextField(30);
    private final JTextField adVilleR = new JTextField(30);
    private final JTextField adCPR = new JTextField(30);
    private final JTextField telR = new JTextField(30);
    private final JTextField mailR = new JTextField(30);
    private final JTextField siretR = new JTextField(30);
    private final JTextField apeR = new JTextField(30);
    
    //Désigne le numéro de ligne sélectionnée
    private int selection/*selection*/;
    
    //instance courante pour avoir accès aux getters
    private final CIHMGestionEntreprises instance;

   
     /***************************************************************
    *                    Constructeur                              *
   ***************************************************************/  
    
    public CIHMGestionEntreprises(){
        instance=this;
        panneauPrincipal = this.buildPannneauPrincipal();
    }
    
    
     /***************************************************************
    *    Panneau principal implémenté dans fenêtre IHMApp          *
   ***************************************************************/
   
    public JPanel buildPannneauPrincipal(){
        panneauPrincipal.setLayout(new BorderLayout());
        panneauPrincipal.setBackground(Color.green);
        
            /**********************************
           *       Titre + message           *
          **********************************/
                JPanel nord = new JPanel();
                nord.setBackground(Color.GREEN);
                nord.setLayout(new BorderLayout());
                
                JLabel titre = new JLabel("Gestion des Entreprises");
                Font policeTitre = new Font("Tahoma", Font.BOLD, 16);
                titre.setFont(policeTitre);
                titre.setForeground(Color.blue);
                titre.setHorizontalAlignment(JLabel.CENTER);
                
                Font policeMessage = new Font("Tahoma", Font.BOLD, 12);
                message.setFont(policeMessage);
                message.setForeground(Color.RED);
                message.setHorizontalAlignment(JLabel.CENTER);

                nord.add(titre, BorderLayout.NORTH);
                nord.add(message, BorderLayout.SOUTH);
    
            /**********************************
           *         Boutons bas de page     *
          **********************************/
                JPanel sud = new JPanel();
                sud.setLayout(new BorderLayout());
                       
                JButton btSelec = new JButton("Afficher l'entreprise sélectionnée");
                btSelec.addActionListener(new OuvrirFenetreAfficher());
                
                JButton btAjouter = new JButton("Ajouter une entreprise");
                btAjouter.addActionListener(new CIHMGestionEntreprises.OuvrirFenetreAjouter());
                
                sud.add(btSelec,BorderLayout.NORTH);
                sud.add(btAjouter,BorderLayout.SOUTH);
        
            /**********************************
           *        implémentation           *
          **********************************/        
                panneauPrincipal.add(nord,BorderLayout.NORTH);
                panneauPrincipal.add(this.tableau(),BorderLayout.CENTER);
                panneauPrincipal.add(sud,BorderLayout.SOUTH);
        
        return panneauPrincipal;
    }
    
     /**************************************************************************
    *     Tableau liste des entreprises impléménté dans Panneau principal     *
   **************************************************************************/
    
    public JPanel tableau(){
        
        //entetes 
        model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Ville");
        model.addColumn("CP");
        model.addColumn("Tel");
 
        //Importation des données 
        for(int i = 0; i < collectionEntreprises.size(); i++){
        model.addRow(collectionEntreprises.get(i).getDonneesTab());
        }
        
        //Création du tableau
        tableauEntreprise = new JTable(model);
  
        //Proporiétés JPanel
        panneauTableauEntreprise.setBackground(Color.GREEN);
        panneauTableauEntreprise.add(new JScrollPane(tableauEntreprise));
        
        return panneauTableauEntreprise;
    } 
    
     /**************************************************
    *      Fenêtre pour ajouter une entreprise        *
   **************************************************/
    class ihmAjoutEntreprise extends JFrame{
        
        public ihmAjoutEntreprise(){
        super();
        setTitle("Editer entreprise");
        setSize(400, 400);
        setLocationRelativeTo(null);
        
        //On définit le layout à utiliser 10 lignes 2 colonnes 5, 5 d'espacement
        this.setLayout(new GridLayout(10, 2, 5,5));
        
        JLabel nom = new JLabel("Raison sociale :");      
        JLabel tel = new JLabel("N° tel :");      
        JLabel mail = new JLabel("Courriel :");  
        JLabel siret = new JLabel("N° SIRET :");
        JLabel ape = new JLabel("Code APE :");
        JLabel adNum = new JLabel("N° de rue :");
        JLabel adRue = new JLabel("Rue :");
        JLabel adCP = new JLabel("Code Postal :");
        JLabel adVille = new JLabel("Ville :");
        JLabel vide = new JLabel("");
        
        JButton btValider = new JButton("Ajouter");
        btValider.addActionListener(new CIHMGestionEntreprises.ValiderAjoutEntreprise());
 
        add(nom);
        add(nomR);
        add(tel);
        add(telR);
        add(mail);
        add(mailR);
        add(siret);
        add(siretR);
        add(ape);
        add(apeR);
        add(adNum);
        add(adNumR);   
        add(adRue);
        add(adRueR);    
        add(adCP);
        add(adCPR);
        add(adVille);
        add(adVilleR);  
        add(vide);
        add(btValider);
            }
        }

     /**************************************************
    *      Fenêtre afficher une entreprise            *
   **************************************************/
     
    class ihmAfficherEntreprise extends JFrame{
        
        private final int i = selection;
        
        public ihmAfficherEntreprise(){
            super();
            setTitle("Détail entreprise");
            setSize(400, 300);
            setLocationRelativeTo(null);
            this.setLayout(new BorderLayout());
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            
            JPanel sud = new JPanel();
            sud.setLayout(new GridLayout());
            
            JButton BtEditer = new JButton("Editer");
            BtEditer.addActionListener(new CIHMGestionEntreprises.EditerEntreprise());
            
            JButton BtSupp = new JButton("Supprimer");
            BtSupp.addActionListener(new CIHMGestionEntreprises.SuppEntreprise());
            
            JButton BtFermer = new JButton("Fermer");
            BtFermer.addActionListener(new CIHMGestionEntreprises.FermerEntreprise());
            
            sud.add(BtEditer);
            sud.add(BtSupp);
            sud.add(BtFermer);
            
            add(this.buildIhmAfficherEntreprise(),BorderLayout.NORTH);
            add(sud,BorderLayout.SOUTH);   
        }
    
        
    public JPanel buildIhmAfficherEntreprise(){
         
        JPanel panel = new JPanel();
        //On définit le layout à utiliser 10 lignes 2 colonnes 5,5 : espacement
        panel.setLayout(new GridLayout(10, 2, 5,5));
    
        JLabel nom = new JLabel("Raison sociale :");      
        JLabel tel = new JLabel("N° tel :");      
        JLabel mail = new JLabel("Courriel :");  
        JLabel siret = new JLabel("N° SIRET :");
        JLabel ape = new JLabel("Code APE :");
        JLabel adNum = new JLabel("N° de rue :");
        JLabel adRue = new JLabel("Rue :");
        JLabel adCP = new JLabel("Code Postal :");
        JLabel adVille = new JLabel("Ville :");
        
        JLabel nomA = new JLabel(collectionEntreprises.get(i).getNom());
        JLabel telA = new JLabel(collectionEntreprises.get(i).getTel());      
        JLabel mailA = new JLabel(collectionEntreprises.get(i).getMail());  
        JLabel siretA = new JLabel(collectionEntreprises.get(i).getSiret());
        JLabel apeA = new JLabel(collectionEntreprises.get(i).getApe());
        JLabel adNumA = new JLabel(collectionEntreprises.get(i).getAdNum());
        JLabel adRueA = new JLabel(collectionEntreprises.get(i).getAdRue());
        JLabel adCPA = new JLabel(collectionEntreprises.get(i).getAdCP());
        JLabel adVilleA = new JLabel(collectionEntreprises.get(i).getAdVille());
        
        panel.add(nom);
        panel.add(nomA);
        panel.add(tel);
        panel.add(telA);
        panel.add(mail);
        panel.add(mailA);
        panel.add(siret);
        panel.add(siretA);
        panel.add(ape);
        panel.add(apeA);
        panel.add(adNum);
        panel.add(adNumA);   
        panel.add(adRue);
        panel.add(adRueA);    
        panel.add(adCP);
        panel.add(adCPA);
        panel.add(adVille);
        panel.add(adVilleA);

        return panel;
     }}

     /**************************************************
    *        Fenêtre éditer une entreprise            *
   **************************************************/
     
    class ihmEditerEntreprise extends JFrame{  
     
        public ihmEditerEntreprise(){
            super();
            setTitle("Editer entreprise");
            setSize(400, 400);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            
            JButton BtModifier = new JButton("Modifier");
            BtModifier.addActionListener(new CIHMGestionEntreprises.ModifierEntreprise());
 
            add(this.buildIhmEditerEntreprise(),BorderLayout.NORTH);
            add(BtModifier,BorderLayout.SOUTH);   
        }
    
        
    public JPanel buildIhmEditerEntreprise(){
         
        JPanel panel = new JPanel();
        //On définit le layout à utiliser 10 lignes 2 colonnes 5,5 : espacement
        panel.setLayout(new GridLayout(10, 2, 5,5));
    
        JLabel nom = new JLabel("Raison sociale :");      
        JLabel tel = new JLabel("N° tel :");      
        JLabel mail = new JLabel("Courriel :");  
        JLabel siret = new JLabel("N° SIRET :");
        JLabel ape = new JLabel("Code APE :");
        JLabel adNum = new JLabel("N° de rue :");
        JLabel adRue = new JLabel("Rue :");
        JLabel adCP = new JLabel("Code Postal :");
        JLabel adVille = new JLabel("Ville :");
 
        panel.add(nom);
        panel.add(nomR);
        panel.add(tel);
        panel.add(telR);
        panel.add(mail);
        panel.add(mailR);
        panel.add(siret);
        panel.add(siretR);
        panel.add(ape);
        panel.add(apeR);
        panel.add(adNum);
        panel.add(adNumR);   
        panel.add(adRue);
        panel.add(adRueR);    
        panel.add(adCP);
        panel.add(adCPR);
        panel.add(adVille);
        panel.add(adVilleR);  

        return panel;
     }}
    
    
     /**************************************************
    *        Fenêtre supprimer une entreprise         *
   **************************************************/
    
    class ihmSuppEntreprise extends JFrame{  
    
        public ihmSuppEntreprise(){
            super();
            setTitle("Suppression");
            setSize(300, 100);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            
            JLabel texte = new JLabel("Vous allez supprimer l'entreprise " + collectionEntreprises.get(selection).getNom());
            
            JButton BtConf = new JButton("Confirmer");
            BtConf.addActionListener(new CIHMGestionEntreprises.ConfSuppEntreprise());

            this.add(texte,BorderLayout.NORTH);
            this.add(BtConf,BorderLayout.SOUTH);
            
     }}       
    

     /*******************************************************************************************************************************************
    *                                Traitement des actions des boutons                                                                        *
   *******************************************************************************************************************************************/   
    
            /**************************************************
           *         Bouton ouvrir fenêtre ajouter           *
          **************************************************/ 
           class OuvrirFenetreAjouter implements ActionListener{
               public void actionPerformed(ActionEvent arg0) {
                   
                   //On vide les champs de leurs contenu
                   instance.getNomR().setText("");
                   instance.getAdNumR().setText("");
                   instance.getAdRueR().setText("");
                   instance.getAdVilleR().setText("");
                   instance.getAdCPR().setText("");
                   instance.getTelR().setText("");
                   instance.getMailR().setText("");
                   instance.getSiretR().setText("");
                   instance.getApeR().setText("");
                  
                   
                   ihmAjoutEntreprise = new ihmAjoutEntreprise();
                   ihmAjoutEntreprise.setVisible(true);
               }
           }
           
         
            /**************************************************
           *     Action après validation ajout entreprise    *
          **************************************************/

           class ValiderAjoutEntreprise implements ActionListener{
               public void actionPerformed(ActionEvent arg0) {

                   //Enregistrement des données récupérées dans un tableau 
                      ArrayList<String> donneeNouvelleEntreprise = new ArrayList();
                      donneeNouvelleEntreprise.add(instance.getNomR().getText());
                      donneeNouvelleEntreprise.add(instance.getAdNumR().getText());
                      donneeNouvelleEntreprise.add(instance.getAdRueR().getText());
                      donneeNouvelleEntreprise.add(instance.getAdVilleR().getText());
                      donneeNouvelleEntreprise.add(instance.getAdCPR().getText());
                      donneeNouvelleEntreprise.add(instance.getTelR().getText());
                      donneeNouvelleEntreprise.add(instance.getMailR().getText());
                      donneeNouvelleEntreprise.add(instance.getSiretR().getText());
                      donneeNouvelleEntreprise.add(instance.getApeR().getText()); 

                  //Envoie du tableau pour enregistrement dans la BDD  
                     tableBDD.ajoutEntreprise(donneeNouvelleEntreprise);     
                      
                  //Envoie du tableau pour ajouter à la collection 
                      int lastId = collectionEntreprises.get(collectionEntreprises.size()-1).getId();
                      collectionEntreprises.add(new CEntreprise(lastId+1,donneeNouvelleEntreprise));

                  //mise a jour du tableau  
                      model.addRow(collectionEntreprises.get(collectionEntreprises.size()-1).getDonneesTab()); 
                        
                  //affiche message pour confirmer l'ajout de l'entreprise   
                     instance.getMessage().setText("L'entreperise "+ instance.getNomR().getText() + " à été ajouté");

                  //on referme la fenêtre ajout entreprise   
                     ihmAjoutEntreprise.dispose();            
               }
            }
    
            /**************************************************
           *                Bouton afficher                  *
          **************************************************/ 
           class OuvrirFenetreAfficher implements ActionListener{
               public void actionPerformed(ActionEvent e) {
                   
                   //on indique la ligne sélectionnée
                   selection = tableauEntreprise.getSelectedRow(); 
                   
                   //message pour indiquer l'entreprise selectionnée
                   instance.getMessage().setText("L'entreprise "+collectionEntreprises.get(selection).getNom()+" est sélectionnée" );                   
                   
                   //on ouvre la fenêtre
                   ihmAfficherEntreprise= new ihmAfficherEntreprise();
                   ihmAfficherEntreprise.setVisible(true);
              }
           }
           
            /**************************************************
           *                  Bouton éditer                  *
          **************************************************/ 
           class EditerEntreprise implements ActionListener{
               public void actionPerformed(ActionEvent e) { 

                   //Message pour indiquer l'entreprise en cours d'édition
                   instance.getMessage().setText("Edition de l'entreprise "+collectionEntreprises.get(selection).getNom() );                   
                   
                   //On remplie le formulaire avec les données actuelles de l'entreprise 
                   instance.getNomR().setText(collectionEntreprises.get(selection).getNom());
                   instance.getAdNumR().setText(collectionEntreprises.get(selection).getAdNum());
                   instance.getAdRueR().setText(collectionEntreprises.get(selection).getAdRue());
                   instance.getAdVilleR().setText(collectionEntreprises.get(selection).getAdVille());
                   instance.getAdCPR().setText(collectionEntreprises.get(selection).getAdCP());
                   instance.getTelR().setText(collectionEntreprises.get(selection).getTel());
                   instance.getMailR().setText(collectionEntreprises.get(selection).getMail());
                   instance.getSiretR().setText(collectionEntreprises.get(selection).getSiret());
                   instance.getApeR().setText(collectionEntreprises.get(selection).getApe());
                   
                   //On affiche la fenêtre 
                   ihmEditerEntreprise= new ihmEditerEntreprise();
                   ihmEditerEntreprise.setVisible(true);
              }
           }
 
           /********************************************************
          *    Action après validation modification entreprise    *
         ********************************************************/

           class ModifierEntreprise implements ActionListener{
               public void actionPerformed(ActionEvent arg0) {                 
                    
                   //Enregistrement des données récupérées dans un tableau
                      ArrayList<String> donneeModif = new ArrayList();
                      donneeModif.add(instance.getNomR().getText());
                      donneeModif.add(instance.getAdNumR().getText());
                      donneeModif.add(instance.getAdRueR().getText());
                      donneeModif.add(instance.getAdVilleR().getText());
                      donneeModif.add(instance.getAdCPR().getText());
                      donneeModif.add(instance.getTelR().getText());
                      donneeModif.add(instance.getMailR().getText());
                      donneeModif.add(instance.getSiretR().getText());
                      donneeModif.add(instance.getApeR().getText());
                    
                    //Modification dans la base de donnée
                    tableBDD.modifEntreprise(donneeModif, instance.collectionEntreprises.get(selection).getId());   
                    
                   //Modification dans la collection 
                     int id = collectionEntreprises.get(selection).getId();
                     collectionEntreprises.set(selection, new CEntreprise(id,donneeModif));
           
                  //mise a jour du tableau 
                     model.setValueAt(collectionEntreprises.get(selection).getNom(), selection, 0);
                     model.setValueAt(collectionEntreprises.get(selection).getAdVille(), selection, 1);
                     model.setValueAt(collectionEntreprises.get(selection).getAdCP(), selection, 2);
                     model.setValueAt(collectionEntreprises.get(selection).getTel(), selection, 3);
                               
                  //affiche message pour confirmer mofification de l'entreprise   
                     instance.getMessage().setText("L'entreperise "+ instance.getCollectionEntreprises().get(selection).getNom() + " à été modifiée");
                     
                  //on referme la fenêtre ajout entreprise   
                  ihmEditerEntreprise.dispose();
                  ihmAfficherEntreprise.dispose();
   
               }
            }            

           
            /**************************************************
           *               Bouton supprimer                  *
          **************************************************/ 
           class SuppEntreprise implements ActionListener{
               public void actionPerformed(ActionEvent e) {       
                   
                   ihmSuppEntreprise = new ihmSuppEntreprise();
                   ihmSuppEntreprise.setVisible(true);
              }
           } 
           
           
            /**************************************************
           *         Bouton valider suppression              *
          **************************************************/ 
           class ConfSuppEntreprise implements ActionListener{
               public void actionPerformed(ActionEvent e) { 

                  //Suppression dans la BDD  
                     tableBDD.suppEntreprise(collectionEntreprises.get(selection).getId());  
                     
                  //Suppression dans la collection
                     String nomEntrepriseSupp = collectionEntreprises.get(selection).getNom();
                     collectionEntreprises.remove(selection);
                     
                  //mise a jour du tableau 
                     model.removeRow(selection);   
                        
                  //affiche message pour confirmer suppression de l'entreprise   
                     instance.getMessage().setText("L'entreprise "+nomEntrepriseSupp+" à été supprimée");
                     
                  //on referme la fenêtre supp entreprise   
                     ihmAfficherEntreprise.dispose();
                     ihmSuppEntreprise.dispose();
 
              }
           }  
           
 
            /**************************************************
           *             Bouton fermer affichage             *
          **************************************************/ 
           class FermerEntreprise implements ActionListener{
               public void actionPerformed(ActionEvent e) { 
               
                  //message vide   
                     instance.getMessage().setText("");
                     
                  //on referme la fenêtre affichage   
                     ihmAfficherEntreprise.dispose();
              }
           } 
           
     /*******************************************************************************************************************************************
    *                                Getters                                                                                                   *
   *******************************************************************************************************************************************/     

     public JPanel getPanneauPrincipal() {
        return panneauPrincipal;
    }
    

    public JLabel getMessage() {
        return message;
    }

    public  CIHMGestionEntreprises getInstance() {
        return instance;
    }


    public ArrayList<CEntreprise> getCollectionEntreprises() {
        return collectionEntreprises;
    }
    
    
        public JTextField getNomR() {
        return nomR;
    }

    public JTextField getAdNumR() {
        return adNumR;
    }

    public JTextField getAdRueR() {
        return adRueR;
    }

    public JTextField getAdVilleR() {
        return adVilleR;
    }

    public JTextField getAdCPR() {
        return adCPR;
    }

    public JTextField getTelR() {
        return telR;
    }

    public JTextField getMailR() {
        return mailR;
    }

    public JTextField getSiretR() {
        return siretR;
    }

    public JTextField getApeR() {
        return apeR;
    }
}

