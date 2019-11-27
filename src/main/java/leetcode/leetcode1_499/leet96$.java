package leetcode.leetcode1_499;

public class leet96$ {
    //具体解释 https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
   //太美了 如此复杂的问题居然分解没了
    public int numTrees(int n) {
       int []G=new int[n+1];
       G[0]=1;
       G[1]=1;
       for(int i=2;i<=n;i++){
           for(int j=1;j<=i;j++){
               G[i]+=G[j-1]*G[i-j];
           }
       }
       return G[n];
    }

    //然后可以推导成卡特拉数
/*    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }*/


}
