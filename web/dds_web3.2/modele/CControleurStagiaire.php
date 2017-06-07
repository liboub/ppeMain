<?php


class CControleurStagiaire {
    
    private $unStagiaire;
    private $listeStagiaire;
   
    function __construct() {
        
    }
  
    public function unStagiaire($idStagiaire){
       require_once 'CBdd.php';
        $cBdd= new CBdd();
        $bdd=$cBdd->getConnection();
       
       $q = $bdd->query('SELECT * FROM stagiaire WHERE id = '.$idStagiaire.'');
       $donnees = $q->fetch(PDO::FETCH_ASSOC);
       
       require_once 'CStagiaire.php';
       return new CStagiaire($donnees);   
   }


   
   public function listeTuteur($idStagiaire,$selection){
       require_once 'CBdd.php';
        $cBdd= new CBdd();
        $bdd=$cBdd->getConnection();
       
       $donneesTab=array();
       $y=0;        
       $q = $bdd->query('SELECT id, nom, prenom  FROM stagiaire WHERE idEntreprise = '.$idStagiaire.'');
       while ($donnees = $q->fetch(PDO::FETCH_ASSOC)){
           $i=0;
           $ligne=array();
           foreach ($selection as $Colonne){
             $ligne[$i]= $donnees[$selection[$i]];  
             $i++;
           }
           $donneesTab[$y] = $ligne;
           $y++;
       }
       return $donneesTab;   
   }
   
    
}









    

