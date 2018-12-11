<?php
 include "connect.php";
 $mangspflashsale = array();
$query ="SELECT * FROM `sanphamflashsale` INNER JOIN `sanpham` ON `sanphamflashsale`.`idSanPham`=`sanpham`.`id` ORDER BY `sanphamflashsale`.`id` DESC LIMIT 30";
$data = mysqli_query($conn,$query);
while ($row = mysqli_fetch_assoc($data)){
 array_push($mangspflashsale,new Sanphamflashsale(
    $row['id'],
    $row['tenSanPham'],
    $row['giaSanPham'],
    $row['hinhAnhSanPham'],
    $row['moTaSanPham'],
    $row['idLoaiSanPham']));
 }
echo json_encode($mangspflashsale);
class Sanphamflashsale{
   function Sanphamflashsale($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham){
     $this->id=$id;
    $this->tensp=$tensp;
    $this->giasp=$giasp;
    $this->hinhanhsp=$hinhanhsp;
    $this->motasp=$motasp;
    $this->idsanpham=$idsanpham;
    } 
 }
?>