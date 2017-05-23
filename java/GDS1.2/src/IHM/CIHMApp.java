
package IHM;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CIHMApp extends JFrame {
   
    
    static CIHMApp instanceApp;
   
    private JPanel menu;
    private JPanel conteneur;

    private JPanel accueil;
    private JPanel ihmStages = new CIHMGestionStages().getPanneauPrincipal();
    private JPanel ihmStagiaires = new CIHMGestionStagiaires().getPanneauPrincipal();
    private JPanel ihmEntreprises= new CIHMGestionEntreprises().getPanneauPrincipal();
    private JPanel ihmFormateur = new CIHMGestionFormateurs().getPanneauPrincipal();
      
    //Préparation du CardLayout, permet de supperposer plusieurs panneaux
    private CardLayout cardLayout = new CardLayout();
    private String[] position = {"ACCUEIL","STAGE", "STAGIAIRE", "ENTREPRISE","FORMATEUR"};
    private int indice = 0;
    
    private JPanel vueEnCours;
  
    
     /****************************************
    *           Constructeur                * 
    ****************************************/
    
    public CIHMApp(){
            super();
        
            instanceApp=this;
            //creation de la fenêtre
            this.setTitle("CardLayout");
            this.setSize(800, 600);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            //Contruction du panneau menu
            this.menu = this.buildMenu();

           //Contruction des panneaux importés dans le CardLayout
            vueEnCours = this.buildAccueil();
           
            //Contruction du conteneur 
            this.conteneur = this.buildConteneur();
            
        }
    
        
     /****************************************
    *        Construction du menu           * 
    ****************************************/        
        private JPanel buildMenu(){
            JPanel menu = new JPanel(); 
            
            /****************************************
           *      Construction des boutons         * 
          ****************************************/ 
            JButton btStage = new JButton("Stages");
            btStage.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event){				
                cardLayout.show(conteneur, position[1]);
              }
            });  

            JButton btStagiaire = new JButton("Stagiaires");
            btStagiaire.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event){				
                cardLayout.show(conteneur, position[2]);
              }
            });  

            JButton btEntreprise = new JButton("Entreprises");
            btEntreprise.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event){				
                cardLayout.show(conteneur, position[3]);
              }
            });  

            JButton btFormateur = new JButton("Formateurs");
            btFormateur.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event){				
                cardLayout.show(conteneur, position[4]);
              }
            });

            menu.add(btStage);
            menu.add(btStagiaire);
            menu.add(btEntreprise);
            menu.add(btFormateur);

            return menu;
        }
        
     /****************************************
    *          Page d'accueil               * 
    ****************************************/      
        private JPanel buildAccueil(){
            JPanel  panneauPrincipal = new JPanel();
            panneauPrincipal.setBackground(Color.ORANGE);

            JLabel titre = new JLabel("Accueil");

            panneauPrincipal.add(titre);

            return panneauPrincipal;  
        }
        
     /****************************************
    *         Conteneur principal            * 
    ****************************************/     
        private JPanel buildConteneur(){  
            conteneur = new JPanel();
            
            conteneur.setLayout(cardLayout);
            conteneur.add(this.vueEnCours,position[0]);
            conteneur.add(ihmStages, position[1]);
            conteneur.add(ihmStagiaires, position[2]);
            conteneur.add(ihmEntreprises,position[3]);
            conteneur.add(ihmFormateur, position[4]);

            this.getContentPane().add(menu, BorderLayout.NORTH);
            this.getContentPane().add(conteneur, BorderLayout.CENTER);
            this.setVisible(true);
            
            return conteneur;
        }
        
 } 
       

    