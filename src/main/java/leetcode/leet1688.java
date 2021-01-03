package leetcode;

public class leet1688 {

/*    public int numberOfMatches(int n) {
      int res=0;
        while (n>1){
      if(n%2==0){
         n/=2;
         res+=(n);
      }else {
          n=((n-1)/2)+1;
        res+=(n-1);
      }
      }
        return res;
    }*/


//一个冠军 每次必然淘汰一个
    public int numberOfMatches(int n) {
        return n-1;
    }


    public static void main(String[] args) {

    }
}
