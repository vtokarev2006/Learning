package p;

abstract public class Person implements Cloneable {

	private String name;
//	private String description;
	
	Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	abstract void setDescription(String description);
	abstract String getDescription();


	public Person Clone() throws CloneNotSupportedException{
		return (Person)super.clone();
	}
	 
	
}
