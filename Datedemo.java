import java.util.Date;
import java.text.SimpleDateFormat;

public class Datedemo {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String res = ft.format(date);
        System.out.println(res);

        long a = date.getTime();

    }
}
