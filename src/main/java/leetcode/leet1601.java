package leetcode;

public class leet1601 {

    //contest
/*    public int maximumRequests(int n, int[][] requests) {
      int m=requests.length;
      int mask=(1<<m)-1;

      int res=0;
     for(int i=mask;i>=1;i--){
        // System.out.println(i);
       int []from=new int[n],to=new int[n];
       int k=1;
       for(int j=0;j<m;j++){

         k=(1<<j);
        // System.out.println(Integer.toBinaryString(k));
        if((i&k)==k){
         from[requests[j][0]]++;
         to[requests[j][1]]++;
        }
       }
      if(check(from,to)){
res=Math.max(res, Integer.bitCount(i));
     //     System.out.println(res+"  "+i+" ");
      }
     }
     return res;
    }
    
    boolean check(int []from,int []to){
        for (int i = 0; i < from.length; i++) {
            if(from[i]!=to[i]) return false;
        }
        return true;
    }*/

   //mine  代码优化一下

    public int maximumRequests(int n, int[][] requests) {
        int m=requests.length;
        int mask=(1<<m)-1;

        int res=0;
        for(int i=mask;i>=1;i--){
            int k=i;
            int []from=new int[n],to=new int[n];
            int index=0;
            while (k>0){
            if((k&1)==1){
              from[requests[index][0]]++;
              to[requests[index][1]]++;
            }
                k>>=1;index++;
            }
            if(check(from,to)){
                res=Math.max(res, Integer.bitCount(i));
            }
        }
        return res;
    }
    boolean check(int []from,int []to){
        for (int i = 0; i < from.length; i++) {
            if(from[i]!=to[i]) return false;
        }
        return true;
    }
}
