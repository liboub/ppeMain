package IHM;

import objets.CStagiaire;
import bdd.CTableStagiaire;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class CIHMGestionStagiaires {
    
   
    //accès à la table entreprise de la base de donnée
    private final CTableStagiaire tableBDD = new CTableStagiaire();

    //Collection des entreprises
    private final ArrayList<CStagiaire> collectionStagiaire = new CTableStagiaire().selectStagiaire();
    
    //tableau
    private DefaultTableModel model;
    private JTable tableauStagiaire;
    private final JPanel panneauTableauStagiaire = new JPanel();
    
    //Fenêtres
    private JFrame ihmAjoutStagiaire = new JFrame();
    private JFrame ihmAfficherStagiaire = new JFrame();
    private JFrame ihmEditerStagiaire = new JFrame();
    private JFrame ihmSuppStagiaire = new JFrame();
    private JPanel panneauPrincipal = new JPanel();
    
    //Message en haut de page indiquant les différentes actions 
    private final JLabel message = new JLabel("");
    
    //Champs pour formulaires création et modification d'entreprise
    private final JTextField nomR = new JTextField(30);
    private final JTextField prenomR = new JTextField(30);
    private final JTextField mailR = new JTextField(30);
    private final JTextField telR = new JTextField(30);
    private final JTextField loginR = new JTextField(30);
    private final JTextField passwordR = new JTextField(30);

    //Désigne le numéro de ligne sélectionnée
    private int selection/*selection*/;
    
    //instance courante pour avoir accès aux getters
    private final CIHMGestionStagiaires instance;

     
     /***************************************************************
    *                    Constructeur                              *
   ***************************************************************/  
    
    public CIHMGestionStagiaires(){
        instance=this;
        panneauPrincipal = this.buildPannneauPrincipal();
    }
    
    
     /***************************************************************
    *    Panneau principal implémenté dans fenêtre IHMApp          *
   ***************************************************************/
   
    public JPanel buildPannneauPrincipal(){
        panneauPrincipal.setLayout(new BorderLayout());
        panneauPrincipal.setBackground(Color.orange);
        
            /**********************************
           *       Titre + message           *
          **********************************/
                JPanel nord = new JPanel();
                nord.setBackground(Color.ORANGE);
                nord.setLayout(new BorderLayout());
                
                JLabel titre = new JLabel("Gestion des Stagiaires");
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
                       
                JButton btSelec = new JButton("Afficher le stagiaire sélectionné");
                btSelec.addActionListener(new OuvrirFenetreAfficher());
                
                JButton btAjouter = new JButton("Ajouter un stagiaire");
                btAjouter.addActionListener(new CIHMGestionStagiaires.OuvrirFenetreAjouter());
                
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
        model.addColumn("Prénom");
        model.addColumn("Mail");
        model.addColumn("Tel");
        model.addColumn("Identifiant");
        model.addColumn("Mot de passe");
        //Importation des données 
        for(int i = 0; i < collectionStagiaire.size(); i++){
        model.addRow(collectionStagiaire.get(i).getDonneesTab());
        }
        
        //Création du tableau
        tableauStagiaire = new JTable(model);
  
        //Proporiétés JPanel
        panneauTableauStagiaire.setBackground(Color.ORANGE);
        panneauTableauStagiaire.add(new JScrollPane(tableauStagiaire));
        
        return panneauTableauStagiaire;
    } 
    
     /**************************************************
    *      Fenêtre pour ajouter une entreprise        *
   **************************************************/
    class ihmAjoutStagiaire extends JFrame{
        
        public ihmAjoutStagiaire(){
        super();
        setTitle("Editer stagiaire");
        setSize(400, 400);
        setLocationRelativeTo(null);
        
        //On définit le layout à utiliser 10 lignes 2 colonnes 5, 5 d'espacement
        this.setLayout(new GridLayout(10, 2, 5,5));
        
        JLabel nom = new JLabel("Nom :");      
        JLabel prenom = new JLabel("Prénom :");      
        JLabel mail = new JLabel("Courriel :");  
        JLabel tel = new JLabel("Tel :");
        JLabel login = new JLabel("Identifiant :");
        JLabel password = new JLabel("Mot de passe :");
           JLabel vide = new JLabel("");
        
        JButton btValider = new JButton("Ajouter");
        btValider.addActionListener(new CIHMGestionStagiaires.ValiderAjoutStagiaire());
 
        add(nom);
        add(nomR);
        add(prenom);
        add(prenomR);
        add(mail);
        add(mailR);
        add(tel);
        add(telR);
        add(login);
        add(loginR);
        add(password);
        add(passwordR);   
        add(vide);
        add(btValider);
            }
        }

     /**************************************************
    *      Fenêtre afficher une entreprise            *
   **************************************************/
     
    class ihmAfficherStagiaire extends JFrame{
        
        private final int i = selection;
        
        public ihmAfficherStagiaire(){
            super();
            setTitle("Détail stagiaire");
            setSize(600, 500);
            setLocationRelativeTo(null);
            this.setLayout(new BorderLayout());
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            
            JPanel sud = new JPanel();
            sud.setLayout(new GridLayout());
            
            JButton BtEditer = new JButton("Editer");
            BtEditer.addActionListener(new CIHMGestionStagiaires.EditerStagiaire());
            
            JButton BtSupp = new JButton("Supprimer");
            BtSupp.addActionListener(new CIHMGestionStagiaires.SuppStagiaire());
            
            JButton BtFermer = new JButton("Fermer");
            BtFermer.addActionListener(new CIHMGestionStagiaires.FermerStagiaire());
            
            sud.add(BtEditer);
            sud.add(BtSupp);
            sud.add(BtFermer);
            
            add(this.buildIhmAfficherStagiaire(),BorderLayout.NORTH);
            add(sud,BorderLayout.SOUTH);   
        }
    
        
    public JPanel buildIhmAfficherStagiaire(){
         
        JPanel panel = new JPanel();
        //On définit le layout à utiliser 10 lignes 2 colonnes 5,5 : espacement
        panel.setLayout(new GridLayout(10, 2, 5,5));
    
        JLabel nom = new JLabel("Nom :");      
        JLabel prenom = new JLabel("Prénom :");      
        JLabel mail = new JLabel("Courriel :");  
        JLabel tel = new JLabel("Tel :");
        JLabel login = new JLabel("Identifiant :");
        JLabel password = new JLabel("Mot de passe :");
      
        
        JLabel nomA = new JLabel(collectionStagiaire.get(i).getNom());
        JLabel prenomA = new JLabel(collectionStagiaire.get(i).getPrenom());      
        JLabel mailA = new JLabel(collectionStagiaire.get(i).getMail());  
        JLabel telA = new JLabel(collectionStagiaire.get(i).getTel());
        JLabel loginA = new JLabel(collectionStagiaire.get(i).getLogin());
        JLabel passwordA = new JLabel(collectionStagiaire.get(i).getPassword());
   
        
        panel.add(nom);
        panel.add(nomA);
        panel.add(prenom);
        panel.add(prenomA);
        panel.add(mail);
        panel.add(mailA);
        panel.add(tel);
        panel.add(telA);
        panel.add(login);
        panel.add(loginA);
        panel.add(password);
        panel.add(passwordA);   
   

        return panel;
     }}

     /**************************************************
    *        Fenêtre éditer une entreprise            *
   **************************************************/
     
    class ihmEditerStagiaire extends JFrame{  
     
        public ihmEditerStagiaire(){
            super();
            setTitle("Editer stagiaire");
            setSize(400, 400);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            
            JButton BtModifier = new JButton("Modifier");
            BtModifier.addActionListener(new CIHMGestionStagiaires.ModifierStagiaire());
 
            add(this.buildIhmEditerStagiaire(),BorderLayout.NORTH);
            add(BtModifier,BorderLayout.SOUTH);   
        }
    
        
    public JPanel buildIhmEditerStagiaire(){
         
        JPanel panel = new JPanel();
        //On définit le layout à utiliser 10 lignes 2 colonnes 5,5 : espacement
        panel.setLayout(new GridLayout(10, 2, 5,5));
    
        JLabel nom = new JLabel("Nom :");      
        JLabel prenom = new JLabel("Prénom :");      
        JLabel mail = new JLabel("Courriel :");  
        JLabel tel = new JLabel("Tel :");
        JLabel login = new JLabel("Identifiant :");
        JLabel password = new JLabel("Mot de passe :");
   
 
        panel.add(nom);
        panel.add(nomR);
        panel.add(prenom);
        panel.add(prenomR);
        panel.add(mail);
        panel.add(mailR);
        panel.add(tel);
        panel.add(telR);
        panel.add(login);
        panel.add(loginR);
        panel.add(password);
        panel.add(passwordR);   
 

        return panel;
     }}
    
    
     /**************************************************
    *        Fenêtre supprimer une entreprise         *
   **************************************************/
    
    class ihmSuppStagiaire extends JFrame{  
    
        public ihmSuppStagiaire(){
            super();
            setTitle("Suppression");
            setSize(300, 100);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            
            JLabel texte = new JLabel("Vous allez supprimer le stagiaire " + collectionStagiaire.get(selection).getNom());
            
            JButton BtConf = new JButton("Confirmer");
            BtConf.addActionListener(new CIHMGestionStagiaires.ConfSuppStagiaire());

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
                   instance.getPrenomR().setText("");
                   instance.getMailR().setText("");
                   instance.getTelR().setText("");
                   instance.getLoginR().setText("");
                   instance.getPasswordR().setText("");
                
                  
                   
                   ihmAjoutStagiaire = new ihmAjoutStagiaire();
                   ihmAjoutStagiaire.setVisible(true);
               }
           }
           
         
            /**************************************************
           *     Action après validation ajout entreprise    *
          **************************************************/

           class ValiderAjoutStagiaire implements ActionListener{
               public void actionPerformed(ActionEvent arg0) {

                   //Enregistrement des données récupérées dans un tableau 
                      ArrayList<String> donneeNouveauStagiaire = new ArrayList();
                      donneeNouveauStagiaire.add(instance.getNomR().getText());
                      donneeNouveauStagiaire.add(instance.getPrenomR().getText());
                      donneeNouveauStagiaire.add(instance.getMailR().getText());
                      donneeNouveauStagiaire.add(instance.getTelR().getText());
                      donneeNouveauStagiaire.add(instance.getLoginR().getText());
                      donneeNouveauStagiaire.add(instance.getPasswordR().getText());
                
                  //Envoie du tableau pour enregistrement dans la BDD  
                     tableBDD.ajoutStagiaire(donneeNouveauStagiaire);     
                      
                  //Envoie du tableau pour ajouter à la collection 
                      int lastId = collectionStagiaire.get(collectionStagiaire.size()-1).getId();
                      collectionStagiaire.add(new CStagiaire(lastId+1,donneeNouveauStagiaire));

                  //mise a jour du tableau  
                      model.addRow(collectionStagiaire.get(collectionStagiaire.size()-1).getDonneesTab()); 
                        
                  //affiche message pour confirmer l'ajout de l'entreprise   
                     instance.getMessage().setText("Le stagiaire "+ instance.getNomR().getText() + " à été ajouté");

                  //on referme la fenêtre ajout entreprise   
                     ihmAjoutStagiaire.dispose();            
               }
            }
    
            /**************************************************
           *                Bouton afficher                  *
          **************************************************/ 
           class OuvrirFenetreAfficher implements ActionListener{
               public void actionPerformed(ActionEvent e) {
                   
                   //on indique la ligne sélectionnée
                   selection = tableauStagiaire.getSelectedRow(); 
                   
                   //message pour indiquer l'entreprise selectionnée
                   instance.getMessage().setText("Le stagiaire "+collectionStagiaire.get(selection).getNom()+" est sélectionnée" );                   
                   
                   //on ouvre la fenêtre
                   ihmAfficherStagiaire= new ihmAfficherStagiaire();
                   ihmAfficherStagiaire.setVisible(true);
              }
           }
           
            /**************************************************
           *                  Bouton éditer                  *
          **************************************************/ 
           class EditerStagiaire implements ActionListener{
               public void actionPerformed(ActionEvent e) { 

                   //Message pour indiquer l'entreprise en cours d'édition
                   instance.getMessage().setText("Edition du stagiaire "+collectionStagiaire.get(selection).getNom() );                   
                   
                   //On remplie le formulaire avec les données actuelles de l'entreprise 
                   instance.getNomR().setText(collectionStagiaire.get(selection).getNom());
                   instance.getPrenomR().setText(collectionStagiaire.get(selection).getPrenom());
                   instance.getTelR().setText(collectionStagiaire.get(selection).getMail());
                   instance.getMailR().setText(collectionStagiaire.get(selection).getTel());
                   instance.getLoginR().setText(collectionStagiaire.get(selection).getLogin());
                   instance.getPasswordR().setText(collectionStagiaire.get(selection).getPassword());
            
                   //On affiche la fenêtre 
                   ihmEditerStagiaire= new ihmEditerStagiaire();
                   ihmEditerStagiaire.setVisible(true);
              }
           }
 
           /********************************************************
          *    Action après validation modification entreprise    *
         ********************************************************/

           class ModifierStagiaire implements ActionListener{
               public void actionPerformed(ActionEvent arg0) {                 
                    
                   //Enregistrement des données récupérées dans un tableau
                      ArrayList<String> donneeModif = new ArrayList();
                      donneeModif.add(instance.getNomR().getText());
                      donneeModif.add(instance.getPrenomR().getText());
                      donneeModif.add(instance.getMailR().getText());
                      donneeModif.add(instance.getTelR().getText());
                      donneeModif.add(instance.getLoginR().getText());
                      donneeModif.add(instance.getPasswordR().getText());
          
                    
                    //Modification dans la base de donnée
                    tableBDD.modifStagiaire(donneeModif, instance.collectionStagiaire.get(selection).getId());   
                    
                   //Modification dans la collection 
                     int id = collectionStagiaire.get(selection).getId();
                     collectionStagiaire.set(selection, new CStagiaire(id,donneeModif));
           
                  //mise a jour du tableau 
                     model.setValueAt(collectionStagiaire.get(selection).getNom(), selection, 0);
                     model.setValueAt(collectionStagiaire.get(selection).getPrenom(), selection, 1);
                     model.setValueAt(collectionStagiaire.get(selection).getMail(), selection, 2);
                     model.setValueAt(collectionStagiaire.get(selection).getTel(), selection, 3);
                     model.setValueAt(collectionStagiaire.get(selection).getLogin(), selection, 4);
                     model.setValueAt(collectionStagiaire.get(selection).getPassword(), selection, 5);         
                  //affiche message pour confirmer mofification de l'entreprise   
                     instance.getMessage().setText("Le stagiaire "+ instance.getCollectionStagiaire().get(selection).getNom() + " à été modifié");
                     
                  //on referme la fenêtre ajout entreprise   
                  ihmEditerStagiaire.dispose();
                  ihmAfficherStagiaire.dispose();
   
               }
            }            

           
            /**************************************************
           *               Bouton supprimer                  *
          **************************************************/ 
           class SuppStagiaire implements ActionListener{
               public void actionPerformed(ActionEvent e) {       
                   
                   ihmSuppStagiaire = new ihmSuppStagiaire();
                   ihmSuppStagiaire.setVisible(true);
              }
           } 
           
           
            /**************************************************
           *         Bouton valider suppression              *
          **************************************************/ 
           class ConfSuppStagiaire implements ActionListener{
               public void actionPerformed(ActionEvent e) { 

                  //Suppression dans la BDD  
                     tableBDD.suppStagiaire(collectionStagiaire.get(selection).getId());  
                     
                  //Suppression dans la collection
                     String nomStagiaireSupp = collectionStagiaire.get(selection).getNom();
                     collectionStagiaire.remove(selection);
                     
                  //mise a jour du tableau 
                     model.removeRow(selection);   
                        
                  //affiche message pour confirmer suppression de l'entreprise   
                     instance.getMessage().setText("Le stagiaire "+nomStagiaireSupp+" à été supprimé");
                     
                  //on referme la fenêtre supp entreprise   
                     ihmAfficherStagiaire.dispose();
                     ihmSuppStagiaire.dispose();
 
              }
           }  
           
 
            /**************************************************
           *             Bouton fermer affichage             *
          **************************************************/ 
           class FermerStagiaire implements ActionListener{
               public void actionPerformed(ActionEvent e) { 
               
                  //message vide   
                     instance.getMessage().setText("");
                     
                  //on referme la fenêtre affichage   
                     ihmAfficherStagiaire.dispose();
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

    public  CIHMGestionStagiaires getInstance() {
        return instance;
    }


    public ArrayList<CStagiaire> getCollectionStagiaire() {
        return collectionStagiaire;
    }
    
    
        public JTextField getNomR() {
        return nomR;
    }

    public JTextField getPrenomR() {
        return prenomR;
    }

    public JTextField getMailR() {
        return mailR;
    }

    public JTextField getTelR() {
        return telR;
    }

    public JTextField getLoginR() {
        return loginR;
    }

    public JTextField getPasswordR() {
        return passwordR;
    }


}
