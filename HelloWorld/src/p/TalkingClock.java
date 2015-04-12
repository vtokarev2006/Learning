package p;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class TalkingClock {
	
	int interval=1000;
	boolean beep = true;
	
	
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
		
	}


	
	
	
	
	public void start(){
		
		
		
		
		
		
		
		
		
		
		
		ActionListener al = new TimePrinter();
		Timer t=new Timer(interval, al);
		t.start();
	}
	

	class TimePrinter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Beep at" + new Date());
			if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
		}
		
	}
	
	
	
	

}
