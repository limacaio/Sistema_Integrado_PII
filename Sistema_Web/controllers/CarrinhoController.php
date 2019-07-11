<?php
require_once "../models/ItemCarrinho.php";
require_once "../controllers/ProdutoController.php";

class CarrinhoController
{

    public static function adicionarItem($produto)
    {
        if (!self::existeItemNoCarrinho($produto)) {
            $carrinho = array();
            if (isset($_SESSION['carrinho'])) {
                $carrinho = unserialize($_SESSION['carrinho']);
            }
            $itemCarrinho = new ItemCarrinho();
            $itemCarrinho->setproduto(produtoController::buscarProduto($_GET['produto']));
            $itemCarrinho->setQuantidade(1);
            $carrinho[] = $itemCarrinho;
            $_SESSION['carrinho'] = serialize($carrinho);
        }
    }

    private static function existeItemNoCarrinho($produto)
    {
        if (isset($_SESSION['carrinho'])) {
            $carrinho = unserialize($_SESSION['carrinho']);
            foreach ($carrinho as $itemCarrinho) {
                if ($produto == $itemCarrinho->getProduto()->getIdProduto()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static function removerItemCarrinho($posicao){
        if (isset($_SESSION['carrinho'])) {
            $carrinho = unserialize($_SESSION['carrinho']);
            array_splice($carrinho, $posicao, 1);
            if (count($carrinho) == 0){
                unset($_SESSION['carrinho']);
            }else{
                $_SESSION['carrinho'] = serialize($carrinho);
            }
        }
    }

    public static function atualizarCarrinho($quantidades){
        if (isset($_SESSION['carrinho'])) {
            $carrinho = unserialize($_SESSION['carrinho']);
            $pos = 0;
            foreach ($quantidades as $key => $value) {
                $carrinho[$pos]->setQuantidade($value);
                $pos++;
            }
            $_SESSION['carrinho'] = serialize($carrinho);
        }
    }

}