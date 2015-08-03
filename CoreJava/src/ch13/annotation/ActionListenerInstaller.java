package ch13.annotation;

import java.awt.event.ActionListener;
import java.lang.reflect.*;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/3
 * Email: billchen01@163.com
 */
public class ActionListenerInstaller {

    /**
     * Processes all ActionListenerFor annotations in the given object.
     * @param obj an object whose methods say have ActionListenerFor annotations
     */
    public static void processAnnotations(Object obj){
        try{
            Class cl = obj.getClass();
            for(Method m : cl.getDeclaredMethods()){
                ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
                if(a!=null){
                    Field f = cl.getDeclaredField(a.source());
                    f.setAccessible(true);
                    addListener(f.get(obj), obj, m);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addListener(Object source, final Object param, final Method m) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return m.invoke(param);
            }
        };

        Object listener = Proxy.newProxyInstance(null, new Class[]{java.awt.event.ActionListener.class}, handler);
        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        adder.invoke(source, listener);
    }
}
