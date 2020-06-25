package leetcode;

import java.math.BigInteger;

public class leet306 {

    //理解错了   但可以是另外一题目
/*   static public boolean isAdditiveNumber(String num) {
  return helper(num,0,0,0);
    }

   static boolean helper(String num,int preSum,int index,int count){
        if(index>=num.length()&&count==0) return true;
        if(count==2) {
          int can=checkCanSum(preSum,num,index);
          if(can>0){
              if(helper(num,0,index+can,0))  return true;
          }else {
              return false;
          }
       }else {
            for(int i=1;index+i<num.length();i++){
                 int n=Integer.parseInt(num.substring(index,index+i));
             if(helper(num,preSum+n,index+i,count+1)) return true;
            }
        }
        return false;
    }

  static   int  checkCanSum(int preSum,String num,int index){
        int preIndex=index;
       StringBuilder sb=new StringBuilder();
       int len=(preSum+"").length();
       while (index<num.length()){
         sb.append(num.charAt(index++));
        if(preSum==Integer.parseInt(sb.toString())) return index-preIndex;
        if(sb.length()>=len+2) return -1;
       }
       return -1;
    }*/


        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 1; i <= n / 2; ++i) {  //先找出第一个和第二个数字
                if (num.charAt(0) == '0' && i > 1) return false;
                BigInteger x1 = new BigInteger(num.substring(0, i));
                for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                    if (num.charAt(i) == '0' && j > 1) break;
                    BigInteger x2 = new BigInteger(num.substring(i, i + j));
                    if (isValid(x1, x2, j + i, num)) return true;  //递归求解
                }
            }
            return false;
        }
        private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
            if (start == num.length()) return true;
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            String sum = x2.toString();
            return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
        }



    public static void main(String[] args) {
    }
}
