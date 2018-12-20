package company.danhy.clothesuit.activity.activity.ultil;

public class Server {

    //TriTue
    //public static String localhost ="192.168.1.15";
//   public static String localhost ="192.168.56.1:8080";

   // public static String localhost ="10.0.3.2:8080";

    //DuyAnh
   public static String localhost ="192.168.1.5:80";

    public static String duongDanLoaiSanPham ="http://"+ localhost +"/server/getloaisanpham.php";
    public static String duongDanSanPhamMoiNhat="http://"+ localhost+ "/server/getsanphammoinhat.php";
    public static String duongDanGiay = "http://"+ localhost+ "/server/getsanpham.php?page=";
    public static String duongDanSanPhamFlashSale = "http://"+ localhost+ "/server/getsanphamflashsale.php";
    public static String duongDanThongTinKhachHang ="http://"+ localhost +"/server/thongtinkhachhang.php";
    public static String duongDanChiTietDonHang ="http://"+ localhost +"/server/chitietdonhang.php";
    public static String signup ="http://"+ localhost +"/server/signup.php";
    public static String signin ="http://"+ localhost +"/server/signin.php";

 }
