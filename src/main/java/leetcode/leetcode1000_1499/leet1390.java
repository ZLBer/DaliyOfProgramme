package leetcode.leetcode1000_1499;

public class leet1390 {

    //mine  暴力居然过了..
/*
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            Integer val=helper(nums[i]);
            if(val==null) continue;
                res+=val;
        }
        return res;
    }
    static Map<Integer,Integer> map=new HashMap<>();
    static {
        map.put(1,1);
        map.put(2,2);
        map.put(3,2);
        map.put(4,3);
        map.put(5,2);
     }
   Integer helper(int num){
        int res=0;
        int count=0;
        for(int i=(int)Math.sqrt(num);i>=1;i--){
            int temp=num/i;
            if(temp*i==num){
                if(temp!=i){
                    count+=2;
                    res+=(temp+i);
                }
                else {
                    count++;
                    res+=temp;
                }
            }
            if(count>4) return null; //提前止损
         }
        if(count==4) return res;
        else return null;
    }
*/



   //人家的解法  看看多么简明扼要
   //在除了1和n之外 只能存在另外两个 以此来遍历
     public int sumFourDivisors(int[] nums) {
         int sum = 0;
        for (int n : nums) {
            int last_d = 0;
            for (int d = 2; d * d <= n; ++d) {
                if (n % d == 0) {
                    if (last_d == 0)
                        last_d = d;
                    else {
                        last_d = 0;
                        break;
                    }
                }
            }
            if (last_d > 0 && last_d != n / last_d) {
                sum += 1 + n + last_d + n / last_d;
            }
        }
        return sum;
    }
}
