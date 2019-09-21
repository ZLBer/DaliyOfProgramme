package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/17.
 */
public class leet537 {
    public String complexNumberMultiply(String a, String b) {
        String []A=a.split("\\+");
        String []B=b.split("\\+");
        int a1=Integer.parseInt(A[0]);
        int b1=Integer.parseInt(B[0]);


         int a2=Integer.parseInt(A[1].replace("i",""));
         int b2=Integer.parseInt(B[1].replace("i",""));

         int  a1b1=a1*b1;
         int   a2b2=-a2*b2;


         String  i=a1*b2+a2*b1+"i";
         return  (a1b1+a2b2)+"+"+i;
    }
}
