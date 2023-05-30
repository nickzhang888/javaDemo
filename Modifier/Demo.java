package Modifier;

import StrBuffer.SBuffer;

public class Demo {
    public static void main(String[] args) {
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

        // 虽然final修饰的引用类型地址不能被修改,但地址里的值可以被修改
        String str = sb.myString;
        str = "change";
        System.out.println(str);

        sb.myBuffer();

    }

}
