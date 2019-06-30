<?php

require_once 'Conexao.php';
require_once '../models/Produto.php';


class ProdutoController{

    public static function salvar(Produto $produto){
        if ($produto->getId() > 0){
            return self::alterar($produto);
        }else{
            return self::inserir($produto);
        }
    }

    private static function inserir(Produto $produto){
        $sql = "INSERT INTO produto (titulo, descricao, autor, idcategoria, idmarca, valor, ano, capa) VALUES (:titulo, :descricao, :autor, :idcategoria, :idmarca, :valor, :ano, :capa)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':titulo', $produto->getTitulo());
        $stmt->bindValue(':descricao', $produto->getDescricao());
        $stmt->bindValue(':autor', $produto->getAutor());
        $stmt->bindValue(':idcategoria', $produto->getcategoria()->getId());
        $stmt->bindValue(':idmarca', $produto->getmarca()->getId());
        $stmt->bindValue(':valor', $produto->getValor());
        $stmt->bindValue(':ano', $produto->getAno());
        $stmt->bindValue(':capa', $produto->getCapaImagem());

        $stmt->execute();

        return "OK";
    }

    private static function alterar(Produto $produto){
        $sql = "UPDATE produto SET titulo=:titulo, descricao=:descricao, 
    autor=:autor, idcategoria=:idcategoria, idmarca=:idmarca, 
    valor=:valor, ano=:ano, capa=:capa WHERE id=:id";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':titulo', $produto->getTitulo());
        $stmt->bindValue(':descricao', $produto->getDescricao());
        $stmt->bindValue(':autor', $produto->getAutor());
        $stmt->bindValue(':idcategoria', $produto->getcategoria()->getId());
        $stmt->bindValue(':idmarca', $produto->getmarca()->getId());
        $stmt->bindValue(':valor', $produto->getValor());
        $stmt->bindValue(':ano', $produto->getAno());
        $stmt->bindValue(':capa', $produto->getCapaImagem());
        $stmt->bindValue(':id', $produto->getId());

        $stmt->execute();

        return "OK";
    }

    public static function excluir($id){
        $sql = "DELETE FROM produto WHERE id = :id";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':id', $id);
        $stmt->execute();
    }

    public static function trazerTodos(){
        $sql = "SELECT l.*, g.nome AS nome, e.nome AS marca FROM produto l INNER JOIN categoria g ON g.id = l.idcategoria INNER JOIN marca e ON e.id = l.idmarca";
        $db = Conexao::getInstance();
        $stmt = $db->query($sql);
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista){
            $arrRetorno[] = self::popularproduto($itemLista);
        }
        return $arrRetorno;
    }

    public static function trazerTodosPorcategoria($categoria){
        $sql = "SELECT l.*, g.nome AS categoria, e.nome AS marca FROM produto l INNER JOIN categoria g ON g.id = l.idcategoria INNER JOIN marca e ON e.id = l.idmarca WHERE l.idcategoria = :categoria";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':categoria', $categoria);
        $stmt->execute();
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista){
            $arrRetorno[] = self::popularproduto($itemLista);
        }
        return $arrRetorno;
    }

    private static function popularproduto($itemLista){
        $produto = new produto();
        $produto->setId($itemLista['id']);
        $produto->setTitulo($itemLista['titulo']);
        $produto->setDescricao($itemLista['descricao']);
        $produto->setAutor($itemLista['autor']);
        $produto->setValor($itemLista['valor']);
        $produto->setAno($itemLista['ano']);
        $produto->getcategoria()->setId($itemLista['idcategoria']);
        $produto->getcategoria()->setNome($itemLista['categoria']);
        $produto->getmarca()->setId($itemLista['idmarca']);
        $produto->getmarca()->setNome($itemLista['marca']);
        $produto->setCapaImagem($itemLista['capa']);

        return $produto;
    }

    public static function buscarproduto($id){
        $sql = "SELECT l.*, g.nome AS categoria, e.nome AS marca FROM produto l INNER JOIN categoria g ON g.id = l.idcategoria INNER JOIN marca e ON e.id = l.idmarca WHERE l.id = :id";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':id', $id);
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0){
            return self::popularproduto($listagem[0]);
        }
    }

}