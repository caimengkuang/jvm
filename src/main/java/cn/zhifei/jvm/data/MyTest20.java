package cn.zhifei.jvm.data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhifei
 * @Date: 2020/6/12 12:16 上午
 */
public class MyTest20 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("cn.zhifei.jvm.data.MyPerson");
        Class<?> clazz2 = loader2.loadClass("cn.zhifei.jvm.data.MyPerson");

        // 结果为true。两个都为系统类加载器加载，只会加载一次，第二次加载的时候直接返回第一次的接口
        System.out.println(clazz1 == clazz2);

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);;
        method.invoke(o1, o2);
    }
}
