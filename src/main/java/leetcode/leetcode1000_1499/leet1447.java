package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1447 {
    //mine
 /*   public List<String> simplifiedFractions(int n) {
     List<String> res=new ArrayList<>();

    for(int i=2;i<=n;i++){
       res.add(1+"/"+i);
     for(int j=2;j<i;j++){
         if(check(j,i)) res.add(j+"/"+i);
     }
    }
    return res;
    }

    boolean check(int a,int b){
     for(int i=2;i<=a;i++){
         if(a%i==0&&b%i==0) return false;
     }
     return true;
    }
*/
    //求最大公约数

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int denominator = 2; denominator <= n; ++denominator) {
            for (int numerator = 1; numerator < denominator; ++numerator) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
