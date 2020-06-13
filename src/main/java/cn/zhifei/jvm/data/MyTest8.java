package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/8 11:06 下午
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block");
    }
}
