package p;

import static java.lang.System.out;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MyObjectAnalyzer {
	
	public String toString(Object obj) {
		Class cl = obj.getClass();
		if (cl == String.class) return (String) obj;
		
		String r = cl.getName();
		do {
			r+="[";
			Field[] fileds = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fileds, true);
			for (Field f:fileds){
				if(!Modifier.isStatic(f.getModifiers())){
					if (!r.endsWith("[")) r+=",";
					r+=f.getName() + "=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive()) r+=val;
						else r+=toString(val);
						
					} catch(Exception e) {e.printStackTrace();	}
				}
			}
			r+="]";
			cl = cl.getSuperclass();
		} while (cl!=null);
		
		return r;
	}
	

	
	
	
}


