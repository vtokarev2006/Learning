import java.util.Iterator;


public class StackArray<Item> implements Stack<Item>,Iterable<Item> {
	
	private int N=0;
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];
	
	private void resize(int n){
		
//		if(a.length<n){
			@SuppressWarnings("unchecked")
			Item[] b = (Item[]) new Object[n];
			for(int i=0;i<N;i++){
				b[i] = a[i];
				a[i] = null;
			}
			a = b;
//		}
	}
	
	
	int sizeArr(){
		return a.length;
	}
	
	public int size(){
		return N;
		
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void push(Item item){
		
		
		if (a.length==N) 
			resize(2*N);
		a[N++] = item;
		
	}
	
	public Item pop(){
		
		Item item = a[--N];
		
		a[N] = null;
				
		if (N==a.length/4) resize(2*N);
		
		return item;
	}
	
	
	

	private class StackArrayIterator implements Iterator<Item> {
		
		int current = 0;

		public boolean hasNext() {
			return current<N;
		}

		public Item next() {
			return a[current++];
		}
		
	}

	public Iterator<Item> iterator() {
		return new StackArrayIterator();
	}
	
	
	
	
	public static void main(String[] args) {
		
		StackArray<String> sa = new StackArray<String>();
		
		StdOut.println("Start size = "+sa.sizeArr());
		
		
		for (int i = 1; i<20; i++) {
			sa.push(Integer.toString(i));
			StdOut.println("Size after "+ i+" ----- " + sa.sizeArr());
			
		}
		
		StdOut.println("-----------------------------");
		
		for(String i:sa){
			StdOut.println(i);
		}
		StdOut.println("-----------------------------");
		StdOut.println(sa.size());

		

	}
	

}
