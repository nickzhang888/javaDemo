import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrList {
    public static void main(String[] args) {
        // 创建一个ArrayList
        ArrayList<Person> personList = new ArrayList<Person>();
        // 添加Person对象到列表
        personList.add(new Person("Tom", 20));
        personList.add(new Person("Jerry", 25));
        personList.add(new Person("Alice", 30));

        // 查询列表中的元素
        System.out.println("List contains: " + personList);
        System.out.println("Second element: " + personList.get(1));

        // 删除元素
        personList.remove(2); // 删除索引为2的元素
        System.out.println("List after deletion: " + personList);

        // 使用forEach方法遍历列表中的元素
        personList.forEach(item -> {
            if (item.getName() == "Tom") {
                System.out.println(item);
            }
        });
        // 增强型 for 循环：
        for (Person item : personList) {
            if (item.getName() == "Tom") {
                System.out.println(item);
                continue;
            }
        }
        // 使用迭代器遍历列表中的元素
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println("值: " + person);
        }

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

    public String getName() {
        return name;
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