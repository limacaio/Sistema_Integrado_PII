<?php
require_once "Produto.php";

class ItemCarrinho
{
    private $produto;
    private $quantidade;

    /**
     * ItemCarrinho constructor.
     * @param $produto
     */
    public function __construct()
    {
        $this->produto = new Produto();
    }

    /**
     * @return Produto
     */
    public function getProduto()
    {
        return $this->produto;
    }

    /**
     * @param Produto $produto
     */
    public function setProduto($produto)
    {
        $this->produto = $produto;
    }

    /**
     * @return mixed
     */
    public function getQuantidade()
    {
        return $this->quantidade;
    }

    /**
     * @param mixed $quantidade
     */
    public function setQuantidade($quantidade)
    {
        $this->quantidade = $quantidade;
    }

}