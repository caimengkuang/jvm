package cn.zhifei.jvm.data;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 获得当前类得ClassLoader:
 *  clazz.getClassLoader()
 *
 * 获得当前线程上下文得ClassLoader:
 *  Thread.currentThread().getContextClassLoader();
 *
 * 获取系统的ClassLoader:
 *  ClassLoader.getSystemClassLoader()
 *
 * 获取调用者的ClassLoader
 *  DriverManager.getCallerClassLoader()
 *
 *
 * @Author: zhifei
 * @Date: 2020/6/9 10:45 下午
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        // 获取上下文类加载器.通常是系统类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println(classLoader);
        String resourceName ="cn/zhifei/jvmdata/MyTest1.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("======");
        Class<MyTest14> clazz = MyTest14.class;
        // 系统类加载器. AppClass
        System.out.println(clazz.getClassLoader());

        Class<?> clazz1 = String.class;
        // 根类加载器. Bootstrap . 这里使用 null 来表示
        System.out.println(clazz1.getClassLoader());
    }
}
