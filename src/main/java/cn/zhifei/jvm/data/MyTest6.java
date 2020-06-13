package cn.zhifei.jvm.data;

import java.security.Signature;

/**
 * @Author: zhifei
 * @Date: 2020/6/7 9:54 上午
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        System.out.println("counter1: "+Singleton.counter1);

        // 结果为 0
        // Singleton.getInstance()时,会去加载 Singleton 类
        // 连接的准备阶段 为静态变量赋默认值,此时 counter1 = 0、counter2 = 0
        // 初始化顺序是按代码中的先后顺序来的,先初始化 counter1 = 0,在初始化 singleton
        // 此时counter1 为初始化后的值 0 + 1 = 1 counter2的值也为 0 + 1 = 1（counter2的
        // 0为还没初始化前的值）,再对 counter2 进行初始化此时 counter2又由 1 变为 0
        System.out.println("counter2: "+Singleton.counter2);
    }

}

class Singleton {
    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1 ++;
        counter2 ++;
        System.out.println("=== counter2 : "+counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
