package leetcode;

public class leet1312$ {
    //dfs超时
/*  public int minInsertions(String s) {

        dfs(0,s.length()-1,s,0);
        return min;
    }
    int min=Integer.MAX_VALUE;
    void dfs(int l,int r,String s,int insert){
        if(r<=l) {
            min= Math.min(insert,min);
            return;
        }
        if(insert>=min) return;
        if(s.charAt(l)==s.charAt(r)){
            dfs(l+1,r-1,s,insert);
            return;
        }

        dfs(l+1,r,s,insert+1);
        dfs(l,r-1,s, insert+1);

    }*/
  //其实就相当于带memo的dfs  防止了很多重复的搜索
    public int minInsertions(String s) {
     return findMinInsertionsDP(s.toCharArray(),s.length());
    }
    static int findMinInsertionsDP(char str[], int n)
    {
        int table[][] = new int[n][n];
        int l, h, gap;
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h])?
                        table[l+1][h-1] :
                        (Integer.min(table[l][h-1],
                                table[l+1][h]) + 1);
        return table[0][n-1];
    }
}
