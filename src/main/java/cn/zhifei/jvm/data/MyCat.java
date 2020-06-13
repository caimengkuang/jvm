package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/11 8:56 上午
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by:" + this.getClass().getClassLoader());

        //
//        System.out.println("from MyCat: "+ MySample.class);
    }
}
