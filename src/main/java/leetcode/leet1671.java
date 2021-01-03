package leetcode;

public class leet1671 {

    //两个最长上升子序列
/*    public int minimumMountainRemovals(int[] nums) {

        int []front=new int[nums.length];
        int []back=new int[nums.length];


        front[0]=1;
        for (int i = 1; i < nums.length; i++) {
            front[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    front[i]=Math.max(front[j]+1,front[i]);
                }
            }
        }
        back[nums.length-1]=1;
        for (int i = nums.length - 2; i >= 0; i--) {
            back[i]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    back[i]=Math.max(back[j]+1,back[i]);
                }
            }
        }
        int res=0;
        for (int i = 1; i < nums.length-1; i++) {
           // System.out.println(front[i]+" "+back[i]);
          if(front[i]==1||back[i]==1) continue;
            res=Math.max(res,front[i]+back[i]-1);
        }
        return nums.length-res;
    }*/


    //logn的最长上升子序列

    public int minimumMountainRemovals(int[] nums) {

        int []front=new int[nums.length];
        int []back=new int[nums.length];

        int []tail=new int[nums.length];
        front[0]=1;
        int len=0;
        for (int i = 0; i < nums.length; i++) {
            front[i]=1;
           int l=0,r=len;
           while (l<r){
               int mid=(l+r)/2;
            if(tail[mid]<nums[i]){
                l=mid+1;
            }else {
                r=mid;
            }
           }
           if(l==len){
             len++;
           }
           tail[l]=nums[i];
           front[i]=l+1;
           // System.out.println(front[i]);
        }

        tail=new int[nums.length];
        len=0;
        for (int i = nums.length - 1; i >= 0; i--) {
          int l=0,r=len;
          while (l<r){
              int mid=(l+r)/2;
              if(tail[mid]<nums[i]){
                 l=mid+1;
              }else{
                  r=mid;
              }

          }  if(l==len){
                len++;
            }
            tail[l]=nums[i];
            back[i]=l+1;
          System.out.println(back[i]);
        }
        int res=0;
        for (int i = 1; i < nums.length-1; i++) {
            // System.out.println(front[i]+" "+back[i]);
            if(front[i]==1||back[i]==1) continue;
            res=Math.max(res,front[i]+back[i]-1);
        }
        return nums.length-res;
    }
}
