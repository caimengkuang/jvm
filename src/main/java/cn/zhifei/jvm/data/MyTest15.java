package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/9 11:24 下午
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        // String[] 的类加载器 看 String 为 根类加载器.这里用null表示
        System.out.println(strings.getClass().getClassLoader());

        MyTest15[] myTest15s = new MyTest15[2];
        // MyTest15[] 的类加载器 看 MyTest15 为 系统类加载器 AppClassLoader
        System.out.println(myTest15s.getClass().getClassLoader());

        int[] ints = new int[2];
        // 元素类型为原生类型,则没有类加载器,则为null
        System.out.println(ints.getClass().getClassLoader());
    }
}
