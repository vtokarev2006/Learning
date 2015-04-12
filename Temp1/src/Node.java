
public class Node<T> {

	
    T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println(this.getClass().getName());
        this.data = data;
    }
	
	
	public static void main(String[] args) {

		
		
		
		
		
}

}	

class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}