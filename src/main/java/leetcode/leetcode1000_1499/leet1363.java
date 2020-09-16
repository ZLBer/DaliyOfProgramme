package leetcode.leetcode1000_1499;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leet1363 {

    //mine  统计余数分为0 1 2
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int last1=-1;int last2=-1;
        int prelast1=-1;int prelast2=-1;
        int sum=0;
        for (int i = digits.length-1; i>=0; i--) {
            int div=digits[i]%3;
             sum+=div;sum%=3;
            if(div==0){

            }else if(div==1){
                prelast1=last1;
                last1=i;
            }else {
                prelast2=last2;
                last2=i;
            }
        }


        if(sum==0){ //正好是3的倍数
            return buildSring(digits,-1,-1);
        }else if(sum==1){ //去除一个1
            if(last1>-1&&digits.length>1){
                return buildSring(digits,last1,-1);
            }else if(prelast2>-1&&digits.length>2){
                return buildSring(digits,last2,prelast2);
            }else {
                return "";
            }

        }else if(sum==2){
            if(last2>-1&&digits.length>1){
                return buildSring(digits,last2,-1);
            }else if(prelast1>-1&&digits.length>2){
                return buildSring(digits,last1,prelast1);
            }else {
                return "";
            }
        }
        return "";
    }

   String buildSring(int []digits,int expectIndex,int exceptIndex2){
        if(digits[digits.length-1]==0) return "0";
        StringBuilder sb=new StringBuilder();
       for (int i = digits.length-1; i >=0; i--) {
           if(i!=expectIndex&&i!=exceptIndex2) sb.append(digits[i]);
       }
       return sb.toString();
   }



  //因为只能是一位数  可以全部统计出来而省去了排序的过程  然后再依次分析
/*    public String largestMultipleOfThree(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) cnt[d]++;
        int remain1Cnt = cnt[1] + cnt[4] + cnt[7]; // Number of elements with remainder = 1
        int remain2Cnt = cnt[2] + cnt[5] + cnt[8]; // Number of elements with remainder = 2
        int remainSum = (remain1Cnt + 2 * remain2Cnt) % 3;
        if (remainSum == 1) { // Delete 1 smallest digit with remainder = 1 or Delete 2 smallest digits with remainder = 2
            if (remain1Cnt >= 1) remain1Cnt -= 1;
            else remain2Cnt -= 2;
        } else if (remainSum == 2) { // Delete 1 smallest digit with remainder = 2 or Delete 2 smallest digits with remainder = 1
            if (remain2Cnt >= 1) remain2Cnt -= 1;
            else remain1Cnt -= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            if (d % 3 == 0) while (cnt[d]-- > 0) sb.append(d);
            else if (d % 3 == 1) while (cnt[d]-- > 0 && remain1Cnt-- > 0) sb.append(d);
            else while (cnt[d]-- > 0 && remain2Cnt-- > 0) sb.append(d);
        }
        if (sb.length() > 0 && sb.charAt(0) == '0') return "0"; // Remove leading 0 case [0,...,0]
        return sb.toString();
    }*/

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(        priorityQueue.peek());
    }
    
}
