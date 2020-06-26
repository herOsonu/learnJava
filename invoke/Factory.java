package invoke;

import java.lang.reflect.InvocationTargetException;

public class Factory{
    private Factory(){}
    public static <T>T getInstance(String className){
        T obj=null;
        try {
             obj =(T)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;

    }
}
