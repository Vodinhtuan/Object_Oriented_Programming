package QLBH;

import java.io.Serializable;

public class Bill implements Serializable{
	private String mahoadon;
	private String makh;
	private String tentk;
	private String tongtien;
	private String ngay;
	
	public Bill(String mahoadon,String makh,String tentk,String tongtien,String ngay) {
		this.mahoadon = mahoadon;
		this.makh = makh;
		this.tentk = tentk;
		this.tongtien = tongtien;
		this.ngay = ngay;
	}

	public String getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTentk() {
		return tentk;
	}

	public void setTentk(String tentk) {
		this.tentk = tentk;
	}

	public String getTongtien() {
		return tongtien;
	}

	public void setTongtien(String tongtien) {
		this.tongtien = tongtien;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	@Override
	public String toString() {
		return "Bill [mahoadon=" + mahoadon + ", makh=" + makh + ", tentk=" + tentk + ", tongtien=" + tongtien
				+ ", ngay=" + ngay + "]";
	}
	
}
