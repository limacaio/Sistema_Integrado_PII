<?php
require_once "../models/Cliente.php";
session_start();
if (isset($_SESSION['user'])){
    $cliente = new Cliente();
    $cliente = unserialize($_SESSION['user']);
}else{
    header("Location: login.php");
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
                            <li class="dropdown"><a href='login.php?logout=true' title="Sair" ><i class="fa fa-user" aria-hidden="true"></i><span>Sair</span> </a>

                                </ul>
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
            <div id="logo"> <a href="index.php"><img src="image/logo.png" title="E-Commerce" alt="E-Commerce" class="img-responsive" /></a> </div>
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
                <button type="button" class="btn btn-inverse btn-block btn-lg dropdown-toggle cart-dropdown-button">
                    <span id="cart-total"><span>Carrinho de Compras</span><br>0 item(s) - R$0,00</span></button>
                <ul class="dropdown-menu pull-right cart-dropdown-menu">
                    <li>
                        <table class="table table-striped">
                            <tbody>
                            <tr>
                                <td class="text-center"><a href="#"><img class="img-thumbnail" title="lorem ippsum dolor dummy" alt="lorem ippsum dolor dummy" src="image/product/7product56x72.jpg"></a></td>
                                <td class="text-left"><a href="#">lorem ippsum dolor dummy</a></td>
                                <td class="text-right">x 1</td>
                                <td class="text-right">$254.00</td>
                                <td class="text-center"><button class="btn btn-danger btn-xs" title="Remove" type="button"><i class="fa fa-times"></i></button></td>
                            </tr>
                            </tbody>
                        </table>
                    </li>

                    <li>
                        <div>
                            <table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <td class="text-right"><strong>Sub-Total</strong></td>
                                    <td class="text-right">$210.00</td>
                                </tr>
                                <tr>
                                    <td class="text-right"><strong>Eco Tax (-2.00)</strong></td>
                                    <td class="text-right">$2.00</td>
                                </tr>
                                <tr>
                                    <td class="text-right"><strong>VAT (20%)</strong></td>
                                    <td class="text-right">$42.00</td>
                                </tr>
                                <tr>
                                    <td class="text-right"><strong>Total</strong></td>
                                    <td class="text-right">$254.00</td>
                                </tr>
                                </tbody>
                            </table>
                            <p class="text-right"> <span class="btn-viewcart"><a href="cart.html"><strong><i class="fa fa-shopping-cart"></i> Meu Carrinho</strong></a></span> <span class="btn-checkout"><a href="checkout.php"><strong><i class="fa fa-share"></i> Finalizar</strong></a></span> </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
