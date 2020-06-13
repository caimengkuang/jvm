package cn.zhifei.jvm.data;

/**
 *
 * -XX:+TraceClassLoading : 用于追踪类顶加载信息并打印出来
 *
 *
 * 虚拟机参数三种形式:
 * -XX:+<option>  表示开启option选项
 * -XX:-<option>  表示关闭option选项
 * -XX:<option>=<value> 表示将option选项的值设置为value
 *
 *
 * @Author: zhifei
 * @Date: 2020/6/6 9:05 下午
 */
public class MyTest1 {

    public static void main(String[] args) {
        // 对于静态字段来说,只有直接定义了该字段的类才会被初始化.所以输入str时,子类不会被初始化,
        // 当一个类在初始化时,要求其父类都已经初始化完毕
        System.out.println(MyChild1.str);

        System.out.println("=====");

        System.out.println(MyChild1.str2);
    }

}

class MyParent1{
    public static String str = "Hello world";
    static {
        System.out.println("MyParent1 static block");
    }
}
class MyChild1 extends MyParent1 {
    public static String str2 = "Hello world2";
    static {
        System.out.println("MyChild1 static blokc");
    }
}