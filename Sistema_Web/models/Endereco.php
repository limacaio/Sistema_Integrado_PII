<?php
require_once 'Cliente.php';

class Endereco
{
    private $idEndereco;
    private $logradouro;
    private $numero;
    private $complemento;
    private $cep;
    private $bairro;
    private $cidade;
    private $uf;
    private $cliente;

    /**
     * Endereco constructor.
     * @param $idEndereco

     */
    public function __construct()
    {
        $this->idEndereco = 0;
        $this->cliente = new Cliente();


    }

    /**
     * @return int
     */
    public function getIdEndereco()
    {
        return $this->idEndereco;
    }

    /**
     * @param int $idEndereco
     */
    public function setIdEndereco($idEndereco)
    {
        $this->idEndereco = $idEndereco;
    }

    /**
     * @return mixed
     */
    public function getLogradouro()
    {
        return $this->logradouro;
    }

    /**
     * @param mixed $logradouro
     */
    public function setLogradouro($logradouro)
    {
        $this->logradouro = $logradouro;
    }

    /**
     * @return mixed
     */
    public function getNumero()
    {
        return $this->numero;
    }

    /**
     * @param mixed $numero
     */
    public function setNumero($numero)
    {
        $this->numero = $numero;
    }

    /**
     * @return mixed
     */
    public function getComplemento()
    {
        return $this->complemento;
    }

    /**
     * @param mixed $complemento
     */
    public function setComplemento($complemento)
    {
        $this->complemento = $complemento;
    }

    /**
     * @return mixed
     */
    public function getCep()
    {
        return $this->cep;
    }

    /**
     * @param mixed $cep
     */
    public function setCep($cep)
    {
        $this->cep = $cep;
    }

    /**
     * @return mixed
     */
    public function getCidade()
    {
        return $this->cidade;
    }

    /**
     * @param mixed $cidade
     */
    public function setCidade($cidade)
    {
        $this->cidade = $cidade;
    }

    /**
     * @return mixed
     */
    public function getUf()
    {
        return $this->uf;
    }

    /**
     * @param mixed $uf
     */
    public function setUf($uf)
    {
        $this->uf = $uf;
    }

    /**
     * @return Cliente
     */
    public function getCliente()
    {
        return $this->cliente->getIdCliente();
    }

    /**
     * @param Cliente $cliente
     */
    public function setCliente($cliente)
    {
        $this->cliente->setIdCliente(cliente);
    }

    /**
     * @return mixed
     */
    public function getBairro()
    {
        return $this->bairro;
    }

    /**
     * @param mixed $bairro
     */
    public function setBairro($bairro)
    {
        $this->bairro = $bairro;
    }




}