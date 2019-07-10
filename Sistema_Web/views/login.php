<?php

require_once "../controllers/ClienteController.php";
session_start();
if (isset($_POST['login'])){
    $email = $_POST['email'];
    $senha = md5($_POST['senha']);
    if (ClienteController::login($email, $senha)){
        header("Location: index.php");
    }
}

if (isset($_GET['logout'])){
    session_destroy();
    header("Location: login.php");
}

?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/meuestilo.css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="login-form" action="login.php" method="post">
            <input type="text" placeholder="email" name="email"/>
            <input type="password" placeholder="password" name="senha"/>
            <button type="submit" name="login">login</button>
            <p class="message">Não Registrado(a)? <a href="register.php">Criar Conta</a></p>
        </form>
    </div>
</div>
<script src="js/meujs.js"></script>
</body>
</html>