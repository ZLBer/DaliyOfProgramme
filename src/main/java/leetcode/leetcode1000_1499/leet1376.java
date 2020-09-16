package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1376 {
    //mine bfs+逐级更新time
    //力扣的判题好像出问题了
     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i],new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        Queue<Integer>queue=new LinkedList<>();
        queue.add(headID);

        int res=0;
        while (!queue.isEmpty()){
         int size=queue.size();
            System.out.println(queue.peek());
         while (size-->0){
             int boss=queue.poll();
             if(!map.containsKey(boss)) continue;
             for(int worker:map.get(boss)){
                 informTime[worker]+=informTime[boss];
                queue.add(worker);
                res=Math.max(informTime[worker],res);
             }
         }
        }
     System.out.println(res);
        return res;
    }




    //dfs
/*    public int numOfMinutes(final int n, final int headID, final int[] manager, final int[] informTime) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        int total = 0;
        for (int i = 0; i < manager.length; i++) {
            int j = manager[i];
            if (!graph.containsKey(j))
                graph.put(j, new ArrayList<>());
            graph.get(j).add(i);
        }
        return dfs(graph, informTime, headID);
    }

    private int dfs(final Map<Integer, List<Integer>> graph, final int[] informTime, final int cur) {
        int maxSum = 0;
        if (!graph.containsKey(cur))
            return maxSum;
        for (int i = 0; i < graph.get(cur).size(); i++)
            maxSum = Math.maxSum(maxSum, dfs(graph, informTime, graph.get(cur).get(i)));
        return maxSum + informTime[cur];
    }*/


//虽然重复搜索很多，但可以说是十分简约了  就从下往上搜索
  /*  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //最终结果
        int res = 0;

        for(int i =0;i<manager.length;i++){
            //判断是否为结束点，剪枝
            if(informTime[i]==0){
                //临时值
                int temp = 0;
                int index=i;
                //向上遍历
                while(index!=-1){
                    temp+=informTime[index];
                    index=manager[index];
                }
                res = Math.maxSum(res,temp);
            }
        }
        return res;
    }*/

    public static void main(String[] args) {
    // numOfMinutes(7,6,new int[]{1,2,3,4,5,6,-1},new int[]{0,6,5,4,3,2,1});
    }
}
