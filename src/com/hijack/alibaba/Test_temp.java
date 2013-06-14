package com.hijack.alibaba;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hijack
 * Date: 13-6-13
 * Time: 下午9:59
 * To change this template use File | Settings | File Templates.
 */
public class Test_temp {
    private final static double PRECISION = 1e-6;
    private final static double result = 24;
    static ArrayList<String> expros = new ArrayList<String>(5);
    static ArrayList<Double> number = new ArrayList<Double>(5);
    static String finalResult = "";
    public static boolean test(int count) {
        if (count == 1) {
            if (Math.abs(number.get(0) - result) < PRECISION) {
                finalResult = expros.get(0).substring(1, expros.get(0).length() - 1);
                return true;
            }
            return false;
        }
        for (int i = 0 ; i < count; i ++) {
            for (int j = i + 1 ; j < count ; j++) {
                double a,b;
                String aexpro,bexpro;
                a = number.get(i);
                b = number.get(j);
                number.set(j, number.get(number.size() - 1));
                aexpro = expros.get(i);
                bexpro = expros.get(j);
                expros.set(j, expros.get(expros.size() - 1));

                /**
                 * 加法
                 */
                expros.set(i, "(" + aexpro + "+" + bexpro + ")");
                number.set(i, a + b);
                if (test(count-1)) return true;
//                test(count - 1);
                /**
                 * 减法
                 */
                expros.set(i, "(" + aexpro + "-" + bexpro + ")");
                number.set(i, a - b);
                if (test(count-1)) return true;
//                test(count - 1);

                expros.set(i, "(" + bexpro + "-" + aexpro + ")");
                number.set(i, b - a);
                if (test(count-1)) return true;
//                test(count - 1);
                /**
                 * 乘法
                 */
                expros.set(i, "(" + aexpro + "*" + bexpro + ")");
                number.set(i, a * b);
                if (test(count - 1)) return true;
//                test(count - 1);
                /**
                 * 除法
                 */
                if (b != 0) {
                    expros.set(i, "(" + aexpro + "/" + bexpro + ")");
                    number.set(i, a / b);
                    if (test(count - 1)) return true;
//                    test(count - 1);
                }
                if (a != 0) {
                    expros.set(i, "(" + bexpro + "/" + aexpro + ")");
                    number.set(i, b / a);
                    if (test(count - 1)) return true;
//                    test(count - 1);
                }

                number.set(i, a);
                number.set(j, b);
                expros.set(i, aexpro);
                expros.set(j, bexpro);

            }
        }
        return false;
    }
    public static void main(String[] args) throws  Exception{
        int a,b,c,d;
        a = 1;
        b = 1;
        c = 1;
        d = 1;
//        number.add(Double.valueOf(a));
//        number.add(Double.valueOf(b));
//        number.add(Double.valueOf(c));
//        number.add(Double.valueOf(d));
//
//        expros.add(String.valueOf(a));
//        expros.add(String.valueOf(b));
//        expros.add(String.valueOf(c));
//        expros.add(String.valueOf(d));
//        test(4);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:/24points/all.txt")));
        String str = "";
        int cout = 0;
        while ( (str = br.readLine()) != null ) {
            if (str.length() != 0) {
                String[] datas = str.substring(0, str.indexOf(" ")).split(",");
                number.add(Double.valueOf(datas[0]));
                number.add(Double.valueOf(datas[1]));
                number.add(Double.valueOf(datas[2]));
                number.add(Double.valueOf(datas[3]));

                expros.add(datas[0]);
                expros.add(datas[1]);
                expros.add(datas[2]);
                expros.add(datas[3]);

                test(4);
                if (finalResult.equals(""))
                {
                    System.out.println(finalResult);
                    cout ++;
                }

            }
        }
        System.out.println(cout);

    }
}
