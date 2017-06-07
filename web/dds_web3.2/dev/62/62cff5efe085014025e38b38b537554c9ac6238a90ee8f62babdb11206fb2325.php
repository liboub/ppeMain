<?php

/* header.twig */
class __TwigTemplate_ca830a4d15dfe170a41bad7faa5bbe8f2afff6e7074f8825f955a0e64f51583c extends Twig_Template
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
        echo "<div class=\" haut navbar\">

    <div class=\" col-md-3 col-md-offset-1\">
        <img src=\"vues/img/logoGEB3.gif\" width=\"200\" height=\"230\" class=\"img-responsive\" alt=\"image greta\">
    </div>
    <div class=\"col-md-offset-3\">
        <h1>gestion des periodes de stage </h1>
    </div>
</div>
";
    }

    public function getTemplateName()
    {
        return "header.twig";
    }

    public function getDebugInfo()
    {
        return array (  19 => 2,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "header.twig", "C:\\wamp64\\www\\gds_web2.6\\vues\\header.twig");
    }
}
