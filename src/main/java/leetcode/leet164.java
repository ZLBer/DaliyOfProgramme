package leetcode;

import java.util.Arrays;

public class leet164 {
  /*  public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for (int i = 1; i < nums.length; i++) {
        res=Math.max(res,nums[i]-nums[i-1]);
        }
        return res;
    }
*/

    //基数排序
    public int maximumGap(int[] nums) {
     int exp=1;
   if(nums.length==0) return 0;
    int max= Arrays.stream(nums).max().getAsInt();

    while (exp<=max){
     int []count=new int[10];
     int []temp=new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int digit=(nums[i]/exp)%10;
            count[digit]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i]+=count[i-1];
        }

        for (int i = nums.length-1; i >=0; i--) {
            int digit=(nums[i]/exp)%10;
            temp[count[digit]-1]=nums[i];
            count[digit]--;
        }
       nums=temp;
        exp*=10;
     }

        int res=0;
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nums[i]);
            res=Math.max(res,nums[i]-nums[i-1]);
        }
        return res;
    }

    //桶排序 因为存在空桶 所以最大间隔一定存在与桶之间而不是桶之内

   /* public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;

        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
*/



   //long都溢出了
/*    public int[] missingTwo(int[] nums) {
        int tsum=0; long tmul=1;
        int asum=0;long amul=1;
        for (int i = 0; i < nums.length; i++) {
            tsum+=nums[i];
            tmul*=nums[i];
            asum+=(i+1);
            amul*=(i+1);
            System.out.println(tsum);
        }
        //  System.out.println(tsum+" "+tmul);
        //System.out.println(asum+" "+amul);
        int sum=asum+nums.length+1+nums.length+2-tsum;
        long mul=amul*(nums.length+1)*(nums.length+2)/tmul;

        // System.out.println(sum+" "+mul);

        int a=(sum+(int)Math.sqrt(sum*sum-4*mul))/2;
        int b=(sum-(int)Math.sqrt(sum*sum-4*mul))/2;
        return new int[]{a,b};
    }*/

// 利用求和
/*    public int[] missingTwo(int[] nums) {

        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        int n=nums.length+2;
        int sumtwo=(n*(n+1)/2)-sum;

        int threshold=sumtwo/2;

        sum=0;
        for (int num : nums) {
         if(num<=threshold) sum+=num;
        }

        int one=(threshold*(threshold+1)/2)-sum;

       return new int[]{one,sumtwo-one};
    }*/

    //利用位运算
    public int[] missingTwo(int[] nums) {
     int n=nums.length;
     int x=0;
        for (int num : nums) {
            x^=num;
        }
        for (int i = 1; i <= (n + 2); i++) {
            x^=i;
        }
       int dif=(x)&(-x);//求最后一个不同的数字

        int y=0;
        for (int num : nums) {
            if((dif&num)==0) y^=num;
        }
        for (int i = 1; i <= (n + 2); i++) {
            if((dif&i)==0) y^=i;
        }
       return new int[]{y,y^x};

    }

    public static void main(String[] args) {
        System.out.println(2&-2);
    }


}
