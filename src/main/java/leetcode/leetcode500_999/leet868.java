package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/19.
 */
public class leet868 {
/*    public int binaryGap(int N) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; N > 0; i++) {
            if (N % 2 == 1) linkedList.add(i);
            N /= 2;
        }
        if (linkedList.size() <= 1) return 0;
        int max = 0;
        for (int i = 1; i < linkedList.size(); i++) {
            if (linkedList.get(i) - linkedList.get(i - 1) > max) max = linkedList.get(i) - linkedList.get(i - 1);
        }
        return max;
    }*/

//多么简洁的做法
//d means the distance from the last 1 position.
// d is initial to a small enough value -32
    public int binaryGap(int N) {
        int res = 0;
        for (int d = -32; N > 0; N /= 2, d++)
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }
}
