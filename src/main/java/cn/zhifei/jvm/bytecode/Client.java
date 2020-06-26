package cn.zhifei.jvm.bytecode;

import java.lang.reflect.Proxy;

/**
 * @Author: zhifei
 * @Date: 2020/6/26 2:47 下午
 */
public class Client {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();
        DynamicSubject ds = new DynamicSubject(rs);
        Class<? extends RealSubject> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }

}
