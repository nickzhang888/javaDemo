package StrBuffer;

import Modifier.Father;

public class SBuffer extends Father {
    public final String myString = "comein";

    public final void myBuffer() {
        System.out.println("myBuffer");
    }

    public static void main(String[] args) {
        final String str = "hello";
        // 只能使用StringBuffer的构造方法创建,因为此处字符串设计长度变化
        StringBuffer sb = new StringBuffer();
        // 我们使用length()方法获取了字符串"hello"的长度

        for (int i = 0; i < str.length(); i++) {
            // str.charAt(i)返回的是一个字符
            char each = str.charAt(i);
            sb.append(each);
        }

        int index = sb.indexOf("o");
        sb.insert(sb.length(), " world");
        System.out.println(sb);

        // 测试protected
        SBuffer buffer = new SBuffer();
        buffer.fnProtected();

    }
}
