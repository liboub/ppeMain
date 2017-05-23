<?php

class CPeriodeStage {
    private $id,
            $dateDebut,
            $dateFin,
            $datevisite,
            $poste,
            $activite,
            $noteFormateur,
            $visiteEffectue,
            $idFormateur,
            $idStagiaire,
            $idEntreprise,
            $idTuteur;
    
        function __construct($donnees) {
        $this->id = $donnees['id'];
        $this->dateDebut = $donnees['dateDebut'];
        $this->dateFin = $donnees['dateFin'];
        $this->dateVisite = $donnees['dateVisite'];
        $this->poste = $donnees['poste'];
        $this->activite = $donnees['activite'];
        $this->noteFormateur = $donnees['noteFormateur'];
        $this->visiteEffectue = $donnees['visiteEffectue'];
        $this->idFormateur = $donnees['idFormateur'];
        $this->idStagiaire = $donnees['idStagiaire'];
        $this->idEntreprise = $donnees['idEntreprise'];
        $this->idTuteur = $donnees['idTuteur'];
    }

    function getId() {
        return $this->id;
    }

    function getDateDebut() {
        return $this->dateDebut;
    }

    function getDateFin() {
        return $this->dateFin;
    }

    function getDatevisite() {
        return $this->datevisite;
    }

    function getPoste() {
        return $this->poste;
    }

    function getActivites() {
        return $this->activites;
    }

    function getNoteFormateur() {
        return $this->noteFormateur;
    }

    function getVisiteEffectue() {
        return $this->visiteEffectue;
    }

    function getIdFormateur() {
        return $this->idFormateur;
    }

    function getIdStagiaire() {
        return $this->idStagiaire;
    }

    function getIdEntreprise() {
        return $this->idEntreprise;
    }

    function getIdTuteur() {
        return $this->idTuteur;
    }


    
    
    
}

