package Modifier;

public class Demo {
    public static void main(String[] args) {
        // Instantiate an object of the Father class
        Father father = new Father();
        father.fn1();
        father.fn2();
        father.fn3();
        // private修饰的字段可以用get获取,set设置
        int a = father.getAge();
        System.out.println(a);

        int as = father.setAge(30);
        System.out.println(as);
    }
}
