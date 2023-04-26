public class Animal {
   int myAge;
   String sex;

   public Animal(String name) {
      // 这个构造器仅有一个参数：name
      System.out.println("小狗的名字是 : " + name);
   }

   // public：表示的这个程序的访问权限，表示的是任何的场合可以被引用，这样 Java 虚拟机就可以找到 main() 方法,从而来运行 javac 程序。
   // static： 表明方法是静态的，不依赖类的对象的，是属于类的，在类加载的时候 main() 方法也随着加载到内存中去。
   // void:main()：方法是不需要返回值的。
   // main：只有有 main() 方法的 Java 程序才能够被 Java 虚拟机运行。
   // String[] args：从控制台接收参数。
   public static void main(String[] args) {
      /* 实例化对象 */
      // Object referenceVariable = new Constructor();
      Animal dog = new Animal("tommy");
      dog.setAge(18);
      String res = dog.getSex("公");
      // final代表定义常量
      final boolean a = true;
      System.out.println(a);

      System.out.println("小狗的年龄为 : " + dog.myAge);
      System.out.println("小狗的性别为 : " + res);

   }

   public String getSex(String sex) {
      return sex;
   }

   public void setAge(int age) {
      this.myAge = age;
      System.out.println(this);
   }
}
