package p;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectionProxy {

    public static void main(String args[]) {
    	 
        ProxyTestInterface proxied = new ProxyTest();
        
        
        ProxyTestInterface test = (ProxyTestInterface) Proxy.newProxyInstance(
                                        ProxyTest.class.getClassLoader(),
                                        new Class[] {ProxyTestInterface.class},
                                        new GetNameInvocationHandler(proxied)
                                    );
 
        System.out.println(proxied.getName("name: ", null));
        System.out.println(test.getName("name: ", null));
 
        proxied.setName("new ProxyName");
        System.out.println("\nname changed\n");
 
        System.out.println(proxied.getName("name: ", null));
        System.out.println(test.getName("name: ", null));
 
    }

}



interface ProxyTestInterface {
    public String getName(String prefix, String arg1);
    public void setName(String name);
}
 
class ProxyTest implements ProxyTestInterface {
 
    private String name = "ProxyTest";
 
    public String getName(String prefix,String arg1) {
        return prefix + name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}
 
class GetNameInvocationHandler implements InvocationHandler {
 
    private ProxyTestInterface proxied;
 

    public GetNameInvocationHandler(ProxyTestInterface proxied) {
        this.proxied = proxied;
    }
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, new Object[]{">> ", null});
    }
}


