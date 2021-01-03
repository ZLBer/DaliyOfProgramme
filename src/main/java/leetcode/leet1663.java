package leetcode;

public class leet1663 {

    public String getSmallestString(int n, int k) {


        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= n; i++) {
           int max=(n-i)*26;
           // System.out.println(max+" "+k);
          if(max>=k){
           sb.append("a");
           k-=1;
          }else {
            sb.append((char)('a'+k-max-1));
             k-=(k-max);
          }
        }
        return sb.toString();
    }
}
