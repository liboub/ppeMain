<?php


class CTuteur {
    private $id,
            $idEntreprise,
            $nom,
            $prenom,
            $mail,
            $tel;
    
    function __construct($donnees) {
        $this->id = $donnees['id'];
        $this->idEntreprise = $donnees['idEntreprise'];
        $this->nom = $donnees['nom'];
        $this->prenom = $donnees['prenom'];
        $this->mail = $donnees['mail'];
        $this->tel = $donnees['tel'];
    }

    
    function getId() {
        return $this->id;
    }

    function getIdEntreprise() {
        return $this->idEntreprise;
    }

    function getNom() {
        return $this->nom;
    }

    function getPrenom() {
        return $this->prenom;
    }

    function getMail() {
        return $this->mail;
    }

    function getTel() {
        return $this->tel;
    }


            
}
