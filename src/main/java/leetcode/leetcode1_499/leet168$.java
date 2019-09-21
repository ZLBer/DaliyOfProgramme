package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/23.
 */
public class leet168$ {
   //将数字转化成26进制
//    public String convertToTitle(int n) {
//       StringBuilder sb=new StringBuilder();
//
//
//       if(n%26==0) {
//           while (n > 26) {
//
//               sb.append((char) (n / 27 - 1 + 'A'));
//               n /= 27;
//           }
//           return sb.reverse().toString();
//       }
//
//
//           while (n>26){
//
//           sb.append((char)(n%26-1+'A'));
//           n/=26;
//        }
//        sb.append((char) (n-1+'A'));
//
//        return sb.reverse().toString();
//    }

 //   Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z, and then here comes the base 26 representation, it's similar when you convert a number from base 10 to base 2
 public String convertToTitle(int n) {
     String res = "";
     while(n != 0) {
         char ch = (char)((n - 1) % 26 + 65);
         n = (n - 1) / 26;
         res = ch + res;
     }
     return res;
 }

   /* public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }*/
}
