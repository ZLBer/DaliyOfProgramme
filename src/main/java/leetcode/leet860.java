package leetcode;

/**
 * Created by libin on 2019/2/24.
 */
public class leet860 {
    //nice
    public boolean lemonadeChange(int[] bills) {
       int five=0;
       int ten=0;
          for (int bill:bills){
              if(bill==5) five++;
              else if (bill==10) {
                  five--;
                  ten++;
              }
              else {
                  if(ten>0) {
                      ten--;
                      five--;
                  }
                  else five-=3;
              }
          if(five<0) return false;
          }

          return true;
    }


    //更简明
   /* public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }*/
}
