package cn.zhifei.jvm.data;

import sun.misc.Launcher;

/**
 * 在运行期,一个Java类是由该类的完全限定名(binary name,二进制名)he
 * 用于加载该类的定义类加载器所共同决定的。
 * 如果同样名字(即相同的完全限定名)的类是由两个不同的加载器所加载，
 * 那么这些类就是不同的,即便.class文件的字节码完全一样,并且从相同的位置加载
 * 亦如此。
 *
 * 在Oracle的hotspot实现中,系统属性sun.boot.class.path如果修改错了,则
 * 运行会出错提示错误信息:
 *
 * java/lang/NoClassDefFoundError: java/lang/Object
 *
 *
 *
 * @Author: zhifei
 * @Date: 2020/6/12 11:43 下午
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        //启动类加载不是Java代码而是C++写的,内建于jvm本身的
        //而扩展类加载和系统类加载是Java写的,他们是由启动类加载器进行加载的。
        System.out.println(ClassLoader.class.getClassLoader());

        // 扩展类加载器与系统类加起也是由启动类加载器加载的。
        // 扩展类加载器与系统类 是Launcher中的两个静态,加载他们的类加载器
        // 和加载Launcher的类加载器一致
        System.out.println(Launcher.class.getClassLoader());

        // 通过 "java.system.class.loader" 能指定系统类加载器
        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
