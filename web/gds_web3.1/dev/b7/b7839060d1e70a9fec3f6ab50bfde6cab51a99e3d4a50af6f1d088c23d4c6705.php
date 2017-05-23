<?php

/* tableauTuteur.twig */
class __TwigTemplate_7b2c3612de0dbc9bff48e54b8bf50390b60bd2dd263b77aaab1f2c6dd55f5b53 extends Twig_Template
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
    <table id=\"tableau\" class=\"table table-striped table-bordered\" width=\"100%\" cellspacing=\"0\">
        <thead>
            <tr>
                ";
        // line 6
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable(range(0, (twig_length_filter($this->env, (isset($context["enteteT"]) ? $context["enteteT"] : null)) - 1)));
        foreach ($context['_seq'] as $context["_key"] => $context["i"]) {
            // line 7
            echo "                    <th>";
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["enteteT"]) ? $context["enteteT"] : null), $context["i"], array(), "array"), "html", null, true);
            echo "</th>
                ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['i'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 9
        echo "            </tr>
        </thead> 
        
        <tbody>
    
            ";
        // line 14
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["donneesTableauT"]) ? $context["donneesTableauT"] : null));
        foreach ($context['_seq'] as $context["_key"] => $context["ligne"]) {
            // line 15
            echo "                <tr>
                    ";
            // line 16
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(range(1, twig_length_filter($this->env, (isset($context["enteteT"]) ? $context["enteteT"] : null))));
            foreach ($context['_seq'] as $context["_key"] => $context["i"]) {
                // line 17
                echo "                       <td><a href=\"";
                echo twig_escape_filter($this->env, (isset($context["hrefT"]) ? $context["hrefT"] : null), "html", null, true);
                echo twig_escape_filter($this->env, $this->getAttribute($context["ligne"], 0, array(), "array"), "html", null, true);
                echo "#";
                echo twig_escape_filter($this->env, (isset($context["idZoneT"]) ? $context["idZoneT"] : null), "html", null, true);
                echo "\">";
                echo twig_escape_filter($this->env, $this->getAttribute($context["ligne"], $context["i"], array(), "array"), "html", null, true);
                echo "</a></td>
                    ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['i'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 19
            echo "                </tr>    
            ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['ligne'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 21
        echo "            
        </tbody>
    </table>
    
";
    }

    public function getTemplateName()
    {
        return "tableauTuteur.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  77 => 21,  70 => 19,  56 => 17,  52 => 16,  49 => 15,  45 => 14,  38 => 9,  29 => 7,  25 => 6,  19 => 2,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "tableauTuteur.twig", "C:\\wamp64\\www\\gds_web3\\vues\\tableauTuteur.twig");
    }
}
