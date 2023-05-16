package StrBuffer;

import Modifier.Father;

public class SBuffer extends Father {
    public final String str = "comeIn";

    public final void myBuffer() {
        System.out.println("myBuffer");
    }

    public static void main(String[] args) {
        String str = "hello";
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
        SBuffer son = new SBuffer();
        son.fn3();

    }
}
