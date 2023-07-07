public class TestCharacter {
    // Character 类是基本类型 char 的包装类,toUpperCase() 方法需要带参数

    public static void main(String[] args) {
        Character ch = 'a';
        String cha = ch.toString().toUpperCase();
        // ch = Character.toUpperCase(ch);
        System.out.println(cha);

        String strCh = Character.toString(ch);
        boolean result = strCh instanceof String;
        System.out.println(result);
    }
}
