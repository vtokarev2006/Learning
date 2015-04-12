import static java.lang.System.out;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;



class SimpleLRUCahe<K,V> extends LinkedHashMap<K,V> {
	private static final long serialVersionUID = 807591026161079092L;
	
	private int capacity;
	
	public SimpleLRUCahe(int capacity) {
		super(capacity+1, 2f, true);
		this.capacity = capacity;
		
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return this.size()>capacity;
	}
	
	
	
	
}



class Test implements Comparable<Test>  {
	
	int field=0;
	
	public Test(int i) {
		field=i;
	}
	
	
	
	@Override
	public int compareTo(Test o) {
		return 0;
	}
	
	
	
	
}


public class Alice {

	
	static NavigableSet<Integer> set = new TreeSet<>();
	
	

	public static void main(String[] args) throws InterruptedException, IOException {
	//	System.setIn(new FileInputStream("./Monte.txt"));
		
		
		String[] s = (String[])Array.newInstance(String.class, 10);
		
		
		s[0] = "aaa";
		
		
		out.println(s[0].getClass());
		
		
		
		
	
		
	}
	
	
	public static Integer getNextElem(Integer elem){
		
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext())
			if (iter.next()==elem) break;
		
		if (iter.hasNext()) return iter.next();
		else return -1;
		
	}
	
	public static Set<Integer> getPrevElem(Integer elem){
		
		
		
		Set<Integer> res = new HashSet<Integer>();
		
		if (!set.contains(elem)) return res;
		
		
		
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext()){
			int j = iter.next();
			if (j<elem) res.add(j);
			else break;
			
		}
		
		return res;
		
	}
	
	
	

}
