package th6;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MangHinhTron {

    private ArrayList<Circle> a = new ArrayList<>();
    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner line = new Scanner(read.nextLine()); // đọc nguyên
                    double r = line.nextDouble();        // đọc 1 số 
                    if (line.hasNext()) {
                        double h = line.nextDouble();
                        a.add(new Cylinder(h, r));
                    } else {
                        a.add(new Circle(r));
                    }
                }
            } else {
                System.out.println("File không tồn tại");
            }
        } catch (Exception e) {
        }
    }
//    void input() {
//        int n;
//        Scanner sc = new Scanner(System.in);
//        
//        do {
//            System.out.print("nhap n>0 : ");
//            n = sc.nextInt();
//        } while (n <= 0);
//        for (int i = 0; i < n; i++) {
//            System.out.print("nhap hinh " + (i + 1) + ": ");
//            sc = new Scanner(new Scanner(System.in).nextLine());
//            double r, h;
//            r = sc.nextDouble();
//            if (sc.hasNext()) {
//                h = sc.nextDouble();
//                a.add(new Cylinder(r, h));
//            } else {
//                a.add(new Circle(r));
//            }
//        }
//    }

    void xuat(String nd) {
        System.out.println(nd);
        for (int i = 0; i < a.size(); i++) {
            System.out.println("\t" + a.get(i));
        }
    }

    Circle MaxS() {
        Circle temp = null;
        double max = 0;
        for (Circle x : a) {
                if (max < x.getArea()) {
                    max = x.getArea();
                    temp = x;
                }
            }
        return temp;
    }

    Circle MaxV() {
        Circle temp = null;
        double max = 0;
        for (Circle x : a) {
            if (x instanceof Cylinder) {
                if (max < ((Cylinder) x).getVolume()) {
                    max = ((Cylinder) x).getVolume();
                    temp = x;
                }
            }
        }
        return temp;
    }
    void phanloai()
    {
        int demcylinder=0;
         for (Circle x : a) {
            if (x instanceof Cylinder) 
            {
                demcylinder++;
            }
        }
        System.out.println("hinh tru: "+demcylinder);
        System.out.println("hinh tron: "+(a.size()-demcylinder));
    }
    void output() {
        xuat("cac hinh vua nhap: ");
        if (MaxV() == null) {
            System.out.println("khong co Cylinder");
        } else {
            System.out.println("Max the tich= " + MaxV());
        }
        System.out.println("Max dien tich= " + MaxS());
        phanloai();
    }

    public static void main(String[] args) {
        MangHinhTron a = new MangHinhTron();
        a.docFile("HT.txt");
//        a.input();
        a.output();
    }
}
