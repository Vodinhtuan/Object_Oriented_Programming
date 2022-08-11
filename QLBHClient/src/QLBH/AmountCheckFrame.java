package QLBH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AmountCheckFrame extends JFrame {

	private JPanel contentPane;
	public static JSpinner spinner = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmountCheckFrame frame = new AmountCheckFrame();
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
	public AmountCheckFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AmountCheckFrame.class.getResource("/QLBH/icons8_small_business_32px.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(23, 30, 83, 33);
		contentPane.add(lblQuantity);
		
		
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(116, 30, 40, 33);
		contentPane.add(spinner);
		spinner.setValue(1);
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model1 = (DefaultTableModel) MainFrame.table1.getModel();
				DefaultTableModel model2 = (DefaultTableModel) MainFrame.table2.getModel();			
				String mahang = (String) model1.getValueAt(MainFrame.table1.getSelectedRow(), 0);
				String tenhang = (String) model1.getValueAt(MainFrame.table1.getSelectedRow(), 1);
				int soluongcon = (int) model1.getValueAt(MainFrame.table1.getSelectedRow(), 2);
				int soluong=(int) spinner.getValue();
				String donvitinh = (String) model1.getValueAt(MainFrame.table1.getSelectedRow(), 3);
				String dongia = (String) model1.getValueAt(MainFrame.table1.getSelectedRow(), 4);
				String baohanh = (String) model1.getValueAt(MainFrame.table1.getSelectedRow(), 5);
				Object[] obj = {mahang,tenhang,soluong,donvitinh,dongia,baohanh};
				if(checkEquals(mahang)==0) {
					model2.addRow(obj);
					try {
						MainFrame.AddTotal((int)(long)MainFrame.currencyVN.parseObject(dongia)*soluong);
					} catch (ParseException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					close();
				}
				else {
					for(int i=0;i<MainFrame.table2.getRowCount();i++) {
						if(model1.getValueAt(MainFrame.table1.getSelectedRow(), 0).equals(model2.getValueAt(i, 0))==true) {
							int tongsoluong = soluong+(int)model2.getValueAt(i, 2);
							try {
								MainFrame.SubTotal((int)(long)MainFrame.currencyVN.parseObject((String) model2.getValueAt(i, 4))*checkEquals(mahang));
								MainFrame.AddTotal((int)(long)MainFrame.currencyVN.parseObject((String) model2.getValueAt(i, 4))*tongsoluong);
							} catch (Exception e2) {
								// TODO: handle exception
							}
							model2.setValueAt(tongsoluong, i, 2);
							close();
						}
					}
				}
				
							
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirm.setBounds(43, 86, 97, 23);
		contentPane.add(btnConfirm);
		
	}
	public void close() {
		WindowEvent closeWiundow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWiundow);
	}
	public static int checkEquals(String mahang) {
		int i;
		DefaultTableModel model2 = (DefaultTableModel) MainFrame.table2.getModel();	
		int soluong=0;
		if(MainFrame.table2.getRowCount()>0) {
			for(i=0;i<MainFrame.table2.getRowCount();i++) {
				if(mahang.equals(model2.getValueAt(i, 0))==true) {
					soluong=(int) model2.getValueAt(i, 2);
					return soluong;
				}
			}
		}
		return 0;
	}

	
	
}
