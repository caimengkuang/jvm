package cn.zhifei.jvm.data;

/**
 * -XX:+TraceClassLoading
 * @Author: zhifei
 * @Date: 2020/6/8 11:14 下午
 */
public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        // 结果
        // MyTest9 static block
        // Parent static block
        // Child static block
        // 4
        System.out.println(Child.b);
    }

}

class Parent {
    static int a = 3;
    static {
        System.out.println("Parent static block");
    }
}
class Child extends Parent {
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}