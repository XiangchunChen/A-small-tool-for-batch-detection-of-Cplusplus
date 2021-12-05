package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 用于过滤c++文件，统一复制到统一文件夹
 */
public class CopyFile {
    // 作业所在的文件目录
    private static final String fromPath = "D:\\C++_homework";
    private static final String toPath = "CppFile\\";

    public static void main(String[] args) throws Exception {

        File fromFile = new File(fromPath);

        clearDir(toPath);
        filter(fromFile);
    }

    private static void clearDir(String outPath){
        File outfile = new File(outPath);
        for (File f : outfile.listFiles()) {
            f.delete();;
        }
    }


    /**
     * 筛选.jar文件
     *
     * @param fromFile
     * @throws Exception
     */
    private static void filter(File fromFile) throws Exception {
        if (fromFile.isDirectory()) {
            File[] listFiles = fromFile.listFiles();
            for (File subFile : listFiles) {
                filter(subFile);
            }
        } else {
            String name = fromFile.getName();
            // 判断文件后缀是否为.cpp
            int length = name.length();
            if (".cpp".equals(name.substring(length - 4))) {
                System.out.print("正在复制" + name + "...");
                copyFile(fromFile, new File(toPath, name));
                System.out.println("√");
            }
        }
    }

    /**
     * 复制文件的方法
     *
     * @param fromFile
     * @param toFile
     * @throws Exception
     */
    private static void copyFile(File fromFile, File toFile) throws Exception {
        FileInputStream is = new FileInputStream(fromFile);
        FileOutputStream os = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int temp = 0;
        while ((temp = is.read(b)) != -1) {
            os.write(b, 0, temp);
        }
        is.close();
        os.close();
    }
}