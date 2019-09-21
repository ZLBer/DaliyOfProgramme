package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/1.
 */
public class leet263 {
    public boolean isUgly(int num) {
 if(num==1)return  true;
 if(num==0) return false;
         while (num!=1){
             if(num%2==0) num/=2;
             else if(num%3==0) num/=3;
             else if(num%5==0) num/=5;
             else return false;
         }
         return true;
    }


  /*  public boolean isUgly(int num) {
        if(num==1) return true;
        if(num==0) return false;
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }*/
}
