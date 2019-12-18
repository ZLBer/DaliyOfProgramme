package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetc6 {
    public List<Integer> sequentialDigits(int low, int high) {
      //获取第一个数字
       // int begin=(low+"").charAt(0)-'0';
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
                    while (temp-->0){
                        if(pre>9){
                        flag=true;
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
}
