package QLBH;

import java.io.Serializable;

public class Staff implements Serializable{
	private String tentk;
	private String hoten;
	private String sdt;
	private String diachi;
	
	public Staff(String tentk,String hoten, String sdt, String diachi) {
		this.tentk=tentk;
		this.hoten=hoten;
		this.sdt=sdt;
		this.diachi=diachi;
	}

	public String getTentk() {
		return tentk;
	}

	public void setTentk(String tentk) {
		this.tentk = tentk;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "Staff [tentk=" + tentk + ", hoten=" + hoten + ", sdt=" + sdt + ", diachi=" + diachi + "]";
	}
	
}
