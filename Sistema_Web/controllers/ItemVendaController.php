<?php


class ItemVendaController
{
    public static function inserir(ItemVenda $itemVenda){
        $sql = "INSERT INTO itemvenda (idItemVenda, idProduto, idVendas, quantidade,valor) 
                VALUES (:idItemVenda, :idProduto, :idVenda, :quantidade,:valor)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idItemVenda', $itemVenda->getVenda()->getId());
        $stmt->bindValue(':idProduto', $itemVenda->getProduto()->getIdProduto());
        $stmt->bindValue(':quantidade', $itemVenda->getQuantidade());
        $stmt->bindValue(':valor', $itemVenda->getValorProduto());

        $stmt->execute();

        return "OK";
    }

}