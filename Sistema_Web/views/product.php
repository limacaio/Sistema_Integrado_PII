<?php
require_once "../controllers/CategoriaController.php";
require_once "../controllers/MarcaController.php";
require_once "../controllers/ProdutoController.php";

$produto = new Produto();
if (isset($_GET['produto'])){
    $produto = ProdutoController::buscarproduto($_GET['produto']);
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
    <div class="content col-sm-12">
      <div class="row">
        <div class="col-sm-5">
          <div class="thumbnails">
            <div><img src="image/products/<?php echo $produto->getImagem();?>" /></a></div>

          </div>
        </div>
        <div class="col-sm-7 prodetail">
          <h1 class="productpage-title"><?php echo $produto->getNome(); ?></h1>
          <ul class="list-unstyled productinfo-details-top">
            <li>
              <h2 class="productpage-price">R$ <?php echo number_format($produto->getValor(),2,',','');?></h2>
            </li>

          </ul>
          <hr>
          <ul class="list-unstyled product_info">
            <li>
              <label>Marca:</label>
              <span> <a href="#"><?php echo $produto->getMarca()->getDescricao();?></a></span></li>
            <li>
              <label>Código do Produto:</label>
              <span> <?php echo $produto->getIdProduto();?></span></li>
            <li>
              <label>Disponibilidade:</label>
              <span> Em Estoque</span></li>
          </ul>
          <hr>

          <div id="product">
            <div class="form-group">

              <div class="qty">
               
                  <ul class="button-group list-btn">

                      <li>
                          <a class="addtocart-btn" href="cart.php?produto=<?php echo $produto->getIdProduto();?>">
                              <i class="fa fa-shopping-bag"></i></a>

                      </li>
                  </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="productinfo-tab">
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab-description" data-toggle="tab">Descrição</a></li>

        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="tab-description">
            <div class="cpt_product_description ">
              <div>
                  <p></p><?php echo $produto->getDescricao(); ?></p>
              </div>
            </div>
            <!-- cpt_container_end --></div>

        </div>
      </div>

    </div>
  </div>
</div>


<script src="javascript/jquery.parallax.js"></script> 
<script>
    jQuery(document).ready(function ($) {
        $('.parallax').parallax();
    });
</script>
</body>
</html>
