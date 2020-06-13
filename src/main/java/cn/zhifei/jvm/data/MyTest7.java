package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/8 10:42 下午
 */
public class MyTest7 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        // 如果加载这个类的类加载器为 根类加载器 则返回为null
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("cn.zhifei.jvm.data.C");
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // AppClassClassLoader 表示应用类加载
        System.out.println(clazz2.getClassLoader());
    }
}

class C {

}
