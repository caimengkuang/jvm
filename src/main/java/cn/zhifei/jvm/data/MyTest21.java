package cn.zhifei.jvm.data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类加载器双亲委托模型的好处:
 *  1.可以确保Java核心库的类型安全:所有的Java应用都至少会引用java.lang.Object类，
 *  也就是说在运行期。java.lang.Object这个类会被加载到Java虚拟机中。如果这个加载过程
 *  是由Java应用自己的类加载器所完成的，那么很可能会在Java中存在多个版本的java.lang.Object类
 *  而且这些类是不兼容的。互相不可见的(正是命名空间在发挥作用)借助于双亲委托机制,
 *  Java核心类库中的类的加载工作都是由启动类加起来统一完成，从而确保来Java应用所使用的都是同一个版本的
 *
 *  2.可以确保Java核心类库所提供的类不会被自定义的类所替代
 *
 *  3.不同的类加载可以为相同名称(binary name)的类创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不同的
 *  类加载器来加载他们即可。不同类加载器所加载的类之间是不兼容的。这就相当于在Java虚拟机内部创建类一个又一个
 *  互相隔离的Java类空间。这类技术在很多框架中都得到了实际应用
 *
 *
 * @Author: zhifei
 * @Date: 2020/6/12 10:42 下午
 */
public class MyTest21 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/Users/zhifei/classes/");
        loader2.setPath("/Users/zhifei/classes/");

        Class<?> clazz1 = loader1.loadClass("cn.zhifei.jvm.data.MyPerson");
        Class<?> clazz2 = loader2.loadClass("cn.zhifei.jvm.data.MyPerson");

        // 当target存在MyPerson文件时结果为true。两个都为系统类加载器加载，只会加载一次，第二次加载的时候直接返回第一次的接口
        //
        System.out.println(clazz1 == clazz2);

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();


        // 当clazz1 != clazz2时表示是两个类加载器分别进行加载的。会报：
        // java.lang.ClassCastException: cn.zhifei.jvm.data.MyPerson cannot be cast to cn.zhifei.jvm.data.MyPerson
        Method method = clazz1.getMethod("setMyPerson", Object.class);;
        method.invoke(o1, o2);
    }
}
