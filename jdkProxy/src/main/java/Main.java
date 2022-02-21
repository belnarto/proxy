import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        ClassLoader classLoader = TargetImpl.class.getClassLoader();
        Class<?>[] interfaces = TargetImpl.class.getInterfaces();
        Target targetProxy = (Target) Proxy.newProxyInstance(classLoader, interfaces, new Handler());
        System.out.println(targetProxy.hello());
    }
}
