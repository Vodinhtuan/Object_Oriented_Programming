
package cs311c;

import java.util.Scanner;

public class STRING 
{
    String chuoi;
    
    void Input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap chuoi:");
        chuoi=sc.nextLine();
    }
    // cau 3 cau 4
    void Count()
    {
        int s_kta=0,s_ktt=0,s_kts=0,s_ktdb=0;
        for (int i=0;i<chuoi.length();i++)
        {
            if(chuoi.charAt(i)==' ') s_ktt++;
            if(chuoi.charAt(i)>=48&&chuoi.charAt(i)<=57) s_kts++;
            if((chuoi.charAt(i)>=65&&chuoi.charAt(i)<=90)||(chuoi.charAt(i)>=97&&chuoi.charAt(i)<=122)) s_kta++;
        }
        s_ktdb=(chuoi.length()-s_kta-s_ktt-s_kts);
        System.out.println("so ky tu cua chuoi: "+chuoi.length()+"\nso ky tu alphabe: "
                            +s_kta+"\nso ky tu so:"+s_kts+"\nso ky tu trang: "
                            +s_ktt+"\nso ky tu dac biet: "+s_ktdb);
    }
    //cau 2 cau 5 cau 1
    void Format()
    {
        int s_t=0;
        chuoi=chuoi.trim();
        chuoi=chuoi.toLowerCase();
        if(chuoi.charAt(0)>=97&&chuoi.charAt(0)<=122) chuoi =(char)(chuoi.charAt(0)-32)+chuoi.substring(1);
        for (int i=0;i<chuoi.length();i++)
        {
            if(chuoi.charAt(i)==' '&&chuoi.charAt(i+1)==' ') 
            {
                chuoi=chuoi.substring(0,i+1)+chuoi.substring(i+2);
                i--;
            }
            if(chuoi.charAt(i)==' '&& (chuoi.charAt(i+1)>=97&&chuoi.charAt(i+1)<=122)) 
            {
                chuoi =chuoi.substring(0,i+1)+(char)(chuoi.charAt(i+1)-32)+chuoi.substring(i+2);
            }
        }
        for(int i=0;i<chuoi.length();i++)
        {
            if(chuoi.charAt(i)==' ') s_t++;
            if(i==chuoi.length()-1) s_t++;
        }
        System.out.println("so tu trong chuoi: "+s_t);        
        System.out.println("chuoi sau khi format:"+chuoi);
    }
    void Output()
    {
        System.out.println("chuoi vua nhap:"+chuoi);
        Count();
        Format();
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        STRING a=new STRING();
        a.Input();
        a.Output();
    }
}
