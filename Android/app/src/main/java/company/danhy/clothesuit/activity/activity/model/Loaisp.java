package company.danhy.clothesuit.activity.activity.model;

public class Loaisp {
    public int ID;
    public String Tenloaisanpham;
    public String Hinhanhloaisanpham;

    public Loaisp(int ID, String tenloaisanpham, String hinhanhloaisanpham) {
        this.ID = ID;
        Tenloaisanpham = tenloaisanpham;
        Hinhanhloaisanpham = hinhanhloaisanpham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenloaisanpham() {
        return Tenloaisanpham;
    }

    public void setTenloaisanpham(String tenloaisanpham) {
        Tenloaisanpham = tenloaisanpham;
    }

    public String getHinhanhloaisanpham() {
        return Hinhanhloaisanpham;
    }

    public void setHinhanhloaisanpham(String hinhanhloaisanpham) {
        Hinhanhloaisanpham = hinhanhloaisanpham;
    }
}
