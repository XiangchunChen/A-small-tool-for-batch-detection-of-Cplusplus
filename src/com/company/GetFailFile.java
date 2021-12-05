package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Copy2File</h3>
 * <p></p>
 * 获得编译失败的所有文件名
 * @author : cxc
 * @date : 2021-12-05 22:07
 **/
public class GetFailFile {
  //3.1b 3.5 5.3 6.1c 6.2c 6.2e 6.3 7.1 7.2
  // 1

    private static final String toPath = "CppFile\\";
    private static final String outPath = "OutFile\\";

    public static void main(String[] args) throws Exception {

      File file = new File(toPath);
      // get the folder list
      File[] array = file.listFiles();
      File outfile = new File(outPath);
      File[] outarray = outfile.listFiles();
      List<String> fileNames = new ArrayList<>();
      for (int i = 0; i < outarray.length; i++) {
        String cppName = outarray[i].getName();
        if(cppName.contains(".out")) {
          fileNames.add(cppName.substring(0,cppName.length()-4)+".cpp");
        }
      }
      //      System.out.println("Wrong Compile files:");
//      int number = 0;
//      for (int i = 0; i < array.length; i++) {
//        String outName = array[i].getName();
//        outName= outName.substring(0,outName.length()-4)+".cpp";
//        if(!fileNames.contains(outName)) {
//          System.out.printf(outName.substring(0,outName.length()-4)+" ");
//          number++;
//        }
//      }
      System.out.printf("\n");
      int number=0;

      System.out.printf("\n");
      for (int i = 0; i < array.length; i++) {
        String outName = array[i].getName();
        outName= outName.substring(0,outName.length()-4)+".cpp";
        if(!fileNames.contains(outName)) {
          System.out.printf(outName+" ");
          number++;
        }
      }
      System.out.printf("\nNumber of Wrong Compile files:%d\n",number);
//      System.out.println("\nAfter Fiter(3.5/5.3):");
//      number=0;
//      for (int i = 0; i < array.length; i++) {
//        String outName = array[i].getName();
//        outName= outName.substring(0,outName.length()-4)+".cpp";
//        if(!fileNames.contains(outName)) {
//          if(!check(outName)) {
//            System.out.printf(outName + " ");
//            number++;
//          }
//        }
//      }
//      System.out.printf("\nAfter Fiter(number):%d\n",number);
      double score = 10 - 10*(number/28.0);
      System.out.printf("The score is %.2f\n", score);
      //  6.1c
      System.out.printf("\n");
      System.out.println("Please input the final wrong number after carefully checking");
      Scanner scan=new Scanner(System.in);
		  int num = scan.nextInt();
      score = 10 - 10*(num/28.0);
      System.out.printf("The final score is %.2f", score);

    }

    private static boolean check(String name){
      if(name.contains("3") && name.contains("5")){
        return true;
      }
      else {
        return false;
      }
    }

}
