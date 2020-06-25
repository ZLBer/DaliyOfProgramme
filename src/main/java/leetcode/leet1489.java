package leetcode;

import java.util.*;

public class leet1489 {

    //遍历PriorityQueue的方式是不对的
    /*public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        PriorityQueue<int[]> priority = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < edges.length; i++) {
            priority.add(new int[]{edges[i][0],edges[i][1],edges[i][2],i});
        }


        UnionFind unionFind = new UnionFind(n);
        int minCost = 0;
        for (int[] edge : priority) {
            int indexFrom = unionFind.find(edge[0]), indexTo = unionFind.find(edge[1]);
            if (indexFrom == indexTo) continue;
            else {
                unionFind.union(edge[0], edge[1]);
                minCost += edge[2];
            }
        }
       //先找到minCost
       System.out.println(minCost);
   List<Integer> critical=new ArrayList<>(),nocritical=new ArrayList<>();


       //一次查看每一条边
        for (int i = 0; i < priority.size(); i++) {
            unionFind=new UnionFind(n);
            int tempCost=0;
            for (int[] edge : priority) {
              if(edge[3]==i) continue;//排除该条边
                int indexFrom = unionFind.find(edge[0]), indexTo = unionFind.find(edge[1]);
                if (indexFrom == indexTo) continue;
                else {
                    unionFind.union(edge[0], edge[1]);
                    tempCost += edge[2];
                }
            }
            System.out.println(i+"  "+tempCost+"  "+unionFind.count);
           if(tempCost>minCost||unionFind.count!=1) {   //cost变大，一定是关键边
               critical.add(i);
           }
           else{  //判断是不是关键边/直接不在MST里

               tempCost=0;
               unionFind=new UnionFind(n);//保证一定有这条边
               unionFind.union(edges[i][0],edges[i][1]);
               tempCost+=edges[i][2];
               for (int[] edge : priority) {

                   int indexFrom = unionFind.find(edge[0]), indexTo = unionFind.find(edge[1]);
                   if (indexFrom == indexTo) continue;
                   else {
                       unionFind.union(edge[0], edge[1]);
                       tempCost += edge[2];
                   }
               }

               if(tempCost==minCost) nocritical.add(i);

           }
        }    

        List<List<Integer>> res=new ArrayList<>();
        res.add(critical);res.add(nocritical);
        return res;
    }*/

/*
    class UnionFind{
       int []arr;
       int count;
     public UnionFind(int size){
      arr=new int[size];
         for (int i = 0; i < arr.length; i++) {
             arr[i]=i;
         }
         count=size;
     }
     void union(int a,int b){
       int indexA=find(a),indexB=find(b);
      if(indexA==indexB) return;
      arr[indexB]=indexA;
      count--;

     }
     int find(int a){
      return arr[a]==a?a:find(arr[a]);
     }
    }*/



   class UnionFind{
        final int[] parents;
        int count;

        public UnionFind(int n){
            this.parents = new int[n];
            reset();
        }

        public void reset(){
            for(int i =0;i<parents.length;i++){
                parents[i] = i;
            }
            count = parents.length;
        }

        public int find(int i){
            int parent = parents[i];
            if(parent == i){
                return i;
            }else{
                int root = find(parent);
                parents[i] = root;
                return root;
            }
        }

        public boolean union(int i, int j){
            int r1 = find(i);
            int r2 = find(j);
            if(r1 != r2){
                count--;
                parents[r1] = r2;
                return true;
            }else{
                return false;
            }
        }

    }
  //主要思想：先kruskal求最小生成树，得到最小路径和
    //然后遍历每一条边 ，去掉这条边，求最小路径
    //若最小路径变大了或者构不成树，则这一定是一条关键路径
    //若没变，有两种可能：可能不在MST里，可能是非关键路径
    //这时候就需要强制把这条边当作MST的路径，看看求出来的路径和变大了则这不是一条MST的路径，不变则是非关键路径
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

            List<Integer>criticals = new ArrayList<>();
            List<Integer> pseduos = new ArrayList<>();

            Map<int[], Integer> map = new HashMap<>();
            for(int i =0;i<edges.length;i++){
                map.put(edges[i], i);
            }

            Arrays.sort(edges, (e1, e2)->Integer.compare(e1[2], e2[2]));
            int minCost = buildMST(n, edges, null, null);
            for(int i =0;i<edges.length;i++){
                int[] edge = edges[i];
                int index = map.get(edge);
                int costWithout = buildMST(n, edges, null, edge);
                if(costWithout > minCost){
                    criticals.add(index);
                }else{
                    int costWith = buildMST(n, edges, edge, null);
                    if(costWith == minCost){
                        pseduos.add(index);
                    }
                }

            }

            return Arrays.asList(criticals, pseduos);
        }

        private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
            UnionFind uf = new UnionFind(n);
            int cost = 0;
            if(pick != null){
                uf.union(pick[0], pick[1]);
                cost += pick[2];
            }

            for(int[] edge : edges){
                if(edge != skip && uf.union(edge[0], edge[1])){
                    cost += edge[2];
                }
            }
            return uf.count == 1? cost : Integer.MAX_VALUE;
        }

}
