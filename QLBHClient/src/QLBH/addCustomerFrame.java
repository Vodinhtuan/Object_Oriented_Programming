package QLBH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addCustomerFrame extends JFrame {

	private JPanel contentPane;
	public JTextField textHoTen;
	public JTextField textSDT;
	public JTextField textDiaChi;
	public String makh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCustomerFrame frame = new addCustomerFrame();
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
	public addCustomerFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(addCustomerFrame.class.getResource("/QLBH/icons8_small_business_32px.png")));
		setTitle("QLBH Client");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoTen.setBounds(64, 71, 84, 21);
		contentPane.add(lblHoTen);
		
		JLabel lblNewLabel_1 = new JLabel("SDT:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(64, 116, 84, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Địa Chỉ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(64, 162, 84, 21);
		contentPane.add(lblNewLabel_2);
		
		textHoTen = new JTextField();
		textHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textHoTen.setBounds(172, 71, 144, 20);
		contentPane.add(textHoTen);
		textHoTen.setColumns(10);
		
		textSDT = new JTextField();
		textSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textSDT.setBounds(172, 116, 144, 20);
		contentPane.add(textSDT);
		textSDT.setColumns(10);
		
		textDiaChi = new JTextField();
		textDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDiaChi.setBounds(172, 162, 144, 20);
		contentPane.add(textDiaChi);
		textDiaChi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(124, 21, 185, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnAddCustomer = new JButton("");
		btnAddCustomer.setBorderPainted(false); 
		btnAddCustomer.setContentAreaFilled(false); 
		btnAddCustomer.setFocusPainted(false); 
		btnAddCustomer.setOpaque(false);
		btnAddCustomer.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnAddCustomer.setContentAreaFilled(true);
				btnAddCustomer.setBackground(Color.LIGHT_GRAY);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddCustomer.setContentAreaFilled(false);
				btnAddCustomer.setBackground(Color.white);
				
			}
		});
		btnAddCustomer.setIcon(new ImageIcon(addCustomerFrame.class.getResource("/QLBH/icons8_check_file_26px.png")));
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.checkCustomerclicked==0) {
					String hoten = textHoTen.getText();
					if(hoten.equals("")) {
						
					}
					else {
						String sdt = textSDT.getText();
						String diachi = textDiaChi.getText();
						String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
						Services stub;
						try {
							stub = (Services)Naming.lookup(servicesName);
							stub.addCustomer(hoten, sdt, diachi);
							MainFrame.ShowCustomerInFor();
						} catch (MalformedURLException | RemoteException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						close();
					}
					
				}
				else{
					String tenkh = textHoTen.getText();
					String sdt = textSDT.getText();
					String diachi = textDiaChi.getText();
					String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
					try {
						Services stub =(Services)Naming.lookup(servicesName);
						stub.editCustomer(makh, tenkh, sdt, diachi);
						MainFrame.ShowCustomerInFor();
						MainFrame.checkCustomerclicked=0;
					} catch (MalformedURLException | RemoteException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					MainFrame.btnEditCustomer.setContentAreaFilled(false);
					MainFrame.btnEditCustomer.setBackground(Color.white);
					close();
				}
			}
		});
		btnAddCustomer.setBounds(199, 217, 32, 35);
		contentPane.add(btnAddCustomer);
		
		JButton btnCancel = new JButton("");
		btnCancel.setBorderPainted(false); 
		btnCancel.setContentAreaFilled(false); 
		btnCancel.setFocusPainted(false); 
		btnCancel.setOpaque(false);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnCancel.setContentAreaFilled(true);
				btnCancel.setBackground(Color.LIGHT_GRAY);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setContentAreaFilled(false);
				btnCancel.setBackground(Color.white);
				
			}
		});
		btnCancel.setIcon(new ImageIcon(addCustomerFrame.class.getResource("/QLBH/icons8_cancel_26px.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.checkCustomerclicked=0;
				MainFrame.btnEditCustomer.setContentAreaFilled(false);
				MainFrame.btnEditCustomer.setBackground(Color.white);
				close();
			}
		});
		btnCancel.setBounds(264, 217, 32, 35);
		contentPane.add(btnCancel);
		
		JButton btnClear = new JButton("");
		btnClear.setBorderPainted(false); 
		btnClear.setContentAreaFilled(false); 
		btnClear.setFocusPainted(false); 
		btnClear.setOpaque(false);
		if(MainFrame.checkCustomerclicked==1) {
			btnClear.setEnabled(false);
		}
		else {
			btnClear.setEnabled(true);
		}
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
		btnClear.setIcon(new ImageIcon(addCustomerFrame.class.getResource("/QLBH/icons8_refresh_26px.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDiaChi.setText("");
				textSDT.setText("");
				textHoTen.setText("");
			}
		});
		btnClear.setBounds(140, 217, 32, 35);
		contentPane.add(btnClear);
	}
	public void close() {
		WindowEvent closeWiundow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWiundow);
	}
}
