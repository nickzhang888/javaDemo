public class ArrayType {
    public static void main(String[] args) {
        // 栈内存:存储局部变量,定义在数组中的变量,例如arr,使用完毕,立即消失
        // 堆内存:存储new 出来的内容,数组在初始化时会为存储空间添加默认值

        // 1.数组动态初始化
        int[] arr1 = new int[3]; // byte、short、int、long类型的数组 0
        char[] arr2 = new char[3]; // 字符 ''
        boolean[] arr3 = new boolean[3]; // 布尔类型 false
        float[] arr4 = new float[3]; // float、double类型的数组 0.00
        String[] arr5 = new String[3]; // String是一个引用类型,引用类型默认值为null
        // 定义一个引用类型
        Object[] arr6 = new Object[3]; // 引用类型默认值为null
        System.out.println(arr1[0]); // 0
        System.out.println(arr2[0]); // ''
        System.out.println(arr3[0]); // false
        System.out.println(arr4[0]); // 0.00
        System.out.println(arr5[0]); // null
        System.out.println(arr6[0]); // null

        // String是一个引用类型，而char是一个基本类型。String是一个由Java提供的类，它表示一个字符序列。它是一个对象，可以使用各种由该类提供的方法进行操作

        // 2.数组静态态初始化
        int[] array = { 1, 7, 8, 9 };

    }
}
