package IHM;

import objets.CPeriode;
import bdd.CTablePeriodes;
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

public final class CIHMGestionPeriodes {

    //accés à la table période
    private final CTablePeriodes tableBDD = new CTablePeriodes();

    //Collection des périodes
    private final ArrayList<CPeriode> collectionPeriodes = new CTablePeriodes().selectPeriode();

    //tableau
    private DefaultTableModel model;
    private JTable tableauPeriode;
    private final JPanel panneauTableauPeriode = new JPanel();

    //Fenêtre
    private JFrame ihmAjouterPeriode = new JFrame();
    private JFrame ihmAfficherPeriode = new JFrame();
    private JFrame ihmEditerPeriode = new JFrame();
    private JFrame ihmSupprimerPeriode = new JFrame();
    private JPanel panneauPrincipal = new JPanel();

    //Message
    private final JLabel message = new JLabel("");

    //Champs pour le formulaire de création et modification des périodes
    private final JTextField dateDebutR = new JTextField(30);
    private final JTextField dateFinR = new JTextField(30);
    private final JTextField dateVisiteR = new JTextField(30);
    private final JTextField posteR = new JTextField(30);
    private final JTextField activiteR = new JTextField(30);
    private final JTextField noteFormateurR = new JTextField(30);
    private final JTextField visiteEffectueR = new JTextField(30);

    //Designe le numero de la ligne selectionnée
    private int selection;

    //Instance courrante pour avoir accès aux getters
    private final CIHMGestionPeriodes instance;

    /**
     * Constructeur                              
    *
     */
    public CIHMGestionPeriodes() {
        instance = this;
        panneauPrincipal = this.buildPannneauPrincipal();
    }

    /**
     * Panneau principal implémenté dans fenêtre IHMApp           
     */
    public JPanel buildPannneauPrincipal() {
        panneauPrincipal.setLayout(new BorderLayout());
        panneauPrincipal.setBackground(Color.gray);

        /**
         * Titre + message           
         */
        JPanel nord = new JPanel();
        nord.setBackground(Color.gray);
        nord.setLayout(new BorderLayout());

        JLabel titre = new JLabel("Gestion des Périodes de stage");
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

        /**
         * Boutons bas de page
        *
         */
        JPanel sud = new JPanel();
        sud.setLayout(new BorderLayout());

        JButton btSelec = new JButton("Afficher la période de stage sélectionnée");
        btSelec.addActionListener(new OuvrirFenetreAfficher());

        JButton btAjouter = new JButton("Ajouter une période de stage");
        btAjouter.addActionListener(new CIHMGestionPeriodes.OuvrirFenetreAjouter());

        sud.add(btSelec, BorderLayout.NORTH);
        sud.add(btAjouter, BorderLayout.SOUTH);

        /**
         * ********************************
         * implémentation *
        *********************************
         */
        panneauPrincipal.add(nord, BorderLayout.NORTH);
        panneauPrincipal.add(this.tableau(), BorderLayout.CENTER);
        panneauPrincipal.add(sud, BorderLayout.SOUTH);

        return panneauPrincipal;
    }

    /**
     * Tableau liste des Périodes impléménté dans Panneau principal     
    *
     */
    public JPanel tableau() {

        //entetes
        model = new DefaultTableModel();
        model.addColumn("dateDebut");
        model.addColumn("dateFin");
        model.addColumn("dateVisite");
        model.addColumn("poste");
        model.addColumn("activite");
        model.addColumn("noteFormateur");
        model.addColumn("visiteEffectue");

        //Importation des données
        for (int i = 0; i < collectionPeriodes.size(); i++) {
            model.addRow(collectionPeriodes.get(i).getDonneesTab());
        }

        //Création du tableau
        tableauPeriode = new JTable(model);

        //Propriété JPanel
        panneauTableauPeriode.setBackground(Color.gray);
        panneauTableauPeriode.add(new JScrollPane(tableauPeriode));

        return panneauTableauPeriode;
    }

