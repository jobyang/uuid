package com.yh.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @deprecated 时间工具类
 * @author yanghua
 */
public class DateTimeUtil {
    /**
     * 瑞年天数
     */
    private final static Integer RUIYEARDAYS = 366;
    /**
     * 非瑞年天数
     */
    private final static Integer NOTRUIYEARDAYS = 365;
    /**
     * 星期
     */
    private final static String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    /**
     * 昨天
     */
    private final static String YESTERDAY = "昨天";

    /**
     * 日期格式
     */
    private enum DateFormat {
        YMDHMS("yyyy-MM-dd HH:mm:ss"), YMDHM("yyyy-MM-dd HH:mm"), HM("HH:mm"), YMD("yyyy-MM-dd");
        private String format;

        DateFormat(String format) {
            this.format = format;
        }
    }
    /**
     * 时间转换
     *
     * 今天时，显示【时分】，例如，18:18
     * 昨天，显示【昨天】，例如，昨天 18:18
     * 在本星期内（星期一~星期日），显示【星期】例如，星期三 18:18
     * 不在上述情况内的显示年月日时分秒 2018-12-15 18:18
     * @author yanghua
     * @date 2018/12/24 14:50
     * @param date
     * @param returnTime ture 显示时间 false显示日期、星期
     * @return java.lang.String
     * @throws
     */
    public static String transformFormatDate(Date date, boolean returnTime) {
        if (date == null) {
            return null;
        }

        if (System.currentTimeMillis() - date.getTime() < 0) {
            return dateConvertStr(date, DateFormat.YMDHM.format);
        }

        String time = dateConvertStr(date, DateFormat.HM.format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dateDay = calendar.get(Calendar.DAY_OF_YEAR);
        int dateYear = calendar.get(Calendar.YEAR);
        calendar.setTime(new Date());
        int nowDay = calendar.get(Calendar.DAY_OF_YEAR);
        // 跨年
        if (nowDay < dateDay) {
            int leastMaxiDay = NOTRUIYEARDAYS;
            if (isRuiYear(dateYear)) {
                // 瑞年天数和非瑞年天数不一样
                leastMaxiDay = RUIYEARDAYS;
            }
            nowDay = leastMaxiDay + nowDay;
        }
        if (dateDay == nowDay) {
            return time;
        } else if ((nowDay - dateDay) == 1) {
            return returnTime ? YESTERDAY + " " + time : YESTERDAY;
        } else if ((nowDay - dateDay) > 1 && (nowDay - dateDay) <= 7) {
            calendar.setTime(date);
            // "星期日" : 1, "星期一": 2, "星期二" :3, "星期三":4, "星期四":5, "星期五":6, "星期六":7
            int dateWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dateWeek < 0) {
                dateWeek = 0;
            }
            // 将星期的数据转换成："星期日" : 7, "星期一": 1, "星期二" :2, "星期三":3, "星期四":4, "星期五":5, "星期六":6
            if (dateWeek + 6 - 7 == 0) {
                dateWeek = dateWeek + 6;
            } else {
                dateWeek = Math.abs(dateWeek + 6 - 7);
            }

            calendar.setTime(new Date());
            int nowWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (nowWeek < 0) {
                nowWeek = 0;
            }
            if (nowWeek + 6 - 7 == 0) {
                nowWeek = nowWeek + 6;
            } else {
                nowWeek = Math.abs(nowWeek + 6 - 7);
            }

            // 跨星期处理
            if (nowWeek > dateWeek) {
                return returnTime ? weekDays[dateWeek -1] + " " + time : weekDays[dateWeek -1];
            } else {
                String fomat = returnTime ? DateFormat.YMDHM.format : DateFormat.YMD.format;
                SimpleDateFormat format1 = new SimpleDateFormat(fomat);
                String format2 = format1.format(date);
                return format2;
            }
        } else {
            String fomat = returnTime ? DateFormat.YMDHM.format : DateFormat.YMD.format;
            return dateConvertStr(date, fomat);
        }
    }

    /**
     * 时间转字符串格式
     * @param date
     * @param format
     * @return
     */
    public static String dateConvertStr(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (format == null || "".equals(format)) {
            format = DateFormat.YMDHMS.format;
        }
        String dateStr = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateStr = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 字符串格式时间转换成date
     * @param dateStr
     * @return
     */
    public static Date strConvertDate(String dateStr) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormat.YMDHMS.format);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 判断是否是瑞年
     * @param dayOfYear 当前年的天数
     * @return
     */
    private static boolean isRuiYear(int dayOfYear) {
        return (dayOfYear % 4 == 0 && dayOfYear % 100 != 0) || dayOfYear % 400 == 0;
    }

    public static void main(String[] args) {
        String date = transformFormatDate(strConvertDate("2019-01-09 00:11:22"), true);
        System.out.println(date);
    }
}
