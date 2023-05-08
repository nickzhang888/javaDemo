package Modifier;

//private修饰符限制最严格，只允许当前类中访问，其他任何类都不能访问该字段或方法,但可以用get和set方法获取和设置。
//protected修饰符允许在当前类、当前包和当前包的子类中访问。

public class Father {
    private int age;

    public void fn1() {
        System.out.println("public");
    }

    void fn2() {
        System.out.println("默认");
    }

    protected void fn3() {
        System.out.println("protected");
    }

    private void fn4() {
        System.out.println("private");
    }

    public int getAge() {
        return this.age;
    }

    public int setAge(int age) {
        return this.age = age;
    }

    public static void main(String[] args) {
        // Create an instance of the Father class
        Father fa = new Father();
        fa.fn1();
        fa.fn2();
        fa.fn3();
        fa.fn4();
        fa.age = 100;
    }
}