        /**
         * Fenêtre pour ajouter une Période de stage  
        *
         */
        class ihmAjouterPeriode extends JFrame {

            public ihmAjouterPeriode() {
                super();
                setTitle("Editer une Période de stage");
                setSize(400, 400);
                setLocationRelativeTo(null);

                //On définit le layout à utiliser 
                this.setLayout(new GridLayout(10, 2, 5, 5));

                JLabel dateDebut = new JLabel("Date de début");
                JLabel dateFin = new JLabel("Date de fin");
                JLabel dateVisite = new JLabel("Date de Visite");
                JLabel poste = new JLabel("Poste");
                JLabel activite = new JLabel("Activité");
                JLabel noteFormateur = new JLabel("Note Formateur");
                JLabel visiteEffectue = new JLabel("Visite éffectuer");
                JLabel vide = new JLabel("");

                JButton btValider = new JButton("Ajouter");
                btValider.addActionListener(new CIHMGestionPeriodes.ValiderAjouterPeriode());

                add(dateDebut);
                add(dateDebutR);
                add(dateFin);
                add(dateFinR);
                add(dateVisite);
                add(dateVisiteR);
                add(poste);
                add(posteR);
                add(activite);
                add(activiteR);
                add(noteFormateur);
                add(noteFormateurR);
                add(visiteEffectue);
                add(visiteEffectueR);
                add(vide);
                add(btValider);
            }
        }

        /**
         * Fenêtre afficher une période           
        *
         */
        class ihmAfficherPeriode extends JFrame {

            private final int i = selection;

            public ihmAfficherPeriode() {
                super();
                setTitle("Détail de la période");
                setSize(400, 300);
                setLocationRelativeTo(null);
                this.setLayout(new BorderLayout());
                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

                JPanel sud = new JPanel();
                sud.setLayout(new GridLayout());

                JButton BtEditer = new JButton("Editer");
                BtEditer.addActionListener(new CIHMGestionPeriodes.EditerPeriode());

                JButton BtSupp = new JButton("Supprimer");
                BtSupp.addActionListener(new CIHMGestionPeriodes.SuppPeriode());

                JButton BtFermer = new JButton("Fermer");
                BtFermer.addActionListener(new CIHMGestionPeriodes.FermerPeriode());

                sud.add(BtEditer);
                sud.add(BtSupp);
                sud.add(BtFermer);

                add(this.buildIhmAfficherPeriode(), BorderLayout.NORTH);
                add(sud, BorderLayout.SOUTH);
            }

            public JPanel buildIhmAfficherPeriode() {

                JPanel panel = new JPanel();

                //On définit le layout à tuiliser
                panel.setLayout(new GridLayout(10, 2, 5, 5));

                JLabel dateDebut = new JLabel("Date de début");
                JLabel dateFin = new JLabel("Date de fin");
                JLabel dateVisite = new JLabel("Date de Visite");
                JLabel poste = new JLabel("Poste");
                JLabel activite = new JLabel("Activité");
                JLabel noteFormateur = new JLabel("Note Formateur");
                JLabel visiteEffectue = new JLabel("Visite éffectuer");

                JLabel dateDebutA = new JLabel(collectionPeriodes.get(i).getDateDebut());
                JLabel dateFinA = new JLabel(collectionPeriodes.get(i).getDateFin());
                JLabel dateVisiteA = new JLabel(collectionPeriodes.get(i).getDateVisite());
                JLabel posteA = new JLabel(collectionPeriodes.get(i).getPoste());
                JLabel activiteA = new JLabel(collectionPeriodes.get(i).getActivite());
                JLabel noteFormateurA = new JLabel(collectionPeriodes.get(i).getNoteFormateur());
                JLabel visiteEffectueA = new JLabel(collectionPeriodes.get(i).getVisiteEffectue());

                panel.add(dateDebut);
                panel.add(dateDebutA);
                panel.add(dateFin);
                panel.add(dateFinA);
                panel.add(dateVisite);
                panel.add(dateVisiteA);
                panel.add(poste);
                panel.add(posteA);
                panel.add(activite);
                panel.add(activiteA);
                panel.add(noteFormateur);
                panel.add(noteFormateurA);
                panel.add(visiteEffectue);
                panel.add(visiteEffectueA);

                return panel;
            }
        }

