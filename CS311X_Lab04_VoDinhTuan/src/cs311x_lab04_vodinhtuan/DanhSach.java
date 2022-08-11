/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_x_lec17_vodinhtuan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//import java.io.LineNumberReader;

/**
 *
 * @author Admin
 */
public class DanhSach {

    private ArrayList<Nguoi> a = new ArrayList<Nguoi>();

    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (f.exists()) {                     // Nếu file. tồn tại.
                Scanner read = new Scanner(f);
                while (read.hasNext()) {           // Khi còn dòng chưa đọc.
                    Scanner line = new Scanner(read.nextLine());    // Đọc nguyên 1 dòng.
                    //001 Trien Chieu  1/1/2000 Nam mon1= 7.0, mon2= 8.0, mon3= 9.0 Điểm trung bình: 8.0
                    //002 ly Nuong Nuong  10/10/2000 Nữ Java  60.0 150.0 Tính Thành Tiền: 9000.0
                    String ma, ht = "", ns;
                    boolean gt;
                    double c1, c2;
                    ma = line.next();
                    while (!line.hasNextBoolean()) // Chưa phải là kiểu boolean thì đọc nối vào họ tên
                    {
                        ht = ht + line.next() + " ";
                    }
                    gt = line.nextBoolean();      // Đọc giới tính
                    ns = line.next();             // Đọc ngày sinh
                    c1 = line.nextDouble();       // đọc con số 1: nếu sv thì là đọc điểm môn 1, gv thì là đọc số giờ
                    c2 = line.nextDouble();       // đọc con số 2: nếu sv thì là đọc điểm môn 2, gv thì là đọc đơn giá 
                    if (line.hasNextDouble()) { //SV
                        double c3 = line.nextDouble();
                        SinhVien x = new SinhVien(c1, c2, c3, ma, ht, ns, gt);
                        a.add(x);     //Thêm phần tử được chỉ định vào cuối danh sách
                    } else { //GV
                        String mon = line.nextLine();
                        GiangVien x = new GiangVien(mon, c1, c2, ma, ht, ns, gt);
                        a.add(x);
                    }
                }
            } else {
                System.out.println("Không tồn tại file");
            }
        } catch (Exception e) {
        }
    }

    public void xuatDS(String noiDung) {
        System.out.println(noiDung);
        for (Nguoi x : a) {
            System.out.println(x);
        }
    }

    public void xuatSV() {
        System.out.println("DSSV: ");
        for (Nguoi x : a) {
            if (x instanceof SinhVien) {
                System.out.println(x);
            }
        }
    }

    public void xuatGV() {
        System.out.println("DSGV: ");
        for (Nguoi x : a) {
            if (x instanceof GiangVien) {
                System.out.println(x);
            }
        }
    }

    public void demSV() {
        int demGV = 0;
        for (Nguoi x : a) {                    //for(int i=0;i<a.size();i++)
            if (x instanceof GiangVien) {     //System.out.println(a.get(i));
                demGV++;
            }
        }
        System.out.println("Giang Vien: " + demGV);
        System.out.println("Sinh Vien: " + (a.size() - demGV));
    }

    public SinhVien maxDTB() {
        SinhVien y = null;
        for (Nguoi x : a) {
            if (x instanceof SinhVien) {
                if (y == null) {
                    y = (SinhVien) x;
                } else if (y.tinhdtb() < ((SinhVien) x).tinhdtb()) {
                    y = (SinhVien) x;
                }
            }
        }
        return y;

    }

    public double diemTBchungTheoGioiTinh(boolean gt) {
        double s = 0, dem = 0;
        for (Nguoi x : a) {
            if (x instanceof SinhVien) {
                if (x.isGioiTinh() == gt) {
                    s = s + ((SinhVien) x).tinhdtb();
                    dem++;
                }
            }
        }
        if (dem == 0) {
            return 0;
        } else {
            return s / dem;
        }
    }

    public double diemTBchung() {
        double s = 0, dem = 0;
        for (Nguoi x : a) {
            if (x instanceof SinhVien) {
                s = s + ((SinhVien) x).tinhdtb();
                dem++;
            }
        }
        if (dem == 0) {
            return 0;
        } else {
            return s / dem;
        }
    }

    public void loaiSV(double can) {
        int i = 0;
        while (i < a.size()) {
            if (a.get(i) instanceof SinhVien) {
                if (((SinhVien) a.get(i)).tinhdtb() < can) {
                    a.remove(i);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    public double tongThanhTien() {
        double s = 0;
        for (Nguoi x : a) {
            if (x instanceof GiangVien) {
                s = s + ((GiangVien) x).tinhThanhTien();
            }
        }
        return s;
    }

    public GiangVien minTienDay() {
        GiangVien y = null;
        for (Nguoi x : a) {
            if (x instanceof GiangVien) {
                if (y == null) {
                    y = (GiangVien) x;
                } else if (y.tinhThanhTien() > ((GiangVien) x).tinhThanhTien()) {
                    y = (GiangVien) x;
                }
            }
        }
        return y;
    }

    public void xuat(String noiDung) {
        System.out.println(noiDung);

    }

    public void output() {
        xuatDS("DS vua doc tu file: ");
        xuatSV();
        xuatGV();
        demSV();
        System.out.println("SV cao diem nhat la: " + maxDTB());
        System.out.println("Diem trung binh chung theo gioi tinh Nam la: " + diemTBchungTheoGioiTinh(true));
        System.out.println("Diem trung binh chung theo gioi tinh Nu la: " + diemTBchungTheoGioiTinh(false));
        double dtb = diemTBchung();
        loaiSV(dtb);
        xuatDS("Danh sách sau khi loại");
        System.out.println("Giang Vien nhan duoc tien day thap nhat:" + minTienDay());
        System.out.println("Tong thanh tien cua giang vien:" + tongThanhTien());
    }

    public static void main(String[] args) {
        DanhSach a = new DanhSach();
        a.docFile("SV_GV.txt");
        a.output();
    }
}
