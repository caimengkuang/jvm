package cn.zhifei.jvm.data;

/**
 * 调用ClassLoader类的loadClass方法加载一个类,并不是对类的主动使用,不会导致类的初始化
 *
 * @Author: zhifei
 * @Date: 2020/6/9 12:17 上午
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取应用类加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        // 加载的时候不会导致类初始化.这里在反射的时候才进行类初始化
        Class<?> clazz = loader.loadClass("cn.zhifei.jvm.data.CL");
        System.out.println(clazz);
        System.out.println("=====");
        clazz = Class.forName("cn.zhifei.jvm.data.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