        /**
         * Fenêtre d'édition des périodes de stage
         */
        class ihmEditerPeriode extends JFrame {

            public ihmEditerPeriode() {
                super();
                setTitle("Editer période de stage");
                setSize(400, 400);
                setLocationRelativeTo(null);
                setLayout(new BorderLayout());

                JButton BtModifier = new JButton("Modifier");
                BtModifier.addActionListener(new CIHMGestionPeriodes.ModifierPeriode());

                add(this.buildIhmEditerPeriode(), BorderLayout.NORTH);
                add(BtModifier, BorderLayout.SOUTH);
            }

            public JPanel buildIhmEditerPeriode() {
                
                JPanel panel = new JPanel();
                // On définit le layout à utiliser 10 lignes 2 colonnes 5,5 d'espacement
                panel.setLayout(new GridLayout(10, 2, 5,5));

                JLabel dateDebut = new JLabel("Date de début");
                JLabel dateFin = new JLabel("Date de fin");
                JLabel dateVisite = new JLabel("Date de Visite");
                JLabel poste = new JLabel("Poste");
                JLabel activite = new JLabel("Activité");
                JLabel noteFormateur = new JLabel("Note Formateur");
                JLabel visiteEffectue = new JLabel("Visite éffectuer");

                add(dateDebut);
                add(dateDebutR);
                add(dateFin);
                add(dateFinR);
                add(dateVisite);
                add(dateVisiteR);
                add(poste);
                add(posteR);
                add(activite);
                add(activiteR);
                add(noteFormateur);
                add(noteFormateurR);
                add(visiteEffectue);
                add(visiteEffectueR);

                return panel;
            }
        }

        /**
         *  Fenêtre de suppression d'une période
         */
        class ihmSupprimerPeriode extends JFrame{
            
            public ihmSupprimerPeriode(){
                super();
                setTitle("Suppression");
                setSize(300,100);
                setLocation(null);

                JLabel texte = new JLabel("Vous aller supprimer la période du" + collectionPeriodes.get(selection).getDateDebut() +  " au " + collectionPeriodes.get(selection).getDateFin());

                JButton BtConf = new JButton("Confimer");
                BtConf.addActionListener(new CIHMGestionPeriodes.ConfSuppPeriode());

                this.add(texte, BorderLayout.NORTH);
                this.add(BtConf, BorderLayout.SOUTH);
            }
        }
        
        
        /**
         * Traitement des actions des boutons
         */
        /**
         * OuvrirFenetreAjouter Bouton qui ouvre la fenêtre d'ajout des périodes
         */
        class OuvrirFenetreAjouter implements ActionListener {

            public void actionPerformed(ActionEvent arg0) {

                //On vide les champs de leurs contenu
                instance.getDateDebutR().setText("");
                instance.getDateFinR().setText("");
                instance.getDateVisiteR().setText("");
                instance.getPosteR().setText("");
                instance.getActiviteR().setText("");
                instance.getNoteFormateurR().setText("");
                instance.getVisiteEffectueR().setText("");

                ihmAfficherPeriode = new ihmAfficherPeriode();
                ihmAfficherPeriode.setVisible(true);
            }
        }

        /**
         * Action apres validation ajout période
         */
        class ValiderAjouterPeriode implements ActionListener {

