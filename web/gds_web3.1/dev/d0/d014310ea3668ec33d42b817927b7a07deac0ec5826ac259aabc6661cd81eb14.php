<?php

/* stagiaire.twig */
class __TwigTemplate_f5e34efcb0f3d2fd73838df07be1c315d6afe9922ebed7e68b2dfe2aba9b7e7c extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("layout.html.twig", "stagiaire.twig", 1);
        $this->blocks = array(
            'body' => array($this, 'block_body'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $this->parent->display($context, array_merge($this->blocks, $blocks));
    }

    public function block_body($context, array $blocks = array())
    {
        // line 2
        echo "
<section class=\"row stagiaire\">

    <button class=\"btn btn-primary btn-lg btn-block\" onclick=\"ajoutPeriode()\">Ajouter une période</button>
    <div id=\"ajoutPeriode\" class=\"ajoutPeriode col-lg-12\" style=\"";
        // line 6
        echo twig_escape_filter($this->env, (isset($context["display_ajoutPeriode"]) ? $context["display_ajoutPeriode"] : null), "html", null, true);
        echo "\">

        <div id=\"periode\" class=\"periode block col-lg-offset-1 col-lg-10\" style=\"";
        // line 8
        echo twig_escape_filter($this->env, (isset($context["display_periode"]) ? $context["display_periode"] : null), "html", null, true);
        echo "\">
            <p>periode</p>
            ";
        // line 10
        $this->loadTemplate("formulaires/stagiaire_periode_date.twig", "stagiaire.twig", 10)->display($context);
        // line 11
        echo "        </div>

        <div id=\"entreprise\" class=\"entreprise block col-lg-offset-1 col-lg-10\" style=\"";
        // line 13
        echo twig_escape_filter($this->env, (isset($context["display_entreprise"]) ? $context["display_entreprise"] : null), "html", null, true);
        echo "\">
            <p>entreprise</p>
            ";
        // line 15
        $this->loadTemplate("tableau.twig", "stagiaire.twig", 15)->display($context);
        // line 16
        echo "            <button class=\"btn btn-primary col-lg-offset-6 col-lg-4\" onclick=\"formVide()\">L'entreprise n'est pas dans la liste</button>
        </div>

        <div id=\"formEntrepriseComplete\" class=\"formEntrepriseComplete block col-lg-offset-1 col-lg-10\" style=\"";
        // line 19
        echo twig_escape_filter($this->env, (isset($context["display_formEntrepriseComplete"]) ? $context["display_formEntrepriseComplete"] : null), "html", null, true);
        echo "\">
            <p>formEntrepriseComplete</p>
            ";
        // line 21
        $this->loadTemplate("formulaires/stagiaire_entreprise_complete.twig", "stagiaire.twig", 21)->display($context);
        // line 22
        echo "        </div>

        <div id=\"tuteur_liste\" class=\"tuteur_liste block col-lg-offset-1 col-lg-10\" style=\"";
        // line 24
        echo twig_escape_filter($this->env, (isset($context["display_tuteur_liste"]) ? $context["display_tuteur_liste"] : null), "html", null, true);
        echo "\">
            <p>tuteur_liste</p>
            ";
        // line 26
        $this->loadTemplate("tableauTuteur.twig", "stagiaire.twig", 26)->display($context);
        // line 27
        echo "            <button class=\"btn btn-primary col-lg-offset-6 col-lg-4\" onclick=\"ajoutTuteur()\">Le tuteur n'est pas dans la liste</button>
        </div>

        <div id=\"tuteur_modif\" class=\"tutueur_modif block col-lg-offset-1 col-lg-10\" style=\"";
        // line 30
        echo twig_escape_filter($this->env, (isset($context["display_tuteur_modif"]) ? $context["display_tuteur_modif"] : null), "html", null, true);
        echo "\">
            <p>tuteur_modif</p>
            ";
        // line 32
        $this->loadTemplate("formulaires/modifTuteur.twig", "stagiaire.twig", 32)->display($context);
        // line 33
        echo "        </div>
        
        <div id=\"tuteur_ajout\" class=\"tutueur_modif block col-lg-offset-1 col-lg-10\" style=\"";
        // line 35
        echo twig_escape_filter($this->env, (isset($context["display_tuteur_ajout"]) ? $context["display_tuteur_ajout"] : null), "html", null, true);
        echo "\">
            <p>tuteur_ajout</p>
            ";
        // line 37
        $this->loadTemplate("formulaires/ajoutTuteur.twig", "stagiaire.twig", 37)->display($context);
        // line 38
        echo "        </div>

        <div id=\"recap\" class=\"recap block col-lg-offset-1 col-lg-10\" style=\"";
        // line 40
        echo twig_escape_filter($this->env, (isset($context["display_recap"]) ? $context["display_recap"] : null), "html", null, true);
        echo "\">
            <p>recap</p>
        </div>
    </div>

    ";
        // line 45
        $this->loadTemplate("formulaires/stagiaire_entreprise_vide.twig", "stagiaire.twig", 45)->display($context);
        echo " 
    
    

</section>

";
    }

    public function getTemplateName()
    {
        return "stagiaire.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  117 => 45,  109 => 40,  105 => 38,  103 => 37,  98 => 35,  94 => 33,  92 => 32,  87 => 30,  82 => 27,  80 => 26,  75 => 24,  71 => 22,  69 => 21,  64 => 19,  59 => 16,  57 => 15,  52 => 13,  48 => 11,  46 => 10,  41 => 8,  36 => 6,  30 => 2,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "stagiaire.twig", "C:\\wamp64\\www\\gds_web3\\vues\\stagiaire.twig");
    }
}
