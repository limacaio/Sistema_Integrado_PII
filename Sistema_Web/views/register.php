<?php
require_once "../models/Cliente.php";
require_once "../controllers/ClienteController.php";


$cliente = new Cliente();

if (isset($_GET['idCliente'])) {
    $cliente = ClienteController::buscarCliente($_GET['idCliente']);


    if (isset($_POST['salvar'])) {
        $cliente->setIdCliente($_POST['idCliente']);
        $cliente->setNome($_POST['nome']);
        $cliente->setCpf($_POST['cpf']);
        $cliente->setEmail($_POST['email']);
        $cliente->setSenha(md5($_POST['senha']));
        $cliente->setTelefone($_POST['telefone']);
        ClienteController::salvar($cliente);
        header('Location:login.php');
    }
}
else{
if(isset($_POST['salvar'])) {
    $cliente->setIdCliente($_POST['idCliente']);
    $cliente->setNome($_POST['nome']);
    $cliente->setCpf($_POST['cpf']);
    $cliente->setEmail($_POST['email']);
    $cliente->setSenha(md5($_POST['senha']));
    $cliente->setTelefone($_POST['telefone']);
    ClienteController::salvar($cliente);



   //echo var_dump($cliente);

   // header('Location:register-adress.php');
}
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

      <form class="form-horizontal" enctype="multipart/form-data" method="post" action="register.php">
        <fieldset id="account">
          <legend>Seus Detalhes Pessoais</legend>
          <div class="form-group">
              <input type="hidden" name="idCliente" value="<?php echo $cliente->getidCliente();?>">
            <label for="input-firstname" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-10">
              <input type="text" class="form-control"  name="nome" placeholder="Nome"
                     value="<?php echo $cliente->getNome();?>"
                 >
            </div>
          </div>
          <div class="form-group required">
            <label for="input-email" class="col-sm-2 control-label">E-Mail</label>
            <div class="col-sm-10">
              <input type="email" class="form-control" name="email" placeholder="E-Mail"
                     value="<?php echo $cliente->getEmail();?>" >
            </div>
          </div>

            <div class="form-group required">
                <label for="input-telephone" class="col-sm-2 control-label">Telefone</label>
                <div class="col-sm-10">
                    <input type="tel" class="form-control"  name="telefone" placeholder="Telefone" value="
                <?php echo $cliente->getTelefone();?>"">
                </div>
            </div>
            <div class="form-group required">
                <label for="input-telephone" class="col-sm-2 control-label">CPF</label>
                <div class="col-sm-10">
                    <input type="tel" class="form-control" name="cpf" placeholder="CPF" value="
                <?php echo $cliente->getCpf();?>" >
                </div>
            </div>

        </fieldset>
        <fieldset>
          <legend>Sua Senha</legend>
          <div class="form-group required">
            <label for="input-password" class="col-sm-2 control-label">Senha</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" idCliente="input-password" placeholder="Senha" value="<?php echo $cliente->getSenha();?>" name="senha">
            </div>
          </div>

        </fieldset>

        </fieldset>
        <div class="buttons">
          <div class="pull-right">
            <input type="submit" class="btn btn-primary" name="salvar">
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