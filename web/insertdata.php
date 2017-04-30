<?php
$servername = "localhost";
$username = "id1499236_nasa";
$password = "8ballpool";
$dbname = "id1499236_nasa";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
date_default_timezone_set('Asia/Kolkata');
$date = date('m/d/Y h:i:s a', time());

$val = ""; //Initialization value; Examples
             //"" When you want to append stuff later
             //0  When you want to add numbers later
//isset()
$val = isset($_POST['zone']) ? $_POST['zone'] : '';
//empty()
$val = !empty($_POST['zone']) ? $_POST['zone'] : '';
$in = $_POST['Website'];
$ed = $_POST['Address'];

$sql = "INSERT INTO insert
VALUES ('$val','$val','$val','$in','$date','$date','$ed');";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>