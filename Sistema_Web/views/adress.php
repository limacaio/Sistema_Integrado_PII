<?php
require_once "../models/Endereco.php";
require_once "../controllers/EnderecoController.php";
require_once "../controllers/ClienteController.php";
$endereco = new Endereco();

    if (isset($_POST['salvarEnd'])) {
        $endereco->setIdEndereco($_POST['idEndereco']);
        //$endereco->setCliente($cliente);
        $endereco->setLogradouro($_POST['logradouro']);
        $endereco->setNumero($_POST['numero']);
        $endereco->setComplemento($_POST['complemento']);
        $endereco->setCep($_POST['cep']);
        $endereco->setBairro($_POST['bairro']);
        $endereco->setCidade($_POST['cidade']);
        $endereco->setUf($_POST['uf']);
        var_dump($endereco);
        EnderecoController::salvar($endereco);
        //header('Location:index.php');

}







?>
<!DOCTYPE html>
<html lang="en">
<head>
<title>MoonStore</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="viewport" content="widClienteth=device-widClienteth, initial-scale=1">
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
<body class="col-2 left-col">
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

      <form class="form-horizontal" enctype="multipart/form-data" method="post">

          <fieldset>
              <legend>Endereço</legend>
              <div class="form-group">
                  <input type="hidden" name="idEndereco" value="<?php echo $endereco->getIdEndereco();?>">

                  <label for="input-password" class="col-sm-2 control-label">Logradouro</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="Logradouro" value="<?php echo $endereco->getLogradouro();?>" name="logradouro">
                  </div>
              </div>
              <div class="form-group">
                  <label for="input-password" class="col-sm-2 control-label">Número</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="Número" value="<?php echo $endereco->getNumero();?>" name="numero">
                  </div>
              </div>
              <div class="form-group">
                  <label for="input-password" class="col-sm-2 control-label">Complemento</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="Complemento" value="<?php echo $endereco->getComplemento();?>"
                             name="complemento">
                  </div>
              </div>
              <div class="form-group required">
                  <label for="input-password" class="col-sm-2 control-label">Bairro</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="Bairro" value="<?php echo $endereco->getBairro();?>" name="bairro">
                  </div>
              </div>
              <div class="form-group">
                  <label for="input-password" class="col-sm-2 control-label">CEP</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="CEP" value="<?php echo $endereco->getCep();?>" name="cep">
                  </div>
              </div>
              <div class="form-group">
                  <label for="input-password" class="col-sm-2 control-label">Cidade</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="Cidade" value="<?php echo $endereco->getCidade();?>" name="cidade">
                  </div>
              </div>
              <div class="form-group">
                  <label for="input-password" class="col-sm-2 control-label">UF</label>
                  <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="UF" value="<?php echo $endereco->getUf();?>" name="uf">
                  </div>
              </div>


          </fieldset>
        <div class="buttons">
          <div >
            <input type="submit" class="btn" name="salvarEnd">
          </div>
        </div>
      </form>
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