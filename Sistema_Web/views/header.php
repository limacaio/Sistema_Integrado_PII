<?php
require_once "../models/Cliente.php";
session_start();
if (isset($_SESSION['user'])){
    $cliente = new Cliente();
    $cliente = unserialize($_SESSION['user']);


}else{
    //header("Location: login.php");
}
?>
<div class="header-top">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="top-left pull-left">
                    <div class="wel-come-msg"> <?php echo "Bem vindo(a) ".$cliente->getNome()." a nossa loja online!" ?> </div>

                </div>
                <div class="top-right pull-right">
                    <div id="top-links" class="nav pull-right">
                        <ul class="list-inline">


                                <?php echo "<li class=\"dropdown\"><a href='register.php?idCliente=".$cliente->getIdCliente()."'
                                                    title='Meus Dados'><i class='fa fa-user' aria-hidden='true'></i><span>Meus Dados</span> </a></li>";?>

                            <li class="dropdown"><a href='login.php?logout=true' title="Sair" ><i class="fa fa-user" aria-hidden="true"></i><span>Sair</span> </a>
                            </li>

                        </ul>


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="header-inner">
        <div class="col-sm-3 col-xs-3 header-left">
            <div id="logo"> <a href="index.php"><img src="image/logo-tads.png" title="E-Commerce" alt="E-Commerce" class="img-responsive" /></a> </div>
        </div>
        <div class="col-sm-9 col-xs-9 header-right">
            <nav id="menu" class="navbar">
                <div class="nav-inner">
                    <div class="navbar-header"><span id="category" class="visible-xs">Categories</span>
                        <button type="button" class="btn btn-navbar navbar-toggle" ><i class="fa fa-bars"></i></button>
                    </div>

                </div>
            </nav>
            <div id="cart" class="btn-group btn-block">
                <a href="cart.php"
                <button type="button" class="btn btn-inverse btn-block btn-lg dropdown-toggle cart-dropdown-button">
                    <span id="cart-total"><span>Carrinho de Compras</span><br>Visualizar</span></button>
                </a>

            </div>
        </div>
    </div>
</div>
