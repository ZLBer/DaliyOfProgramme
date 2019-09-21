package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/2/28.
 */
public class leet836$ {
    //太繁琐
//    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        int width=rec1[3]-rec1[1];
//        int length=rec1[2]-rec1[0];
//      int top_left[]={rec1[0],rec1[1]+width};
//      int top_right[]={rec1[2],rec1[3]};
//      int bottom_left[]={rec1[0],rec1[1]};
//      int bottom_right[]={rec1[2],rec1[3]-width};
//
//      if(bottom_left[0]<)
//
//
//    }
     //先看不重叠的情况
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
    //根据德摩根定律化简
    //非(P 且 Q) = (非 P) 或 (非 Q)
   // 非(P 或 Q) = (非 P) 且 (非 Q)
   /* public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return   rec1[2] > rec2[0] &&   // left
                rec1[3] > rec2[1] &&   // bottom
                rec1[0] < rec2[2] &&   // right
                rec1[1] < rec2[3];     // top
    }*/
}
