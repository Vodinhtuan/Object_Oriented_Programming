/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoa_don_chuan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import sun.applet.Main;

/**
 *
 * @author Administrator
 */
public class DSHD {
    private ArrayList<HangHoa> a = new ArrayList<HangHoa>();
    public void readfile(String nd){
        try {
            File f= new File(nd);
            if(f.exists()){
                Scanner read=new Scanner(f);
                while(read.hasNext())
                {
                    
                }
            }
        } catch (Exception e) {
        }
    }
    
    public boolean themMoi(HangHoa y){
        for(HangHoa x: a)
            if(x.getMaHang().equalsIgnoreCase(y.getMaHang()))
                return false; //khong them duoc
        a.add(y);
        return true;
    }
    public boolean xoaTheoMa(String ma){
        for(HangHoa x: a)
            if(x.getMaHang().equalsIgnoreCase(ma)){
                a.remove(x);
                return true; //xoa duoc.
            }
        return false;
    }
    public HangHoa timTheoMa(String ma){
        for(HangHoa x : a)
            if(x.getMaHang().equalsIgnoreCase(ma))
                return x;
            return null; //rong
    }
    public ArrayList<HangHoa> laDSBH(){
        return a;
    }
    public double tongTienHangDienMay(){
        double s=0;
        for(HangHoa x:a)
            if(x instanceof HangDienMay)
                s=s+((HangDienMay)x).tinhThanhTien();
        return s;
    }
    public static void main(String[] args) {
        DSHD a = new DSHD();
        System.out.println("");
    }
}
