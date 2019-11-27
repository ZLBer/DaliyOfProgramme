package leetcode.leetcode1_499;

public class leet42$ {
    //双指针   其实看明白了还是不难的
    //往里走 只有更高的木板会对结果有影响，低的板会被外层高的木板兜住
    public int trap(int[] height) {
       int leftMax=Integer.MIN_VALUE;
       int rightMax=Integer.MIN_VALUE;
        int left=0;
        int right=height.length-1;
      int result=0;
        while (left<=right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
            result+=leftMax-height[left];
            left++;
            }else {
                result+=rightMax-height[right];
                right--;
            }
        }
        return result;
    }

  //用栈来解决   和双指针还是有本质上的不同的   一个侧重纵向，一个侧重横向
/*    public int trap(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                //次数i的值增加
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                        0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }*/
}
