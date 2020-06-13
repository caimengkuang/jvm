package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/9 12:10 上午
 */
public class MyTest11 {
    public static void main(String[] args) {
        // 结果:
        // Parent3
        // 3
        // do something
        System.out.println(Child3.a);
        System.out.println("===");
        Child3.doSomething();
    }
}

class Parent3 {
    static int a = 3;
    static {
        System.out.println("Parent3");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("child3");
    }
}

