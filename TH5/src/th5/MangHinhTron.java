package th5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MangHinhTron {

    ArrayList<HinhTron> a = new ArrayList<>();

    void docfile(String nd) {

        try {
            File f = new File(nd);
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    DiemOxy tam = new DiemOxy();
                    double bankinh;
                    Scanner sc = new Scanner(read.nextLine());
                    tam.setX(sc.nextInt());
                    tam.setY(sc.nextInt());
                    bankinh = sc.nextDouble();
                    HinhTron temp = new HinhTron(tam, bankinh);
                    a.add(temp);
                }
            } else {
                System.out.println("khong ton tai file");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void maxS() {
        double max = a.get(0).dientich();
        int index = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).dientich() > max) {
                max = a.get(i).dientich();
                index = i;
            }
        }
        System.out.println("b hinh tron co dien tich lon nhat: " + a.get(index) + " dien tich=" + a.get(index).dientich());
    }

    void lietke() {
        DiemOxy temp=new DiemOxy();
        int x = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("e nhap goc phan tu can liet ke: ");
            x = sc.nextInt();
        } while(x<1||x>4);

        switch (x) {
            case 1: {
                System.out.println("goc phan tu 1");
                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() >= 0 && temp.getY() >= 0) {
                        System.out.println(a.get(i));
                    }
                }
                break;
            }
            case 2: {
                System.out.println(" goc phan tu 2");

                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() <= 0 && temp.getY() >= 0) {
                        System.out.println(a.get(i));
                    }
                }
                break;
            }
            case 3: {
                System.out.println(" goc phan tu 3");

                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() <= 0 && temp.getY() <= 0) {
                        System.out.println(a.get(i));
                    }
                }
                break;
            }
            case 4: {
                System.out.println("4 goc phan tu 4");

                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() >= 0 && temp.getY() <= 0) {
                        System.out.println(a.get(i));
                    }
                }
                break;
            }

        }

    }
    void loai()
    {
        DiemOxy temp=new DiemOxy();
        int x = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("e nhap goc phan tu can loai: ");
            x = sc.nextInt();
        } while(x<1||x>4);
        
        switch (x) {
            case 1: {
                System.out.println("goc phan tu 1");
                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() >= 0 && temp.getY() >= 0) {
                        a.remove(a.get(i));
                        i--;
                    }
                }
                break;
            }
            case 2: {
                System.out.println(" goc phan tu 2");

                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() <= 0 && temp.getY() >= 0) {
                        a.remove(a.get(i));
                        i--;
                    }
                }
                break;
            }
            case 3: {
                System.out.println(" goc phan tu 3");

                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() <= 0 && temp.getY() <= 0) {
                        a.remove(a.get(i));
                        i--;
                    }
                }
                break;
            }
            case 4: {
                System.out.println("4 goc phan tu 4");

                for (int i = 0; i < a.size(); i++) {
                    temp = a.get(i).getTam();
                    if (temp.getX() >= 0 && temp.getY() <= 0) {
                        a.remove(a.get(i));
                        i--;
                    }
                }
                break;
            }

        }
        xuatMang("mang sau khi loai: ");

    }
     void sapxep()
      {
          HinhTron temp;
          for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                if (a.get(i).dientich()< a.get(j).dientich())
                {
                   temp = a.get(i);
                   a.set(i,a.get(j));
                   a.set(j,temp);
               }
            }  
        }
         xuatMang("f mang sau khi loai sap xep:");  
      }
    void xuatMang(String nd) {
        System.out.println(nd);
        for (HinhTron i : a) {
            System.out.print(i + "\n");
        }
        System.out.println();
    }

    void output() {
        xuatMang("Mang hinh tron:");
        maxS();
        lietke();
        loai();
        sapxep();
    }

    public static void main(String[] args) {
        MangHinhTron a = new MangHinhTron();
        a.docfile("F:\\HT.txt");
        a.output();
    }
}