            public void actionPerformed(ActionEvent arg0) {

                // Enregistrement des données récupérés dans un tableau
                ArrayList<String> donneeNouvellePeriode = new ArrayList();
                donneeNouvellePeriode.add(instance.getDateDebutR().getText());
                donneeNouvellePeriode.add(instance.getDateFinR().getText());
                donneeNouvellePeriode.add(instance.getDateVisiteR().getText());
                donneeNouvellePeriode.add(instance.getPosteR().getText());
                donneeNouvellePeriode.add(instance.getActiviteR().getText());
                donneeNouvellePeriode.add(instance.getNoteFormateurR().getText());
                donneeNouvellePeriode.add(instance.getVisiteEffectueR().getText());

                // Envoie du tableau pour enregistrement dans la base de données
                tableBDD.ajoutPeriode(donneeNouvellePeriode);

                // Envoie du tableau pour ajouter à la collection
                int lastId = collectionPeriodes.get(collectionPeriodes.size() - 1).getId();
                collectionPeriodes.add(new CPeriode(lastId + 1, donneeNouvellePeriode));

                // Mise à jour du tableau
                model.addRow(collectionPeriodes.get(collectionPeriodes.size() - 1).getDonneesTab());

                // Affiche message pour confirmer l'ajout de période de stage
                instance.getMessage().setText("La periode du" + instance.getDateDebutR().getText() + " au " + instance.getDateFinR().getText() + " à bien été ajouté");

                // On referme la fenêtre d'ajout des périodes de stages
                ihmAjouterPeriode.dispose();
            }
        }

        /**
         * OuvrirFenetreAfficher Affiche les données contenu dans la base de
         * données
         */
        class OuvrirFenetreAfficher implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                // On indique la ligne à selectionnée
                selection = tableauPeriode.getSelectedRow();

                // Message pour indiquer la période selectionnée
                instance.getMessage().setText("La periode du" + collectionPeriodes.get(selection).getDateDebut() + " au " + collectionPeriodes.get(selection).getDateFin() + " à bien été selectionnée");

