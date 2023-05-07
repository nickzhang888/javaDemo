public class TestCharacter {
    // Character 类在对象中包装一个基本类型 char 的值,toUpperCase是Character的静态属性不能给实例继承,
    // 所有实例成员ch不能用toUpperCase方法,但可以用toString方法
    public static void main(String[] args) {
        Character ch = 'a';
        String cha = ch.toString().toUpperCase();
        // ch = Character.toUpperCase(ch);
        System.out.println(cha);

        String strCh = Character.toString(ch);
        System.out.println(strCh instanceof String);
    }
}
