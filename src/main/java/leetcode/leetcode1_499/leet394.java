package leetcode.leetcode1_499;

public class leet394 {
/*    static public String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        char []arr=s.toCharArray();
        for (int i = 0; i < arr.length; ) {
            char c=arr[i];
            if(c==']'){
                StringBuilder sb=new StringBuilder();
                while (!"[".equals(stack.peek())&&!Character.isDigit(stack.peek().charAt(0))){
                    sb.insert(0,stack.pop()+"");
                }
                //弹出[
                stack.pop();
                int size= Integer.parseInt(stack.pop());
                StringBuilder temp=new StringBuilder();
                while (size-->0){
                    temp.append(sb);
                }
                stack.push(temp.toString());
                i++;
            }else {
                StringBuilder t=new StringBuilder(c+"");
                i++;
                if(Character.isDigit(c)){
                    while (i<arr.length&&Character.isDigit(arr[i])) {
                        t.append(arr[i]);
                        i++;
                    }
                }

                stack.push(t.toString());
            }
        }
        StringBuilder result=new StringBuilder();
        // stack.forEach(s1 -> result.append(s1)); 效率为何如此低下？？原因应该是加锁了
        for (String s1 : stack) {
            result.append(s1);
        }
        return result.toString();
    }*/

    public static void main(String[] args) {
      //  decodeString("3[a2[c]]");
    }


   //DFS 还是很有想法的，不太好想

    //用于记录位置的全局指针
    private int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for (int i = pos; i < s.length(); i++) {
            //是字符就添加sb
            if (s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                //是数字就添加num
                num += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                //遇到[ 就进行DFS
                pos = i + 1;
                String next = decodeString(s);
                for (int n = Integer.valueOf(num); n > 0; n--) sb.append(next);
                num = "";
                //i更新到pos位置
                i = pos;
                //遇到]就返回
            } else if (s.charAt(i) == ']') {
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
