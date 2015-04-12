import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MaxPQ<K extends Comparable<K>> {
	
	
	private class Pair implements Comparable<Pair>{
		
		final private K value;
		final private int index;
		
		Pair(K value, int index){
			this.value = value;
			this.index = index;
		}
		
		public K getValue() {
			return value;
		}


		public int getIndex() {
			return index;
		}

		
		@Override
		public int compareTo(Pair o) {
			
			int r=this.value.compareTo(o.getValue());
			
			if (r==0) return (index-o.getIndex());
			else return r;
			
		}

		
	}
	

	private Pair[] pq;
	private int N;
	private int order;
	
	private boolean less(int i, int j){
		return ( pq[i].compareTo(pq[j])<0 );
	}
	
	private void exch(int i, int j){
		Pair t = pq[i];
		pq[i]=pq[j];
		pq[j]=t;
	}
	
	
	private void swim(int k){
		while(k>1&&less(k/2, k)){
			exch(k, k/2);
			k=k/2;
		}
	}
	
	private void sink(int k){
		int j=0;
		while(2*k<=N){
			j = 2*k;
			if ((j<N)&&less(j,j+1)) j++;
			if (!less(k,j)) break;
			exch(k, j);
			k=j;
			
		}
	}
	
	
	public MaxPQ() {
		this(1);
	}
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int maxN) {
		pq = (Pair[])Array.newInstance(Pair.class, maxN+1);
		
		
		N=0;
		order = Integer.MAX_VALUE;
	}
	
	public MaxPQ(K[] a) {
	}
	
	public void insert(K v){
		N++;
		order--;
		pq[N] = new Pair(v, order);
		swim(N);
	}
	
	
	public K max(){
		throw new UnsupportedOperationException();
	}
	
	public K delMax(){
		Pair max = pq[1];
		if (max.getIndex() == order) order++;
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max.getValue();
	}
	
	public boolean isEmpty(){
		throw new UnsupportedOperationException();
	}
	
	public int size(){
		return N;
		
	}
	
	
	
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, CloneNotSupportedException {
		
		int n=1000000;
		Item[] item = new Item[n];
		MaxPQ<Item> pq = new MaxPQ<>(n);

		
		for (int i=0;i<n;i++){
			int k = (i%2==0)?1:2;
			item[i] = new Item(k, "Item "+i);
			pq.insert(item[i]);
			System.out.println(pq.order);
			
		}
		
		
		
		
		while (pq.size()>0) {
			Item i=pq.delMax();		
			System.out.println(i.getItem() + " ----- "+i.getKey() + " --- order="+pq.order);
			
			
		}
			
		
		
		
		
	
	}

}
class Item implements Comparable<Item> {
	
	private String item;
	private int key;
	

	Item(int key, String item){
		this.key = key;
		this.item = item;
	}

	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}


	@Override
	public int compareTo(Item o) {
		return (this.key - o.key);
	}
	
}

