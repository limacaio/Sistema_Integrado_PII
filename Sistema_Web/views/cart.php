<?php

require_once "../controllers/CarrinhoController.php";
session_start();

if (isset($_GET['produto']))
{
    CarrinhoController::adicionarItem($_GET['produto']);
}
if (isset($_GET['excluir'])){
    CarrinhoController::removerItemCarrinho($_GET['excluir']);
}
if (isset($_POST['qtd0'])){
    CarrinhoController::atualizarCarrinho($_POST);
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
</header>
<?php
if (!isset($_SESSION['carrinho'])){
    echo "<br><h3 align='center'>Carrinho de compras vazio</h3>";
    echo "<br><br><br><br>";
    echo "<p align='center'><a class='btn btn-primary' href='index.php'>Voltar para o Shopping</a></p>";
}else {
?>
<div class="container">
  <div class="row">

    <div class="col-sm-12" id="content">
      <form enctype="multipart/form-data" method="post" id="formcarrinho" action="#">
        <div class="table-responsive">
          <table class="table table-bordered">

            <thead>
              <tr>
                <td class="text-center">Imagem</td>
                <td class="text-left">Nome do Produto</td>
                <td class="text-left">Categoria</td>
                <td class="text-left">Quantidade</td>
                <td class="text-right">Preço Unitário</td>
                <td class="text-right">Total</td>
              </tr>
            </thead>
            <tbody>
            <?php
            $carrinho = unserialize($_SESSION['carrinho']);
            $posicao = 0;
            $total = 0;
            foreach ($carrinho as $itemCarrinho) {
            ?>
              <tr>
                <td class="text-center"><a href=image/products/<?php echo $itemCarrinho->getProduto()->getImagem();?>><img class="img-thumbnail" title="iPhone" alt="iPhone" src="image/product/2product56x72.jpg"></a></td>
                <td class="text-left"><a href="product.php"><?php echo $itemCarrinho->getProduto()->getNome();?></a></td>
                <td class="text-left"><?php echo $itemCarrinho->getProduto()->getCategoria()->getDescricao();?></td>
                <td class="text-left"><div style="max-width: 200px;" class="input-group btn-block">
                    <input type="number" class="form-control quantity" size="1" min="1" name="qtd<?php echo $posicao;?>" value="<?php echo $itemCarrinho->getQuantidade();?>">
                    <span class="input-group-btn">
                    <button class="btn btn-primary" title="" data-toggle="tooltip" type="submit" onClick="document.getElementById('formcarrinho').submit();"data-original-title="Atualizar"><i class="fa fa-refresh"></i></button>
                    <a  class="btn btn-danger"  href="cart.php?excluir=<?php echo $posicao;?>" title="" data-toggle="tooltip" type="button" data-original-title="Remove"><i class="fa fa-times-circle"></i></a>
                    </span></div></td>
                <td class="text-right">R$ <?php echo number_format($itemCarrinho->getProduto()->getValor(),2,',','');?></td>
                <td class="text-right">R$ <?php echo number_format($itemCarrinho->getProduto()->getValor()*$itemCarrinho->getQuantidade(),2,',','');?></td>

              </tr>
                <?php
                $total += $itemCarrinho->getQuantidade() * $itemCarrinho->getProduto()->getValor();
                $posicao++;
            }
            ?>
            </tbody>
          </table>
        </div>
      </form>

      <br>
      <div class="row">
        <div class="col-sm-4 col-sm-offset-8">
          <table class="table table-bordered">
            <tbody>

              <tr>
                <td class="text-right"><strong>Total:</strong></td>
                <td class="text-right">$254.00</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div class="buttons">
        <div class="pull-left"><a class="btn btn-default" href="index.php">Continue Comprando</a></div>
        <div class="pull-right"><a class="btn btn-primary" href="checkout.php">Finalizar Compra</a></div>
      </div>
    </div>
  </div>
</div>
<?php
}
?>

<script src="javascript/jquery.parallax.js"></script> 
<script>
    jQuery(document).ready(function ($) {
        $('.parallax').parallax();
    });
</script>
</body>
</html>