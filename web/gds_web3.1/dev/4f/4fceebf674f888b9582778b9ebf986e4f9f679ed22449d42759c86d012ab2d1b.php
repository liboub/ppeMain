<?php

/* formulaires/stagiaire_entreprise_complete.twig */
class __TwigTemplate_2581f6eb20ca52f2bfc52200bef21ac30f0bc94e05851c4b0507903d5a0e9003 extends Twig_Template
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
        echo "<div id='form_entreprise_complete' class=\"form_entreprise_complete form-horizontal\">
    <h1>Information de l'entreprise</h1>

    <form action=\"stagiaire.php\" method=\"post\" id=\"form_entreprise\">
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Raison Sociale</label>
            <input type=\"text\" name=\"nom\" value=\"";
        // line 7
        echo twig_escape_filter($this->env, (isset($context["nom"]) ? $context["nom"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Numéro</label>
            <input type=\"text\" name=\"adnum\" value=\"";
        // line 11
        echo twig_escape_filter($this->env, (isset($context["adnum"]) ? $context["adnum"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Rue</label>
            <input type=\"text\" name=\"adrue\" value=\"";
        // line 15
        echo twig_escape_filter($this->env, (isset($context["adrue"]) ? $context["adrue"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Code Postal</label>
            <input type=\"text\" name=\"adcp\" value=\"";
        // line 19
        echo twig_escape_filter($this->env, (isset($context["adcp"]) ? $context["adcp"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Ville</label>
            <input type=\"text\" name=\"adville\" value=\"";
        // line 23
        echo twig_escape_filter($this->env, (isset($context["adville"]) ? $context["adville"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Tel</label>
            <input type=\"text\" name=\"tel\" value=\"";
        // line 27
        echo twig_escape_filter($this->env, (isset($context["tel"]) ? $context["tel"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Mail</label>
            <input type=\"text\" name=\"mail\" value=\"";
        // line 31
        echo twig_escape_filter($this->env, (isset($context["mail"]) ? $context["mail"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">Siret</label>
            <input type=\"text\" name=\"siret\" value=\"";
        // line 35
        echo twig_escape_filter($this->env, (isset($context["siret"]) ? $context["siret"] : null), "html", null, true);
        echo "\">
        </div>
        <div class=\"form-group\">
            <label class=\"col-lg-2\">APE</label>
            <input type=\"text\" name=\"ape\" value=\"";
        // line 39
        echo twig_escape_filter($this->env, (isset($context["ape"]) ? $context["ape"] : null), "html", null, true);
        echo "\">
        </div>
        <button name=\"form_entreprise_modifier\" type=\"submit\" class=\"btn btn-default\">Modifier</button>
        <button name=\"valider\" type=\"submit\" class=\"btn btn-default\">Valider</button>
        
    </form>
</div>
";
    }

    public function getTemplateName()
    {
        return "formulaires/stagiaire_entreprise_complete.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  83 => 39,  76 => 35,  69 => 31,  62 => 27,  55 => 23,  48 => 19,  41 => 15,  34 => 11,  27 => 7,  19 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "formulaires/stagiaire_entreprise_complete.twig", "C:\\wamp64\\www\\gds_web3\\vues\\formulaires\\stagiaire_entreprise_complete.twig");
    }
}
