package leetcode._jianzhioffer;

public class p67 {
    public int strToInt(String str) {
      boolean positive=true;
      boolean set=false;
      int index=0;
      //处理头部
      while (index<str.length()&&(str.charAt(index)<'0'||str.charAt(index)>'9')){

        if(!set&&str.charAt(index)==' ') {
           index++;
           continue;
        }else {
           if(!set) {
               if (str.charAt(index) == '-') {
                   positive = false;
                   set = true;
               }
               else if (str.charAt(index) == '+') {
                   positive = true;
                   set = true;
               }else {
                   return 0;
               }
           }else {
               return 0;
           }

        }
       index++;
      }
      int pre=0;
      int res=0;
      while (index<str.length()){
           if(str.charAt(index)>='0'&&str.charAt(index)<='9'){
               pre=res;
              res*=10;
              res+=(str.charAt(index)-'0');
               if(pre!=res/10) {
                   if(positive) return Integer.MAX_VALUE;
                   else return Integer.MIN_VALUE;
               }
           }else{
             break;
           }
          System.out.println(pre+"  "+res);
          index++;

      }

     if(positive){
         return res;
     }else return -res;
    }
}
