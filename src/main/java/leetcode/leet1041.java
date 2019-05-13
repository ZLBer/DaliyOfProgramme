package leetcode;

public class leet1041 {
    //mine
    public boolean isRobotBounded(String instructions) {
      int [][]order={
              {0,1},{-1,0},{0,-1},{1,0}
      };
      int ord=0;
      int[] dist=new int[]{0,0};
    for(char c:(instructions+instructions+instructions+instructions).toCharArray()){
        if(ord==4){
            ord=0;
        }else if(ord==-1){
            ord=3;
        }
        if(c=='G'){
           dist[0]+=order[ord][0];
           dist[1]+=order[ord][1];
        }else if(c=='L') ord++;
        else if(c=='R') ord--;

    }
    if(dist[0]==0&&dist[1]==0){
        return true;
    }
    else return false;
    }

    //大佬的做法   执行完指令后若不是北方向则一定可以回到原来的位置
  /*  public boolean isRobotBounded(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }*/
}
