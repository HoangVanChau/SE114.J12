package company.danhy.clothesuit.activity.activity.model;

public class Loaisp {
    public int Id;
    public String tenLoaiSanPham;
    public String hinhAnhLoaiSanPham;

    public Loaisp(int id, String tenLoaisp, String hinhAnhLoaiSanPham) {
        Id = id;
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.hinhAnhLoaiSanPham = hinhAnhLoaiSanPham;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenLoaisp() {
        return tenLoaiSanPham;
    }

    public void setTenLoaisp(String tenLoaisp) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public String getHinhAnhLoaiSanPham() {
        return hinhAnhLoaiSanPham;
    }

    public void setHinhAnhLoaiSanPham(String hinhAnhLoaiSanPham) {
        this.hinhAnhLoaiSanPham = hinhAnhLoaiSanPham;
    }
}
