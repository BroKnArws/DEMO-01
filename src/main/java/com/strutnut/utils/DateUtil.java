package com.strutnut.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理相关的工具类
 *
 * @author strutnut
 * @date 2020/2/14
 */

public class DateUtil {

    private static final String FORMAT = "yyyy-MM-dd hh:mm";

    /* 获取当前时间 */
    public static String getCurrentTime() {

        long currentTime = System.currentTimeMillis();
        SimpleDateFormat simpleFormat = new SimpleDateFormat(FORMAT);
        String time = simpleFormat.format(currentTime);
        return time;

    }

    /* 时间差额是否大于marginMinutes? */
    public static boolean isTimeDifferenceMoreThan(String beforeTime, String nowTime, int marginMinutes) {
        if (beforeTime != null) {
            SimpleDateFormat simpleFormat = new SimpleDateFormat(FORMAT);
            try {
                Date beforeDate = simpleFormat.parse(beforeTime);
                Date nowDate = simpleFormat.parse(nowTime);
                long diff = nowDate.getTime() - beforeDate.getTime();
                long minutes = diff / (1000 * 60);
                if (minutes > marginMinutes) {
                    return true;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
