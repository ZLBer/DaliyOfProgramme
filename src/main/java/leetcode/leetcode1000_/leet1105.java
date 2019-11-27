package leetcode.leetcode1000_;

public class leet1105 {

   //mine  dfs  Time Limit Exceeded
/*    int min = Integer.MAX_VALUE;

    public int minHeightShelves(int[][] books, int shelf_width) {
        dfs(books, shelf_width, 0, 0, 0, 0);
        return min;
    }

    void dfs(int[][] books, int shelf_width, int index, int levelHeight, int tempHeight, int tempWidth) {
        //搜索到结尾
        if (index == books.length) {
            min = Math.min(min, tempHeight + levelHeight);
            return;
        }
        int width = books[index][0];
        int height = books[index][1];


        //保证每一层都有书
        if (levelHeight == 0) {
            dfs(books, shelf_width, index + 1, height, tempHeight, width);
        }
        //如果之前已经有书
        else {
            //只能进入下一层
            if (width + tempWidth > shelf_width) {
                dfs(books, shelf_width, index + 1, height, tempHeight + levelHeight, width);
            }
            //可以选择下一层，或者本层
            else {
                //选择本层
                dfs(books, shelf_width, index + 1, Math.max(height, levelHeight), tempHeight, width + tempWidth);

                //选择下一层
                dfs(books, shelf_width, index + 1, height, tempHeight + levelHeight, width );

            }
        }
    }*/
    //dp

    public int minHeightShelves(int[][] books, int shelf_width) {
        int []dp=new int[books.length+1];


        for(int i=1;i<=books.length;i++){
            int width=books[i-1][0];
            int height=books[i-1][1];
            //自己单独一层
            dp[i] =  dp[i-1] + height;
            //和前面的放一层
            for(int j=i-1;j>0;j--){
                width+=books[j-1][0];
                height=Math.max(books[j-1][1],height);

                if(width>shelf_width) break;
                dp[i]=Math.min(dp[i],dp[j-1]+height);
            }

        }
        return dp[books.length];
    }
}
