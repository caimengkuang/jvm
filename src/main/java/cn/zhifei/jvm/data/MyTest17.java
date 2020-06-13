package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/11 9:00 上午
 */
public class MyTest17 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("cn.zhifei.jvm.data.MySample");
        System.out.println(clazz.hashCode());
        // 如果注释掉该行就不会实例化 MySample对象,即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象,没有对MyCat进行主动使用,这里就不会加载MyCat class
        Object object = clazz.newInstance();
    }

}
