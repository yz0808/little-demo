package com.little.demo.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author yangzhong
 * @Date 2021-03-23 21:53
 * @Description 描述
 */
public class TextFileReader {
    public static void main(String[] args) throws IOException {
        String path = "/Users/yangzhong61/Work/项目/万家价格技改/所有调用者应用名称.txt";

        File file = new File(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String str;
        int i = 0;
        Set<String> appNames = new HashSet<>();
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
            appNames.add(str);
            i++;
        }
        bufferedReader.close();
        System.out.println(i);
        System.out.println(appNames.size());
        System.out.println(appNames);
    }
}
