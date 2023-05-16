package Modifier;

public class Son extends Father {
    public final String hobby = "basketball";

    public void show() {
        // System.out.println(hobby);
        System.out.println(super.hobby);
    }

    @Override
    void fn2() {
        System.out.println("子默认");
    }

    public static void main(String[] args) {

        Son son = new Son();
        String name = son.name;
        name = "chen";
        System.out.println(name);
        son.show();
        son.fn2();
    }
}
