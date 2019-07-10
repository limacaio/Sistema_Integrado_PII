<?php
require_once "../models/Cliente.php";
require_once "Conexao.php";

class ClienteController
{

    public static function salvar(Cliente $cliente){
        if ($cliente->getidCliente
() > 0){
            return self::alterar($cliente);
        }else{
            return self::inserir($cliente);
        }
    }

    private static function alterar(Cliente $cliente){
        $sql = "UPDATE cliente SET nome = :nome, cpf=:cpf, 
                 telefone=:telefone WHERE idCliente
=:idCliente
";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':nome', $cliente->getNome());
        $stmt->bindValue(':cpf', $cliente->getCpf());
        $stmt->bindValue(':telefone', $cliente->getTelefone());
        $stmt->bindValue(':idCliente
Cliente', $cliente->getidCliente
());

        $stmt->execute();

        return "OK";
    }

    private static function inserir(Cliente $cliente){
        $sql = "INSERT INTO cliente (nome, cpf, email, senha, telefone) 
                VALUES (:nome, :cpf,  :email, :senha, :telefone)";

        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':nome', $cliente->getNome());
        $stmt->bindValue(':cpf', $cliente->getCpf());
        $stmt->bindValue(':email', $cliente->getEmail());
        $stmt->bindValue(':senha', $cliente->getSenha());
        $stmt->bindValue(':telefone', $cliente->getTelefone());

        $stmt->execute();

        return "OK";
    }

    public static function trazerTodos(){
        $sql = "SELECT * FROM cliente ORDER BY nome";
        $db = Conexao::getInstance();
        $stmt = $db->query($sql);
        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $arrRetorno = array();
        foreach ($listagem as $itemLista){
            $arrRetorno[] = self::popularCliente($itemLista);
        }
        return $arrRetorno;
    }

    public static function buscarCliente($idCliente){
        $sql = "SELECT * FROM cliente WHERE idCliente = :idCliente
";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idCliente', $idCliente);
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0){
            return self::popularCliente($listagem[0]);
        }
    }

    public static function login($email, $senha){
        $sql = "SELECT * FROM cliente WHERE email = :email AND senha = :senha";
        $db = Conexao::getInstance();

        $stmt = $db->prepare($sql);
        $stmt->bindValue(':email', $email);
        $stmt->bindValue(':senha', $senha);
        $stmt->execute();

        $listagem = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if (count($listagem) > 0){
            $clientelogin = self::popularClienteLogin($listagem[0]);
            $_SESSION['user'] = serialize($clientelogin);
            return true;
        }else{
            return false;
        }
    }

    private static function popularCliente($itemLista){
        $cliente = new Cliente();
        $cliente->setidCliente($itemLista['idCliente']);
        $cliente->setNome($itemLista['nome']);
        $cliente->setCpf($itemLista['cpf']);
        $cliente->setEndereco($itemLista['endereco']);
        $cliente->setTelefone($itemLista['telefone']);
        $cliente->setEmail($itemLista['email']);
        $cliente->setSenha($itemLista['senha']);
        $cliente->setCelular($itemLista['celular']);
        $cliente->setDataNascimento($itemLista['dataNascimento']);
        return $cliente;
    }

    private static function popularClienteLogin($itemLista){
        $cliente = new Cliente();
        $cliente->setidCliente($itemLista['idCliente']);
        $cliente->setNome($itemLista['nome']);
        $cliente->setCpf($itemLista['cpf']);
        $cliente->setTelefone($itemLista['telefone']);
        $cliente->setCelular($itemLista['celular']);
        $cliente->setDataNascimento($itemLista['dataNascimento']);
        $cliente->setEmail($itemLista['email']);
        return $cliente;
    }

    public static function excluir($idCliente
){
        $sql = "DELETE FROM cliente WHERE idCliente
 = :idCliente
";
        $db = Conexao::getInstance();
        $stmt = $db->prepare($sql);
        $stmt->bindValue(':idCliente
', $idCliente
);
        $stmt->execute();
    }

}