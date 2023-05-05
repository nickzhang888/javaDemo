public class Test {
    // Character 类在对象中包装一个基本类型 char 的值
    public static void main(String[] args) {
        char ch = 'a';
        ch = Character.toUpperCase(ch);
        System.out.println(ch);

        String strCh = Character.toString(ch);
        System.out.println(strCh instanceof String);
    }
}
