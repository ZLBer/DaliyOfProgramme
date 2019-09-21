package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/4/11.
 */
public class leet357$ {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
      int result=10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-->1&&availableNumber>0){
            uniqueDigits=uniqueDigits*availableNumber;
            result+=uniqueDigits;
            availableNumber--;
        }
        return result;

    }
}
