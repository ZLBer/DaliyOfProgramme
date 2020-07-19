package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leet1509 {
    //无脑排序
 /*   public int minDifference(int[] nums) {

        if (nums.length <= 4) return 0;
        Arrays.sort(nums);


        int length=nums.length-1;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<=3;i++){
            for(int j=3-i;j>=0;j--){
                res=Math.min(res,nums[length-j]-nums[i]);

            }
        }
        return res;

    }*/


    //分情况  反而更慢了  不应该啊
    public int minDifference(int[] nums) {

        if (nums.length <= 4) return 0;
        Arrays.sort(nums);

if(nums.length<=8) {
    int length = nums.length - 1;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i <= 3; i++) {
        for (int j = 3 - i; j >= 0; j--) {
            res = Math.min(res, nums[length - j] - nums[i]);

        }
    }
    return res;
}else {
    PriorityQueue<Integer> min=new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> max=new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
        int num=nums[i];
        if(min.size()<4){
            min.add(num);
        }else if(min.peek()>num){
            min.poll();
            min.add(num);
        }

        if(max.size()<4){
            max.add(num);
        }else if(max.peek()<num){
            max.poll();
            max.add(num);
        }
    }
    int []arr=new int[8];
    int i=0;
    while (!max.isEmpty()&&!min.isEmpty()){
        arr[i++]=max.poll();
        arr[i++]=min.poll();
    }
    Arrays.sort(arr);
    int length=arr.length-1;
    int res=Integer.MAX_VALUE;
    for( i=0;i<=3;i++){
        for(int j=3-i;j>=0;j--){
            res=Math.min(res,arr[length-j]-arr[i]);

        }
    }

    return res;
}
}


}
