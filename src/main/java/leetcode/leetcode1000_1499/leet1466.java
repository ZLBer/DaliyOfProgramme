package leetcode.leetcode1000_1499;

public class leet1466 {
 /* static   public int minReorder(int n, int[][] connections) {
      Map<Integer, List<Integer>> map=new HashMap<>();
        Map<Integer, List<Integer>> map2=new HashMap<>();
        for (int[] connection : connections) {
            if(!map.containsKey(connection[1])) map.put(connection[1],new ArrayList<>());
            map.get(connection[1]).add(connection[0]);
         if(!map2.containsKey(connection[0])) map2.put(connection[0],new ArrayList<>());
         map2.get(connection[0]).add(connection[1]);
        }

        Queue <Integer> queue=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
       queue.add(0);
       Set<Integer> set=new HashSet<>();
      int res=0;//需要改变的线路
      while (set.size()<n){

          if(queue.isEmpty()){
           while (!queue2.isEmpty()) {
             int a=queue2.poll();
               for (Integer to : map2.getOrDefault(a,new ArrayList<>())) {
                 if(set.contains(to)) continue;
                 res++;
                 queue.add(to);
               } 
           }
          }
          int pos=queue.poll();
          queue2.add(pos);
          set.add(pos);
          for (Integer from : map.getOrDefault(pos,new ArrayList<>())) {
              queue.add(from);
          }
      }
      return res;
    }
*/


    //比较直接的方法  直接bfs就行  遇到不合适的就自增
 /*   public int minReorder(int n, int[][] cs) {
        Set<String> st = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] c : cs) {
            st.add(c[0] + "," + c[1]);
            map.computeIfAbsent(c[0], k -> new HashSet<>());
            map.computeIfAbsent(c[1], k -> new HashSet<>());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int res = 0;
        boolean[] vs = new boolean[n];
        vs[0] = true;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int next : map.getOrDefault(c, new HashSet<>())) {
                if (vs[next]) continue;
                vs[next] = true;
                if (!st.contains(next + "," + c)) res++;
                q.offer(next);
            }
        }
        return res;
    }
*/
    //了不起的改变  符号和正号
   /* int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (var to : al.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }*/

    public static void main(String[] args) {
     //   minReorder(4,new int[][]{{0,1},{2,0},{3,2}});
    }
}