                // On ouvre la fenêtre
                ihmAfficherPeriode = new ihmAfficherPeriode();
                ihmAfficherPeriode.setVisible(true);
            }
        }

        /**
         * EditerPeriode Permet d'éditer les donnée importé de la base de donnée
         */
        class EditerPeriode implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                // Message pour indiquer la période en cours d'édition
                instance.getMessage().setText("Edition de la période du " + collectionPeriodes.get(selection).getDateDebut() + " au " + collectionPeriodes.get(selection).getDateFin());

                // On remplie le formulaire avec les données
                instance.getDateDebutR().setText(collectionPeriodes.get(selection).getDateDebut());
                instance.getDateFinR().setText(collectionPeriodes.get(selection).getDateFin());
                instance.getDateVisiteR().setText(collectionPeriodes.get(selection).getDateVisite());
                instance.getPosteR().setText(collectionPeriodes.get(selection).getPoste());
                instance.getActiviteR().setText(collectionPeriodes.get(selection).getActivite());
                instance.getNoteFormateurR().setText(collectionPeriodes.get(selection).getNoteFormateur());
                instance.getVisiteEffectueR().setText(collectionPeriodes.get(selection).getVisiteEffectue());

                // On affiche la fenêtre
                ihmEditerPeriode = new ihmEditerPeriode();
                ihmEditerPeriode.setVisible(true);
            }
        }

        /**
         * ModifierPeriode Valide les modifications fait dans la base de données
         */
        class ModifierPeriode implements ActionListener {

            public void actionPerformed(ActionEvent Arg0) {

                // Enregistrement des donnée récupérées dans un tableau
                ArrayList<String> donneeModif = new ArrayList();
                donneeModif.add(instance.getDateDebutR().getText());
                donneeModif.add(instance.getDateFinR().getText());
                donneeModif.add(instance.getDateVisiteR().getText());
                donneeModif.add(instance.getPosteR().getText());
                donneeModif.add(instance.getActiviteR().getText());
                donneeModif.add(instance.getNoteFormateurR().getText());
                donneeModif.add(instance.getVisiteEffectueR().getText());

                // Modification dans la base de données
                tableBDD.modifPeriode(donneeModif, instance.collectionPeriodes.get(selection).getId());

                // Modification dans la collection
                int id = collectionPeriodes.get(selection).getId();
                collectionPeriodes.set(selection, new CPeriode(id, donneeModif));

                // Mise à jour du tableau
                model.setValueAt(collectionPeriodes.get(selection).getDateDebut(), selection, 0);
                model.setValueAt(collectionPeriodes.get(selection).getDateFin(), selection, 1);
                model.setValueAt(collectionPeriodes.get(selection).getDateVisite(), selection, 2);
                model.setValueAt(collectionPeriodes.get(selection).getPoste(), selection, 3);
                model.setValueAt(collectionPeriodes.get(selection).getActivite(), selection, 4);
                model.setValueAt(collectionPeriodes.get(selection).getNoteFormateur(), selection, 5);
                model.setValueAt(collectionPeriodes.get(selection).getVisiteEffectue(), selection, 6);

                // Affiche le message de confirmation de modification de la période
                instance.getMessage().setText("La période du " + collectionPeriodes.get(selection).getDateDebut() + " au " + collectionPeriodes.get(selection).getDateFin() + " à bien été modifier !");

                // on referme la fenêtre d'ajout de période
                ihmEditerPeriode.dispose();
                ihmAfficherPeriode.dispose();
            }
        }

        /**
         * SuppPeriode Bouton supprimer
         */
        class SuppPeriode implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                ihmSupprimerPeriode = new ihmSupprimerPeriode();
                ihmSupprimerPeriode.setVisible(true);
            }
        }

        /**
         * ConfSuppPeriode
         */
        class ConfSuppPeriode implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                // Suppression dans la base de donnée
                tableBDD.suppPeriode(collectionPeriodes.get(selection).getId());

                // Suppression dans la collection
                String nomPeriodeDebutSupp = collectionPeriodes.get(selection).getDateDebut();
                String nomPeriodeFinSupp = collectionPeriodes.get(selection).getDateFin();
                collectionPeriodes.remove(selection);

                // Mise à jour du tableau
                model.removeRow(selection);

                // Affiche le message de confirmation de suppréssion de la période
                instance.getMessage().setText("La période de stage du " + nomPeriodeDebutSupp + " au " + nomPeriodeFinSupp + " à bien été supprimer !");

                // On referme la fenêtre de confirmation de suppression
                ihmAfficherPeriode.dispose();
                ihmSupprimerPeriode.dispose();
            }
        }

        /**
         * FermerPeriode Bouton de fermeture de l'affichage
         */
        class FermerPeriode implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                // Affiche un message vide
                instance.getMessage().setText("");

                // On referme la fenêtre d'affichage
                ihmAfficherPeriode.dispose();
            }
        }

        /**
         * Getter
         */

        public JPanel getPanneauPrincipal() {
            return panneauPrincipal;
        }

        public JLabel getMessage(){
            return message;
        }

        public CIHMGestionPeriodes getInstance(){
            return instance;
        }

        public ArrayList<CPeriode> getCollectionPeriodes(){
            return collectionPeriodes;            
        }

        public JTextField getDateDebutR(){
            return dateDebutR;
        }

        public JTextField getDateFinR(){
            return dateFinR;
        }

        public JTextField getDateVisiteR(){
            return dateVisiteR;
        }

        public JTextField getPosteR() {
            return posteR;
        }

        public JTextField getActiviteR() {
            return activiteR;
        }

        public JTextField getNoteFormateurR() {
            return noteFormateurR;
        }
        
        public JTextField getVisiteEffectueR() {
            return visiteEffectueR;
        }
    }


