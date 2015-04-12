import java.util.Iterator;


public class StackLinkedList<Item> implements Stack<Item>,Iterable<Item> {
	
	private Node first;
	private int N;
	
	private class Node{
		private Item item;
		private Node next;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		N--;
		first = first.next;
		return item;
	}

	public Iterator<Item> iterator() {
		
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{
		
		private Node current = first;

		public boolean hasNext() {
			return current!=null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

	
	public static void main(String[] args) {
		
		String[] s = new String[3];
		
		s[0] = "a";
		s[1] = "b";
		s[2] = "c";
		
		
		StackLinkedList<String> sll = new StackLinkedList<String>();
		
		
		for(String q:s){
			sll.push(q);
			StdOut.println(q);
		}
		
		StdOut.println("-----------");
		
		while(!sll.isEmpty()) {
			StdOut.println(sll.pop());
		}

/*		
		StdOut.println("-----------");
		
		Iterator<String> it =  st.iterator();
		while(it.hasNext()){
			StdOut.println(it.next());
			
			
		}
*/		
		
		

		

	}
	
	
	
	
	
}
