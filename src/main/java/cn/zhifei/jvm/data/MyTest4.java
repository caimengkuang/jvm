package cn.zhifei.jvm.data;

/**
 * 对于数组实例,其类型是由JVM在运行期间动态生成的,表示为 [Lcn.zhifei.jvm.data.MyParent4;
 * 这种形式,动态生成的类型其副类型为 Object
 *
 * 对于数组来说,javaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后的类型
 *
 * 助记符:
 *  anewarray : 表示创建一个引用类型的(如类、接口、数组)数组,并将其引用值压入栈顶
 *  newarray : 表示创建一个指定的原始类型(如int、float、char等)的数组,并将其引入值压入栈顶
 *
 * @Author: zhifei
 * @Date: 2020/6/7 9:13 上午
 */
public class MyTest4 {

    public static void main(String[] args) {
        // 这并不是对类的主动使用，也就不会进行类的初始化
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());


    }

}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}