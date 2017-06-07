<?php


class CControleurFormateur {
    
    private $unFormateur;
    private $listeFormateur;
   
    function __construct() {
        
    }
  
    public function unFormateur($idFormateur){
       require_once 'CBdd.php';
        $cBdd= new CBdd();
        $bdd=$cBdd->getConnection();
       
       $q = $bdd->query('SELECT * FROM formateur WHERE id = '.$idFormateur.'');
       $donnees = $q->fetch(PDO::FETCH_ASSOC);
       
       require_once 'CFormateur.php';
       return new CFormateur($donnees);   
   }    
}









    

