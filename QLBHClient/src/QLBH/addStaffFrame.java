package QLBH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addStaffFrame extends JFrame {

	public JPanel contentPane;
	public JTextField textAccount;
	public JPasswordField passwordField1;
	public JPasswordField passwordField2;
	public JTextField textName;
	public JTextField textSDT;
	public JTextField textAddress;
	public JPasswordField passwordFieldOld;
	public JLabel lblNewLabel_7 = new JLabel("Mật Khẩu Cũ : ");
	public JButton btnClear = new JButton("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStaffFrame frame = new addStaffFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addStaffFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(addStaffFrame.class.getResource("/QLBH/icons8_small_business_32px.png")));
		setTitle("QLBH CLient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Thông Tin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Tên Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Nhập Lại Mật Khẩu :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Họ Tên : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("Địa Chỉ : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textAccount = new JTextField();
		textAccount.setColumns(10);

		passwordField1 = new JPasswordField();
		
		passwordField2 = new JPasswordField();
		
		textName = new JTextField();
		textName.setColumns(10);
		
		textSDT = new JTextField();
		textSDT.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		
		JButton btnAddStaff = new JButton("");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.checkStaffclicked==0) {
					String pass1 = String.valueOf(passwordField1.getPassword());
					String pass2 = String.valueOf(passwordField2.getPassword());
					if(pass1.equals(pass2)==false) {
						JOptionPane.showMessageDialog(btnAddStaff, "Mật khẩu không trùng khớp!");
						return;
					}
					if(textAccount.getText().equals("") | textAddress.getText().equals("") | textName.getText().equals("") | textSDT.getText().equals("")) {
						return;
					}
					String tentk = textAccount.getText();
					try {
						if(checkAccount(tentk)==true) {
							JOptionPane.showMessageDialog(contentPane, "Tài khoản đã tồn tại!");
							return;
						}
					} catch (HeadlessException | MalformedURLException | RemoteException | NotBoundException
							| SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String hoten = textName.getText();
					String sdt = textSDT.getText();
					String diachi = textAddress.getText();
					try {
						addStaff(tentk, pass1, hoten, sdt, diachi);
						MainFrame.ShowStaffInfor();
					} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					close();
				}
				else {
					String tentk = textAccount.getText();
					String pass1 = String.valueOf(passwordField1.getPassword());
					String pass2 = String.valueOf(passwordField2.getPassword());
					String oldpass = String.valueOf(passwordFieldOld.getPassword());
					if(textAddress.getText().equals("") || textName.getText().equals("") || textSDT.getText().equals("") || String.valueOf(passwordField2.getPassword()).equals("") || String.valueOf(passwordField1.getPassword()).equals(""))  {
						JOptionPane.showMessageDialog(btnAddStaff, "Vui lòng nhập đầy đủ thông tin!");
						return;
					}
					if(pass1.equals(pass2)==false) {
						JOptionPane.showMessageDialog(btnAddStaff, "Mật không trùng khớp!");
						return;
					}
					try {
						if(oldpass.equals(getPassword(tentk))==false) {
							JOptionPane.showMessageDialog(btnAddStaff, "Mật khẩu cũ không đúng!");
							return;
						}
					} catch (HeadlessException | MalformedURLException | RemoteException | NotBoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String hoten = textName.getText();
					String sdt = textSDT.getText();
					String diachi = textAddress.getText();
					try {
						editStaff(tentk, pass2, hoten, sdt, diachi);
						MainFrame.ShowStaffInfor();
					} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					MainFrame.checkStaffclicked=0;
					MainFrame.btnEditStaff.setContentAreaFilled(false);
					MainFrame.btnEditStaff.setBackground(Color.white);
					close();
				}
			}
		});
		btnAddStaff.setBorderPainted(false); 
		btnAddStaff.setContentAreaFilled(false); 
		btnAddStaff.setFocusPainted(false); 
		btnAddStaff.setOpaque(false);
		btnAddStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddStaff.setContentAreaFilled(true);
				btnAddStaff.setBackground(Color.LIGHT_GRAY);
				btnAddStaff.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			public void mouseExited(MouseEvent e) {
				btnAddStaff.setContentAreaFilled(false);
				btnAddStaff.setBackground(Color.white);				
				
			}
		});
		btnAddStaff.setIcon(new ImageIcon(addStaffFrame.class.getResource("/QLBH/icons8_check_file_26px.png")));
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.checkStaffclicked=0;
				MainFrame.btnEditStaff.setContentAreaFilled(false);
				MainFrame.btnEditStaff.setBackground(Color.white);
				close();
			}
		});
		btnCancel.setBorderPainted(false); 
		btnCancel.setContentAreaFilled(false); 
		btnCancel.setFocusPainted(false); 
		btnCancel.setOpaque(false);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setContentAreaFilled(true);
				btnCancel.setBackground(Color.LIGHT_GRAY);
				
			}
			public void mouseExited(MouseEvent e) {
				btnCancel.setContentAreaFilled(false);
				btnCancel.setBackground(Color.white);
				
			}
		});
		btnCancel.setIcon(new ImageIcon(addStaffFrame.class.getResource("/QLBH/icons8_cancel_26px.png")));
		
		
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setVisible(false);
		passwordFieldOld = new JPasswordField();
		passwordFieldOld.setVisible(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAccount.setText("");
				textAddress.setText("");
				textName.setText("");
				textSDT.setText("");
				passwordField1.setText("");
				passwordField2.setText("");
				passwordFieldOld.setText("");
			}
		});
		
		
		btnClear.setBorderPainted(false); 
		btnClear.setContentAreaFilled(false); 
		btnClear.setFocusPainted(false); 
		btnClear.setOpaque(false);
		btnClear.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnClear.setContentAreaFilled(true);
				btnClear.setBackground(Color.LIGHT_GRAY);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClear.setContentAreaFilled(false);
				btnClear.setBackground(Color.white);
				
			}
		});
		btnClear.setIcon(new ImageIcon(addStaffFrame.class.getResource("/QLBH/icons8_refresh_26px.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(170, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED, 300, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_7)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_6)
											.addComponent(lblNewLabel_4)
											.addComponent(lblNewLabel_5)
											.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textAddress, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(passwordFieldOld, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(textSDT, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(textName, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(passwordField2, 187, 187, Short.MAX_VALUE)
										.addComponent(passwordField1, 187, 187, Short.MAX_VALUE)
										.addComponent(textAccount, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(133)
					.addComponent(btnAddStaff, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(textAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordFieldOld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCancel)
						.addComponent(btnClear)
						.addComponent(btnAddStaff, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void addStaff(String taikhoan,String mk,String hoten,String sdt,String diachi) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		stub.addStaff(taikhoan, mk, hoten, sdt, diachi);
	}
	public void close() {
		WindowEvent closeWiundow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWiundow);
	}
	public String getPassword(String taikhoan) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		return stub.getPassword(taikhoan);
		
	}
	public void editStaff(String tentk, String mk, String hoten, String sdt, String diachi) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		stub.editStaff(tentk, mk, hoten, sdt, diachi);
	}
	public boolean checkAccount(String acc) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		return stub.checkAccount(acc);
	}
}
