package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/9 1:27 下午
 */
public class MyTest13 {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader) {
            // 若parent为启动类加载则用null表示
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
