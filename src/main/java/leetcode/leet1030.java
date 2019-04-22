package leetcode;



import java.util.*;

/**
 * Created by libin on 2019/4/22.
 */
public class leet1030 {

    //mine 利用TreeMap天生自带排序的功能
  /*  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {


        Map<Integer,List<int []>> map = new TreeMap<>();
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
               int distance=Math.abs(r-r0)+Math.abs(c-c0);
               if(!map.containsKey(distance)){
                   map.put(distance,new ArrayList());
               }
               map.get(distance).add(new int[]{r,c});
            }
        }
        int temp=0;
        int[][] ressult= new int[R*C][2];
        Iterator<Map.Entry<Integer, List<int[]>>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, List<int[]>> entry = entries.next();

            for(int []a:entry.getValue()){
                ressult[temp++]=a;
            }

        }

        return ressult;
    }*/


    //BFS,  并不比treemap快多少
   /* public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
       Queue<int []> queue=new LinkedList<>();
       boolean[][]visited=new boolean[R][C];
       queue.offer(new int[]{r0,c0});
        int[][] result=new int[R*C][2];
        int index=0;
       while (!queue.isEmpty()){
           int []a=queue.poll();
           int r=a[0],c=a[1];
           if(r<0||r>=R||c<0||c>=C||visited[r][c]){
               continue;
           }
           result[index++]=a;
        visited[r][c]=true;
           queue.offer(new int[]{r-1,c});
           queue.offer(new int[]{r+1,c});
           queue.offer(new int[]{r,c-1});
           queue.offer(new int[]{r,c+1});


       }
       return result;
    }*/
    //用计数排序 是真的nice
   static public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
           int[] counter = new int[R + C + 1];
           for (int r = 0; r < R; r++) {
               for (int c = 0; c < C; c++) {
                   int dist = Math.abs(r - r0) + Math.abs(c - c0);
                   counter[dist ] += 1;
               }
           }

           for (int i = 1; i < counter.length; i++) {
               counter[i] += counter[i - 1];
           }

           int[][] ans = new int[R * C][];
           for (int r = 0; r < R; r++) {
               for (int c = 0; c < C; c++) {
                   int dist = Math.abs(r - r0) + Math.abs(c - c0);
                   ans[counter[dist]-1] = new int[] { r, c };
                   counter[dist]--;
               }
           }

           return ans;
       }


    public static void main(String[] args) {
        allCellsDistOrder(2,2,0,1);
    }
}
