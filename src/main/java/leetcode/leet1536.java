package leetcode;

public class leet1536 {
  //写成另一个题目了..已提交给力扣官方
   /*     public int minSwaps(int[][] grid) {

            Map<Integer, List<Integer>> map=new HashMap<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j]==1){
                        if(!map.containsKey(j)){
                            map.put(j,new ArrayList<>());
                        }
                        map.get(j).add(i);
                    }
                }
            }
            if(map.size()!=grid[0].length) return -1;//提前剪枝

            dfs(new boolean[grid.length],grid,0,map,0);
            return min==Integer.MAX_VALUE?-1:min;

        }

        int min= Integer.MAX_VALUE;
        void dfs(boolean[]visited,int [][]grid,int step,Map<Integer, List<Integer>> map,int cost){
            if(step>=grid.length){
                min=Math.min(min,cost);
                return;
            }

            for (Integer row : map.get(step)) {
                if(visited[row]) continue;
                visited[row]=true;
                int cos=comulate(visited,step,row);
                dfs(visited,grid,step+1,map,cost+cos);
                visited[row]=false;
            }
        }
        //把row换到step的花费
        int comulate(boolean []visited,int step,int row){
            int res=0;
            for (int i = row; i >=0; i--) {
                if(!visited[i]) res++;
            }
            return res;
        }*/


   //mine
    public int minSwaps(int[][] grid) {
        //统计后置0的个数
        int[] zero=new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int res=0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(grid[i][j]==0) res++;
                else break;
            }
          zero[i]=res;
        }
       boolean[]visited=new boolean[grid.length];
        int res=0;
        for (int i = 0; i < grid.length; i++) {
           int hope=grid.length-i-1;
           boolean flag=false;
            for(int j=0;j<grid.length;j++){
             if(!visited[j]&&zero[j]>=hope){
                visited[j]=true;
           res+=comulate(visited,j);
           flag=true;
           break;
             }
          }
           if(!flag) return -1; //没有合适的了
        }
       return res;
    }
    int comulate(boolean []visited,int row){
        int res=0;
        for (int i = row; i >=0; i--) {
            if(!visited[i]) res++;
        }
        return res;
    }

  //看着比较正儿八经的做法
/*
    public int minSwaps(int[][] grid) {
        int n = grid.length, res=0;
        List<Integer> row = new LinkedList<>();
        for (int i=0; i<n; i++){
            int trailingZeroCnt=0;
            for (int j=n-1; j>-1 && grid[i][j]==0; j--) trailingZeroCnt++;
            row.add(trailingZeroCnt);
        }
        for (int curRowIdx=0, minTrailingZeros=n-1; curRowIdx<n; curRowIdx++, minTrailingZeros--){
            int satisfiedRowIdx =curRowIdx;
            while (satisfiedRowIdx <n && row.get(satisfiedRowIdx)<minTrailingZeros) satisfiedRowIdx++;
            if (satisfiedRowIdx ==n) return -1;
            int toRemove = row.remove(satisfiedRowIdx);
            row.add(curRowIdx, toRemove);
            res+=satisfiedRowIdx -curRowIdx;
        }
        return res;
    }
*/
    public static void main(String[] args) {
       /* minSwaps(new int[][]{
                {0,0,1},{1,1,0},{1,0,0}
        });*/
    }
}
