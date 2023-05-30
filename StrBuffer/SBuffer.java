package StrBuffer;

import Modifier.Father;

public class SBuffer extends Father {
    // 注意String是引用类型
    // 被final修饰的变量不可以被改变，被final修饰不可变的是变量的引用，而不是引用指向的内容，引用指向的内容是可以改变的
    public final String str = "comeIn";

    public final void myBuffer() {
        System.out.println("myBuffer");
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str);
        // 只能使用StringBuffer的构造方法创建
        StringBuffer sb = new StringBuffer();
        // 我们使用length()方法获取了字符串"hello"的长度

        for (int i = 0; i < str.length(); i++) {
            // str.charAt(i)返回的是一个字符
            char each = str.charAt(i);
            sb.append(each);
        }

        int index = sb.indexOf("o");
        System.out.println(index);
        sb.insert(sb.length(), " world");
        System.out.println(sb);

        // 测试protected
        SBuffer buffer = new SBuffer();
        buffer.fnProtected();

    }
}
