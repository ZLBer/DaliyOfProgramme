package leetcode._jianzhioffer;

public class p46 {
    //mine dp
    public int translateNum(int num) {
     String s=num+"";
    int []dp=new int[s.length()+1];
   dp[0]=1;
  for(int index=1;index<=s.length();index++){
       dp[index]+=dp[index-1];
       if(index-2>=0&&s.charAt(index-2)!='0'&&Integer.parseInt(s.substring(index-2,index))<=25){
       dp[index]+=dp[index-2];
     }
   }
   return dp[dp.length-1];
    }

    //递归
/*    public int translateNum(int num) {
        if(num<=9) return 1;
      int xy=num%100;
     if(xy>=10&&xy<26){
         return translateNum(num/10)+translateNum(num/100);
     }else {
         return translateNum(num/10);
     }
    }*/

 //此种动态规划更好
/*    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }*/

}
