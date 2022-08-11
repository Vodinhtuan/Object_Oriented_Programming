package QLBH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainFrame extends JFrame {
	

	private JPanel contentPane;
	public static JLabel lblAccount = new JLabel("adu");
	public static JLabel lblMoneyInteger = new JLabel("0");
	public static JTable table1 = new JTable();
	public static JTable table3 = new JTable();
	public static JTable table2;
	private JTextField textFindItem;
	private TableRowSorter sorter;
	public static Locale localeVN = new Locale("vi","VN");
	public static NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	public static JLabel lblTotal = new JLabel("0");
	private JTable table4;
	private int hoveredRow = -1, hoveredColumn = -1;
	private JTextField textMaKH;
	public static JTable table6;
	private JTable table7;
	private JTextField textFindCustomer;
	JLabel lblMaHoaDon = new JLabel("");
	private static JTable table8;
	private Socket socket;
	JTextArea textMessageBoard;
	private JTable table9;
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private Socket client;
	private JTable table5;
	private JTextField textTenHang;
	private JTextField textSoLuong;
	private JTextField textDVT;
	private JTextField textDonGia;
	private JTextField textBaoHanh;
	private JTextField textFind;
	private JTextField textFindStaff;
	public static int checkCustomerclicked=0;
	public static int checkStaffclicked = 0;
	public static JButton btnEditStaff = new JButton("");
	public static JButton btnEditCustomer = new JButton("");
	private JTextField textFindBill;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
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
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public MainFrame() throws SQLException, RemoteException, MalformedURLException, NotBoundException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/QLBH/icons8_small_business_32px.png")));
		
		setTitle("QLBH Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tabbedPane.setToolTipText("");
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
				.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 568, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblClock = new JLabel("Clock");
		lblClock.setHorizontalAlignment(SwingConstants.RIGHT);
		Clock clock = new Clock(lblClock);
		clock.start();
		
		JLabel lblHint = new JLabel("");
		lblHint.setForeground(Color.GRAY);

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(lblHint, GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
					.addGap(244))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(960, Short.MAX_VALUE)
					.addComponent(lblClock, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClock)
						.addComponent(lblHint))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					close();
					LoginFrame login = new LoginFrame();
					login.setUndecorated(true);
					login.setVisible(true);
					login.setLocationRelativeTo(null);					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setForeground(Color.RED);
				lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Sign out of your account");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogout.setForeground(Color.GREEN);
				lblHint.setText("");
			}
		});
		lblLogout.setForeground(Color.GREEN);
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		lblAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(912, Short.MAX_VALUE)
					.addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLogout, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(122))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblLogout)
					.addComponent(lblAccount))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Item", null, panel1, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
	
		
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
				String mahang = (String) model1.getValueAt(table1.getSelectedRow(), 0);
				int soluongcon = (int) model1.getValueAt(table1.getSelectedRow(), 2);
				AmountCheckFrame amountcheck = new AmountCheckFrame();
				
				if(soluongcon ==0) {
					JOptionPane.showMessageDialog(contentPane, "Hết Hàng!");
				}
				else if(soluongcon==AmountCheckFrame.checkEquals(mahang)) {
					JOptionPane.showMessageDialog(contentPane, "Hết Hàng!");
				}
				
				else if(AmountCheckFrame.checkEquals(mahang)==0) {
					amountcheck.setLocationRelativeTo(null);
					amountcheck.setVisible(true);
					SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1,1,soluongcon,1);
					AmountCheckFrame.spinner.setModel(spinnermodel);
					
				}else {
					amountcheck.setLocationRelativeTo(null);
					amountcheck.setVisible(true);
					int slmax = soluongcon-AmountCheckFrame.checkEquals(mahang);
					SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1,1,slmax,1);
					AmountCheckFrame.spinner.setModel(spinnermodel);
		
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				table1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Nhấn để thêm vào hóa đơn");
			}
						
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblHint.setText("");
			}
		});
		
		
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00E0ng", "T\u00EAn H\u00E0ng", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n V\u1ECB T\u00EDnh", "\u0110\u01A1n Gi\u00E1", "B\u1EA3o H\u00E0nh"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table1);
		
		JLabel lblNewLabel = new JLabel("Find : ");
		
		textFindItem = new JTextField();
	
		textFindItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String search = textFindItem.getText().toLowerCase();
				try {
					SearchItemInfor(search,table1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textFindItem.setColumns(10);
		
		JLabel lblTextTotal = new JLabel("Total : ");
		
		JButton btnSell = new JButton("");
		btnSell.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_paid_26px.png")));
		btnSell.setBorderPainted(false); 
		btnSell.setContentAreaFilled(false); 
	    btnSell.setFocusPainted(false); 
	    btnSell.setOpaque(false);
		btnSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSell.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnSell.setContentAreaFilled(true);
				btnSell.setBackground(Color.LIGHT_GRAY);
				lblHint.setText("Nhấn để bán");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSell.setContentAreaFilled(false);
				btnSell.setBackground(Color.white);
				lblHint.setText("");
			}
		});
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
				String makh = textMaKH.getText();
				try {
					if(checkCustomerID(makh)==false) {
						JOptionPane.showMessageDialog(contentPane, "Mã Khách Hàng Không Đúng!");
						return;
					}
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				if(model2.getRowCount()==0) {
					return;
				}
				for(int i=0;i<table2.getRowCount();i++) {
					int soluong = (int) model2.getValueAt(i, 2);
					String mahang = (String) model2.getValueAt(i, 0);
					try {	
											
						sellItem(soluong, mahang);
					} catch (SQLException e1) {						
						JOptionPane.showMessageDialog(btnSell, "Hết Hàng!");
						try {
							ShowItemInfor(table1);
							ShowItemInfor(table5);
						} catch (RemoteException | MalformedURLException | SQLException | NotBoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				String tentk = LoginFrame.accInput;
				int tongtien = Integer.parseInt(lblMoneyInteger.getText());
				String ngay = lblClock.getText();
				try {
					addBill(makh, tentk, tongtien, ngay);
					ShowItemInfor(table1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String mahd = null;
				try {
					mahd = getBillCode(ngay);
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for(int i=0;i<table2.getRowCount();i++) {
					String mahang = (String) model2.getValueAt(i, 0);
					int soluong = (int) model2.getValueAt(i, 2);
					int dongia=0;
					try {
						dongia =(int)(long)currencyVN.parseObject((String) model2.getValueAt(i, 4));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						addItemToBill(mahd, mahang, soluong, dongia);
					} catch (RemoteException | MalformedURLException | SQLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					ShowBill();
					ShowItemInfor(table1);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textMaKH.setText("");
				lblTotal.setText("");
				lblMoneyInteger.setText("0");
				model2.setRowCount(0);
			}
		});
		
		JButton btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_cancel_26px.png")));
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
				lblHint.setText("Nhấn để hủy");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHint.setText("");
				btnCancel.setContentAreaFilled(false);
				btnCancel.setBackground(Color.white);
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table2.getModel();
				model.setRowCount(0);
				lblMoneyInteger.setText("0");
				lblTotal.setText("0");
			}
		});
		lblMoneyInteger.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Khách Hàng:");
		
		textMaKH = new JTextField();
		textMaKH.setColumns(10);
		
		
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFindItem, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
					.addGap(781))
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(lblMoneyInteger)
									.addGap(87)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(10))
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(btnSell, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(52)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addComponent(textMaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addComponent(lblTextTotal)
							.addGap(18)
							.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)))
					.addGap(59))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFindItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTextTotal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoneyInteger)
								.addComponent(textMaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell))
							.addGap(44))
						.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))))
		);
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				table2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Click to remove");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
				int row = table2.getSelectedRow();
				String dongia = (String) model2.getValueAt(table2.getSelectedRow(), 4);
				int soluong = (int) model2.getValueAt(table2.getSelectedRow(), 2);
				try {
					SubTotal((int)(long)currencyVN.parseObject(dongia)*(int)soluong);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model2.removeRow(row);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHint.setText("");
			}
		});
		
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00E0ng", "T\u00EAn H\u00E0ng", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n V\u1ECB T\u00EDnh", "\u0110\u01A1n Gi\u00E1", "B\u1EA3o H\u00E0nh"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table2);
		panel1.setLayout(gl_panel1);
		
		Thread threadShowItem = new Thread() {
			public void run() {
				try {
					ShowItemInfor(table1);
				} catch (RemoteException | MalformedURLException | SQLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		threadShowItem.start();
	
		
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("History", null, panel2, null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("Chi tiết");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Khách Hàng:");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblTenKH = new JLabel("");
		
		
		JLabel lblNewLabel_2 = new JLabel("Người Bán:");
		
		JLabel lblTenNV = new JLabel("");
		lblTenNV.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Tiền:");
		
		JLabel lblTongTien = new JLabel("");
		
		JLabel lblNewLabel_4 = new JLabel("Ngày Bán:");
		
		JLabel lblNgayBan = new JLabel("");
	
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model3 = (DefaultTableModel) table3.getModel();
				String maHD = (String) model3.getValueAt(table3.getSelectedRow(), 0);
				String maKH = (String) model3.getValueAt(table3.getSelectedRow(), 1);
				String tenTK = (String) model3.getValueAt(table3.getSelectedRow(), 2);
				lblNgayBan.setText((String) model3.getValueAt(table3.getSelectedRow(), 4));
				lblTongTien.setText((String) model3.getValueAt(table3.getSelectedRow(), 3));
				lblMaHoaDon.setText(maHD);			
				try {
					showBillInfor(maHD);
					lblTenKH.setText(getCustomerName(maKH));
					lblTenNV.setText(getStaffName(tenTK));
				} catch (RemoteException | MalformedURLException | SQLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				table3.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Nhấn để xem thông tin");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHint.setText("");
			}
		});
		table3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn T\u00E0i Kho\u1EA3n", "T\u1ED5ng Ti\u1EC1n", "Ng\u00E0y B\u00E1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane3.setViewportView(table3);
		
		ShowBill();	
		
		JLabel lblNewLabel_8 = new JLabel("Hóa Đơn:");
		
		JLabel lblNewLabel_16 = new JLabel("Find : ");
		
		textFindBill = new JTextField();
		textFindBill.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				DefaultTableModel model3 = (DefaultTableModel) table3.getModel();
				model3.setRowCount(0);
				try {
					searchBill(textFindBill.getText());
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textFindBill.setColumns(10);
		
		
		
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_16)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFindBill, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel2.createSequentialGroup()
									.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel2.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNewLabel_8)
											.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel2.createSequentialGroup()
													.addGap(139)
													.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
													.addGap(28)
													.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblNgayBan, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel2.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblMaHoaDon, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panel2.createSequentialGroup()
											.addGap(8)
											.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addGap(111)
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblTenNV, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(122, Short.MAX_VALUE))
								.addGroup(gl_panel2.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(119))))
						.addGroup(gl_panel2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_8)
							.addComponent(lblMaHoaDon)
							.addComponent(lblNewLabel_16)
							.addComponent(textFindBill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNgayBan)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel2.createSequentialGroup()
							.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel2.createSequentialGroup()
									.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTenNV))
									.addGap(3))
								.addComponent(lblTenKH, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTongTien)
								.addComponent(lblNewLabel_3))))
					.addContainerGap())
		);
		
		table4 = new JTable();
		table4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00E0ng", "T\u00EAn H\u00E0ng", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n V\u1ECB T\u00EDnh", "\u0110\u01A1n Gi\u00E1", "B\u1EA3o H\u00E0nh"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table4);
		panel2.setLayout(gl_panel2);
		
		JPanel panel3 = new JPanel();
		tabbedPane.addTab("Manage", null, panel3, null);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		JButton btnAdd = new JButton("");
		table5 = new JTable();
		table5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model5 = (DefaultTableModel) table5.getModel();
				String tenhang = (String) model5.getValueAt(table5.getSelectedRow(), 1);
				int soluong = (int) model5.getValueAt(table5.getSelectedRow(), 2);
				String donvitinh = (String) model5.getValueAt(table5.getSelectedRow(), 3);
				String baohanh = (String) model5.getValueAt(table5.getSelectedRow(), 5);
				String dongia = null;
				try {
					dongia = String.valueOf((long)currencyVN.parseObject((String) model5.getValueAt(table5.getSelectedRow(), 4)));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textTenHang.setText(tenhang);
				textSoLuong.setText(""+soluong);
				textDVT.setText(donvitinh);
				textDonGia.setText(dongia);
				textBaoHanh.setText(baohanh);
				btnAdd.setEnabled(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				table5.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Nhấn để chỉnh sửa");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHint.setText("");
			}
		});
		table5.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00E0ng", "T\u00EAn H\u00E0ng", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n V\u1ECB T\u00EDnh", "\u0110\u01A1n Gi\u00E1", "B\u1EA3o H\u00E0nh"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8.setViewportView(table5);
		
		ShowItemInfor(table5);
		
		JLabel lblNewLabel_10 = new JLabel("Tên Hàng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_11 = new JLabel("Số Lượng:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_12 = new JLabel("Đơn Vị Tính:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_13 = new JLabel("Đơn Giá:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_14 = new JLabel("Bảo Hành:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textTenHang = new JTextField();
		textTenHang.setColumns(10);
		
		textSoLuong = new JTextField();
		textSoLuong.setColumns(10);
		
		textDVT = new JTextField();
		textDVT.setColumns(10);
		
		textDonGia = new JTextField();
		textDonGia.setColumns(10);
		
		textBaoHanh = new JTextField();
		textBaoHanh.setColumns(10);
		
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnAdd.setContentAreaFilled(true);
				btnAdd.setBackground(Color.LIGHT_GRAY);
				lblHint.setText("Thêm");
			}
			public void mouseExited(MouseEvent e) {
				btnAdd.setContentAreaFilled(false);
				btnAdd.setBackground(Color.white);
				lblHint.setText("");
			}
		});
		btnAdd.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_add_new_26px_9a.png")));
		btnAdd.setBorderPainted(false); 
		btnAdd.setContentAreaFilled(false); 
	    btnAdd.setFocusPainted(false); 
	    btnAdd.setOpaque(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(textTenHang.getText().equals("")) {
					return;
				}
				else {

					String tenhang = textTenHang.getText();
					int soluong = Integer.parseInt(textSoLuong.getText());
					String donvitinh = textDVT.getText();
					int dongia = Integer.parseInt(textDonGia.getText());
					String baohanh = textBaoHanh.getText();
					try {
						addItem(tenhang, soluong, donvitinh, dongia, baohanh);
					} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textTenHang.setText("");
					textSoLuong.setText("");
					textDVT.setText("");
					textDonGia.setText("");
					textBaoHanh.setText("");
					try {
						ShowItemInfor(table5);
						ShowItemInfor(table1);
					} catch (RemoteException | MalformedURLException | SQLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
								
			}
		});
		
		JButton btnClear = new JButton("");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnClear.setContentAreaFilled(true);
				btnClear.setBackground(Color.LIGHT_GRAY);
				lblHint.setText("Hủy");
			}
			public void mouseExited(MouseEvent e) {
				btnClear.setContentAreaFilled(false);
				btnClear.setBackground(Color.white);
				lblHint.setText("");
			}
		});
		btnClear.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_cancel_26px.png")));
		btnClear.setBorderPainted(false); 
		btnClear.setContentAreaFilled(false); 
	    btnClear.setFocusPainted(false); 
	    btnClear.setOpaque(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTenHang.setText("");
				textSoLuong.setText("");
				textDVT.setText("");
				textDonGia.setText("");
				textBaoHanh.setText("");
				btnAdd.setEnabled(true);
			}
		});
		
		JButton btnEdit = new JButton("");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnEdit.setContentAreaFilled(true);
				btnEdit.setBackground(Color.LIGHT_GRAY);
				lblHint.setText("Chỉnh sửa");
			}
			public void mouseExited(MouseEvent e) {
				btnEdit.setContentAreaFilled(false);
				btnEdit.setBackground(Color.white);
				lblHint.setText("");
			}
		});
		btnEdit.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_edit_26px_1.png")));
		btnEdit.setBorderPainted(false); 
		btnEdit.setContentAreaFilled(false); 
	    btnEdit.setFocusPainted(false); 
	    btnEdit.setOpaque(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textTenHang.getText().equals("")) {
					return;
				}
				else {
					DefaultTableModel model5 = (DefaultTableModel) table5.getModel();
					String mahang = (String) model5.getValueAt(table5.getSelectedRow(), 0);
					String tenhang = textTenHang.getText();
					int soluong = Integer.parseInt(textSoLuong.getText());
					String donvitinh = textDVT.getText();
					String baohanh = textBaoHanh.getText();
					int dongia = Integer.parseInt(textDonGia.getText());
					
					try {
						EditItem(mahang, tenhang, soluong, donvitinh, dongia, baohanh);
						ShowItemInfor(table1);
						ShowItemInfor(table5);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textTenHang.setText("");
					textSoLuong.setText("");
					textDVT.setText("");
					textDonGia.setText("");
					textBaoHanh.setText("");	
					btnAdd.setEnabled(true);
				}
			}
		});
		
		textFind = new JTextField();
		textFind.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String search = textFind.getText().toLowerCase();
				try {
					SearchItemInfor(search,table5);
				} catch (RemoteException | MalformedURLException | SQLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textFind.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Find : ");
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel3.createSequentialGroup()
							.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel3.createSequentialGroup()
									.addGap(117)
									.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel3.createSequentialGroup()
											.addGroup(gl_panel3.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_10)
												.addComponent(lblNewLabel_11))
											.addGap(32)
											.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textSoLuong)
												.addComponent(textTenHang, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel3.createSequentialGroup()
											.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_12)
												.addComponent(lblNewLabel_13)
												.addComponent(lblNewLabel_14))
											.addGap(18)
											.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
												.addComponent(textBaoHanh, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
												.addComponent(textDonGia, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
												.addComponent(textDVT)))))
								.addGroup(Alignment.TRAILING, gl_panel3.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(18))))
						.addGroup(gl_panel3.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFind, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(229, Short.MAX_VALUE))
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel3.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_10)
								.addComponent(textTenHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_11)
								.addComponent(textSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_12)
								.addComponent(textDVT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_13)
								.addComponent(textDonGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_14)
								.addComponent(textBaoHanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAdd)
								.addComponent(btnClear)
								.addComponent(btnEdit)))
						.addGroup(gl_panel3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_9)
								.addComponent(textFind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		
		JPanel panel4 = new JPanel();
		tabbedPane.addTab("Customer", null, panel4, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		
		JLabel lblNewLabel_6 = new JLabel("Lịch Sử Mua");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		table6 = new JTable();
		table6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model6 = (DefaultTableModel) table6.getModel();	
				if(checkCustomerclicked == 0) {	
					DefaultTableModel model7 = (DefaultTableModel) table7.getModel();
					model7.setRowCount(0);
					String maKH = (String) model6.getValueAt(table6.getSelectedRow(), 0);
					try {
						getBillByCustomer(maKH);
					} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					addCustomerFrame editcustomer = new addCustomerFrame();
					editcustomer.setUndecorated(true);
					editcustomer.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.LIGHT_GRAY));
					editcustomer.setVisible(true);
					editcustomer.setLocationRelativeTo(null);				
					editcustomer.makh =(String) model6.getValueAt(table6.getSelectedRow(), 0);				
					editcustomer.textHoTen.setText((String) model6.getValueAt(table6.getSelectedRow(), 1));
					editcustomer.textSDT.setText((String) model6.getValueAt(table6.getSelectedRow(), 2)); 
					editcustomer.textDiaChi.setText((String) model6.getValueAt(table6.getSelectedRow(), 3));
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				table6.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("CLick to view information");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHint.setText("");
			}
		});
		table6.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch", "H\u1ECD T\u00EAn", "SDT", "\u0110\u1ECBa Ch\u1EC9"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_3.setViewportView(table6);
		
		ShowCustomerInFor();
		textFindCustomer = new JTextField();
		textFindCustomer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					SearchCustomerInfor(textFindCustomer.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textFindCustomer.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Find : ");
		
		JButton btnAddCustomer = new JButton("");
		btnAddCustomer.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_add_new_26px_9.png")));
		btnAddCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddCustomer.setContentAreaFilled(true);
				btnAddCustomer.setBackground(Color.LIGHT_GRAY);
				btnAddCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Thêm khách hàng");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddCustomer.setContentAreaFilled(false);
				btnAddCustomer.setBackground(Color.white);
				lblHint.setText("");
			}
		});
			
		btnAddCustomer.setBackground(Color.WHITE);
		btnAddCustomer.setForeground(Color.WHITE);
		btnAddCustomer.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_add_user_male_26px.png")));
		btnAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddCustomer.setBorderPainted(false); 
		btnAddCustomer.setContentAreaFilled(false); 
	    btnAddCustomer.setFocusPainted(false); 
	    btnAddCustomer.setOpaque(false);
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerFrame addcustomer = new addCustomerFrame();
				addcustomer.setUndecorated(true);
				addcustomer.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.LIGHT_GRAY));
				addcustomer.setVisible(true);
				addcustomer.setLocationRelativeTo(null);
			}
		});
		
		
		
		btnEditCustomer.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnEditCustomer.setContentAreaFilled(true);
				btnEditCustomer.setBackground(Color.LIGHT_GRAY);
				btnEditCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Chỉnh sửa");
			}
			public void mouseExited(MouseEvent e) {
				if(checkCustomerclicked ==0) {
					btnEditCustomer.setContentAreaFilled(false);
					btnEditCustomer.setBackground(Color.white);
					lblHint.setText("");
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
					checkCustomerclicked =1;
					btnEditCustomer.setRolloverEnabled(true);
					btnEditCustomer.setContentAreaFilled(true);
					btnEditCustomer.setBackground(Color.LIGHT_GRAY);
				
				
				
			}
			
		});
		btnEditCustomer.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_edit_26px_1.png")));
		GroupLayout gl_panel4 = new GroupLayout(panel4);
		gl_panel4.setHorizontalGroup(
			gl_panel4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel4.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel4.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEditCustomer, 0, 0, Short.MAX_VALUE)
						.addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
					.addGap(118))
				.addGroup(Alignment.LEADING, gl_panel4.createSequentialGroup()
					.addGap(59)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFindCustomer, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(334))
		);
		gl_panel4.setVerticalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel4.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFindCustomer, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel4.createSequentialGroup()
							.addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditCustomer, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel4.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		btnEditCustomer.setBorderPainted(false); 
		btnEditCustomer.setContentAreaFilled(false); 
	    btnEditCustomer.setFocusPainted(false); 
	    btnEditCustomer.setOpaque(false);
		
		table7 = new JTable();
		table7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model7 = (DefaultTableModel) table7.getModel();
				String mahd = (String) model7.getValueAt(table7.getSelectedRow(), 0);
				String makh = (String) model7.getValueAt(table7.getSelectedRow(), 1);
				String tentk = (String) model7.getValueAt(table7.getSelectedRow(), 2);
				String tongtien = (String) model7.getValueAt(table7.getSelectedRow(), 3);
				lblNgayBan.setText((String) model7.getValueAt(table7.getSelectedRow(), 4));
				lblMaHoaDon.setText(mahd);
				lblTongTien.setText(tongtien);
				
				try {
					lblTenKH.setText(getCustomerName(makh));
					lblTenNV.setText(getStaffName(tentk));
					showBillInfor(mahd);
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
							
				tabbedPane.setSelectedIndex(1);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				table7.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Click to view information");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHint.setText("");
			}
		});
		table7.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn T\u00E0i Kho\u1EA3n", "T\u1ED5ng Ti\u1EC1n", "Ng\u00E0y B\u00E1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_4.setViewportView(table7);
		panel4.setLayout(gl_panel4);
		
		JPanel panel5 = new JPanel();
		tabbedPane.addTab("Staff", null, panel5, null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
		JScrollPane scrollPane_6 = new JScrollPane();
		
		table8 = new JTable();
		table8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				table8.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model8 = (DefaultTableModel) table8.getModel();
				if(checkStaffclicked==0) {
					DefaultTableModel model9 = (DefaultTableModel) table9.getModel();
					model9.setRowCount(0);
					String tentk = (String) model8.getValueAt(table8.getSelectedRow(), 0);
					try {
						getBillByStaff(tentk);
					} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					String tentk = (String) model8.getValueAt(table8.getSelectedRow(), 0);
					String hoten = (String) model8.getValueAt(table8.getSelectedRow(), 1);
					String sdt = (String) model8.getValueAt(table8.getSelectedRow(), 2);
					String diachi = (String) model8.getValueAt(table8.getSelectedRow(), 3);
					addStaffFrame addstaffframe = new addStaffFrame();
					addstaffframe.setUndecorated(true);
					addstaffframe.setVisible(true);
					addstaffframe.setLocationRelativeTo(null);
					addstaffframe.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.LIGHT_GRAY));
					addstaffframe.btnClear.setEnabled(false);
					addstaffframe.lblNewLabel_7.setVisible(true);
					addstaffframe.passwordFieldOld.setVisible(true);
					addstaffframe.textAccount.setText(tentk);
					addstaffframe.textAccount.setEditable(false);
					addstaffframe.textAddress.setText(diachi);
					addstaffframe.textName.setText(hoten);
					addstaffframe.textSDT.setText(sdt);
				}
				
			}
		});
		table8.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn TK", "H\u1ECD T\u00EAn", "S\u0110T", "\u0110\u1ECBa Ch\u1EC9"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_6.setViewportView(table8);
		
		JLabel lblNewLabel_15 = new JLabel("Find : ");
		
		textFindStaff = new JTextField();
		textFindStaff.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					searchStaffInfor(textFindStaff.getText());
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textFindStaff.setColumns(10);
		
		JButton btnAddStaff = new JButton("");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				addStaffFrame addstaffframe = new addStaffFrame();
				addstaffframe.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.LIGHT_GRAY));
				addstaffframe.btnClear.setEnabled(true);
				addstaffframe.setUndecorated(true);
				addstaffframe.setVisible(true);
				addstaffframe.setLocationRelativeTo(null);
			}
		});
		btnAddStaff.setBorderPainted(false); 
		btnAddStaff.setContentAreaFilled(false); 
		btnAddStaff.setFocusPainted(false); 
		btnAddStaff.setOpaque(false);
		btnAddStaff.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddStaff.setContentAreaFilled(true);
				btnAddStaff.setBackground(Color.LIGHT_GRAY);
				btnAddStaff.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Chỉnh sửa");
			}
			public void mouseExited(MouseEvent e) {
				btnAddStaff.setContentAreaFilled(false);
				btnAddStaff.setBackground(Color.white);
				lblHint.setText("");
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAddStaff.setRolloverEnabled(true);
				btnAddStaff.setContentAreaFilled(true);
				btnAddStaff.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnAddStaff.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_add_user_male_26px.png")));
		
		
		btnEditStaff.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		btnEditStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditStaff.setBorderPainted(false); 
		btnEditStaff.setContentAreaFilled(false); 
		btnEditStaff.setFocusPainted(false); 
		btnEditStaff.setOpaque(false);
		btnEditStaff.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnEditStaff.setContentAreaFilled(true);
				btnEditStaff.setBackground(Color.LIGHT_GRAY);
				btnEditStaff.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblHint.setText("Chỉnh sửa");
			}
			public void mouseExited(MouseEvent e) {
				if(checkStaffclicked==0) {
					btnEditStaff.setContentAreaFilled(false);
					btnEditStaff.setBackground(Color.white);
					lblHint.setText("");
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkAccount()==0) {
					return;
				}
				else {
					checkStaffclicked =1;
					btnEditStaff.setRolloverEnabled(true);
					btnEditStaff.setContentAreaFilled(true);
					btnEditStaff.setBackground(Color.LIGHT_GRAY);
				
				}
			}
			
		});
		btnEditStaff.setIcon(new ImageIcon(MainFrame.class.getResource("/QLBH/icons8_edit_26px_1.png")));
		GroupLayout gl_panel5 = new GroupLayout(panel5);
		gl_panel5.setHorizontalGroup(
			gl_panel5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddStaff, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditStaff, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel5.createSequentialGroup()
							.addComponent(lblNewLabel_15)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFindStaff, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
							.addGap(794))
						.addGroup(gl_panel5.createSequentialGroup()
							.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)))
					.addGap(109))
		);
		gl_panel5.setVerticalGroup(
			gl_panel5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_15)
						.addComponent(textFindStaff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel5.createSequentialGroup()
							.addComponent(btnAddStaff, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditStaff))
						.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
		);
		
		table9 = new JTable();
		table9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model9 = (DefaultTableModel) table9.getModel();
				String mahd = (String) model9.getValueAt(table9.getSelectedRow(), 0);
				String makh = (String) model9.getValueAt(table9.getSelectedRow(), 1);
				String tentk = (String) model9.getValueAt(table9.getSelectedRow(), 2);
				String tongtien = (String) model9.getValueAt(table9.getSelectedRow(), 3);
				lblNgayBan.setText((String) model9.getValueAt(table9.getSelectedRow(), 4));
				lblMaHoaDon.setText(mahd);
				lblTongTien.setText(tongtien);
				try {
					lblTenKH.setText(getCustomerName(makh));
					lblTenNV.setText(getStaffName(tentk));					
					showBillInfor(mahd);
				} catch (MalformedURLException | RemoteException | NotBoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				tabbedPane.setSelectedIndex(1);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				table9.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		table9.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn T\u00E0i Kho\u1EA3n", "T\u1ED5ng Ti\u1EC1n", "Ng\u00E0y B\u00E1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_5.setViewportView(table9);
		panel5.setLayout(gl_panel5);
		
		ShowStaffInfor();
		contentPane.setLayout(gl_contentPane);
		
		if(checkAccount()==0) {
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnClear.setEnabled(false);
			btnAddStaff.setEnabled(false);
			btnEditStaff.setEnabled(false);	
		}
			
		
	}
	public void close() {
		WindowEvent closeWiundow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWiundow);
	}
	public void ShowItemInfor(JTable table) throws SQLException, RemoteException, MalformedURLException, NotBoundException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		ArrayList<Item> list = new ArrayList<>();			
		model.setRowCount(0);
		if(stub!=null) {
			list = stub.showItemInfor();
			for(int i=0;i<list.size();i++) {
				Object[] obj = {list.get(i).getMahang(),list.get(i).getTenhang(),list.get(i).getSoluong(),list.get(i).getDonvitinh()
						,currencyVN.format(list.get(i).getDongia()),list.get(i).getBaohanh()};
				model.addRow(obj);
			}
		}		
	}
	public void SearchItemInfor(String text,JTable table) throws SQLException, RemoteException, MalformedURLException, NotBoundException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Item> list = new ArrayList<>();
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		stub = (Services)Naming.lookup(servicesName);
		list = stub.searchItemInfor(text);
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getMahang(),list.get(i).getTenhang(),list.get(i).getSoluong(),list.get(i).getDonvitinh(),currencyVN.format(list.get(i).getDongia()),list.get(i).getBaohanh()};
			model.addRow(obj);
		}	
		
	}
	public static void EditItem(String mahang,String tenhang,int soluong,String donvitinh,int dongia,String baohanh) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		stub.editItem(mahang, tenhang, soluong, donvitinh, dongia, baohanh);
	}
	public static void ShowCustomerInFor() throws SQLException, RemoteException,NotBoundException,MalformedURLException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		DefaultTableModel model = (DefaultTableModel) table6.getModel();
		model.setRowCount(0);
		ArrayList<Customer> list = new ArrayList<>();
		
		list = stub.showCustomerInfor();
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getMakh(),list.get(i).getTenkh(),list.get(i).getDienthoai(),list.get(i).getDiachi()};
			model.addRow(obj);
		}	
	}
	public void SearchCustomerInfor(String text) throws SQLException, RemoteException, MalformedURLException, NotBoundException {
		DefaultTableModel model = (DefaultTableModel) table6.getModel();
		model.setRowCount(0);
		ArrayList<Customer> list = new ArrayList<>();
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		list = stub.searchCustomerInfor(text);
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getMakh(),list.get(i).getTenkh(),list.get(i).getDienthoai(),list.get(i).getDiachi()};
			model.addRow(obj);
		}
	}
	public static void ShowStaffInfor() throws SQLException, RemoteException, MalformedURLException, NotBoundException {
		DefaultTableModel model = (DefaultTableModel) table8.getModel();
		model.setRowCount(0);
		ArrayList<Staff> list = new ArrayList<>();
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		list = stub.showStaffInfor();
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getTentk(),list.get(i).getHoten(),list.get(i).getSdt(),list.get(i).getDiachi()};
			model.addRow(obj);
		}
	}
	public void searchStaffInfor(String text) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		DefaultTableModel model = (DefaultTableModel) table8.getModel();
		model.setRowCount(0);
		ArrayList<Staff> list = new ArrayList<>();
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		list = stub.searchStaffInfor(text);
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getTentk(),list.get(i).getHoten(),list.get(i).getSdt(),list.get(i).getDiachi()};
			model.addRow(obj);
		}
	}
	public static void AddTotal(int money) {
		long n = Long.parseLong(lblMoneyInteger.getText());
		long total = money + n;
		lblMoneyInteger.setText(String.valueOf(total));
		lblTotal.setText(currencyVN.format(total));
	}
	public static void SubTotal(int money) {
		long n = Long.parseLong(lblMoneyInteger.getText());
		long total = n-money;
		lblMoneyInteger.setText(String.valueOf(total));
		lblTotal.setText(currencyVN.format(total));
	}
