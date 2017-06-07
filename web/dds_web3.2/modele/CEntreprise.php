<?php

class CEntreprise {
    private $id,
            $nom,
            $adnum,
            $adrue,
            $adville,
            $adcp,
            $tel,
            $mail,
            $siret,
            $ape;
    
    function __construct($donnees) {
        $this->id = $donnees['id'];
        $this->nom = $donnees['nom'];
        $this->adnum = $donnees['adnum'];
        $this->adrue = $donnees['adrue'];
        $this->adville = $donnees['adville'];
        $this->adcp = $donnees['adcp'];
        $this->tel = $donnees['tel'];
        $this->mail = $donnees['mail'];
        $this->siret = $donnees['siret'];
        $this->ape = $donnees['ape'];
    }

    function getId() {
        return $this->id;
    }

    function getNom() {
        return $this->nom;
    }
    
    function getAdnum() {
        return $this->adnum;
    }

    
    function getAdrue() {
        return $this->adrue;
    }

    function getAdville() {
        return $this->adville;
    }

    function getAdcp() {
        return $this->adcp;
    }

    function getTel() {
        return $this->tel;
    }

    function getMail() {
        return $this->mail;
    }

    function getSiret() {
        return $this->siret;
    }

    function getApe() {
        return $this->ape;
    }


    
    
}
