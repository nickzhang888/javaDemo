import java.util.Timer;

import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override

            public void run() {

                System.out.println("定时任务开始执行");

            }

        };

        // 定时任务开始执行，延迟1秒，每隔5秒执行一次

        timer.schedule(task, 1000, 5000);

    }

}