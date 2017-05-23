  <?php
  
  $idTuteur="";
  
  
  
    require_once 'modele/CControleurTuteur.php';
    $cControleurTuteur=new CControleurTuteur;
  
if (isset($_POST['ajouterTuteur'])){
    
    
    $donnees = array(
        "nom"=>$_POST['nom'], 
        "prenom"=>$_POST['prenom'],
        "mail"=>$_POST['mail'],
        "tel"=>$_POST['tel'] 
    );
        

    $idTuteur=$cControleurTuteur->ajouterTuteur($donnees);
    
}

if (isset($_POST['modifierTuteur'])){
    
    
    $donnees = array(
        "nom"=>$_POST['nom'], 
        "prenom"=>$_POST['prenom'],
        "mail"=>$_POST['mail'],
        "tel"=>$_POST['tel'] 
    );
    
    $id=1;
    

    $cControleurTuteur->modifierTuteur($donnees, $id);
}

  ?>

    <form action="test.php" method="post" id="form_tuteur">
        <div class="form-group">
            <label>Nom</label>
            <input type="text" name="nom">
        </div>
        <div class="form-group">
            <label>Prénom</label>
            <input type="text" name="prenom">
        </div>
        <div class="form-group">
            <label>Couriel</label>
            <input type="text" name="mail">
        </div>
        <div class="form-group">
            <label>Tel</label>
            <input type="text" name="tel">
        </div>
        <button name="ajouterTuteur" type="submit" class="btn btn-default">Ajouter</button>
        <button name="modifierTuteur" type="submit" class="btn btn-default">Modofier</button> 
    </form>


<?php echo $idTuteur ?>