package cn.zhifei.jvm.bytecode;

/**
 * @Author: zhifei
 * @Date: 2020/6/26 1:58 下午
 */
public class MyTest8 {

    public int myCalculate() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        int result = (a + b - c) + d;

        return result;
    }

}
