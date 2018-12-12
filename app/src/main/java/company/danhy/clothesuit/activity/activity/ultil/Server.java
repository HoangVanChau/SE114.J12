package company.danhy.clothesuit.activity.activity.ultil;

public class Server {

    //TriTue
    //public static String localhost ="192.168.56.1:8080";

    //DuyAnh
   public static String localhost ="172.17.24.247:80";

    public static String duongDanLoaiSanPham ="http://"+ localhost +"/server/getloaisanpham.php";
    public static String duongDanSanPhamMoiNhat="http://"+ localhost+ "/server/getsanphammoinhat.php";
    public static String duongDanGiay = "http://"+ localhost+ "/server/getsanpham.php?page=";
    public static String duongDanSanPhamFlashSale = "http://"+ localhost+ "/server/getsanphamflashsale.php";

 }
