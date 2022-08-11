/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybenhvien;


public class TaiKhoan {
    String tentk,matkhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentk, String matkhau) {
        this.tentk = tentk;
        this.matkhau = matkhau;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return tentk + " " + matkhau;
    }
    
}
