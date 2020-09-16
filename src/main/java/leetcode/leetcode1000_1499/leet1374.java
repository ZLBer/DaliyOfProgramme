package leetcode.leetcode1000_1499;

public class leet1374 {
    //mine搞不懂这题有什么意义
    public String generateTheString(int n) {
     StringBuilder stringBuilder=new StringBuilder();
     if(n%2==0){
         n--;
         while (n-->0){
             stringBuilder.append('a');
         }
         stringBuilder.append('b');
     }else {
         while (n-->0){
             stringBuilder.append('a');
         }
     }
     return stringBuilder.toString();
    }

    //简约一点
   /* public String generateTheString(int n) {
        char[] strArr = new char[n];
        Arrays.fill(strArr, 'a');
        if(n % 2 == 0) {
            strArr[n - 1] = 'b';
        }
        return String.valueOf(strArr);
    }*/
}
