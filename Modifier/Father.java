package Modifier;

//private修饰符限制最严格，只允许当前类中访问，其他任何类都不能访问该字段或方法,但可以用get和set方法获取和设置。
//protected修饰符允许在当前类、当前包和当前包的子类中访问。
// 这些修饰符的访问权限从大到小依次是：public > protected > default > private

public class Father {
    private int age;

    public final String name = "nick";

    public String hobby;

    public static void fnPublic() {
        System.out.println("public");
    }

    protected void fnProtected() {
        System.out.println("protected");
    }

    void fnDefault() {
        System.out.println("default");
    }

    private void fnPrivate() {
        System.out.println("private");
    }

    public int getAge() {
        return this.age;
    }

    public int setAge(int age) {
        return this.age = age;
    }

    public static void main(String[] args) {
        Father fa = new Father();
        fa.fnPublic();
        fa.fnProtected();
        fa.fnDefault();
        fa.fnPrivate();
        fa.age = 100;
    }
}
