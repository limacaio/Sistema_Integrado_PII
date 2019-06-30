<?php
require_once "../controllers/CategoriaController.php";
require_once "../controllers/MarcaController.php";
require_once "../controllers/ProdutoController.php";

$listaCategorias = CategoriaController::trazerTodos();

$listaProdutos = null;
if (isset($_GET['genero'])){
    //$listaProdutos = ProdutoController::trazerTodosPorGenero($_GET['categoria']);
}else{
    //$listaProdutos = ProdutoController::trazerTodos();
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
<title>MoonStore</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="e-commerce site well design with responsive view." />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="image/favicon.png" rel="icon" type="image/png" >
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
<link href="javascript/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
<link href='https://fonts.googleapis.com/css?family=Roboto:100,200,300,400,500,700,900' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i,900,900i" rel="stylesheet">
<link href="css/stylesheet.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="javascript/owl-carousel/owl.carousel.css" type="text/css" rel="stylesheet" media="screen" />
<link href="javascript/owl-carousel/owl.transitions.css" type="text/css" rel="stylesheet" media="screen" />
<script type="text/javascript" src="javascript/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="javascript/bootstrap/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="javascript/template_js/jstree.min.js"></script>
<script type="text/javascript" src="javascript/template_js/template.js"></script>
<script type="text/javascript" src="javascript/common.js" ></script>
<script type="text/javascript" src="javascript/global.js" ></script>
<script type="text/javascript" src="javascript/owl-carousel/owl.carousel.min.js"></script>
</head>
<body class="category col-2 left-col">
<div class="preloader loader" style="display: block;"> <img src="image/loader.gif"  alt="#"/></div>
<header>
    <!--Header-->
    <?php
    include_once "header.php";
    ?>
</header>

<div class="container">
  <div class="row">
    <div id="column-left" class="col-sm-3 hidden-xs column-left">
      <div class="Categories left-sidebar-widget">
        <div class="columnblock-title">Categorias</div>
        <div class="category_block">
          <ul class="box-category treeview">
              <?php
              foreach ($listaCategorias as $categoria){
                  echo "<li>
                <a href=\"index.php?categoria=".$categoria->getIdCategoria()."\"><?php echo (string)$categoria->getDescricao(); ?></a>
                
              <ul>
                <li><a href=\"#\">PC</a></li>
                <li><a href=\"#\">MAC</a></li>
              </ul>
            </li>";
              }
              ?>
              </ul>
        
        </div>
      </div>


    </div>
    <div class=" content col-sm-9">
      <div class="category-page-wrapper">


        <div class="col-md-9 list-grid-wrapper">
          <div class="btn-group btn-list-grid">
            <button type="button" id="list-view" class="btn btn-default list" data-toggle="tooltip" title="List"></button>
            <button type="button" id="grid-view" class="btn btn-default grid" data-toggle="tooltip" title="Grid"></button>
          </div>
        </div>
      </div>
      <br />
      <div class="grid-list-wrapper">
        <div class="product-layout product-list col-xs-12">
          <div class="product-thumb">
            <div class="image product-imageblock">
            <a href="product.html">
            <img src="image/product/Pro-04.jpg" alt="iPod Classic" title="iPod Classic" class="img-responsive" />
            <img src="image/product/Pro-04-1.jpg" alt="iPod Classic" title="iPod Classic" class="img-responsive" />
            </a>
              <ul class="button-group grid-btn">

                <li>
                  <button type="button" class="addtocart-btn" title="Adicionar ao Carrinho">Adicionar ao Carrinho</button>
                </li>
              </ul>
            </div>
            <div class="caption product-detail">
              <div class="rating"> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i><i class="fa fa-star fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i><i class="fa fa-star fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i><i class="fa fa-star fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i><i class="fa fa-star fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> </div>
              <h4 class="product-name"><a href="#" title="Produto Teste">Produto Teste</a></h4>
              <p class="price product-price">$122.00<span class="price-tax">Ex Tax: $100.00</span></p>
              <p class="product-desc"> More room to move.
                
                With 80GB or 160GB of storage and up to 40 hours of battery life, the new iPod classic lets you enjoy up to 40,000 songs or up to 200 hours of video or any combination wherever you go.
                
                Cover Flow.
                
                Browse through your music collection by flipping..</p>
              <ul class="button-group list-btn">

                <li>
                  <button type="button" class="addtocart-btn" data-toggle="tooltip" data-placement="top" title="Adicionar ao Carrinho"  ><i class="fa fa-shopping-bag"></i></button>
                </li>
              </ul>
            </div>
          </div>
        </div>

      </div>

    </div>
  </div>
</div>
<div class="container">

</div>

<script src="javascript/jquery.parallax.js"></script> 
<script>
    jQuery(document).ready(function ($) {
        $('.parallax').parallax();
    });
</script>
</body>
</html>