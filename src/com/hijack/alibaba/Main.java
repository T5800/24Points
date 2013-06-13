package com.hijack.alibaba;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hijack
 * Date: 13-6-13
 * Time: 下午7:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>(5);
        Calculator calculator = new Calculator();
        list.add(6);
        list.add(6);
        list.add(6);
        list.add(10);
        boolean t = calculator.calc(list, 24);
        System.out.println(t);
        list.clear();
    ///注意7，8，9，10
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\24points/not.txt"),"gbk"));
        String str = "";
        int count = 0 ;
        while( (str = br.readLine()) != null ) {
            if (str.length() != 0) {
                String[] datas = str.substring(0, str.indexOf(" ")).split(",");
                list.add(Integer.valueOf(datas[0]));
                list.add(Integer.valueOf(datas[1]));
                list.add(Integer.valueOf(datas[2]));
                list.add(Integer.valueOf(datas[3]));
                Boolean flag = calculator.calc(list, 24);
                if (!flag){
                    count ++;
                    System.out.println(str);
                }
                list.clear();
                calculator.setFlag(false);
            }
        }
        System.out.println(count);///566组
        br.close();

    }

}
