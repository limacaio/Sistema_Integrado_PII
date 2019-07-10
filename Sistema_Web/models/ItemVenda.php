<?php
require_once "Venda.php";
require_once "Produto.php";

class ItemVenda
{
    private $id;
    private $produto;
    private $venda;
    private $quantidade;
    private $valorProduto;

    /**
     * ItemVenda constructor.
     * @param $id
     */
    public function __construct()
    {
        $this->produto = new Produto();
        $this->venda = new Venda();
    }


    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getProduto()
    {
        return $this->produto;
    }

    /**
     * @param mixed $produto
     */
    public function setProduto($produto)
    {
        $this->produto = $produto;
    }

    /**
     * @return mixed
     */
    public function getVenda()
    {
        return $this->venda;
    }

    /**
     * @param mixed $venda
     */
    public function setVenda($venda)
    {
        $this->venda = $venda;
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

    /**
     * @return mixed
     */
    public function getValorProduto()
    {
        return $this->valorProduto;
    }

    /**
     * @param mixed $valorProduto
     */
    public function setValorProduto($valorProduto)
    {
        $this->valorProduto = $valorProduto;
    }

}