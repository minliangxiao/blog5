package club.huangliang.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /*
     * 这是生成时间的工具类（包括时间格式整理）
     */
    public static String getTime() {
        String time = null;
        Date data = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //time.
        time = df.format(data);

        return time;

    }

}
