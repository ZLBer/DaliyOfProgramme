package leetcode;

public class leet1262$ {
/*    static  public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        List<Integer> div1=new ArrayList<>(),div2=new ArrayList<>();
        int res=0;
        for (int i = nums.length-1; i >=0; i--) {
            if(nums[i]%3==0) res+=nums[i];
            else if(nums[i]%3==1){
                    div1.add(nums[i]);
            }else {
                    div2.add(nums[i]);
            }
        }
*//*        int i=0,j=0;
        int div1Length=div1.size();
        int div2Lenghth=div2.size();
        while (i<div1Length&&j<div2Lenghth){
            int three1=0,two12=0,three2=0;
            if(i+2<div1Length){
                three1=div1.get(i)+div1.get(i+1)+div1.get(i+2);
            }
            if(j+2<div2Lenghth){
                three2=div2.get(j)+div2.get(j+1)+div2.get(j+2);
            }
            two12=div1.get(i)+div2.get(j);
            if(three1>=two12&&three1>=three2){
                res+=three1;
                i+=3;
            }else if(three2>=three1&&three2>=two12){
                res+=three2;
                j+=3;
            }else {
                res+=two12;
                i++;
                j++;
            }
        }
        while (i+2<div1Length){
            int three1=div1.get(i)+div1.get(i+1)+div1.get(i+2);
            res+=three1;
          i+=3;
        }

        while (j+2<div2Lenghth){
           int  three2=div2.get(j)+div2.get(j+1)+div2.get(j+2);
            res+=three2;
          j+=3;
        }*//*
DFS(div1,div2,0,0,0);
res+=maxss;
maxss=0;
        return maxss+res;
    }


 static     int maxss=0;
 static   void DFS(List<Integer> div1,List<Integer> div2,int i,int j,int res){
       int div1Length=div1.size();
       int div2Lenghth=div2.size();
       if(i+2>=div1Length&&j+2>=div2Lenghth&&(i>=div1Length||j>=div2Lenghth)){
            maxss=Math.max(maxss,res);
            return;
       }

       int three1=0,two12=0,three2=0;
       if(i+2<div1Length){
           three1=div1.get(i)+div1.get(i+1)+div1.get(i+2);
           DFS(div1,div2,i+3,j,res+three1);
       }
       if(j+2<div2Lenghth){
           three2=div2.get(j)+div2.get(j+1)+div2.get(j+2);
           DFS(div1,div2,i,j+3,res+three2);
       }
     if(i<div1Length&&j<div2Lenghth){
         two12=div1.get(i)+div2.get(j);
         DFS(div1,div2,i+1,j+1,res+two12);
     }
   }*/


    //逆向思维很重要  从sum反向推
/*    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        List<Integer> q1 = new LinkedList<>();
        List<Integer> q2 = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 3 == 1) {
                q1.add(nums[i]);
            } else if (nums[i] % 3 == 2) {
                q2.add(nums[i]);
            }
        }
        if (sum % 3 == 1) {
            int t1 = 0;
            int t2 = 0;
            if (q1.size() > 0) {
                t1 = sum - q1.get(0);
            }
            if (q2.size() > 1) {
                t2 = sum - q2.get(0) - q2.get(1);
            }
            return Math.max(t1, t2);
        } else if (sum % 3 == 2) {
            int t1 = 0;
            int t2 = 0;
            if (q2.size() > 0) {
                t1 = sum - q2.get(0);
            }
            if (q1.size() > 1) {
                t2 = sum - q1.get(0) - q1.get(1);
            }
            return Math.max(t1, t2);
        }
        return sum;
    }*/



        //DP   用之前做的状态更新现在的状态
 //   https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431077/JavaC%2B%2BPython-One-Pass-O(1)-space
  static   public int maxSumDivThree(int[] A) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int a : A) {
            int[] dp2 = new int[3];
            for (int i = 0; i < 3; ++i)
                //放弃这个数字 或者
                dp2[(i + a) % 3] = Math.max(dp[(i + a) % 3], dp[i] + a);
            dp = dp2;
        }
        return dp[0];
    }
    public static void main(String[] args) {
     maxSumDivThree(new int[]{1,1,5,4,7});
        System.out.println(1%3);
    }
}
