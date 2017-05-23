<?php

// Appel auto des classes******************************************************************** 
    
class CControleurPeriodeStage {
    
   private $periodeStage;

   function __construct() {       
   }

    public function nouvellePeriode($idStagiaire,$dateDebut,$dateFin){
        require_once 'CBdd.php';
            $cBdd= new CBdd();
            $bdd=$cBdd->getConnection(); 
          
            $req = $bdd->prepare('INSERT INTO periode(dateDebut, dateFin, idStagiaire) VALUES(:dateDebut, :dateFin, :idStagiaire)');
                $req->execute(array(
                'dateDebut' => $dateDebut,
                'dateFin' => $dateFin,
                'idStagiaire' => $idStagiaire 
                ));

               return $bdd->lastInsertId();
    }  

    public function assignerEntreprise($idPeriode, $idEntreprise) {
        require_once 'CBdd.php';
            $cBdd= new CBdd();
            $bdd=$cBdd->getConnection();
        $q = $bdd->prepare('UPDATE periode SET idEntreprise="'.$idEntreprise.'" WHERE id='.$idPeriode.' ');
        $q->execute();        
    }
   
    public function assignerTuteur($idPeriode, $idTuteur) {
        require_once 'CBdd.php';
            $cBdd= new CBdd();
            $bdd=$cBdd->getConnection();
        $q = $bdd->prepare('UPDATE periode SET idTuteur="'.$idTuteur.'" WHERE id='.$idPeriode.' ');
        $q->execute();        
    }
  
    public function unePeriode($idPeriode){
       require_once 'CBdd.php';
            $cBdd= new CBdd();
            $bdd=$cBdd->getConnection();
       
       $q = $bdd->query('SELECT * FROM periode WHERE id = '.$idPeriode.'');
       $donnees = $q->fetch(PDO::FETCH_ASSOC);

       require_once 'CPeriodeStage.php';
       return new CPeriodeStage($donnees);        
    }    
}
