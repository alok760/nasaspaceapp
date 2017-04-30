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

$sql = "INSERT INTO datec (datetime)
VALUES ('$date')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
