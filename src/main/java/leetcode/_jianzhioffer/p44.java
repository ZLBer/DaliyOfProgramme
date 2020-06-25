package leetcode._jianzhioffer;

public class p44 {

    //TLE了
/*    public int findNthDigit(int n) {
        int i=0;
        n++;
     while (n>0){
        if(n<=(i+"").length()){
           return (i+"").charAt(n-1)-'0';
        }else {
           n-=(i+"").length();
        }
        i++;
     }
    return -1;
    }*/

    //找规律
    public int findNthDigit(int n) {

        int digit=1;
        long count=9;
        long start=1;

      while (n>count){
         n-=count;
        digit++;
        start*=10;
        count=digit*start*9;
      }

      //求那个数字是多少
       long num=start+(n-1)/digit;
     return Long.toString(num).charAt((n-1)%digit)-'0';

    }
}
