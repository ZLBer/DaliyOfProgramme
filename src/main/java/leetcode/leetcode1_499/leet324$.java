package leetcode.leetcode1_499;

import static leetcode.leetcode1_499.leet215.findKthLargest;

public class leet324$ {
    //这道题细看也不是很难  关键是那个点没想到就
    //1.排序后分成两段  反转之后进行插入
    //2.找到中位数 根据中位数就可以分成三段 分别进行插入
    //3.找到中位数 然后虚地址映射  一般是想不到的
/*    public void wiggleSort(int[] nums) {
        int median=findKthLargest(nums,(nums.length+1)/2);
        int []temp=new int[nums.length];
        int large=1,small=nums.length%2==0?nums.length-2:nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>median){
                temp[large]=nums[i];
                large+=2;
                continue;
            }
            if(nums[i]<median){
                temp[small]=nums[i];
                small-=2;
                continue;
            }
        }
      //和之前的倒叙是一样的
        while (large<nums.length){
            temp[large]=median;
            large+=2;
        }
        while (small>=0){
            temp[small]=median;
            small-=2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=temp[i];
        }

    }*/

/*  //其实排序的想法也是可以的  但是需要反转两个数组
    public void wiggleSort(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len=nums.length,i = 0;
        int[] smaller=new int[len%2==0?len/2:(len/2+1)],bigger=new int[len/2];
        //复制
        System.arraycopy(nums,0,smaller,0,smaller.length);
        System.arraycopy(nums,smaller.length,bigger,0,len/2);
        //穿插
        for (; i < len / 2; i++) {
            nums[2*i]=smaller[smaller.length-1-i];
            nums[2*i+1]=bigger[len/2-1-i];
        }
        if (len%2!=0) nums[2*i]=smaller[smaller.length-1-i];
    }*/




   //虚地址映射  太强了  https://leetcode-cn.com/problems/wiggle-sort-ii/solution/yi-bu-yi-bu-jiang-shi-jian-fu-za-du-cong-onlognjia/
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {


            //比median大  换到下面1 3 5
            //left-i之间只能是<=median
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            //比median小 换到。。。6 4 2
            //此时高位向低位换 i不需要增加
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            //和median一样大  不需要交换
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    void swap(int[]nums,int i,int j){
        if(i==j) return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
