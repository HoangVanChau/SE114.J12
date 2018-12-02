package company.danhy.clothesuit.activity.activity.model;

public class Loaisp {
    public int Id;
    public String tenLoaisp;
    public String hinhAnhLoaiSanPham;

    public Loaisp(int id, String tenLoaisp, String hinhAnhLoaiSanPham) {
        Id = id;
        this.tenLoaisp = tenLoaisp;
        this.hinhAnhLoaiSanPham = hinhAnhLoaiSanPham;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenLoaisp() {
        return tenLoaisp;
    }

    public void setTenLoaisp(String tenLoaisp) {
        this.tenLoaisp = tenLoaisp;
    }

    public String getHinhAnhLoaiSanPham() {
        return hinhAnhLoaiSanPham;
    }

    public void setHinhAnhLoaiSanPham(String hinhAnhLoaiSanPham) {
        this.hinhAnhLoaiSanPham = hinhAnhLoaiSanPham;
    }
}
