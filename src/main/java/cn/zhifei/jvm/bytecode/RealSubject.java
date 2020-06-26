package cn.zhifei.jvm.bytecode;

/**
 * @Author: zhifei
 * @Date: 2020/6/26 2:45 下午
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
