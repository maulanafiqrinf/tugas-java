<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "db_way";

$con = mysqli_connect($host, $user, $pass, $db);

 if($con->connect_error){
     die("Koneksi gagal");
 }

?>