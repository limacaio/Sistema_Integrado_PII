<?php
require_once "../models/Venda.php";
require_once "Conexao.php";

class VendaController
{
    public static function inserir(Venda $venda){
        $sql = "INSERT INTO venda (data, idCliente, Situacao_idSituacao) 
                VALUES (:data, :idcliente, :Situacao_idSituacao)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':data', $venda->getDataVenda());
        $stmt->bindValue(':idCliente', $venda->getCliente()->getIdCliente());
        $stmt->bindValue(':Situacao_idSituacao', 1);

        $stmt->execute();

        return "OK";
    }

    public static function buscarVenda(Venda $venda){
        $sql = "SELECT v.id AS idvenda, v.data, v.idcliente, v.Situacao_idSituacao,
                c.*, s.descricao FROM venda v INNER JOIN situacao s ON v.Situacao_idSituacao = s.id INNER JOIN cliente c 
                ON v.idCliente = c.id WHERE idCliente = :idcliente AND data = :datavenda ORDER BY idvenda DESC LIMIT 1";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idcliente', $venda->getCliente()->getId());
        $stmt->bindValue(':data', $venda->getDataVenda());
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0){
            return self::popularVenda($listagem[0]);
        }
    }

    public static function popularVenda($itemLista){
        $venda = new Venda();
        $venda->setId($itemLista['idvenda']);
        $venda->setDataVenda($itemLista['data']);

        $venda->getCliente()->setId($itemLista['idcliente']);
        $venda->getCliente()->setNome($itemLista['nome']);
        $venda->getCliente()->setCpf($itemLista['cpf']);
        $venda->getCliente()->setEndereco($itemLista['endereco']);
        $venda->getCliente()->setTelefone($itemLista['telefone']);
        $venda->getCliente()->setCelular($itemLista['celular']);
        $venda->getCliente()->setDataNascimento($itemLista['dataNascimento']);
        $venda->getCliente()->setEmail($itemLista['email']);



        $venda->getSituacao()->setId($itemLista['idsituacao']);
        $venda->getSituacao()->setDescricao($itemLista['descricao']);

        return $venda;
    }
}