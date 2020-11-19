package leetcode;

public class leet1631 {


    //Dijistra
  /*  public int minimumEffortPath(int[][] heights) {

        Queue<int []> queue=new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.add(new int[]{0,0,0});

        int res=Integer.MAX_VALUE;
        boolean[][]visited=new boolean[heights.length][heights[0].length];
     while (!queue.isEmpty()){
            int []point=queue.poll();
            if(point[0]==heights.length-1&&point[1]==heights[0].length-1){
                return point[2];
            }

           visited[point[0]][point[1]]=true;
             for (int i = 0; i < next.length; i++) {
                 int nx=point[0]+next[i][0];
                 int ny=point[1]+next[i][1];
                 if(nx>=0&&ny>=0&&nx<heights.length&&ny<heights[0].length&&!visited[nx][ny]){
                     int sub=Math.abs(heights[nx][ny]-heights[point[0]][point[1]]);
                    queue.add(new int[]{nx,ny,Math.max(point[2],sub)});
                 }
             }
     }

   //   helper(0,0,heights,new boolean[heights.length][heights[0].length]);
      return res;
    }
*/
     int [][]next=new int[][]{
            {0,1},{1,0},{0,-1},{-1,0}
    };


  //可以二分
    public int minimumEffortPath(int[][] heights) {
       int left=0,right=(int)1e9;
       while (left<right){
          int mid=(left+right)/2;
           System.out.println(mid);
         if(helper(0,0,heights,mid,new boolean[heights.length][heights[0].length])){
             right=mid;
             System.out.println(true);
         }else {
            left=mid+1;
         }
       }
       return left;
    }

    boolean helper(int x,int y,int [][]heights,int max,boolean[][]visited){

        if(x==heights.length-1&&y==heights[0].length-1){
            return true;
        }

        visited[x][y]=true;
        for (int i = 0; i < next.length; i++) {
            int nx=x+next[i][0];
            int ny=y+next[i][1];
            if(nx<0||nx>=heights.length||ny<0||ny>=heights[0].length||visited[nx][ny]||Math.abs(heights[nx][ny]-heights[x][y])>max) continue;
          if(helper(nx,ny,heights,max,visited)) return true;
        }
         return false;
    }


    //可以memo
   /* public int minimumEffortPath(int[][] heights) {
    Queue<int []> queue=new LinkedList<>();
     queue.add(new int[]{0,0,0,});
     int [][]memo=new int[heights.length][heights[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints,(int)1e9);
        }
    memo[0][0]=0;
      while (!queue.isEmpty()){
          int []point=queue.poll();
          for (int i = 0; i < next.length; i++) {
              int nx=point[0]+next[i][0];
              int ny=point[1]+next[i][1];
              if(nx<0||nx>=heights.length||ny<0||ny>=heights[0].length) continue;

              int sub=Math.max(point[2],Math.abs(heights[nx][ny]-heights[point[0]][point[1]]));

              if(sub>=memo[nx][ny]) continue;

              memo[nx][ny]=sub;
              queue.add(new int[]{nx,ny,sub});

          }
      }
      return  memo[heights.length-1][heights[0].length-1];
    }
*/


    public static void main(String[] args) {

    }
}
