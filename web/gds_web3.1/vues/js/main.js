/* Tableau */
$(document).ready(function () {
$('#tableau').DataTable({"language": {"url":"//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"}});
});


 function ajoutPeriode() {
        $('.ajoutPeriode').slideToggle();
        }
        
        function formVide() { 
        document.getElementById("form_entreprise_vide").style.display="block";
        $('.ajoutPeriode').slideToggle();
        
        }
        
        function ajoutTuteur() { 
        document.getElementById("tuteur_ajout").style.display="block";
        document.getElementById("tuteur_liste").style.display="none";    
        
        
        }
        
        $(document).ready(function(){
           $(".stagiaire").fadeIn(8000);
        });
        
        