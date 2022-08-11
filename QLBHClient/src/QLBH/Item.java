package QLBH;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private String mahang;
	private String tenhang;
	private int soluong;
	private String donvitinh;
	private int dongia;
	private String baohanh;
	
	public Item(String mahang,String tenhang,int soluong,String donvitinh,int dongia,String baohanh){
		this.baohanh=baohanh;
		this.mahang=mahang;
		this.tenhang=tenhang;
		this.soluong=soluong;
		this.donvitinh=donvitinh;
		this.dongia=dongia;
	}

	public String getMahang() {
		return mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public String getBaohanh() {
		return baohanh;
	}

	public void setBaohanh(String baohanh) {
		this.baohanh = baohanh;
	}

	@Override
	public String toString() {
		return "Item [mahang=" + mahang + ", tenhang=" + tenhang + ", soluong=" + soluong + ", donvitinh=" + donvitinh
				+ ", dongia=" + dongia + ", baohanh=" + baohanh + "]";
	}
}
