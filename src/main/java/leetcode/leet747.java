package leetcode;

/**
 * Created by libin on 2019/1/2.
 */
public class leet747 {
  static   public int dominantIndex(int[] nums) {
      if(nums.length==1) return 0;
     Integer max=null,viceMax=null,index=0;
     for(int i=0;i<nums.length;i++){
         if(max==null) {
             max=nums[i];
             index=i;
         }
         else if(viceMax==null){
             if(nums[i]>max){
                 viceMax=max;
                 max=nums[i];
                 index=i;
             }
             else viceMax=nums[i];
         }
         else {
             if(nums[i]>max){
                 viceMax=max;
                 max=nums[i];
                 index=i;
             } else if(nums[i]>viceMax) viceMax=nums[i];

         }


     }

      if(max/2>=viceMax)  return index;
        else return -1;
    }
    //遍历两遍(反而比我遍历一遍还要快，难受..)
//    public int dominantIndex(int[] nums) {
//        int maxIndex = 0;
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i]>nums[maxIndex])
//                maxIndex=i;
//        }
//        for(int j : nums)
//            if(j!= nums[maxIndex] && nums[maxIndex]< 2*j)
//                return -1;
//
//        return maxIndex;
//    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
