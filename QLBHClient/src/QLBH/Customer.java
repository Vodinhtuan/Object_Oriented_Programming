package QLBH;

import java.io.Serializable;

public class Customer implements Serializable{
	private String makh;
	private String tenkh;
	private String dienthoai;
	private String diachi;
	
	public Customer(String makh,String tenkh,String dienthoai,String diachi) {
		this.diachi=diachi;
		this.dienthoai=dienthoai;
		this.makh=makh;
		this.tenkh=tenkh;
		}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	@Override
	public String toString() {
		return "Customer [makh=" + makh + ", tenkh=" + tenkh + ", dienthoai=" + dienthoai + ", diachi=" + diachi + "]";
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
}
