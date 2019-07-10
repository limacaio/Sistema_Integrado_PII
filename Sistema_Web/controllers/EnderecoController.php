<?php
require_once "../models/Endereco.php";
require_once "Conexao.php";




class EnderecoController
{




    public static function salvar(Endereco $endereco)
    {
        if ($endereco->getIdEndereco() > 0) {
            return self::alterar($endereco);
        } else {
            return self::inserir($endereco);
        }
    }

    private static function alterar(Endereco $endereco)
    {
        $sql = "UPDATE endereco SET logradouro = :logradouro, numero=:numero,
                complemento=:complemento,bairro=:bairro, cep=:cep,
                cidade=:cidade,uf=:uf,
                 WHERE idEndereco=:idEndereco";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':logradouro', $endereco->getLogradouro());
        $stmt->bindValue(':numero',$endereco->getNumero());
        $stmt->bindValue(':complemento',$endereco->getComplemento());
        $stmt->bindValue(':cep',$endereco->getCep());
        $stmt->bindValue(':bairro',$endereco->getBairro());
        $stmt->bindValue(":cidade",$endereco->getCidade());
        $stmt->bindValue(":uf",$endereco->getUf());


        $stmt->execute();

        return "OK";
    }

    private static function inserir(Endereco $endereco)
    {
        $sql = "INSERT INTO endereco (logradouro, numero, complemento,bairro, cep, cidade, uf, idCliente) 
                VALUES (:logradouro, :numero, :complemento,:bairro, :cep, :cidade, :uf,:idCliente)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':logradouro', $endereco->getLogradouro());
        $stmt->bindValue(':numero',$endereco->getNumero());
        $stmt->bindValue(':complemento',$endereco->getComplemento());
        $stmt->bindValue(':bairro',$endereco->getBairro());
        $stmt->bindValue(':cep',$endereco->getCep());
        $stmt->bindValue(":cidade",$endereco->getCidade());
        $stmt->bindValue(":uf",$endereco->getUf());
        $stmt->bindValue(":idCliente",$endereco->getCliente()->getIdCliente());

        $stmt->execute();

        return "OK";
    }

    public static function trazerTodos()
    {
        $sql = "SELECT * FROM endereco ORDER BY idEndereco";
        $db = Conexao::getInstance();
        $stmt = $db->query($sql);
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista) {
            $arrRetorno[] = self::popularEndereco($itemLista);
        }
        return $arrRetorno;
    }

    public static function buscarEndereco($idCliente)
    {
        $sql = "SELECT * FROM endereco WHERE idCliente = :idCliene";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idCliente', $idCliente);
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0) {
            return self::popularEndereco($listagem[0]);
        }
    }


    private static function popularEndereco($itemLista)
    {
        $endereco = new Endereco();
        $endereco->setIdEndereco($itemLista['idEndereco']);
        $endereco->setLogradouro($itemLista['logradouro']);
        $endereco->setNumero($itemLista['numero']);
        $endereco->getComplemento($itemLista['complemento']);
        $endereco->setCep($itemLista['cep']);
        $endereco->setBairro($itemLista['bairro']);
        $endereco->setCidade($itemLista['cidade']);
        $endereco->setUf($itemLista['uf']);
        $endereco->getCliente()->setIdCliente($itemLista['idCliente']);
        return $endereco;
    }

    private static function popularClienteLogin($itemLista)
    {
        $cliente = new Cliente();
        $cliente->setId($itemLista['idCliente']);
        $cliente->setNome($itemLista['nome']);
        $cliente->setCpf($itemLista['cpf']);
        $cliente->setEndereco($itemLista['endereco']);
        $cliente->setTelefone($itemLista['telefone']);
        $cliente->setCelular($itemLista['celular']);
        $cliente->setDataNascimento($itemLista['dataNascimento']);
        $cliente->setEmail($itemLista['email']);
        return $cliente;
    }

    public static function excluir($id)
    {
        $sql = "DELETE FROM cliente WHERE id = :id";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':id', $id);
        $stmt->execute();
    }

}
