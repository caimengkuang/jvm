package cn.zhifei.jvm.data;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: zhifei
 * @Date: 2020/6/9 11:45 下午
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;

    private String fileExtension = ".class";

    /**
     * 绝对路径
     */
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        // 将系统类加载器当作该类的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked : "+ className);
        System.out.println("class loader name: "+ this.classLoaderName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".","/");

        try {
//            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(this.path + name + this.fileExtension));

            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return data;
    }


    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("cn.zhifei.jvm.data.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException {
        // 当target中有 MyTest1时,那么类加载器为系统类加载器(当前类加载器加载时先让父类加载器加载,此时系统类加载能加载MyTest1);
        // 则 clazz 的hashCode为同一个

        // 当target中没有MyTest1时,那么父类加载器不能加载则由自己去加载
        // 此时clazz的hashCode不为同一个。loader1、loader2为两个命名空间

        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("/Users/zhifei/project/zhifei/zhifei_project/jvm_lecture/target/classes/");
        loader1.setPath("/Users/zhifei/classes/");
        Class<?> clazz = loader1.loadClass("cn.zhifei.jvm.data.MyTest1");
        System.out.println("clazz: "+clazz.hashCode());
        Object o = clazz.newInstance();
        System.out.println(o);
        System.out.println("===");

//        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("/Users/zhifei/classes/");
//
//        Class<?> clazz2 = loader2.loadClass("cn.zhifei.jvm.data.MyTest1");
//        System.out.println("class:" + clazz2.hashCode());
//        Object o2 = clazz2.newInstance();
//        System.out.println(o2);
//        System.out.println("===");
//
//        MyTest16 loader21 = new MyTest16(loader1, "loader2");
//        loader21.setPath("/Users/zhifei/classes/");
//
//        Class<?> clazz21 = loader21.loadClass("cn.zhifei.jvm.data.MyTest1");
//        System.out.println("class:" + clazz21.hashCode());
//        Object o21 = clazz21.newInstance();
//        System.out.println(o21);
//        System.out.println("===");
//
//        MyTest16 loader3 = new MyTest16(loader21, "loader3");
//        loader3.setPath("/Users/zhifei/classes/");
//        Class<?> clazz3 = loader3.loadClass("cn.zhifei.jvm.data.MyTest1");
//        System.out.println("class:" + clazz3.hashCode());
//        Object o3 = clazz3.newInstance();
//        System.out.println(o3);
//        System.out.println("===");

        Thread.sleep(30 * 1000);

        // 卸载: 只有用户自定义类加载器加载的才会被卸载.
        loader1 = null;
        clazz = null;
        o = null;
        System.gc();
    }

}
