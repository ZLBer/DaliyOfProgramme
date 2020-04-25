package leetcode.leetcode1_499;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class leet227 {
    //mine 就是入栈出栈 先筛选乘除，然后筛选加减
/*   static public int calculate(String s) {
       Stack<String> stack=new Stack<>();
       s=s.trim();
       if(s.charAt(0)<='9'&&s.charAt(0)>='0')
           stack.add("+");
       int index=0;
       boolean canMul=false;
       boolean canDiv=false;
       while (index<s.length()){
           char c=s.charAt(index++);
           switch (c){
               case ' ':continue;
               case '+':;
               case '-':{ stack.push(c+"");break;}
               case '*':{canMul=true;break;}
               case '/':{canDiv=true;break;}
               default:{
                   String num=c+"";
                   while (index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
                       num+=s.charAt(index++);
                   }
                   if(canMul){
                      stack.push(Integer.valueOf(stack.pop())*Integer.valueOf(num)+"");
                       canMul=false;
                   }else if(canDiv){
                       stack.push(Integer.valueOf(stack.pop())/Integer.valueOf(num)+"");
                       canDiv=false;
                   }
                   else {
                       stack.push(num);
                   }

               }
           }
       }
       int res=0;
       while (!stack.isEmpty()){
           int num=Integer.valueOf(stack.pop());
           String operator=stack.pop();
           if("+".equals(operator)){
               res+=num;
           }
           else {
               res-=num;
           }
       }
       return res;
    }*/


    //自己来优化  提升不是很明显，那就是算法问题了
    static public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        s=s.trim();
        if(s.charAt(0)<='9'&&s.charAt(0)>='0')
            stack.add(0);//0表示+ 1表示-
        int index=0;
        boolean canMul=false;
        boolean canDiv=false;
        while (index<s.length()){
            char c=s.charAt(index++);
            switch (c){
                case ' ':continue;
                case '+':;{ stack.push(0);break;}
                case '-':{ stack.push(1);break;}
                case '*':{canMul=true;break;}
                case '/':{canDiv=true;break;}
                default:{
                    String num=c+"";
                    while (index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
                        num+=s.charAt(index++);
                    }
                    if(canMul){
                        stack.push(stack.pop()*Integer.valueOf(num));
                        canMul=false;
                    }else if(canDiv){
                        stack.push(stack.pop()/Integer.valueOf(num));
                        canDiv=false;
                    }
                    else {
                        stack.push(Integer.valueOf(num));
                    }

                }
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            int num=Integer.valueOf(stack.pop());
            int operator=stack.pop();
            if(operator==0){
                res+=num;
            }
            else {
                res-=num;
            }
        }
        return res;
    }


  //别人的  感觉想法差不多，但又比自己的好  sign是上一个符号
  /*  public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            //计算数字
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            //若是碰到符号
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
*/
//进一步可以不需要栈  每次都进行计算就行了
 /*   public int calculate(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
                switch(lastSign) {
                    case '+':
                        sum+=tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum+=tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                lastSign = c;
                num=0;
            }
        }
        sum+=tempSum;
        return sum;
    }*/
    public static void main(String[] args) {
       // calculate( " 3/2 ");
        ExecutorService executorService= Executors.newSingleThreadExecutor();
    }
}
