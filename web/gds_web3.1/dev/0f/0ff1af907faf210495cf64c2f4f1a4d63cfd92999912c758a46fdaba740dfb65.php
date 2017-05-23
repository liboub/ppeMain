<?php

/* layout.html.twig */
class __TwigTemplate_9c74dc524536da1c7f1f3384d5ae606dd526bdc20e507a1e4ab2ef1ac51564a5 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'body' => array($this, 'block_body'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 2
        echo "<!doctype html>
<html class=\"no-js\" lang=\"\">
    <head>
        <meta charset=\"utf-8\">
        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">
        <title></title>
        <meta name=\"description\" content=\"\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">

        

        <link rel=\"stylesheet\" href=\"vues/css/normalize.css\">
        <link rel=\"stylesheet\" href=\"vues/css/main.css\">
        <link rel=\"stylesheet\" href=\"vues/css/bootstrap.css\">
        <link rel=\"stylesheet\" href=\"vues/css/bootstrap-theme.css\">
        <!-- Style tableau -->
        <link rel=\"stylesheet\" href=\"vues/css/dataTables.bootstrap.min.css\">
        
        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\" rel=\"stylesheet\">
    
        <script src=\"vues/js/vendor/modernizr-2.8.3.min.js\"></script>
    </head>
\t
\t<body>
\t\t
\t\t
\t\t
\t\t<section class='container-fluid'> 
                          ";
        // line 30
        $this->displayBlock('body', $context, $blocks);
        // line 32
        echo "\t\t</section>

        
        </body>
                            

          
        
          <!--***********************************************************************************************************************************
         *                   SCRIPT
        **************************************************************************************************************************************-->

        <script src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>
        <script>window.jQuery || document.write('<script src=\"vues/js/vendor/jquery-1.12.0.min.js\"><\\/script>')</script>
        <script src=\"vues/js/plugins.js\"></script>
        <script src=\"vues/js/main.js\"></script>
        <script src=\"vues/js/bootstrap.js\"></script>
        
        <!-- script tableau -->
        <script src=\"vues/js/jquery.dataTables.min.js\"></script>
        <script src=\"vues/js/dataTables.bootstrap.min.js\"></script>
        
   
        
        

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='https://www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>
    
</html>

";
    }

    // line 30
    public function block_body($context, array $blocks = array())
    {
        // line 31
        echo "                          ";
    }

    public function getTemplateName()
    {
        return "layout.html.twig";
    }

    public function getDebugInfo()
    {
        return array (  97 => 31,  94 => 30,  52 => 32,  50 => 30,  20 => 2,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("", "layout.html.twig", "C:\\wamp64\\www\\gds_web3\\vues\\layout.html.twig");
    }
}
