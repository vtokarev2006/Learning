import java.util.Arrays;


public class Compare {
	
	
	public static void sortSelect(Comparable<?>[] a){
		
		int N = a.length;
		int min;
		
		for(int i=0;i<N;i++) {
			min = i;
			for(int j=i+1;j<N;j++){
				if (less(a[j],a[min]))
					exch(a, j, min);
				
				
			}
		}
		
	}
	
	public static void sortInsert(Comparable<?>[] a){
		int N = a.length;
		
		for(int i=1;i<N;i++){
			for (int j=i;(j>0)&&less(a[j], a[j-1]);j--){
				exch(a, j, j-1);
			}
		}
		
	}
	
	
	public static void sortShell(Comparable<?>[] a){
		int N=a.length;
		int h=1;
		while(h<N/3) h = 3*h+1;
		while(h>=1){
			
			
			
			for(int i=h;i<N;i++){
				for(int j=i;(j>=h)&&less(a[j], a[j-h]);j-=h)
					exch(a, j, j-h);
			}
			
			
			
			h=h/3;
			
		}
		
		
		
	}
	
	
	private static void merge(Comparable<?>[] a, Comparable<?>[] b1, Comparable<?>[] b2){
		
		int n1=b1.length;
		int n2=b2.length;
		int n = n1+n2;
		int cur1=0;
		int cur2=0;
		
		for(int cur=0; cur<n;cur++){
			
			if(cur2==n2){
				a[cur]=b1[cur1];
				cur1++;
				
			} else if(cur1==n1){
				a[cur]=b2[cur2];
				cur2++;
				
			} else if (less(b1[cur1],b2[cur2])) {
				a[cur]=b1[cur1];
				cur1++;
			} else {
				a[cur]=b2[cur2];
				cur2++;
			}
		}
		
	}
	
	
	public static void mergeSort(Comparable<?>[] a) {
		int N=a.length;
		if(N<15) {
			sortInsert(a);
			return;
		}
		
		int mid = N/2;
		
		
		Comparable<?>[] b1 = Arrays.copyOfRange(a, 0, mid);
		Comparable<?>[] b2 = Arrays.copyOfRange(a, mid, N);
		
		
		mergeSort(b1);
		mergeSort(b2);
		merge(a, b1, b2);
		
		
		
		
		
		
	}
	
	public static int partition(Comparable<?>[] a, int lo, int hi){
		int k=StdRandom.uniform(lo, hi+1);
		
		int i=lo;
		int j=hi;
		
		
		while(true) {
			
			while(less(a[i],a[k])) {
				if (i==k) break;
				i++;
			}
			
			while(!less(a[j],a[k])) {
				if (j==k) break;
				j--;
			}
			
			
			if ((i<k)&&(j>k)) {
				exch(a, i, j);
				i++;
				j--;
				continue;
				
			}
			
			if (i==j) {
				return i;
			}
			
			if ((i==k)&&(j>k)){
				exch(a, k, j);
				k=j;
				i++;
				continue;
			}
			if ((j==k)&&(i<k)){
				exch(a, k, i);
				k=i;
				j--;
				
			}
			
			
		}
		

	}
	
	private static void quickSort(Comparable<?>[] a, int lo, int hi){
		
		if (lo>=hi) return;
		int j = partition(a, lo, hi);
		quickSort(a, lo, j-1);
		quickSort(a, j+1, hi);
		
		
	}
	
	
	public static void quickSort(Comparable<?>[] a){
		quickSort(a, 0, a.length-1);
	}
	
	
	
	
	

	private static boolean less(Comparable v, Comparable w){
		return (v.compareTo(w)<0);
	}
	
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t;
		t = a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if (less(a[i],a[i-1])) return false;
		}
		return true;
	}
	
	private static void show(Comparable[] a){
		for(Comparable t:a)
			StdOut.print(t+" ");
		StdOut.println();
	}
	
	

	public static void main(String[] args) {
		
		Integer[] a = new Integer[10000000];

		//Integer[] a = {65, 98, 34, 69, 34, 69, 46, 14, 90, 46};
		
		
		
		for(int i=0;i<a.length;i++)
			a[i] = StdRandom.uniform(10000000);
		
		
		
		//Integer[] a = {9,11,5,1,2,4};
		//partition(a, 0, a.length-1);
		
		//show(a);
		//StdOut.println(isSorted(a));

		//StdOut.println("!!!!!!!!!!!!!!!!");
		long t1 = System.currentTimeMillis()/1000;
		StdOut.println("Start ...");
		

		
		//show(a);
		
		quickSort(a);
		//sortShell(a);
		//mergeSort(a);
		//sortInsert(a);
		//sortSelect(a);
		//Arrays.sort(a);
		long t = System.currentTimeMillis()/1000-t1;
		
		
		StdOut.println("It takes " + t + " sec");
		
		
		
		
//		sortSelect(a);
		//sortInsert(a);
		
		//show(a);
		StdOut.println(isSorted(a));
		
		

	}

}
