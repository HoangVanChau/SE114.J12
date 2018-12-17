<?php
	include"connect.php";
	mysqli_set_charset($con,'utf8');
	/** Array for JSON response*/
	$response = array();
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		$username = $_POST['username'];
		$password = md5($_POST['password']);
		$email = $_POST['email'];
		$sqlCheck = "SELECT * FROM khachhang WHERE ten = '$username' OR email='$email' ";
		$result = @mysqli_query($con,$sqlCheck);
		if (mysqli_num_rows($result) != 0) {	
				$response["success"] = 0;
				$response["message"] = "Tên đăng nhập hoặc email đã có người sử dụng!";
			} else {	
				$sqlInsert = "INSERT INTO khachhang (ten,matkhau,email) VALUES ('$username','$password','$email')";
				$resultInsert = @mysqli_query($con,$sqlInsert);
				if ($resultInsert) {
						$sqlGetInfo = "SELECT ten, email FROM khachhang WHERE ten = '$username' AND matkhau = '$password'";
						$result = mysqli_query($con,$sqlGetInfo);
						$row = mysqli_fetch_array($result);
						
						$response["success"] = 1;
						$response["message"] = "Đăng ký thành công!";
						$response["ten"] = $username;
						$response["email"] = $email;
				} else {
					$response["success"] = 0;
					$response["message"] = "Đăng ký thất bại!";
				}
			}	
			/**Return json*/
		echo json_encode($response);
	}
?>
