<?php

/* formulaires/stagiaire_entreprise_vide.twig */
class __TwigTemplate_73fd85296a650b808989aac7701503ae2b3217192d477b9f0bd16020b061b567 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "<div id='form_entreprise_vide' class=\"form_entreprise_vide\">
    <h1>Enregistrer une nouvelle entreprise</h1>

    <form action=\"stagiaire.php\" method=\"post\" id=\"form_entreprise\">
        <div class=\"form-group\">
            <label>Raison Sociale</label>
            <input type=\"text\" name=\"nom\">
        </div>
        <div class=\"form-group\">
            <label>Numéro</label>
            <input type=\"text\" name=\"adnum\">
        </div>
        <div class=\"form-group\">
            <label>Rue</label>
            <input type=\"text\" name=\"adrue\">
        </div>
        <div class=\"form-group\">
            <label>Code Postal</label>
            <input type=\"text\" name=\"adcp\">
        </div>
        <div class=\"form-group\">
            <label>Ville</label>
            <input type=\"text\" name=\"adville\">
        </div>
        <div class=\"form-group\">
            <label>Tel</label>
            <input type=\"text\" name=\"tel\">
        </div>
        <div class=\"form-group\">
            <label>Mail</label>
            <input type=\"text\" name=\"mail\">
        </div>
        <div class=\"form-group\">
            <label>Siret</label>
            <input type=\"text\" name=\"siret\">
        </div>
        <div class=\"form-group\">
            <label>APE</label>
            <input type=\"text\" name=\"ape\">
        </div>
        <button name=\"form_entreprise_creer\" type=\"submit\" class=\"btn btn-default\">Modifier</button>
      
        
    </form>
</div>
";
    }

    public function getTemplateName()
    {
        return "formulaires/stagiaire_entreprise_vide.twig";
    }

    public function getDebugInfo()
    {
        return array (  19 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "formulaires/stagiaire_entreprise_vide.twig", "C:\\wamp64\\www\\gds_web3\\vues\\formulaires\\stagiaire_entreprise_vide.twig");
    }
}
