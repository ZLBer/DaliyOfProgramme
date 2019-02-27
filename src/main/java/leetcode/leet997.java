package leetcode;

/**
 * Created by libin on 2019/2/27.
 */
public class leet997 {

    //mine
    public int findJudge(int N, int[][] trust) {
     int []count=new int[N];
     int [] flag=new int[N];
        for (int []t:trust){
              flag[t[0]-1]=1;
              count[t[1]-1]++;
        }
for(int i=0;i<N;i++){
     if(count[i]==N-1&&flag[i]==0) return i+1;
    }
return -1;
   }

  //思路相同  但是更简洁
  /*  public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }*/
}
