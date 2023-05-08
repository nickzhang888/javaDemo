import java.util.ArrayList;
import java.util.Arrays;

public class ArrList {
    public static void main(String[] args) {
        // 创建一个ArrayList
        ArrayList<Person> personList = new ArrayList<>();

        // 添加Person对象到列表
        personList.add(new Person("Tom", 20));
        personList.add(new Person("Jerry", 25));
        personList.add(new Person("Alice", 30));

        // 查询列表中的元素
        System.out.println("List contains: " + personList); // 输出 [Person{name='Tom', age=20}, Person{name='Jerry',
                                                            // age=25}, Person{name='Alice', age=30}]
        System.out.println("Second element: " + personList.get(1)); // 输出 Person{name='Jerry', age=25}

        // 删除元素
        personList.remove(2); // 删除索引为2的元素
        System.out.println("List after deletion: " + personList); // 输出 [Person{name='Tom', age=20},
                                                                  // Person{name='Jerry', age=25}]
    }
}

class Person {
    private String name;
    private int age;

    // 构造器,如果要传入参数的话,需自己创建, 默认会创造一个没参数的构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写toString方法转为能见的数组内容
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}