<?php

/* tableau.twig */
class __TwigTemplate_9fd1be5e6b58b7f796ab2b97ce8b9469dc9f8d467381b5de2f1724eb1ff80578 extends Twig_Template
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
        // line 7
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable(range(0, (twig_length_filter($this->env, (isset($context["entete"]) ? $context["entete"] : null)) - 1)));
        foreach ($context['_seq'] as $context["_key"] => $context["i"]) {
            // line 8
            echo "                    <th>";
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["entete"]) ? $context["entete"] : null), $context["i"], array(), "array"), "html", null, true);
            echo "</th>
                ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['i'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 10
        echo "            </tr>
        </thead> 
        
        <tbody>
    
            ";
        // line 15
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["donneesTableau"]) ? $context["donneesTableau"] : null));
        foreach ($context['_seq'] as $context["_key"] => $context["ligne"]) {
            // line 16
            echo "                <tr>
                    ";
            // line 17
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(range(1, twig_length_filter($this->env, (isset($context["entete"]) ? $context["entete"] : null))));
            foreach ($context['_seq'] as $context["_key"] => $context["i"]) {
                // line 18
                echo "                       <td><a href=\"";
                echo twig_escape_filter($this->env, (isset($context["href"]) ? $context["href"] : null), "html", null, true);
                echo twig_escape_filter($this->env, $this->getAttribute($context["ligne"], 0, array(), "array"), "html", null, true);
                echo "#";
                echo twig_escape_filter($this->env, (isset($context["idZone"]) ? $context["idZone"] : null), "html", null, true);
                echo "\">";
                echo twig_escape_filter($this->env, $this->getAttribute($context["ligne"], $context["i"], array(), "array"), "html", null, true);
                echo "</a></td>
                    ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['i'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 20
            echo "                </tr>    
            ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['ligne'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 22
        echo "            
        </tbody>
    </table>
    

  ";
    }

    public function getTemplateName()
    {
        return "tableau.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  78 => 22,  71 => 20,  57 => 18,  53 => 17,  50 => 16,  46 => 15,  39 => 10,  30 => 8,  26 => 7,  19 => 2,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "tableau.twig", "C:\\wamp64\\www\\gds_web3\\vues\\tableau.twig");
    }
}
