package leetcode;

/**
 * Created by libin on 2019/4/13.
 */
public class leet991 {

    //mine nice !! 像贪心法
    public int brokenCalc(int X, int Y) {
        int count=0;
     while (X!=Y&&Y>=X){
         if(Y%2==0){
             Y/=2;
             count++;
         }
         else {
             Y+=1;
             count++;
         }
     }
     return count+X-Y;
    }
}
