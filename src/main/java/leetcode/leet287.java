package leetcode;

public class leet287 {
/*    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            else set.add(nums[i]);
        }
        return 0;
    }
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]) return nums[i];
        }
        return 0;
    }*/
    //快慢指针
    public int findDuplicate(int[] nums) {
        int slow=nums[0],fast=nums[nums[0]];
        while (fast!=slow){
           slow=nums[slow];
           fast=nums[nums[fast]];
        }

        fast=0;
        while (fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return fast;
    }

//二分查找
    //要注意条件 Given an array nums containing n + 1 integers where each integer is between 1 and n
 /*   public static int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }*/

 //统计字节数  还是要注意题目中的 n+1和n
/*public static int findDuplicate(int[] nums) {
     int res=0;
     for(int i=0;i<32;i++){
             int bit=(1<<i),a=0,b=0;
             for(int j=0;j<nums.length;j++){
                 if(j>0&&(j&bit)>0) a++;
                 if((bit&nums[j])>0) b++;
             }
             if(b>a) res+=bit;
         }
     return res;
 }*/
}
