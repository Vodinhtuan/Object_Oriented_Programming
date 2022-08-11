
package cs311c;

import java.util.Scanner;

public class TamGiac 
{
    double x1,x2,x3,y1,y2,y3;
    double ab,ac,bc,g_abc,g_acb,g_bac;
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhap toa do diem A:");
        System.out.print("x: ");
        x1=sc.nextDouble();
        System.out.print("y: ");
        y1=sc.nextDouble();
        System.out.println("nhap toa do diem B:");
        System.out.print("x: ");
        x2=sc.nextDouble();
        System.out.print("y: ");
        y2=sc.nextDouble();
        System.out.println("nhap toa do diem C:");
        System.out.print("x: ");
        x3=sc.nextDouble();
        System.out.print("y: ");
        y3=sc.nextDouble();
    }
    double khoangcach(double x1,double y1,double x2,double y2)
    {
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }
    void goc()
    {
        g_abc=((x2-x1)*(x3-x2)+(y2-y1)*(y3-y2))/(ab*bc);
        g_acb=((x3-x1)*(x2-x3)+(y3-y1)*(y2-y3))/(ac*bc);
        g_bac=((x1-x2)*(x3-x1)+(y1-y2)*(y3-y1))/(ac*ab);
    }
    void loaitamgiac()
    {
        if(ab+ac>bc && ab+bc>ac && bc+ac>ab)
        {
            if (ab==ac && ab==bc)
            {
                System.out.println("day la tam giac deu");
            }
            else if(g_abc==0 || g_acb==0 || g_bac==0)
            {
                if(ab==ac || ab==bc  || ac==bc)
                {
                    System.out.println("day la tam giac vuong can");
                }
                else
                {
                    System.out.println("day la tam giac vuong ");
                }
            }
            else if(ab==ac || ab==bc  || ac==bc)
            {
                System.out.println("day la tam giac can");
            }
            else
            {
                System.out.println("day la tam giac thuong");
            }
            System.out.println("chu vi: "+(ab+ac+bc));
            double p=(ab+ac+bc)/2;
            System.out.println("dien tich: "+Math.sqrt(p*(p-ab)*(p-bc)*(p-ac)));
        }
        else System.out.println("du lieu vua nhap khong phai toa do ba dinh cua mot tam giac");
    }
    void OutPut()
    {
        ab=khoangcach(x1,y1,x2,y2);
        ac=khoangcach(x1,y1,x3,y3);
        bc=khoangcach(x2,y2,x3,y3);
        goc();
        loaitamgiac();
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        TamGiac a=new TamGiac();
        a.Input();
        a.OutPut();
    }
}
