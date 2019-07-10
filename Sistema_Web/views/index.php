<?php
require_once "../controllers/CategoriaController.php";
require_once "../controllers/MarcaController.php";
require_once "../controllers/ProdutoController.php";

$listaCategorias = CategoriaController::trazerTodos();
$listaMarcas = null;
$listaProdutos = null;
$listaProdutos = ProdutoController::trazerTodos();

if (isset($_GET['categoria']))
{
    $listaProdutos = ProdutoController::trazerTodosPorCategoria($_GET['categoria']);
}
elseif (isset($_GET['categoria'])&&isset($_GET['marca']))
{
    $listaProdutos = ProdutoController::trazerTodosPorcategoriaEMarca($_GET['categoria'],$_GET['marca']);
}
else{
    $listaProdutos = ProdutoController::trazerTodos();
}



?>


<!DOCTYPE html>
<html lang="en">
<head>
<title>IFStore</title>
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
              foreach ($listaCategorias as $categoria) {
                  echo '<li>';
                  echo ' <a href=\'index.php?categoria='.$categoria->getIdCategoria()."'>".$categoria->getDescricao().'</a>';
                  echo ' <ul>';
                  $listaMarcas = MarcaController::trazerTodasMarcasPorCategoria($categoria->getIdCategoria());
                  foreach ($listaMarcas as $marca) {
                      echo ' <li><a href=\'index.php?categoria='.$categoria->getIdCategoria().'&marca='.$marca->getIdMarca().
                      "\'>".$marca->getDescricao().'</a></li>';
                  }
                  echo ' </ul>';
                  echo '</li>';
              }



              ?>

              </ul>
        </div>
      </div>


    </div>
    <div class=" content col-sm-9">

      <br />
      <div class="grid-list-wrapper">
        <div class="product-layout product-list col-xs-12">

            <!-- lista de produtos -->
            <?php
            foreach ($listaProdutos as $produto){
               ?>
                <div class="product-thumb">
            <div class="image product-imageblock">
            <a href="product.php">
            <img src="image/products/<?php echo $produto->getImagem();?>" class="img-responsive" width="100px" height="200px" />
            </a>
              <ul class="button-group grid-btn">

                <li>
                  <button type="button" class="addtocart-btn" title="Adicionar ao Carrinho">Adicionar ao Carrinho</button>
                </li>
              </ul>
            </div>
            <div class="caption product-detail">

                <h4 class="product-name">

                    <a href=product.php?produto=<?php echo $produto->getIdProduto();?>><?php echo $produto->getNome()?></a>
                </h4>
              <p class="price product-price">R$ <?php echo number_format($produto->getValor(),2,',','');?><span class="price-tax"></span></p>
              <p class="product-desc"><?php echo $produto->getDescricao();?>.</p>
              <ul class="button-group list-btn">

                <li>
                  <button type="button" class="addtocart-btn" data-toggle="tooltip" data-placement="top" title="Adicionar ao Carrinho"  ><i class="fa fa-shopping-bag"></i></button>
                </li>
              </ul>
            </div>


          </div>


            <?php }  ?>
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