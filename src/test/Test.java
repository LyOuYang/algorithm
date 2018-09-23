package test;

public class Test{


    public static <T> T add(Class<T> c) throws IllegalAccessException, InstantiationException {
        T a = c.newInstance();
        System.out.println(1);
        return a;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> dd = Class.forName("dd");
        add(dd);
    }
}
class AAA{
    public void myPrint(){
        System.out.println("123");
    }
}
