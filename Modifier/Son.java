package Modifier;

public class Son extends Father {
    public final String hobby = "basketball";

    public void show() {
        // System.out.println(hobby);
        System.out.println(super.hobby);
    }

    public static void main(String[] args) {

        Son son = new Son();
        String name = son.name;
        name = "chen";
        System.out.println(name);
        son.show();
    }
}
