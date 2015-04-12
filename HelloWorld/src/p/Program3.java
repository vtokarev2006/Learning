package p;

import javax.swing.JOptionPane;

public class Program3 {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		TalkingClock tc = new TalkingClock(500, true);
		tc.start();
		System.out.println("!!!!!");
		
		//JOptionPane.showMessageDialog(null, "Quit ?");
		
		//System.exit(0);
		
		
		
		
	}

}