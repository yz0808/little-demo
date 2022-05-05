package com.yangzhong.spring.boot.demo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author yangzhong
 * @Date 2022-01-10 15:42
 * @Description 描述
 */
public class DateFormatTest {
    public static void main(String[] args) {

        Long timestamp = 1641800355036L;
        Date date = new Date(timestamp);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        System.out.println(sdf.format(date));
        if (null instanceof Boolean) {
            System.out.println("11111");
        }
        System.out.println(2222222);
        System.out.println(null instanceof Boolean);
    }
}
