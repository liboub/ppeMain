<?php
class Ctableau {
    private $table;
    private $donneesTableau = array();
    private $entete = array();
    private $href;
    private $idZone;
        
    function __construct($table,$selection,$entete,$href,$idZone) {
        $this->table=$table;
        $this->donneesTableau=$this->donnesTableau($selection);
        $this->entete = $entete;
        $this->href=$href;
        $this->idZone=$idZone;
    }
       
    private function donnesTableau($selection){
       require_once 'CBdd.php';
        $cBdd= new CBdd();
        $bdd=$cBdd->getConnection();
       
       $donneesTab=array();
       $y=0;        
       $q = $bdd->query('SELECT * FROM '.$this->table.'');
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
   
   function getTable() {
       return $this->table;
   }

       
    function getEntete() {
        return $this->entete;
    }

    function getDonneesTableau() {
        return $this->donneesTableau;
    }

    function getHref() {
        return $this->href;
    }
    
    function getIdZone() {
        return $this->idZone;
    }
}
?>
