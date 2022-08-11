/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinhtuan;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
/**
 *
 * @author Admin
 */
public class mangSV {
    private ArrayList<sinhvien> a= new ArrayList<sinhvien>();
    public void docFile(String tenFile){
        try {
            File f = new File(tenFile);
            if(f.exists()){
                Scanner read = new Scanner(f);
                while(read.hasNext()){
                    Scanner line = new Scanner(read.nextLine());
                    //line = 001 Trien Chieu true 1/1/2000 Khai Phong Phu 9.2
                    String ma, ht="",ns, qq="";
                    boolean gt;
                    double diem;
                    ma=line.next();
                    while (!line.hasNextBoolean())
                        ht = ht + line.next()+" ";
                    ht=ht.trim();
                    gt=line.nextBoolean();
                    ns=line.next();
                    while(!line.hasNextDouble())
                        qq=qq+line.next()+" ";
                    qq= qq.trim();
                    diem=line.nextDouble();
                   // SinhVien(String ma, String hoTen, String ngaySinh, 
                    //String queQuan, boolean gioiTinh, double diem)
                    a.add(new sinhvien (ma,ht,ns,qq,gt,diem));
                }
                
            }else System.out.println("File ko ton tai");
        } catch (Exception e) {
        }
    }
    public void xuat(String noiDung){
        System.out.println(noiDung);
        for(sinhvien x: a)
            System.out.println(x);
    }
  
    public void output(){
        xuat("DSSV vua doc tu file");
      
    }
    public static void main(String[] args) {
        mangSV a= new mangSV();
        a.docFile("SV.txt");
        a.output();
    }  
}
