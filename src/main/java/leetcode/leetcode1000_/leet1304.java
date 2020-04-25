package leetcode.leetcode1000_;

public class leet1304 {
    //mine contest
    public int[] sumZero(int n) {
    int []res=new int[n];
    int count=n/2;
    int index=0;
    if(n%2!=0){
       res[index++]=0;
    }
  for(int i=1;i<=count;i++){
      res[index++]=i;
      res[index++]=-i;
  }

    return res;
    }


    //就这样人家都比你写的好
    //找规律
/*    public int[] sumZero(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = i * 2 - n + 1;
        return A;
    }*/

}
