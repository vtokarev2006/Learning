
public class StopWach {
	
	private final long start;
	
	public StopWach(){
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		return (System.currentTimeMillis() - start)/1000.0;
	}
	
	
	
	
	public static void main(String[] args) {
		
		int N = 5000;
		int[] a = new int[N];

		StopWach timer = new StopWach();

		for (int i=0;i<N;i++) {
			 a[i] = StdRandom.uniform(-1000000, 1000000);
		}
		StdOut.println("Fill array of " +N +" in " + timer.elapsedTime()+" sec");
		
		
		
		//timer = new StopWach();
		int cnt = ThreeSum.count(a);
		StdOut.print(cnt + "---" + timer.elapsedTime());
		
		

		

	}
	

}
