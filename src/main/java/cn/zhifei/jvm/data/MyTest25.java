package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/13 5:42 下午
 */
public class MyTest25 implements Runnable {

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        ClassLoader contextClassLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(contextClassLoader);
        System.out.println("Class: "+contextClassLoader.getClass());
        System.out.println("Parent: "+contextClassLoader.getParent());
    }

    public static void main(String[] args) {
        // 上下文线程类加载默认是 系统类加载器
        new MyTest25();
    }
}
