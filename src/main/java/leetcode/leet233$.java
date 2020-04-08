package leetcode;

public class leet233$ {
    public int countDigitOne(int n) {

        int count=0;
        for(long k=1;k<=n;k*=10){
            long xyzd=n/k;
            long abc=n%k;
            long d=xyzd%10;
            long xyz=xyzd/10;
           count+=(xyz)*k;
           if(d==1){
              count+=abc+1;
           }
           if(d>1){
               count+=k;
           }
            System.out.println(count);
        }
        return count;
    }
}
