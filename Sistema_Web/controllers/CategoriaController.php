<?php
require_once "../models/Categoria.php";
require_once "Conexao.php";

class categoriaController
{
    public static function salvar(Categoria $categoria){
        if ($categoria->getidCategoria() > 0){
            return self::alterar($categoria);
        }else{
            return self::inserir($categoria);
        }
    }

    private static function alterar(Categoria $categoria){
        $sql = "UPDATE categoria SET nome = :nome WHERE idCategoria=:idCategoria";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':nome', $categoria->getNome());
        $stmt->bindValue(':idCategoria', $categoria->getidCategoria());

        $stmt->execute();

        return "OK";
    }

    private static function inserir(categoria $categoria){
        $sql = "INSERT INTO Categoria (nome) VALUES (:nome)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':nome', $categoria->getNome());

        $stmt->execute();

        return "OK";
    }

    public static function trazerTodos(){
        $sql = "SELECT * FROM categoria ORDER BY descricao";
        $db = Conexao::getInstance();
        $stmt = $db->query($sql);
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista){
            $arrRetorno[] = self::popularCategoria($itemLista);
        }
        return $arrRetorno;
    }

    public static function buscarCategoria($idCategoria){
        $sql = "SELECT * FROM categoria WHERE idCategoria = :idCategoria";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idCategoria', $idCategoria);
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0){
            return self::popularCategoria($listagem[0]);
        }
    }

    private static function popularCategoria($itemLista){
        $categoria = new Categoria();
        $categoria->setIdCategoria($itemLista['idCategoria']);
        $categoria->setDescricao($itemLista['descricao']);
        return $categoria;
    }

    public static function excluir($idCategoria){
        $sql = "DELETE FROM categoria WHERE idCategoria = :idCategoria";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idCategoria', $idCategoria);
        $stmt->execute();
    }
}