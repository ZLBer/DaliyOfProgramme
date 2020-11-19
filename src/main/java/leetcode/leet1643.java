package leetcode;

public class leet1643 {

/*    class Point{
     int x;
     int y;
     String command;

        public Point(int x, int y, String command) {
            this.x = x;
            this.y = y;
            this.command = command;
        }
    }

    int count;
    String res;
    boolean dfs(int x,int y,int []destination,String command){

     if(x>destination[0]||y>destination[1]) return false;
        if(x==destination[0]&&y==destination[1]){
         count--;
         if(count==0){
             res=command;
             return true;
         }
        return false;

     }

      if(dfs(x,y+1,destination,command+"H")) return true;

      if(dfs(x+1,y,destination,command+"V")) return true;

      return false;

    }

    public String kthSmallestPath(int[] destination, int k) {
       count=k;
         dfs(0,0,destination,"");
        return res;
    }*/
//mine
  public String kthSmallestPath(int[] destination, int k) {
    String res="";
    int max=destination[0]+destination[1];
    int h=destination[1],v=destination[0];
    while (res.length()<max){
        //如果是H开头
        if(h>0){
            int left=(int)combination(h+v-1,h-1);
            if(k>left){
                k-=left;
                res+="V";
                v--;
            }else {
                res+="H";
                h--;
            }
        }else {
            res+="V";
            v--;
        }

    }
    return res;
}

    //组合数 Cnm   m>n
    static long combination(int m, int n) {
        int k = 1;
        long ans = 1;
        while (k <= n) {
            ans = ((m - k + 1) * ans) / k;
            k++;
        }
        return ans;

    }

}