//	private String getMaHang() throws SQLException {
//		ResultSet rs = stmt.executeQuery("select MAHANG from HANGHOA");
//		String mahang = null;
//		while(rs.next()) {
//			mahang = rs.getString("MAHANG");
//		}
//		return mahang;
//	}
//	private String getMaHoaDon() throws SQLException {
//		ResultSet rs = stmt.executeQuery("select MAHOADON from HOADON");
//		String mahoadon = null;
//		while(rs.next()) {
//			mahoadon = rs.getString("MAHOADON");
//		}
//		return mahoadon;
//	}
	public void ShowBill() throws SQLException, RemoteException, MalformedURLException, NotBoundException{
		DefaultTableModel model3 = (DefaultTableModel) table3.getModel();
		model3.setRowCount(0);
		ArrayList<Bill> list = new ArrayList<>();
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		list = stub.showBill();
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getMahoadon(),list.get(i).getMakh(),list.get(i).getTentk(),list.get(i).getTongtien(),list.get(i).getNgay()};
			model3.addRow(obj);
		}		
	}
	public void showBillInfor(String mahd) throws SQLException, RemoteException, MalformedURLException, NotBoundException {
		DefaultTableModel model4 = (DefaultTableModel) table4.getModel();
		model4.setRowCount(0);
		ArrayList<BillInfor> list = new ArrayList<>();
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		list = stub.ShowBillInfor(mahd);
		for(int i=0;i<list.size();i++) {
			Object[] obj = {list.get(i).getMahang(),list.get(i).getTenhang(),list.get(i).getSoluong(),
					list.get(i).getDonvitinh(),list.get(i).getDongia(),list.get(i).getBaohanh()};
			model4.addRow(obj);
		}
	}
