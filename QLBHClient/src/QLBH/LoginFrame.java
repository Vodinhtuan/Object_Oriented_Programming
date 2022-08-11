package QLBH;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textAccount;
	private JPasswordField passwordField;
	public static String accInput;
	private JTextField textIP;
	private JTextField textPort;
	public static int port;
	public static String ip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
				//	frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() throws SQLException,RemoteException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/QLBH/icons8_small_business_32px.png")));
		setTitle("QLBH Client");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Tên Đăng Nhập :");
		lblNewLabel.setBounds(57, 137, 125, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu : ");
		lblNewLabel_1.setBounds(97, 205, 87, 29);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textAccount = new JTextField();
		textAccount.setBounds(209, 139, 162, 35);
		textAccount.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 204, 162, 35);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accInput=textAccount.getText();
				String pwInput=String.valueOf(passwordField.getPassword());	
				String ten = null;	
				ip = textIP.getText();
				try {
					port = Integer.parseInt(textPort.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Sai Port!");
					
					
				}
				try {
					if(login(accInput, pwInput)!=null) {
						MainFrame.lblAccount.setText(login(accInput, pwInput));
						MainFrame mainframe = new MainFrame();
						mainframe.setVisible(true);
						mainframe.setLocationRelativeTo(null);					
						close();
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Sai Tài Khoản Hoặc Mật Khẩu!");
					}
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e) {
					JOptionPane.showMessageDialog(contentPane, "Không tìm thấy IP/Port!");
					
				}
			}
		});
		
		JLabel lblCheckServer = new JLabel("");
		lblCheckServer.setBounds(164, 257, 125, 14);
		contentPane.add(lblCheckServer);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(191, 296, 80, 29);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		
			
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				Thread th2 = new Thread(){
					public void run() {
						accInput=textAccount.getText();
						String pwInput=String.valueOf(passwordField.getPassword());	
						String ten = null;	
						ip = textIP.getText();
						try {
							port = Integer.parseInt(textPort.getText());
						} catch (Exception e) {
							JOptionPane.showMessageDialog(contentPane, "Sai Port!");
							
							
						}
						try {
							if(login(accInput, pwInput)!=null) {	
								MainFrame.lblAccount.setText(login(accInput, pwInput));
								MainFrame mainframe = new MainFrame();
								mainframe.setVisible(true);
								mainframe.setLocationRelativeTo(null);		
								close();
							}
							else {
								JOptionPane.showMessageDialog(contentPane, "Sai Tài Khoản Hoặc Mật Khẩu!");
								
								
							}
						} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e) {
							JOptionPane.showMessageDialog(contentPane, "Không tìm thấy IP/Port!");	
							
							
						}	
					}
				};
				th2.start();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textAccount);
		contentPane.add(passwordField);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng Nhập");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(178, 73, 96, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("IP:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(97, 24, 25, 14);
		contentPane.add(lblNewLabel_3);
		
		textIP = new JTextField();
		textIP.setBounds(132, 22, 86, 20);
		contentPane.add(textIP);
		textIP.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Port:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(244, 24, 27, 14);
		contentPane.add(lblNewLabel_4);
		
		textPort = new JTextField();
		textPort.setBounds(281, 22, 86, 20);
		contentPane.add(textPort);
		textPort.setColumns(10);
		
		
	
	}
	public void close() {
		WindowEvent closeWiundow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWiundow);
	}
	public String login(String account,String password) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		String servicesName = "rmi://"+ip+":"+port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		String hoten = stub.Login(account, password);
		return hoten;
	}
}
