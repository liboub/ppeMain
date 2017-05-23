<?php
    require_once __DIR__ . '/vendor/autoload.php';
    $loader = new Twig_Loader_Filesystem('vues'); // Dossier contenant les templates

    $twig = new Twig_Environment($loader, array(
      'cache' => 'dev'
    ));

   

 /******************************************************
*       Appel des classes utilisées                   *
******************************************************/
        require_once 'modele/CControleurEntreprise.php';
        $cControleurEntreprise=new CControleurEntreprise;
  
        require_once 'modele/CControleurPeriodeStage.php';
        $cControleurPeriodeStage = new CControleurPeriodeStage();
          
        require_once 'modele/CControleurTuteur.php';
        $cControleurTuteur=new CControleurTuteur(); 
        
  
 /******************************************************
*         Déclaration des variables                   *
******************************************************/         
    //stagiaire
          $idStagiaire=5;//récupéré par la session en cours 

          
    //Periode
            //idPeriode null si premier formulaire pas encore remplie récp cookies si deja rempli
            if (isset($_COOKIE['idPeriode'])){
                $idPeriode=$_COOKIE['idPeriode'];
            }
            else {
                $idPeriode=NULL;
            }
          $dateDebut=NULL;
          $dateFin=NULL;
          $poste=NULL;
          $activite=NULL;
 
    //entreprise
          $nom=NULL;
          $adnum=NULL;
          $adrue=NULL;
          $adville=NULL;
          $adcp=NULL;
          $tel=NULL;
          $mail=NULL;
          $siret=NULL;
          $ape=NULL;
          $nbTuteur=NULL;
 
    //données tableau Entreprise 
          $table="entreprise";
          $selection=array("id","nom","adville","adcp","tel");          
          $entete = array("Nom","Ville","Code postal","TEL");              
          $href="stagiaire.php?idEntreprise=";
          $idZone="";
          require_once 'modele/Ctableau.php';
 
          $cTableau = new Ctableau($table,$selection,$entete,$href,$idZone);
          
          
          
    //données tuteur
            $nomTuteur=NULL;
            $prenomTuteur=NULL;
            $mailTuteur=NULL;
            $telTuteur=NULL;  
               
    //données tableau tuteur    
            $tableT=NULL;
            $donneesTableauT=NULL;
            $enteteT=NULL;
            $hrefT=NULL;
            $idZoneT=NULL;

    //style
            $display_ajoutPeriode='display : none';
            $display_periode='display : block';
            $display_entreprise='display :none';
            $display_formEntrepriseComplete='display : none';
            $display_tuteur_liste='display : none';
            $display_tuteur_modif='display : none';
            $display_tuteur_ajout='display : none';
            $display_recap='display : none';
          
            $test ="pas recu";


 /******************************************************
*         Traitement des formulaire                   *
******************************************************/ 

         /******************************************************
        *         Création d'une période de stage              *
        ******************************************************/ 
            
          /*Formulaire date*/
          if (isset($_POST['date'])) {       
             
            $idPeriode=$cControleurPeriodeStage->nouvellePeriode($idStagiaire, $_POST['dateDebut'], $_POST['dateFin']);
            setcookie("idPeriode",$idPeriode,time()+3600);
              
            $display_ajoutPeriode='display : block';
            $display_periode='display : none';
            $display_entreprise='display : block';
          }

         /******************************************************
        *                 Traitement Entreprise                *
        ******************************************************/ 
          
        /*Retour choix liste entreprise*/
              if (isset($_GET['idEntreprise'])) { 

                $idPeriode=$cControleurPeriodeStage->assignerEntreprise($_COOKIE['idPeriode'], $_GET['idEntreprise']);

                $entreprise=$cControleurEntreprise->uneEntreprise($_GET['idEntreprise']);

                $nom=$entreprise->getNom();
                $adnum=$entreprise->getAdnum();
                $adrue=$entreprise->getAdrue();
                $adville=$entreprise->getAdville();
                $adcp=$entreprise->getAdcp();
                $tel=$entreprise->getTel();
                $mail=$entreprise->getMail();
                $siret=$entreprise->getSiret();
                $ape=$entreprise->getApe();

                setcookie("idEntreprise",$_GET['idEntreprise'],time()+3600);

                $display_ajoutPeriode='display : block';
                $display_periode='display : none';
                $display_formEntrepriseComplete='display : block';
              }
          
        /*Formulaires entreprise*/
         
                //*Choisis dans la liste et validé tel quel*/
                if (isset($_POST['valider'])) {   
    
                  $nbTuteur=$cControleurEntreprise->compterTuteur($_COOKIE['idEntreprise']);
              
                  if ($nbTuteur>1){
                      $display_ajoutPeriode='display : block';
                      $display_periode='display : none'; 
                      $display_tuteur_liste='display : block';
                  }  
                    
                  else {
                      $display_ajoutPeriode='display : block';
                      $display_periode='display : none';
                      $display_tuteur_ajout='display : block';
                  }          
                }
          
                /*Choisis dans la liste et modifié*/
                if (isset($_POST['form_entreprise_modifier'])) { 

                    $donnees = array(
                        "nom"=>$_POST['nom'], 
                        "adnum"=>$_POST['adnum'], 
                        "adrue"=>$_POST['adrue'], 
                        "adville"=>$_POST['adville'], 
                        "adcp"=>$_POST['adcp'], 
                        "tel"=>$_POST['tel'], 
                        "mail"=>$_POST['mail'], 
                        "siret"=>$_POST['siret'], 
                        "ape"=>$_POST['ape'],
                    );
                    
                    $idEntreprise=$_COOKIE['idEntreprise'];
                    
                    $cControleurEntreprise->modifierEntreprise($donnees, $idEntreprise);
                    
                    $nbTuteur=$cControleurEntreprise->compterTuteur($idEntreprise);
              
                    if ($nbTuteur>1){
                        $display_ajoutPeriode='display : block';
                        $display_periode='display : none'; 
                        $display_tuteur_liste='display : block';
                    }  

                    else {
                        $display_ajoutPeriode='display : block';
                        $display_periode='display : none';
                        $display_tuteur_ajout='display : block';
                    }          
                }  
                    
                
                /*création d'une nouvelle entreprise*/
                if (isset($_POST['form_entreprise_creer'])) { 

                  $donnees = array(
                        "nom"=>$_POST['nom'], 
                        "adnum"=>$_POST['adnum'], 
                        "adrue"=>$_POST['adrue'], 
                        "adville"=>$_POST['adville'], 
                        "adcp"=>$_POST['adcp'], 
                        "tel"=>$_POST['tel'], 
                        "mail"=>$_POST['mail'], 
                        "siret"=>$_POST['siret'], 
                        "ape"=>$_POST['ape'],
                    );

                  $cControleurEntreprise->ajouterEntreprise($donnees);
                  
                  $display_ajoutPeriode='display : block';
                  $display_periode='display : none';
                  $display_tuteur_ajout='display : block';
                }

         /******************************************************
        *                 Traitement Tuteur                    *
        ******************************************************/ 

        //Construction du tableau  
            $tableT="tuteur";
            $selectionT=array("id","nom","prenom");          
            $enteteT = array("Nom","Prenom");              
            $hrefT="stagiaire.php?idTuteur=";
            $idZoneT="";
      
            
            $donneesTableauT=$cControleurTuteur->listeTuteur(1,$selectionT);        
            

          /*Retour choix liste tuteur*/
              if (isset($_GET['idTuteur'])) { 
                $idTuteur=$_GET['idTuteur'];  
                $idPeriode=$cControleurPeriodeStage->assignerTuteur($idPeriode, $idTuteur);

                $tuteur=$cControleurTuteur->unTuteur($idTuteur);

                $nomTuteur=$tuteur->getNom();
                $prenomTuteur=$tuteur->getPrenom();
                $mailTuteur=$tuteur->getMail();
                $telTuteur=$tuteur->getTel();


                setcookie("idTuteur",$_GET['idTuteur'],time()+3600);

                $display_ajoutPeriode='display : block';
                $display_periode='display : none';
                $display_tuteur_modif='display : block';
              }          
                
         //*Choisis dans la liste et validé tel quel*/
                if (isset($_POST['validerTuteur'])) {   
                    $cControleurPeriodeStage->assignerTuteur($idPeriode, $_COOKIE['idTuteur']);
                }
          
         /*Choisis dans la liste et modifié*/
                if (isset($_POST['modifierTuteur'])){
     
                    $donnees = array(
                        "nom"=>$_POST['nom'], 
                        "prenom"=>$_POST['prenom'],
                        "mail"=>$_POST['mail'],
                        "tel"=>$_POST['tel'] 
                        );    
                    
                    $idTuteur=$_COOKIE['idTuteur'];
                    $cControleurTuteur->modifierTuteur($donnees, $idTuteur);
                    $cControleurPeriodeStage->assignerTuteur($idPeriode, $idTuteur);
                }
                
         /*Création tuteur*/                
                if (isset($_POST['ajouterTuteur'])){

                    $donnees = array(
                        "nom"=>$_POST['nom'], 
                        "prenom"=>$_POST['prenom'],
                        "mail"=>$_POST['mail'],
                        "tel"=>$_POST['tel'], 
                        "idEntreprise"=>$_COOKIE['idEntreprise']    
                    );
                    $idTuteur=$cControleurTuteur->ajouterTuteur($donnees);
                    $cControleurPeriodeStage->assignerTuteur($idPeriode, $idTuteur);
                }

 /******************************************************
*         Données page récapitulative                  *
******************************************************/
if (isset($_POST['validerTuteur']) OR isset($_POST['modifierTuteur']) OR isset($_POST['ajouterTuteur']) ){
    
    $periode=$cControleurPeriodeStage->unePeriode($idPeriode);
    $entreprise=$cControleurEntreprise->uneEntreprise($periode->getIdEntreprise());
    $tuteur=$cControleurTuteur->unTuteur($periode->getIdTuteur());
   
    //periode
          $dateDebut=$periode->getDateDebut();
          $dateFin=$periode->getDateFin();
          $poste=$periode->getPoste();
    //entreprise
          $nom=$entreprise->getNom();
          $adnum=$entreprise->getAdnum();
          $adrue=$entreprise->getAdrue();
          $adville=$entreprise->getAdville();
          $adcp=$entreprise->getAdcp();
          $tel=$entreprise->getTel();
          $mail=$entreprise->getMail();
          $siret=$entreprise->getSiret();
          $ape=$entreprise->getApe();    
    //tuteur
          $nomTuteur=$tuteur->getNom();
          $prenomTuteur=$tuteur->getPrenom();
          $mailTuteur=$tuteur->getMail();
          $telTuteur=$tuteur->getTel();  
       
          $display_ajoutPeriode='display : block';
          $display_periode='display : none';
          $display_recap='display : block';
}                     
                

 /*******************************************************
*         Données envoyées au template                 *
******************************************************/         
      $template = $twig->loadTemplate('stagiaire.twig');    
           echo $template->render(array(

            //Periode
            'idPeriode'=>$idPeriode,
            'dateDebut'=>$dateDebut,
            'dateFin'=>$dateFin,
            'poste'=>$poste,
            'activite'=>$activite,  
            
            //entreprise   
            'nom'=>$nom,
            'adnum'=>$adnum,
            'adrue'=>$adrue,
            'adville'=>$adville,
            'adcp'=>$adcp,
            'tel'=>$tel,
            'mail'=>$mail,
            'siret'=>$siret,
            'ape'=>$ape,   

            //données tableau entreprise  
            'table'=> $cTableau->getTable(),
            'donneesTableau'=>$cTableau->getDonneesTableau(),
            'entete' =>$cTableau->getEntete(), 
            'href' =>$cTableau->getHref(), 
            'idZone'=>$cTableau->getIdZone(), 
               
            //données tuteur
            'nomTuteur'=>$nomTuteur,
            'prenomTuteur'=>$prenomTuteur,
            'mailTuteur'=>$mailTuteur,
            'telTuteur'=>$telTuteur,  
               
            //données tableau tuteur    
            'tableT'=> $tableT,
            'donneesTableauT'=>$donneesTableauT,
            'enteteT' =>$enteteT, 
            'hrefT' =>$hrefT, 
            'idZoneT'=>$idZoneT,   
                   
            //style
            'display_ajoutPeriode'=>$display_ajoutPeriode,       
            'display_periode'=>$display_periode,
            'display_entreprise'=>$display_entreprise,
            'display_formEntrepriseComplete'=>$display_formEntrepriseComplete,   
            'display_tuteur_modif'=>$display_tuteur_modif,
            'display_tuteur_ajout'=>$display_tuteur_ajout,
            'display_tuteur_liste'=>$display_tuteur_liste,   
            'display_recap'=>$display_recap, 

            'test'=>$test       
            ));