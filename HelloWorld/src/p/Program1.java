package p;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static java.lang.System.*;



public class Program1 {
	
	public static void main(String[] args) {
		
		
		Scanner scaner = new Scanner(System.in);
		
		
		out.print("Class name:");
		String clName = scaner.next();
		out.print("\n");
		
		try {
		
			Class<?> cl = Class.forName(clName);
			Class<?> superl = Class.forName(clName).getSuperclass();
			
			String clModName = Modifier.toString(cl.getModifiers());
	
			if (clModName!="") out.print(clModName + " ");
			out.print("class "+cl.getName()+" ");
			
			if ((superl!=null) && (superl!=Object.class))
				out.print("extends " + superl.getName());
			out.print(" { \n");
	
			out.print(" \n");
			
			printConstructors(cl);
			out.print(" \n");
			printMethods(cl);
			out.print(" \n");
			printFields(cl);
			out.print("\n}");
		
		} catch (ClassNotFoundException e){
			out.println("Class not found:" + clName);
			
		}
		
		scaner.close();

		
		
	}

	static void printConstructors(Class<?> cl){
		
		Constructor<?>[] constr  = cl.getDeclaredConstructors();
		
		for (Constructor<?> c:constr){
			
			out.print("\t");
			if(Modifier.toString(c.getModifiers())!="") out.print(Modifier.toString(c.getModifiers()) + " ");
			out.print(c.getName() + " (");
			Class<?>[] params = c.getParameterTypes();
			for(int i=0;i<params.length;i++){
				if (i>0) out.print(", ");
				out.print(params[i].getName());
			}
			out.print(");\n");
			
		}
		
		
	}
	
	static void printMethods(Class<?> cl){
		Method[] meth = cl.getMethods();
		
		for(Method m:meth){
			out.print("\t");
			
			if(Modifier.toString(m.getModifiers())!="") out.print(Modifier.toString(m.getModifiers()) + " ");
			out.print(m.getReturnType().getName() + " ");
			out.print(m.getName() + " (");
			
			Class<?>[] params = m.getParameterTypes();
			for(int i=0;i<params.length;i++){
				if (i>0) out.print(", ");
				out.print(params[i].getName());
			}
			out.print(");\n");
			
		}
		
		
	}
	
	static void printFields(Class<?> cl){
		Field [] fields = cl.getDeclaredFields();
		for (Field f:fields) {
			out.print("\t");
			if(Modifier.toString(f.getModifiers())!="") out.print(Modifier.toString(f.getModifiers()) + " ");
			out.print(f.getType().getName() + " " + f.getName() +";\n" );
		}
		
		
	}
	

	
	
	
	
	
	public static void calc(String s, int ... i){

		
		for (int k:i){
			out.println(k);
		}
		
		
		out.println();
		
		for (int j=0;j<i.length;j++){
			out.println(i[j]);
		}
		
		
		
	}
	
	
	
}