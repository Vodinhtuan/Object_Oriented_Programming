
package th7;

import java.util.Scanner;
import java.util.ArrayList;

public class MangPhuongTrinh {
    private ArrayList<PhuongTrinhBac1> a = new ArrayList<>();
    
    void input()
    {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("nhap so phuong trinh >0 : ");
            n = sc.nextInt();
        } while (n <= 0);
        
        double a1,b,c;
        for (int i = 0; i < n; i++) 
        {
            System.out.print("nhap phuong trinh " + (i + 1) + ": ");
            sc= new Scanner(new Scanner(System.in).nextLine());
            a1=sc.nextDouble();
            b=sc.nextDouble();
            if (sc.hasNext())
            {
                c=sc.nextDouble();
                a.add(new PhuongTrinhBac2(a1,b,c));
            }
            else a.add(new PhuongTrinhBac1(a1,b));
        }
    }
    void xuat(String nd) {
        System.out.println(nd);
        for (PhuongTrinhBac1 i:a) {
            System.out.println("\t" + i);
        }
    }
    void phanloai()
    {
        int count_bac_2=0;
         for (PhuongTrinhBac1 i : a) {
            if (i instanceof PhuongTrinhBac2) 
            {
                count_bac_2++;
            }
        }
        System.out.println("so phuong trinh bac 1: "+(a.size()-count_bac_2));
        System.out.println("so phuong trinh bac 2: "+count_bac_2);
    }
    void output()
    {
        xuat("phuong trinh da nhap: ");
        phanloai();
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        MangPhuongTrinh a = new MangPhuongTrinh();
        a.input();
        a.output();
    }
}
