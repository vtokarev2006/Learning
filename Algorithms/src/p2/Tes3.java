/**
 * 
 */
package p2;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author vtokarev
 *
 */
public class Tes3 implements ActionListener  {
	static Date date;
	
	static
	{
		date = new Date();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(date);
		
		
		Toolkit.getDefaultToolkit().beep();;
	}
	
	public static void main(String[] args){
		Tes3 t = new Tes3();
		Timer timer = new Timer(1000, t);
		
		timer.start();
		JOptionPane.showMessageDialog(null, "!!!");
		System.exit(0);
		
		
	}
	
	
	
	
	
}
