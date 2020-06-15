package cn.zhifei.jvm.data;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式: 获取 - 使用- 还原
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try {
 *     Thread.currentThread().setContextClassLoader(targetTccl);
 *     myMethod();
 * } finally {
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 *
 * MyMethod()里面则调用了Thread.currentThread().getContextClassLoader()
 * 获取当前线程的上下文类加载器做某些事情。
 *
 * 如果一个类由类加载器由，那么这个类的依赖类也是由
 * 相同的类加载器加载
 *
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制
 *
 * 当高层提供了统一的接口让低层区实现,同时又要在高层
 * 加载(或实例化)低层的类时,就必须要通过线程上下文类加载器来帮助高层的ClassLoader
 * 找到并加载该类。
 *
 * @Author: zhifei
 * @Date: 2020/6/13 5:51 下午
 */
public class MyTest26 {

    public static void main(String[] args) {

        // 将线程类加载器设置为 扩展类加载器,则 ServiceLoader.load(Driver.class); 将加载不到数据
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:"+driver.getClass() +",loader:"
                            + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器:" +
                Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器:" +
                ServiceLoader.class.getClassLoader());
    }

}
