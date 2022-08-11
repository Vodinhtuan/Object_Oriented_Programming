/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

/**
 *
 * @author Admin
 */
public class DiemOxy {
    private int ox, oy;
    public DiemOxy(){ //ox=oy=0;
    }
    public DiemOxy(int ox, int oy){
        this.ox = ox;
        this.oy = oy;
    }

    public int getOx() {
        return ox;
    }

    public void setOx(int ox) {
        this.ox = ox;
    }

    public int getOy() {
        return oy;
    }

    public void setOy(int oy) {
        this.oy = oy;
    }
    
    public String toString(){
        return "("+ox+","+oy+")";
    }
    public double modul(){
        return Math.sqrt(ox*ox*oy*oy);
    }
    public double khoangCach (DiemOxy b){
        return Math.sqrt(Math.pow(ox-b.ox,2)+Math.pow(oy-b.oy,2));
    }
    public static void main(String[] args) {
        DiemOxy a=new DiemOxy (-1,2);
        DiemOxy b= new DiemOxy();
        System.out.println(a+"->(0,0):"+a.modul());
        System.out.println(a+"->"+b+":"+a.khoangCach(b));
    }
}

// 