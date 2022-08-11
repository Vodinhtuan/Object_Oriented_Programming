package QLBH;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Clock extends Thread{
	private JLabel label;
	public Clock(JLabel label) {
		this.label=label;
	}
	@Override
	public void run() {
		while(true) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			label.setText(formatter.format(date));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
