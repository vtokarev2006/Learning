package p;

import static java.lang.System.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program2 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		
		
		
		
		Employee e = new Employee("Name1", 1, 100);
		
		Field f = e.getClass().getSuperclass().getDeclaredField("name");
		
		f.setAccessible(true);
		
		out.println(f.get(e));
		
		Method m1 = Employee.class.getMethod("getName");
		
		out.println("!!!!!  -  " + m1.invoke(e));
		
		Method m2 = Employee.class.getMethod("setName", String.class);
		
		m2.invoke(e, "Name2");
		
		out.println(e.getName());
		

		
		
		
		
		
		
		ObjectAnalyzer objectAnalizer = new ObjectAnalyzer();
		MyObjectAnalyzer myObjectAnalizer = new MyObjectAnalyzer();
		
		String s = "Hello";
		
		out.println(objectAnalizer.toString(e));
		out.println(myObjectAnalizer.toString(e));
		
		out.println(objectAnalizer.toString(s));
		out.println(myObjectAnalizer.toString(s));
		
		
		
		
		
		

	}

}
