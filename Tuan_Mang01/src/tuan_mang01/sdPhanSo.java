/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class sdPhanSo {
    private phanSo a,b;
    private char pt;
    public void input (){
        Scanner kb=new Scanner(System.in);
        System.out.println("Tính toán trên phân số");
        System.out.print("Nhap tu so 1: ");
        int t,m;
        t  = kb.nextInt();
        do
            {System.out.print("\tNhap mau 1<>0: ");
                m  = kb.nextInt();
            }while(m==0);
        a = new phanSo(t,m);
        System.out.print("Nhap tu so 2: ");
        t = kb.nextInt();
        do
            {System.out.print("\tNhap mau 2<>0: ");
                m  = kb.nextInt();
        }while(0==m);
        b = new phanSo(t,m);
        System.out.print("Nhap phep toan(+,-,*,/): ");
        pt= kb.next().charAt(0);           
    }
    public void output (){
        switch(pt){
            case '+' -> System.out.println(a +"+"+ b + "=" +a.cong(b));
            case '-' -> System.out.println(a +"-"+ b + "=" +a.tru(b));
            case '*' -> System.out.println(a +"*"+ b + "=" +a.nhan(b));
            case '/' -> {
                if(b.getTu()==0){
                    System.out.println("khong chia 0");
                    System.exit(pt);
                }
                else
                    System.out.println(a +"/"+ b + "=" +a.chia(b));
            }
            default -> {
                    System.out.println("ky tu sai khong tinh");
                    System.exit(pt);
            }
        }
    }
     public static void main(String []arg){
       sdPhanSo a= new sdPhanSo();
        a.input();
        a.output();    
    }       
}
