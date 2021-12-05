package com.company;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * <h3>Copy2File</h3>
 * <p></p>
 * gcc编译
 * @author : cxc
 * @date : 2021-12-05 21:34
 **/
public class CompileCpp {
  private static final String toPath = "CppFile\\";
  private static final String outPath = "OutFile\\";


  public static void main(String[] args) throws Exception {

    File file = new File(toPath);
    clearDir(outPath);
    // get the folder list
    File[] array = file.listFiles();

    for (int i = 0; i < array.length; i++) {
      String cppName = array[i].getName();
      compileCppFile(cppName);
    }
  }
  private static void clearDir(String outPath){
    File outfile = new File(outPath);
    for (File f : outfile.listFiles()) {
        f.delete();;
    }
  }

  private static void compileCppFile(String cppName) throws Exception {
      try {
        final long timeout = 3000; // 限制的执行时间（毫秒）
        String cmd = "g++ "+toPath+cppName+" -o "+outPath+cppName.substring(0,cppName.length()-4)+".out";
        System.out.println(cmd);
        final long starttime = System.currentTimeMillis();
        final Process process = Runtime.getRuntime().exec(cmd); // 执行编译指令
//        if (process != null) {
//          InputStream is = process.getInputStream(); // 获取编译命令输出
//          InputStream error = process.getErrorStream(); // 获取编译命令错误输出
//          new Thread() {
//            public void run() {
//              while (true) {
//                try {
//                  sleep(10);
//
//                } catch (InterruptedException e) {
//                  e.printStackTrace();
//                }
//                if (System.currentTimeMillis() - starttime > timeout) {
//                  // 超时
//                  process.destroy();
//                }
//              }
//            }
//          }.start();
//        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

}
