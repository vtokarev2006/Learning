package controller;

import javax.inject.Named;

@Named
public class TestController {
	
	private String field1;
	
	
	
	
	
	public String getField1() {
		return "Привет" + field1;
	}





	public void setField1(String field1) {
		this.field1 = field1;
	}





	public void doAction(){
		System.out.println("Click!");
		System.err.println("Click!");
		
	}
	
}
