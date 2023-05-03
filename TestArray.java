public class TestArray {
    public static void main(String[] args) {
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