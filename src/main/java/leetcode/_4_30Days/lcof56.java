package leetcode._4_30Days;

public class lcof56 {
    public int[] singleNumbers(int[] nums) {
    int a=0;
        for (int num : nums) {
            a^=num;
        }
        int mask=1;//最低的不相同位置
        while ((mask&a)==0){
            mask<<=1;
        }
        
        int b=0,c=0;
        for (int num : nums) {
            if((num&mask)==0) b^=num;
            else c^=num;
        }
       return new int[]{b,c};
    }
}
