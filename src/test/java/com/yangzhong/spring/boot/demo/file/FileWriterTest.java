package com.yangzhong.spring.boot.demo.file;

import java.io.File;
import java.io.FileWriter;

/**
 * @Author yangzhong
 * @Date 2021-11-12 17:04
 * @Description 描述
 */
public class FileWriterTest {
    public static void main(String[] args) {
        File file = new File("/Users/yangzhong61/File/generalPriceError.csv");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("测试测试");
            fileWriter.write("\r\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {

        }

    }
}
