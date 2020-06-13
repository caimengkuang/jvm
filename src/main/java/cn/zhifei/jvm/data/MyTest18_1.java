package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/12 12:02 上午
 */
public class MyTest18_1 {

    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/zhifei/classes/");
        Class<?> clazz = loader1.loadClass("cn.zhifei.jvm.data.MyTest1");
        System.out.println("clazz: "+clazz.hashCode());
        System.out.println("clazz loader: "+ clazz.getClassLoader());
    }

}
