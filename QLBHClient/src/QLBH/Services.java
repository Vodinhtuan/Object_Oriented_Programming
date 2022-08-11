package QLBH;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Services extends Remote{
	public ArrayList<Bill> showBill() throws RemoteException, SQLException;
	public ArrayList<Bill> searchBill(String text)throws RemoteException, SQLException;
	public ArrayList<BillInfor> ShowBillInfor(String mahd) throws SQLException,RemoteException;
	public ArrayList<Customer> showCustomerInfor() throws SQLException,RemoteException;
	public ArrayList<Customer> searchCustomerInfor(String text) throws SQLException,RemoteException;
	public void editCustomer(String makh,String hoten,String sdt,String diachi)throws SQLException,RemoteException;
	public void addCustomer(String tenkh,String dienthoai,String diachi) throws SQLException,RemoteException;
	public ArrayList<Item> showItemInfor() throws SQLException, RemoteException;
	public ArrayList<Item> searchItemInfor(String text) throws SQLException,RemoteException;
	public void addItem(String tenhang,int soluong,String donvitinh,int dongia,String baohanh) throws SQLException,RemoteException;
	public int checkItem(String tenhang) throws SQLException,RemoteException;
	public void editItem(String mahang,String tenhang,int soluong,String donvitinh,int dongia,String baohanh) throws SQLException,RemoteException;
	public ArrayList<Staff> showStaffInfor() throws SQLException,RemoteException;
	public ArrayList<Staff> searchStaffInfor(String text) throws SQLException,RemoteException;
	public void addStaff(String tentk,String mk,String hoten,String sdt,String diachi)throws SQLException,RemoteException;
	public void editStaff(String tentk,String mk,String hoten,String sdt,String diachi)throws SQLException,RemoteException;
	public String getPassword(String tentk)throws SQLException,RemoteException;
	public String Login(String account,String password) throws SQLException,RemoteException;
	public String getCustomerName(String makh)throws SQLException,RemoteException;
	public String getStaffName(String tentk)throws SQLException,RemoteException;
	public void addBill(String makh,String tentk,int tongtien,String ngay)throws SQLException,RemoteException;
	public void sellItem(int soluong,String mahang)throws SQLException,RemoteException;
	public String getBillCode(String ngay)throws SQLException,RemoteException;
	public void addItemToBill(String mahd,String mahang,int soluong,int dongia)throws SQLException,RemoteException;
	public ArrayList<Bill> getBillByCustomer(String makh)throws SQLException,RemoteException;
	public ArrayList<Bill> getBillByStaff(String tentk)throws SQLException,RemoteException;
	public boolean checkCustomerID(String id)throws SQLException,RemoteException;
	public boolean checkAccount(String acc)throws SQLException,RemoteException;
}
