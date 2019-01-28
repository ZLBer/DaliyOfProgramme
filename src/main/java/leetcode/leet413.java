package leetcode;

/**
 * Created by libin on 2019/1/28.
 */
public class leet413 {

    //mine  类似动态规划  1ms beat 100%
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        int result = 0;
        Integer[] distance = new Integer[A.length];
        //求每一个数字前面的距离
        for (int i = 1; i < A.length; i++) {
            distance[i] = A[i] - A[i - 1];
        }
        //默认第一个没有距离
        distance[0]=null;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (distance[i] == distance[i - 1]) count++;
            else {
                if (count >= 2) result += ((count - 1) * count) / 2;
                count = 1;
            }
        }
        //计算最后一列
        if (count >= 2) result += ((count - 1) * count) / 2;


        return result;
    }

  //一种十分简洁的方法
      //真的是很牛b
   /* public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }*/
}
