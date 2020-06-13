package cn.zhifei.jvm.classloader;

/**
 * @Author: zhifei
 * @Date: 2020-02-04 19:58
 */
public class MySample {

    public MySample(){
        System.out.println("MySample is loaded by:" + this.getClass().getClassLoader());

        new MyCat();
    }

}
