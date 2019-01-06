package leetcode;

/**
 * Created by libin on 2017/9/2.
 */
public class Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int count=0;
        for(int i=0;i<99;i++) {
            if (x % 2 != y % 2)
                count++;
            x = x / 2;
            y = y / 2;
            if(x==0&&y==0) break;
        }
        return count;
    }
}
