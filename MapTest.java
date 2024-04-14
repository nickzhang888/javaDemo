import java.util.HashMap; // 引入 HashMap 类

public class MapTest {
    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<String, String> map = new HashMap<>();

        // 添加键值对到 HashMap
        map.put("name", "小夏");
        map.put("age", "12");
        map.put("hobby", "打篮球");
        // 删除 HashMap 中的某个键值对
        map.remove("hobby");
        // 修改 HashMap 中的某个键值对
        map.put("age", "13");
        // 获取 HashMap 中的某个键值对
        String name = map.get("name");
        // 遍历key
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        // 遍历value
        for (String value : map.values()) {
            System.out.println(value);
        }

    }
}