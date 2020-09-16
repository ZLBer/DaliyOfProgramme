package leetcode.leetcode1000_1499;

public class leet1209 {
    //mine 两个栈  一个统计次数，一个统计字符
 /*   public String removeDuplicates(String s, int k) {
        Stack<Character> charstack=new Stack<>();
        Stack<Integer> countStack=new Stack<>();
         charstack.push(s.charAt(0));
         countStack.push(1);
     for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(!charstack.isEmpty()&&c==charstack.peek()){
                charstack.push(c);
                countStack.push(countStack.peek()+1);
            }else {
                charstack.push(c);
                countStack.push(1);
            }

            if(countStack.peek()==k){
            int count= countStack.peek();
            while (count-->0){
                charstack.pop();
                countStack.pop();
            }
            }
        }


        StringBuilder sb=new StringBuilder();
     while (!charstack.isEmpty()){
         sb.append(charstack.pop());
     }
        return sb.reverse().toString();
    }*/



 //把count和char封装成类
/*    public String removeDuplicates(String s, int k) {
        Stack<Adjacent> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == x) {
                stack.peek().freq++;
            } else {
                stack.push(new Adjacent(x, 1));
            }
            if (stack.peek().freq == k) {
                stack.pop();
            }
        }

        // Convert stack to string
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            Adjacent peek = stack.peek();
            for (int i = 0; i < peek.freq; i++) {
                builder.append(peek.ch);
            }
            stack.pop();
        }
        return builder.reverse().toString();
    }

    class Adjacent {
        char ch;
        int freq;

        public Adjacent(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }*/


      //用数组模拟栈确实会更快
    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = (i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1);
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }
}
