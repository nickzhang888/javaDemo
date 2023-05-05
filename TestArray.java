public class TestArray {
    public static void main(String[] args) {
        // 需要我们注意的是，在Java语言中，小数默认的类型是double类型的，所以，在定义float变量时，需要加上类型转换
        float[] floatList = { 1.6f, 1.7f };
        double[] myList = { 1.9, 29, 3.4, 3.5 };

        int[] array = { 1, 7, 8, 9 };
        // foreach循环
        for (int i : array) {
            // sysout简写
            System.out.println("foreach循环的值:" + i);
        }

        // 倒序
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println("倒叙" + array[i]);
        }

        // 正序
        for (int i = 0; i < array.length; i++) {
            System.out.println("正序" + array[i]);
        }

        // 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
            total += myList[i];
        }
        System.out.println("Total is " + total);

        // 查找最大元素
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max)
                max = myList[i];
        }
        System.out.println("Max is " + max);

    }
}