package cn.zhifei.jvm.data;

/**
 * 关于命名空间的重要说明:
 *  1.子加载器加载的类能够访问到父加载器所加载的类
 *  2.父加载器加载的类无法访问到子加载器所加载的类
 *
 * @Author: zhifei
 * @Date: 2020/6/11 11:08 下午
 */
public class MyTest17_1 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/zhifei/classes/");
        Class<?> clazz = loader1.loadClass("cn.zhifei.jvm.data.MySample");
        System.out.println(clazz.hashCode());
        // 如果注释掉该行就不会实例化 MySample对象,即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象,没有对MyCat进行主动使用,这里就不会加载MyCat class
        Object object = clazz.newInstance();
    }

}
