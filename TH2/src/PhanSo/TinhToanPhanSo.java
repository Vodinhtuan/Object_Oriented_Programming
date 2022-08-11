
package PhanSo;

import java.util.Scanner;        

public class TinhToanPhanSo 
{
    private PhanSo a=new PhanSo() ,b=new PhanSo();
    private char pt;

    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap phan so a");
        System.out.print("nhap tu:");
        a.setTu(sc.nextInt());
        do
        {
            System.out.print("nhap mau #0:");
            a.setMau(sc.nextInt());
        }   while(a.getMau()==0);
        System.out.println("nhap phan so b");
        System.out.print("nhap tu:");
        b.setTu(sc.nextInt());
        do
        {
            System.out.print("nhap mau #0:");
            b.setMau(sc.nextInt());
        }   while(b.getMau()==0);
        System.out.print("nhap phep tinh(+,-,/*,/): ");
        pt=sc.next().charAt(0);
    }
    
    
    void output()
    {
        switch (pt)
        {
            case '+':System.out.println("tong 2 phan so: "+a+" + "+b+" = "+a.cong(b)); break;
            case '-':System.out.println("hieu 2 phan so: "+a+" - "+b+" = "+a.tru(b));break;
            case '*':System.out.println("tich 2 phan so: "+a+" * "+b+" = "+a.chia(b)); break;
            case '/':if (b.getTu()==0) System.out.println("khong chia cho 0");
                        else System.out.println("thuong 2 phan so: "+a+" / "+b+" = "+a.chia(b)); break;
                     
            default:System.out.println("Khong tinh");
            
        }
    }

    
    public static void main(String[] args)
    {
        TinhToanPhanSo a = new TinhToanPhanSo();
        a.input();
        a.output();
    }
    
}
