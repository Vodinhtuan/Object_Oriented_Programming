
package th11;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> a = new ArrayList<>();
    
    void readfile(String namefile){
        try{
            File f = new File(namefile);
            if (f.exists()){
                Scanner read = new Scanner(f);
                while (read.hasNext()){
                    Scanner line = new Scanner(read.nextLine());
                    String id = "", name = "";
                    boolean sex = false;
                    int s1, s2, s3;
                    id = line.next();
                    while(!line.hasNextBoolean()){
                        name += line.next() + " ";
                    }
                    name = name.trim();
                    sex = line.nextBoolean();
                    s1 = line.nextInt();
                    s2 = line.nextInt();
                    if (line.hasNextInt()){
                        s3 = line.nextInt();
                        a.add(new CNTT(id, name, sex, s1, s2, s3));
                    }else{
                        a.add(new KinhTe(id, name, sex, s1, s2));
                    }
                }
            }else System.out.println("khong ton tai file");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    void xuat(String nd){
        System.out.println(nd);
        for (SinhVien i:a)
            System.out.println("\t"+i);
    }
    
    int demCNTT(){
        int count = 0;
        for (SinhVien x : a){
            if (x instanceof CNTT)
                count++;
        }
        return count;
    }
    int demKinhTe(){
        int count = 0;
        for (SinhVien x : a){
            if (x instanceof KinhTe)
                count++;
        }
        return count;
    }
    int demSVgioi(){
        int count = 0;
        for (SinhVien x : a){
            if ((x instanceof KinhTe && ((KinhTe)x).getHocluc().equalsIgnoreCase("gioi")) ||
                 (x instanceof CNTT && ((CNTT)x).getHocluc().equalsIgnoreCase("gioi")))   
                count++;
        }
        return count;
    }
    
    void max_tb(){
        double max_cntt = 0, max_kinhte = 0;
        for (SinhVien x : a){
            if (x instanceof CNTT)
                if (max_cntt < ((CNTT) x).diemtrungbinh()){
                    max_cntt = ((CNTT) x).diemtrungbinh();
                }else;
            else{
                if (max_kinhte < ((KinhTe) x).diemtrungbinh()){
                    max_kinhte = ((KinhTe) x).diemtrungbinh();
                }
            }
        }
        System.out.println("Max tung binh CNTT: "+max_cntt);
        System.out.println("Max tung binh Kinh Te: "+max_kinhte);
    }
    
    void output(){
        xuat("danh sach sinh vien: ");
        System.out.println("sinh vien CNTT: "+demCNTT());
        System.out.println("sinh vien Kinh Te: "+demKinhTe());
        max_tb();
        System.out.println("sinh vien gioi: "+demSVgioi());
    }
    
    public static void main(String[] args) {
        DanhSachSinhVien a = new DanhSachSinhVien();
        a. readfile("SV.txt");
        a. output();
    }
}