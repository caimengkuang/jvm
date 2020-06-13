package cn.zhifei.jvm.data;

/**
 * 常量在编译阶段会存入到调用这个常量到方法所在的类的常量池中,
 * 本质上,调用类并没有直接引用到定义常量的类,因此并不会触发
 * 定义常量的类的初始化
 *
 * 注意:这里指的是将常量存放到MyTest2的常量池中,之后MyTest2
 * 就MyParent2没有任何关系了,甚至我们可以将MyParent2的class
 * 文件删除
 *
 * cd target/classes/cn/zhifei/jvm/data
 * 反编译: javap -c MyTest2
 *
 * 助记符:
 * ldc表示将int,float或是String类型的常量值从常量池中推送至栈顶
 * bipush表示将单字节(-128 - 127)的常量值推送至栈顶
 * sipush表示将一个短整形常量值(-32768 - 32767)
 * iconst_1表示将int类型1推送至栈顶(icons_1 - incons_6)
 *
 * @Author: zhifei
 * @Date: 2020/6/7 12:08 上午
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.s);
    }
}

class MyParent2 {
    /** ldc表示将int,float或是String类型的常量值从常量池中推送至栈顶 */
    public static final String str = "hello world";

    /** bipush表示将单字节(-128 - 127)的常量值推送至栈顶 */
    public static final short s = 127;

    /** sipush表示将一个短整形常量值(-32768 - 32767) */
    public static final int i = 128;

    /** iconst_1表示将int类型1推送至栈顶(icons_1 - incons_6) */
    public static final int m = 2;

    static {
        System.out.println("MyParent2 static block");
    }
}