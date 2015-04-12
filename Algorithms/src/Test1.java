import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Test1 implements Comparable<Test1> {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("./input.txt"));
		
		
		int i=2;
		
		assert(i==1);
		
		StdOut.print("!!!");
		
		
		
		

	}
	
	

	
	

	public static boolean eq(String s1, String s2){
		if( ((s1+s1).indexOf(s2) >= 0) || ((s2+s2).indexOf(s1) >= 0)) return true;
		return false;  
	}
	
	
	public static int evklid(int a,int b){
		
		while (a!=0 && b!=0){
			StdOut.println(a+" ----- "+b);
			if (a>b) a = a%b;
			else  b = b%a;
		}
		return a+b;
		
	}
	
	
	
	public static String mystery(String s){
		int N = s.length();
		if(N==1) return s;
		String a=s.substring(0, N/2);
		String b=s.substring(N/2,N);
		return mystery(b) + mystery(a);
		
	}






	@Override
	public int compareTo(Test1 o) {
		// TODO Auto-generated method stub
		return 0;
	}






	
	
}