package leetcode.leetcode1000_1499;

public class leet1147$ {


    //递归
/*

public int longestDecomposition(String text) {
      int n=text.length();

      for(int i=0;i<n/2;i++){
          if(text.substring(0,i+1).equals(text.substring(n-i-1,n))){
              return 2+longestDecomposition(text.substring(i+1,n-i-1));
          }
      }

      return  n==0?0:1;
    }

    */

   // bf
  /*  public int longestDecomposition(String S) {
     String l="";
     String r="";
      int res=0;
     for(int i=0;i<S.length()/2;i++){
         l=l+S.charAt(i);
         r=S.charAt(S.length()-i-1)+r;

         if (l.equals(r)) {
            l="";
            r="";
            res+=2;
         }

     }
return (!"".equals(l)||S.length()%2==1)?res+1:res;
    }*/

    //sb版本
    public int longestDecomposition(String S) {
        StringBuilder l=new StringBuilder();
        StringBuilder r=new StringBuilder();
        int res=0;
        for(int i=0;i<S.length()/2;i++){
            l.append(S.charAt(i));
            r.insert(0,S.charAt(S.length()-i-1));
            if (l.toString().equals(r.toString())) {
                l=new StringBuilder();
                r=new StringBuilder();
                res+=2;
            }

        }
        return (!"".equals(l.toString())||S.length()%2==1)?res+1:res;
    }
}
