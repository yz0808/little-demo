package com.little.demo.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Author yangzhong
 * @Date 2021-11-12 16:47
 * @Description 描述
 */
public class CsvFileWriter {
    public static void main(String[] args) {
        File file = new File("/Users/yangzhong61/File/generalPriceError.csv");
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            if (!file.exists()) {
                boolean hasFile = file.createNewFile();
                if (hasFile) {
                    System.out.println("file not exists, create new file");
                }
                fos = new FileOutputStream(file);
            } else {
                System.out.println("file exists");
                fos = new FileOutputStream(file, true);
            }
            osw = new OutputStreamWriter(fos, "utf-8");
            osw.write("测试内容"); //写入内容
            osw.write("\r\n");  //换行
        } catch (Exception e) {
            e.printStackTrace();
        } finally {   //关闭流
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
