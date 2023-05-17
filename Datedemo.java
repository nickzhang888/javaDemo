import java.util.Date;
import java.text.SimpleDateFormat;

public class Datedemo {
    public static String getCurrentDate(String pattern) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(now);
    }

    public static void main(String[] args) {

        String res = getCurrentDate("YYYY-MM-dd HH:mm:ss");
        System.out.println(res);
        // 时间戳
        Long time = new Date().getTime();
        System.out.println(time);
    }
}
