package leetcode;

public class leet440 {
    public static void main(String[] args) {
    }

    /*   static public int findKthNumber(int n, int k) {
            int maxBit = (n + "").length();
         for(int i=1;i<=9;i++){
            int num=compute(i+"",maxBit,n);
           if(num==1) return i;
             if(num>k){
               return dfs(i+"",n,k,maxBit);
            }else {
               k-=num;
            }
         }
         return -1;
        }

        static int compute(String pre, int maxBit,int n) {
            int res = 1;
         int max=maxBit-pre.length();
        if() max--;
            for (int i = 1; i <= max; i++) {
                res += Math.pow(10, i);
                pre+="9";
            }

      if(pre.charAt(0)==(n+"").charAt(0)){  //同一级
          return res-(Integer.parseInt(pre)-n);
      }else {
          return res;
      }
        }
      static   int dfs(String pre,int n,int k,int maxBit) {

            for (int i = 0; i <= 9; i++) {
              int count=compute(pre+i,maxBit,n);
             if(count==1) return Integer.parseInt(pre+i);
              if(count>k){
                return dfs(pre,n,k,maxBit);
              }else {
                k-=count;
              }
            }
           return -1;
        }*/
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while (k > 0) {
            int count = helper(n, cur, cur + 1);
            // System.out.println(count);
            if (count > k) {
                cur *= 10;
                k--;
            } else {
                k -= count;
                cur++;
            }
        }
        return cur;
    }

    int helper(int n, long first, int last) {
        int res = 0;
        while (first <= n) {
            res += Math.min(last, n + 1) - first;
            first *= 10;
            last *= 10;
        }
        return res;
    }
}
