<?php
session_start();

require_once "../controllers/VendaController.php";
require_once "../controllers/CarrinhoController.php";
require_once "../controllers/ItemVendaController.php";


    if (isset($_SESSION['carrinho'])) {
        //$venda = new Venda();
        //$venda->setCliente(unserialize($_SESSION['user']));
       // $venda->setDataVenda(date('Y-m-d'));
       // VendaController::inserir($venda);
       // $venda = VendaController::buscarVenda($venda);

        $carrinho = unserialize($_SESSION['carrinho']);

        foreach ($carrinho as $itemCarrinho) {
           // $itemVenda = new ItemVenda();
            //$itemVenda->setVenda($venda);
            //$itemVenda->setProduto($itemCarrinho->getProduto());
//            $itemVenda->setValorProduto($itemCarrinho->getProduto()->getValor());
            //ItemVendaController::inserir($itemVenda);
        }
        //unset($_SESSION['carrinho']);
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

    <div class="col-sm-9" id="content">
      <div id="accordion" class="panel-group">

        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title"><a class="accordion-toggle collapsed" data-parent="#accordion" data-toggle="collapse" href="#collapse-shipping-address" aria-expanded="false">Detalhes da Entrega <i class="fa fa-caret-down"></i></a></h4>
          </div>
          <div id="collapse-shipping-address" role="heading" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body">
              <form class="form-horizontal">
                <div class="radio">
                  <label>
                    <input type="radio" checked="checked" value="existing" name="shipping_address">
                    Eu quero usar este endereço para a entrega:</label>
                </div>
                <div id="shipping-existing" >
                  <select class="form-control" name="address_id">
                    <option selected="selected" value="4" label="#"></option>
                  </select>
                </div>

                </div>

              </form>
              <script type="text/javascript">
$('input[name=\'shipping_address\']').on('change', function() {
	if (this.value == 'new') {
		$('#shipping-existing').hide();
		$('#shipping-new').show();
	} else {
		$('#shipping-existing').show();
		$('#shipping-new').hide();
	}
});
</script>
            </div>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title"><a class="accordion-toggle" data-parent="#accordion" data-toggle="collapse" href="#collapse-checkout-confirm" aria-expanded="true">Confirmar pedido <i class="fa fa-caret-down"></i></a></h4>
          </div>
          <div id="collapse-checkout-confirm" role="heading" class="panel-collapse collapse in" aria-expanded="true" style="">
            <div class="panel-body">
              <div class="table-responsive">
                <table class="table table-bordered table-hover" >
                  <thead>
                    <tr>
                      <td class="text-left">Nome do Produto</td>
                      <td class="text-left">Categoria</td>
                      <td class="text-right">Quantidade</td>
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

                        <td class="text-left"><?php echo $itemCarrinho->getProduto()->getNome()?></td>
                      <td class="text-left"><?php echo $itemCarrinho->getProduto()->getCategoria()->getDescricao()?></td>
                      <td class="text-right"><?php echo $itemCarrinho->getQuantidade()?></td>
                      <td class="text-right" > <?php echo $itemCarrinho->getProduto()->getValor()?></td>

                      <td class="text-right"> <?php
                               echo $itemCarrinho->getQuantidade() * $itemCarrinho->getProduto()->getValor()


                                ?></td>
                     <?php
                     $total +=$itemCarrinho->getQuantidade() * $itemCarrinho->getProduto()->getValor();
                     $posicao++;
                        }

                        ?>

                    </tr>
                  </tbody>
                  <tfoot>

                    <tr>
                    </tr>
                    <tr>
                      <td class="text-right" colspan="4"><strong>Total:</strong></td>
                      <td class="text-right"><?php echo $total ?></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
              <div class="buttons">
                <div class="pull-right">
                  <input type="button" data-loading-text="Loading..." name="bt-sucess"class="btn btn-primary" id="button-confirm" value="Confirmar Pedido" onclick="myFunction()"   >
                    <script>
                        function myFunction() {
                            alert("Compra concluída");
                        }
                    </script>
                </div>
              </div>
            </div>
          </div>
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
