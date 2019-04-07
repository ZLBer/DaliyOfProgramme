package leetcode;

/**
 * Created by libin on 2019/4/7.
 */
public class leet1011$ {

    //这想法是真的厉害..
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w); //max
            right += w;//sum
        }
        //二分搜索
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;

            //统计需要多少个bag
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;//若bag大于规定 ，则增大bag容量
            else right = mid; //否则缩小bag容量
        }
        return left;
    }
}
