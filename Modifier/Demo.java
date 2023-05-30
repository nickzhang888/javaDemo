package Modifier;

import StrBuffer.SBuffer;

public class Demo {
    public static void main(String[] args) {
        // Instantiate an object of the Father class
        Father father = new Father();
        father.fnPublic();
        father.fnProtected();
        father.fnDefault();
        // private修饰的字段可以用get获取,set设置
        int a = father.getAge();
        System.out.println(a);

        int as = father.setAge(30);
        System.out.println(as);

        SBuffer sb = new SBuffer();

        String str = sb.str;
        str = "change"; // 虽然值不能被修改,但值的引用可以被修改
        System.out.println(str);

        sb.myBuffer();

    }
}
