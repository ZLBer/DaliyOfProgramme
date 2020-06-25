package leetcode._jianzhioffer;

public class p43 {
    public int countDigitOne(int n) {
      int high=n/10,low=0;
      int digit=1;

      int res=0;
      while (n>0){
       int there=n%10;
      if(there==0){
          res+=high*digit;
      }else if(there==1){
         res+=(high*digit)+1+low;
      }else {
          res+=(high+1)*digit;
      }

        n/=10;
       high/=10;
       low+=(there*digit);
          digit*=10;
      }

      return res;

    }
}
