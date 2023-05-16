public class EncapTest {

    private String name;
    private String idNum;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return "name=" + name + ",age=" + age + ",idNum=" + idNum;
    }

    public static void main(String[] args) {
        EncapTest encap = new EncapTest();
        encap.setName("xl");
        encap.setAge(18);
        encap.setIdNum("12");
        System.out.println(encap + "");

    }

}
