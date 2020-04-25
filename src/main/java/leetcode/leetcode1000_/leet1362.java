package leetcode.leetcode1000_;

public class leet1362 {
    //mine 直接法
 /*   public int[] closestDivisors(int num) {
        for(int i=(int)Math.sqrt(num+2);i>=1;i--){
            if(i*((num+2)/i)==num+2) return new int[]{i,(num+2)/i};
            if(i*((num+1)/i)==num+1) return new int[]{i,(num+1)/i};
        }
        return new int[]{};
    }*/

//可以直接求余
    public int[] closestDivisors(int x) {
        for (int a = (int)Math.sqrt(x + 2); a > 0; --a) {
            if ((x + 1) % a == 0)
                return new int[]{a, (x + 1) / a};
            if ((x + 2) % a == 0)
                return new int[]{a, (x + 2) / a};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
        threadLocal.set(1);
        threadLocal.get();
    }
}
