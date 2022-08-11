package QLBH;

import java.io.Serializable;

public class BillInfor implements Serializable{
	private String mahang;
	private String tenhang;
	private int soluong;
	private String donvitinh;
	private String dongia;
	private String baohanh;
	
	public BillInfor(String mahang,String tenhang,int soluong,String donvitinh,String dongia,String baohanh) {
		this.mahang = mahang;
		this.tenhang = tenhang;
		this.soluong = soluong;
		this.dongia=dongia;
		this.donvitinh = donvitinh;
		this.baohanh = baohanh;
	}



	public String getTenhang() {
		return tenhang;
	}



	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}



	public String getDonvitinh() {
		return donvitinh;
	}



	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}



	public String getBaohanh() {
		return baohanh;
	}



	public void setBaohanh(String baohanh) {
		this.baohanh = baohanh;
	}



	public String getMahang() {
		return mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}                                  
                                       
	public String getDongia() {
		return dongia;
	}

	public void setDongia(String dongia) {
		this.dongia = dongia;
	}



	@Override
	public String toString() {
		return "BillInfor [mahang=" + mahang + ", tenhang=" + tenhang + ", soluong=" + soluong + ", donvitinh="
				+ donvitinh + ", dongia=" + dongia + ", baohanh=" + baohanh + "]";
	}


	
}
