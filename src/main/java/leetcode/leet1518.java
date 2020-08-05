package leetcode;

public class leet1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
       int res=numBottles;
      while (numBottles>=numExchange){
          int next=(numBottles/numExchange);//剩下这么多
          int x= numBottles%numExchange;//换了这么多
          res+=next;
          numBottles=next+x;

      }
      return res;
    }
}
