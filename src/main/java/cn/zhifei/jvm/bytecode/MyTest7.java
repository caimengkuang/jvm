package cn.zhifei.jvm.bytecode;



/**
 * @Author: zhifei
 * @Date: 2020/6/23 11:18 下午
 */
public class MyTest7 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(1);
    }

}

class Animal {
    public void test(String str) {
        System.out.println("animal str");
    }

    public void test(Integer a) {
        System.out.println("animal a");
    }
}

class Dog extends Animal {

    @Override
    public void test(String str) {
        System.out.println("dog str");
    }


    @Override
    public void test(Integer a) {
        System.out.println("dog a");
    }


}
