<?php
 include "connect.php";
$query ="select * from loaisanpham";
$data = mysqli_query($conn,$query);
$mangloaisanpham = array();
while ($row = mysqli_fetch_assoc($data)){
      array_push($mangloaisanpham, new Loaisp(
        $row['id'],
        $row['tenLoaiSanPham'],
        $row['hinhAnhLoaiSanPham']));
 }
echo json_encode($mangloaisanpham );
class Loaisp{
   function Loaisp ($id,$tenloaisp,$hinhanhloaisp){
     $this->id=$id;
    $this->tenloaisp=$tenloaisp;
    $this->hinhanhloaisp=$hinhanhloaisp;
    } 
 }
?>

