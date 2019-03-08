package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/3/8.
 */
public class leet202 {
    public boolean isHappy(int n) {
        Set<Integer> set =new HashSet<>();
        if(n<=0) return false;
while (!set.contains(n)) {
    set.add(n);
    int a = 0;
    while (n != 0) {
        a += (n % 10) * (n % 10);
        n /= 10;
    }
    n = a;

}
if(n==1) return true;
else  return false;
    }
}
