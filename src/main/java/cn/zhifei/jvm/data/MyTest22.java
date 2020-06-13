package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/12 11:26 下午
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 init");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }

}
