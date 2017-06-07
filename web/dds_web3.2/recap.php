<?php

        require_once 'modele/CControleurPeriodeStage.php';
        $cControleurPeriodeStage = new CControleurPeriodeStage();

        require_once 'modele/CControleurEntreprise.php';
        $cControleurEntreprise=new CControleurEntreprise;
        
        require_once 'modele/CControleurStagiaire.php';
        $cControleurStagiaire=new CControleurStagiaire();
  
        require_once 'modele/CControleurFormateur.php';
        $cControleurFormateur=new CControleurFormateur();
          
        require_once 'modele/CControleurTuteur.php';
        $cControleurTuteur=new CControleurTuteur();

$idPeriode=1;//période recupérée en GET

$periode=$cControleurPeriodeStage->unePeriode($idPeriode);

$entreprise=$cControleurEntreprise->uneEntreprise($periode->getIdEntreprise());

$stagiaire=$cControleurStagiaire->unStagiaire($periode->getIdStagiaire());

$formateur=$cControleurFormateur->unFormateur($periode->getIdFormateur());

$tuteur=$cControleurTuteur->unTuteur($periode->getIdTuteur());


echo 'date debut'.$periode->getDateDebut().'<br>';

echo 'date nom entreprise'.$entreprise->getNom().'<br>';

echo 'nom stagiare'.$stagiaire->getNom().'<br>';




echo 'date debut'.$periode->getDateDebut().'<br>';

echo 'date debut'.$periode->getDateDebut().'<br>';






