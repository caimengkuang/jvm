package cn.zhifei.jvm.classloader;

import java.io.*;

/**
 *
 * 类的卸载:
 *  1.当MySample类被加载、连接和初始化后，它的生命周期就开始了。当
 *  代表MySample类当Class对象不再被引用，即不可触及时，Class对象就
 *  会结束生命周期，MySample类在方法区内的数据也会被卸载，从而结束MySample
 *  类的生命周期
 *  2.一个类何时借宿生命周期，取决于代表它的Class对象何时结束生命周期
 *
 *
 * @Author: zhifei
 * @Date: 2020-01-26 22:00
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        // 将系统类加载器当作该类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".", "/");

        try {
            is = new FileInputStream(new File(this.path + name + this.fileExtension));

            baos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("cn.zhifei.jvm.classloader.MyTest1");
        Object instance = clazz.newInstance();
        System.out.println(instance);
        System.out.println(instance.getClass().getClassLoader());
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/zhifei/");
        Class<?> clazz = loader1.loadClass("cn.zhifei.jvm.classloader.MyTest1");
        System.out.println("clazz:"+clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

//        System.out.println("========");
//
//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//        loader2.setPath("/Users/zhifei/");
//        Class<?> clazz2 = loader1.loadClass("cn.zhifei.jvm.classloader.MyTest1");
//        System.out.println("clazz2:"+clazz2.hashCode());
//
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//
//        System.out.println("========");
//
//        MyTest16 loader3 = new MyTest16(loader2,"loader3");
//        loader3.setPath("/Users/zhifei/");
//        Class<?> clazz3 = loader3.loadClass("cn.zhifei.jvm.classloader.MyTest1");
//        System.out.println("clazz3:"+clazz3.hashCode());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3);
//
//        System.out.println("========");

        // 类卸载
        loader1 = null;
        clazz = null;
        object = null;

        System.out.println("gc");

        System.gc();

        Thread.sleep(30 * 1000);

        loader1 = new MyTest16("loader4");
        loader1.setPath("/Users/zhifei/");
        clazz = loader1.loadClass("cn.zhifei.jvm.classloader.MyTest1");
        System.out.println("clazz1:"+clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

        Thread.sleep(10 * 60 * 1000);
    }


}
