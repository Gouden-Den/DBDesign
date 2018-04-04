package tools;

import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GenerateTools {
    private static Calendar calendar;
    private static Random random = new Random(33);

    static {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                calendar = Calendar.getInstance();
            }
        }, 0L, 60 * 60 * 1000L);
    }

    public static String getId(){
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(Calendar.YEAR));
        sb.append(calendar.get(Calendar.MONTH));
        sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        sb.append(calendar.get(Calendar.HOUR_OF_DAY));
        sb.append(random.nextInt(1000));
        return sb.toString();
    }
}
