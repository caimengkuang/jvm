package cn.zhifei.jvm.bytecode;

/**
 * @Author: zhifei
 * @Date: 2020/6/23 1:04 下午
 */
public class MyTest5 {

    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        // g1的静态类型是 Grandpa而g1的实际类型(真正指向的类型)是Father

        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
