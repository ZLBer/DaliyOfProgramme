package leetcode;

/**
 * Created by libin on 2019/1/1.
 */
public class leet724 {
//  static   public int pivotIndex(int[] nums) {
//        if (nums.length<3) return -1;
//       for(int i=0;i<nums.length;i++){
//           int j=0;
//           int sumleft=0;
//           int sumright=0;
//           while (j<i){
//               sumleft+=nums[j++];
//           }
//           j++;
//           while (j<nums.length){
//               sumright+=nums[j++];
//           }
//           if(sumleft==sumright) return i;
//       }
//       return -1;
//    }

//先算出全部的和，然后从头开始遍历 ，可以求出左边的和 and 右边的和
  static   int pivotIndex(int[] input) {
        int rightSum = 0;
        for(int i = 0; i < input.length; i++) {
            rightSum += input[i];
        }

        int leftSum = 0;
        for(int i = 0; i < input.length; i++) {
            rightSum -= input[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += input[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }
}
