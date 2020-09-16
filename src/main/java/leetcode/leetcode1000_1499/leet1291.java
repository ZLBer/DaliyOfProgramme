package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1291 {
    //mine  就是根据位数生成数字
    public List<Integer> sequentialDigits(int low, int high) {
      //获取有几位数字
        int countLow=(low+"").length();
        int countHigh=(high+"").length() ;
        List<Integer> res=new ArrayList<>();
            //控制位数
            for(int i=countLow;i<=countHigh;i++){
                //以什么数字开头
                for(int j=1;j<=9;j++){
                    StringBuilder stringBuilder=new StringBuilder();
                    int pre=j;
                    int temp=i;
                    boolean flag=false;
                    while (temp-->0) {
                        if (pre > 9) {
                            flag = true;
                            break;
                        }
                        stringBuilder.append(pre);
                        pre++;
                    }
                    if(flag) break;
                    long val=Long.parseLong(stringBuilder.toString());
                    if(val>=low&&val<=high) res.add((int)val);
                    else if(val<low) continue;
                    else break;
            }
        }
            return res;
    }


   //极客做法
/*    public List<Integer> sequentialDigits(int low, int high) {
        //所有的序列
        int[] allNums = {12,23,34,45,56,67,78,89,
                123,234,345,456,567,678,789,
                1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,
                123456,234567,345678,456789,
                1234567,2345678,3456789,
                12345678,23456789,
                123456789};
        List<Integer> res = new ArrayList<>();
        int n = allNums.length;
        for (int i = 0; i < n; i++) {
            if (allNums[i] < low) continue;
            if (allNums[i] > high) break;
            res.add(allNums[i]);
        }
        return res;
    }*/

/*
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        //按起始数字开头 开始遍历
        for (int digit = 1; digit < 9; ++digit) {
            int next = digit, n = next;
            //首先要小于high ，下一个数字也要小于10
            while (n <= high && next < 10) {

                //如果大于low则添加
                if (n >= low) {
                    res.add(n);
                }
                //计算下一个
                int n1 = n * 10 + ++next;
                if (n1 > n) {
                   //更新
                    n = n1;
                    //溢出
                }else { // Integer overflow.
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }*/
}
