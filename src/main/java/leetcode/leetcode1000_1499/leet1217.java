package leetcode.leetcode1000_1499;

public class leet1217 {
 /*   public int minCostToMoveChips(int[] chips) {
      int result=0;
        for (int i = 0; i < chips.length; i++) {
            if(i%2!=0)
                result++;

        }
        return result;
    }*/
    public int minCostToMoveChips(int[] chips) {
       int odd=0;
        for (int i = 0; i < chips.length; i++) {
            if(chips[i]%2==1)
                odd++;
        }
        return odd*2>chips.length?chips.length-odd:odd;
    }
}
