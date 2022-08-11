
package th9;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MangSinhVien {
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
    
    void out(String nd){
        System.out.println(nd);
        for (int i=0;i<a.size();i++)
            System.out.println("\t"+a.get(i));
    }
    
    int count_CNTT(){
        int count = 0;
        for (SinhVien x : a){
            if (x instanceof CNTT)
                count++;
        }
        return count;
    }
    
    void max_average(){
        double max_cntt = 0, max_kinhte = 0;
        SinhVien temp1 = null, temp2 = null;
        for (SinhVien x : a){
            if (x instanceof CNTT)
                if (max_cntt < ((CNTT) x).diemtrungbinh()){
                    max_cntt = ((CNTT) x).diemtrungbinh();
                    temp1 = x;
                }else;
            else{
                if (max_kinhte < ((KinhTe) x).diemtrungbinh()){
                    max_kinhte = ((KinhTe) x).diemtrungbinh();
                    temp2 = x;
                }
            }
        }
        System.out.println("Max CNTT:");
        System.out.println("\t"+temp1);
        System.out.println("Max KINH TE:");
        System.out.println("\t"+temp2);
    }
    
    void output(){
        out("mang sau khi nhap: ");
        max_average();
    }
    
    public static void main(String[] args) {
        MangSinhVien a = new MangSinhVien();
        a. readfile("SV.txt");
        a. output();
    }
}