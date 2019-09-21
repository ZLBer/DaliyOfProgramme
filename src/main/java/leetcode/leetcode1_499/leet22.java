package leetcode.leetcode1_499;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/19.
 */
public class leet22 {


    //mine  递归
 static    public List<String> generateParenthesis(int n) {
List<String> result=new LinkedList<>();

recursion(0,n,result,"");


return result;
    }

   static void  recursion(int left,int n,List<String> result,String s){

   //递归到底
     if(n==0) result.add(s);

        if(left==0) {//不存在左括号，只能添加左括号
           recursion(left+1,n,result,s+"(");
           return;
       }
        if(left==n){ //唯一截止
            while (left-->0){
               s+=")";
            }
            result.add(s);
            return;
        }
        //加一个左括号
        recursion(left+1,n,result,s+"(");
       //加一个右括号
      recursion(left-1,n-1,result,s+")");

    }



    //和我的思路大致相同

   /* public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }


    public void backtrack(List<String> list, String str, int open, int close, int max){
        //递归到底
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max) //左括号
            backtrack(list, str+"(", open+1, close, max);
        if(close < open) //右括号
            backtrack(list, str+")", open, close+1, max);
    }*/


    public static void main(String[] args) {
        List<String >r=generateParenthesis(3);
        for(String s:r){
            System.out.println(s);
        }
    }
}
