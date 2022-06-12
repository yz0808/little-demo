package com.yangzhong.spring.boot.demo.date;

import java.util.Calendar;

/**
 * @Author yangzhong
 * @Date 2021-12-01 00:07
 * @Description 描述
 */
public class CalendarTest {
    public static void main(String[] args) {

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar1.getTime().before(calendar2.getTime()));
        System.out.println(calendar1.getTime().getTime());
        System.out.println(calendar2.getTime().getTime());
    }
}
