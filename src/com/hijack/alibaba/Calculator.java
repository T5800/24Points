package com.hijack.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hijack
 * Date: 13-6-13
 * Time: 下午7:14
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {

    List<String> expro = new ArrayList<String>(5);
    List<Integer> data = new ArrayList<Integer>(5);

    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Boolean calc(ArrayList<Integer> arrayList, int total) {
//        if (flag) return true;
        if (arrayList.size() == 1) {
            if (total == Integer.valueOf(arrayList.get(0))) {
                System.out.println("找到");
                for (int i = 0 ; i < expro.size(); i ++) {
                    System.out.print(expro.get(i) + " ");
                }
                System.out.println();
                for (int i = 0 ; i < data.size() ; i ++) {
                    System.out.print(data.get(i) + " ");
                }
                System.out.println();
                flag = true;
                return flag;
            }

        }
        for (int i = 0 ; i < arrayList.size() ; i ++) {
            for (int j = 0 ; j < 4 ; j ++) {
                ArrayList<Integer> array_temp;
                int temp;
                switch (j) {
                    case 0:
                        temp = total - arrayList.get(i);
                        addExpro(j);addData(arrayList.get(i));

                        array_temp = getArray_Temp(arrayList, i);
                        calc(array_temp, temp);

                        removeLastExpro();removeLastData();
                        break;
                    case 1:
                        if ((int)total/arrayList.get(i) == ((double)total)/arrayList.get(i)) {
                            addExpro(j);addData(arrayList.get(i));

                            array_temp = getArray_Temp(arrayList, i);
                            calc(array_temp, total/arrayList.get(i));
                            /**
                             * 将不满足的数字和符号删除...
                             */
                            removeLastExpro();removeLastData();
                        }
                        break;
                    case 2:
                        temp = total + arrayList.get(i);
                        addExpro(j);addData(arrayList.get(i));
                        array_temp = getArray_Temp(arrayList, i);
                        calc(array_temp, temp);
                        removeLastExpro();removeLastData();
                        break;
                    case 3:
                        temp = total * arrayList.get(i);
                        addExpro(j);addData(arrayList.get(i));
                        array_temp = getArray_Temp(arrayList, i);
                        calc(array_temp, temp);
                        removeLastExpro();removeLastData();
                        break;
                    default:break;
                }
            }
        }
        return flag;
    }

    public ArrayList<Integer> getArray_Temp(ArrayList<Integer> array_temp, int i) {
        ArrayList<Integer> temp = new ArrayList<Integer>(5);
        for (int j = 0 ; j < array_temp.size() ; j ++) {
            if ( j != i )
                temp.add(array_temp.get(j));
        }
        return temp;
    }

    public void addData(Integer integer) {
        data.add(integer);
    }
    public void removeLastData() {
        data.remove(data.size() - 1);
    }
    public void addExpro(int i) {
        switch (i) {
            case 0:
                expro.add("-");
                break;
            case 1:
                expro.add("/");
                break;
            case 2:
                expro.add("+");
                break;
            case 3:
                expro.add("*");
                break;
            default:break;

        }
    }

    public void removeLastExpro() {
        expro.remove(expro.size() - 1);
    }
}