public void addItem(String tenhang,int soluong,String donvitinh,int dongia,String baohanh) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	stub.addItem(tenhang, soluong, donvitinh, dongia, baohanh);
}
public String getCustomerName(String makh) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	
	return stub.getCustomerName(makh);
}
public String getStaffName(String tentk) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	return stub.getStaffName(tentk);
}
public void addBill(String makh, String tentk, int tongtien, String ngay) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	stub.addBill(makh, tentk, tongtien, ngay);
}
	public void sellItem(int soluong,String mahang) throws RemoteException, SQLException, MalformedURLException, NotBoundException {
		String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
		Services stub = (Services)Naming.lookup(servicesName);
		stub.sellItem(soluong, mahang);
	}
	
public String getBillCode(String ngay) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	return stub.getBillCode(ngay);
}
public void addItemToBill(String mahd, String mahang, int soluong, int dongia)
		throws SQLException, RemoteException, MalformedURLException, NotBoundException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	stub.addItemToBill(mahd, mahang, soluong, dongia);
}
public void getBillByCustomer(String makh) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	DefaultTableModel model7 = (DefaultTableModel) table7.getModel();
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	ArrayList<Bill> list = new ArrayList<>();
	list = stub.getBillByCustomer(makh);
	for(int i=0;i<list.size();i++) {
		Object[] obj= {list.get(i).getMahoadon(),list.get(i).getMakh(),list.get(i).getTentk(),list.get(i).getTongtien(),list.get(i).getNgay()};
		model7.addRow(obj);
	}
}
public void getBillByStaff(String tentk) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	DefaultTableModel model9 = (DefaultTableModel) table9.getModel();
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	ArrayList<Bill> list = new ArrayList<>();
	list = stub.getBillByStaff(tentk);
	for(int i=0;i<list.size();i++) {
		Object[] obj= {list.get(i).getMahoadon(),list.get(i).getMakh(),list.get(i).getTentk(),list.get(i).getTongtien(),list.get(i).getNgay()};
		model9.addRow(obj);
	}
}
public int checkAccount() {
	String acc = lblAccount.getText()+" "+" "+" "+" ";
	String check="";
	int i;
	for(i=0;i<5;i++) {
		check+=acc.charAt(i);
	}
	if(check.equals("admin")==true) {
		return 1;
	}else {
		return 	0;
	}
}
public boolean checkCustomerID(String makh) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	return stub.checkCustomerID(makh);
}
public void searchBill(String text) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	String servicesName = "rmi://"+LoginFrame.ip+":"+LoginFrame.port+"/qlbhhh";
	Services stub = (Services)Naming.lookup(servicesName);
	DefaultTableModel model3 = (DefaultTableModel) table3.getModel();
	ArrayList<Bill> list = new ArrayList<>();
	list = stub.searchBill(text);
	for(int i=0;i<list.size();i++) {
		Object[] obj= {list.get(i).getMahoadon(),list.get(i).getMakh(),list.get(i).getTentk(),list.get(i).getTongtien(),list.get(i).getNgay()};
		model3.addRow(obj);
	}
}
}
