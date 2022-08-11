
package th18;
import java.util.Scanner;

public class SinhVien extends Nguoi{
    
    private String ma,email;
    private double dtb;
    public SinhVien() {
        super();
    }

    public SinhVien(String ma, String ten, boolean gioitinh, String diachi, String ngaysinh, double dtb , String email) {
        super(ten, gioitinh, diachi, ngaysinh);
        this.ma = ma;
        this.email = email;
        this.dtb = dtb;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }
     public SinhVien nhap1SV()
     {
        String ma,email,ten,diachi,ngaysinh;;
        double dtb;
        boolean gioitinh;
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap ma sinh vien: ");
        ma=sc.nextLine();
        sc=new Scanner(System.in);
        System.out.print("nhap ho ten sinh vien: ");
        ten=sc.nextLine();
        sc=new Scanner(System.in);
        System.out.print("nhap gioi tinh sinh vien: ");
        gioitinh=sc.nextBoolean();
        sc=new Scanner(System.in);
        System.out.print("nhap dia chi sinh vien: ");
        diachi=sc.nextLine();
        sc=new Scanner(System.in);
        System.out.print("nhap ngay sinh sinh vien: ");
        ngaysinh=sc.nextLine();
        sc=new Scanner(System.in);
        System.out.print("nhap email sinh vien: ");
        email=sc.nextLine();
        sc=new Scanner(System.in);
        System.out.print("nhap diem trung binh sinh vien: ");
        dtb=sc.nextDouble();
        return new SinhVien( ma,  ten,  gioitinh,  diachi,  ngaysinh,  dtb ,  email);
     }
     public String xeploai()
    {
        if(dtb<3) return "kem";
        else if(dtb>=3&&dtb<5) return "yeu";
        else if(dtb>=5&&dtb<6.5) return "trung binh";
        else if(dtb>=6.5&&dtb<8) return "kha";
        else if(dtb>=8&&dtb<9) return "gioi";
        else if(dtb>=9) return "xuat sac";
        return "khong xep loai";
    }
    @Override
    public String toString() {
        return ma + " "+super.toString()+" " +dtb +" "+email+" "+xeploai();
    }

   
    
}