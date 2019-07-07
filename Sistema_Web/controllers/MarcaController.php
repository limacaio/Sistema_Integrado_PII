<?php

require_once "../models/Marca.php";
require_once "Conexao.php";
class MarcaController
{
    public static function salvar(marca $marca){
        if ($marca->getidMarca() > 0){
            return self::alterar($marca);
        }else{
            return self::inserir($marca);
        }
    }

    private static function alterar(marca $marca){
        $sql = "UPDATE marca SET descricao = :descricao WHERE idMarca=:idMarca";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':descricao', $marca->getdescricao());
        $stmt->bindValue(':idMarca', $marca->getidMarca());

        $stmt->execute();

        return "OK";
    }

    private static function inserir(marca $marca){
        $sql = "INSERT INTO marca (descricao) VALUES (:descricao)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':descricao', $marca->getdescricao());

        $stmt->execute();

        return "OK";
    }

    public static function trazerTodos(){
        $sql = "SELECT * FROM marca ORDER BY descricao";
        $db = Conexao::getInstance();
        $stmt = $db->query($sql);
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista){
            $arrRetorno[] = self::popularmarca($itemLista);
        }
        return $arrRetorno;
    }

    public static function trazerTodasMarcasPorCategoria($idCategoria)
    {
        $sql = "SELECT  m.* from marca m 
        inner join produto p on p.idMarca = m.idMarca 
        inner join categoria c on c.idCategoria = p.idCategoria
        WHERE p.idCategoria = :idCategoria
        ORDER BY m.descricao";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idCategoria', $idCategoria);
        $stmt->execute();
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista){
            $arrRetorno[] = self::popularMarca($itemLista);
        }
        return $arrRetorno;
    }

    public static function buscarmarca($idMarca){
        $sql = "SELECT * FROM marca WHERE idMarca = :idMarca";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idMarca', $idMarca);
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0){
            return self::popularmarca($listagem[0]);
        }
    }

   private static function popularmarca($itemLista){
        $marca = new marca();
        $marca->setidMarca($itemLista['idMarca']);
        $marca->setdescricao($itemLista['descricao']);
        return $marca;
    }

    public static function excluir($idMarca){
        $sql = "DELETE FROM marca WHERE idMarca = :idMarca";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idMarca', $idMarca);
        $stmt->execute();
    }


}