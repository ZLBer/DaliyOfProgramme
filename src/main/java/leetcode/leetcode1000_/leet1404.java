package leetcode.leetcode1000_;

public class leet1404 {
/*
    //错误 s太长了
    public int numSteps(String s) {
      int num=Integer.parseInt(s,2);
        System.out.println(num);
      int res=0;
      while (num!=1){
          res++;
          if(num%2==1){
              num++;
          }else {
              num/=2;
          }
      }
      return res;
    }*/

    //mine 当作字符串
   /* public int numSteps(String s) {
        int res=0;
       while (s.length()>1){
           res++;
           //奇数 加一
           if(s.charAt(s.length()-1)=='1'){
               s=addOne(s);
           }else {//偶数右移
               s=s.substring(0,s.length()-1);
           }
       }
       return res;
    }

    String addOne(String s){
        char []chars=s.toCharArray();
        chars[s.length()-1]='0';
        boolean flag=true;
        for (int i = chars.length - 2; i >= 0; i--) {
          if(chars[i]=='0'){ //如果收0就结束
         flag=false;
         chars[i]='1';
         break;
          }else {
              chars[i]='0';//把1转成0
          }
        }

        if(flag){
            return "1"+new String(chars);
        }else {
            return new String(chars);
        }
    }*/



    //其实只需要一趟变历
    public int numSteps(String s) {
        int res=0;
        int carry=0;
        //0位一定是1 只需要看carry即可
        //四种情况看 0 0 carry不变，1 1 carry不变，0 1 需要走两步，1，0  carry=1 需要走两步
        for(int i=s.length()-1;i>=0;i++){
            res++;
            if(s.charAt(i)-'0'+carry==1){
                carry=1;
                res++;
            }

        }
        return carry+res;
    }
}
