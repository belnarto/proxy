import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(Target.class);
        MethodHandler handler = (self, thisMethod, proceed, args1) -> "hello from handler";
        Target targetProxy = (Target) factory.create(new Class<?>[0], new Object[0], handler);
        System.out.println(targetProxy.hello());
    }
}
