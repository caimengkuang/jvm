package cn.zhifei.jvm.classloader;

/**
 * @Author: zhifei
 * @Date: 2020-02-04 19:55
 */
public class MyCat {

    public MyCat (){
        System.out.println("MyCat is loaded by: "+this.getClass().getClassLoader());
    }

}
