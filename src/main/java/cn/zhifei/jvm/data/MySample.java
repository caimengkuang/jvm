package cn.zhifei.jvm.data;

/**
 * @Author: zhifei
 * @Date: 2020/6/11 8:58 上午
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by:" + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("from MySample: "+ MyCat.class);
    }

}
