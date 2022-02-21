import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class Main {

    public static void main(String[] argsMain) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "hello from handler";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });
        Target targetProxy = (Target) enhancer.create();
        System.out.println(targetProxy.hello());
    }
}
