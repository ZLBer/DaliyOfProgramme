package leetcode;

/**
 * Created by libin on 2019/4/2.
 */
public class leet1010 {


    //Time Limit Exceeded
//    public int numPairsDivisibleBy60(int[] time) {
//      int count=0;
//        for(int i=0;i<time.length;i++){
//          for(int j=i+1;j<time.length;j++){
//              if((time[i]+time[j])%60==0) count++;
//          }
//      }
//      return count;
//    }

    //mine 求余数
  /*  public int numPairsDivisibleBy60(int[] time) {
    int count[]=new int[60];
    for(int a:time){
        count[a%60]++;
    }
    int result=0;
        count[0]--;
     while (count[0]>0){
         result+=(count[0]--);
     }
        count[30]--;
        while (count[30]>0){
            result+=(count[30]--);
        }
     for(int i=1;i<=29;i++){
            result+=(count[i]*count[60-i]);
     }
return  result;
    }*/

    //elegant solution....
    public int numPairsDivisibleBy60(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60]; //avoid 60,120,180
            c[t % 60] += 1;
        }
        return res;
    }
}
