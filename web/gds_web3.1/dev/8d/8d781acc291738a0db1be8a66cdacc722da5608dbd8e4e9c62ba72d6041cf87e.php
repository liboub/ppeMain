<?php

/* formulaires/modifTuteur.twig */
class __TwigTemplate_ac173302775881a8db5af7565f495b38cf6c6f4d2ea6319edf2adb2a96d800e3 extends Twig_Template
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
        // line 2
        echo "

    <form action=\"stagiaire.php\" method=\"post\" id=\"modif_tuteur\" class=\"modif_tuteur\">
        <div class=\"form-group\">
            <label>Nom</label>
            <input type=\"text\" name=\"nom\" value='";
        // line 7
        echo twig_escape_filter($this->env, (isset($context["nomTuteur"]) ? $context["nomTuteur"] : null), "html", null, true);
        echo "'>
        </div>
        <div class=\"form-group\">
            <label>Prénom</label>
            <input type=\"text\" name=\"prenom\" value='";
        // line 11
        echo twig_escape_filter($this->env, (isset($context["prenomTuteur"]) ? $context["prenomTuteur"] : null), "html", null, true);
        echo "'>
        </div>
        <div class=\"form-group\">
            <label>Couriel</label>
            <input type=\"text\" name=\"mail\" value='";
        // line 15
        echo twig_escape_filter($this->env, (isset($context["mailTuteur"]) ? $context["mailTuteur"] : null), "html", null, true);
        echo "'>
        </div>
        <div class=\"form-group\">
            <label>Tel</label>
            <input type=\"text\" name=\"tel\" value='";
        // line 19
        echo twig_escape_filter($this->env, (isset($context["telTuteur"]) ? $context["telTuteur"] : null), "html", null, true);
        echo "'>
        </div>
        <button name=\"validerTuteur\" type=\"submit\" class=\"btn btn-default\">Valider</button>
        <button name=\"modifierTuteur\" type=\"submit\" class=\"btn btn-default\">Modifier</button> 
    </form>";
    }

    public function getTemplateName()
    {
        return "formulaires/modifTuteur.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  47 => 19,  40 => 15,  33 => 11,  26 => 7,  19 => 2,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "formulaires/modifTuteur.twig", "C:\\wamp64\\www\\gds_web3\\vues\\formulaires\\modifTuteur.twig");
    }
}
