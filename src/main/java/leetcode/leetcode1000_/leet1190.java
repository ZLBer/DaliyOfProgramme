package leetcode.leetcode1000_;

public class leet1190 {


    //读错题意  理解成对于嵌套括号的解法
/*  static   public String reverseParentheses(String s) {
        int before=0,last=s.length()-1;

        while (before<last){

            while (s.charAt(before)!='('&&s.charAt(before)!=')'&&before<last){
                before++;
            }
            while (s.charAt(last)!=')'&&s.charAt(last)!='('&&before<last){
           last--;
            }
        if(before<last){
            s=s.substring(0,before)+new StringBuilder(s.substring(before,last+1)).reverse().toString()+s.substring(last);
            before++;
            last--;
        }
        }
    return  s.replaceAll("\\(|\\)","");
    }*/


/*   static public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
       for(char c:s.toCharArray()){
       if(c==')'){
          List<Character> list=new ArrayList<>();
          while (!stack.isEmpty()&&stack.peek()!='(') list.add(stack.pop());
          if (!stack.isEmpty()) stack.pop();//把（弹出
          for(int i=0;i<list.size();i++){
              stack.push(list.get(i));
          }
       }else {
           stack.push(c);
       }
       }
       StringBuilder stringBuilder=new StringBuilder();
       while (!stack.isEmpty()) stringBuilder.append(stack.pop());
       return stringBuilder.reverse().toString();
    }*/

    //  递归
    public String reverseParentheses(String s) {
        int begin = 0;
        int end;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                begin = i;
            if(s.charAt(i) == ')'){
                end = i;
                String temp = s.substring(begin + 1, end);
                return reverseParentheses(s.substring(0, begin) + reverseString(temp) + s.substring(end + 1));
            }
        }
        return s;
    }


    String reverseString(String s){
        char[] temp = s.toCharArray();
        StringBuilder r = new StringBuilder();
        for (int i = temp.length-1; i>=0; i--)
            r.append(temp[i]);

        return r.toString();
    }

    public static void main(String[] args) {
      //  reverseParentheses("a(jkl(mno)p)q");
    }
}
