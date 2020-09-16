package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1431 {
    //mine
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max)
                res.add(true);
            else res.add(false);
        }
        return res;
    }

/*    //stream流
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
      int max= Arrays.stream(candies).max().getAsInt();
      return Arrays.stream(candies).mapToObj(c->c+extraCandies>=max).collect(Collectors.toList());
    }*/
}