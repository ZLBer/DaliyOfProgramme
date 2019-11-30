package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet8 {

    //mine 需要判断很多情况，简直智障啊
  static   public int myAtoi(String str) {
        long res = 0;
        str = str.trim();
        if(str.length()==0) return 0;
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && !Character.isDigit(str.charAt(0))) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean minus = false;
        int i = 0;
//判断正负
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                minus = false;
                break;
            }
            if (str.charAt(i) == '-') {
                if(i+1>=str.length()) return 0;
                if(!Character.isDigit(str.charAt(i+1))) return 0;
                minus = true;
                break;
            }
            if(str.charAt(i)=='+'){

                if(i+1>=str.length()||(!Character.isDigit(str.charAt(i+1))))
                return 0;
            }
        }
        if(minus) i++;
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') queue.offer(str.charAt(i) - '0');
else break;
        }
        while (!queue.isEmpty()) {
            res = (res * 10 + queue.poll());
          if(res>Integer.MAX_VALUE){
              if(minus) return Integer.MIN_VALUE;
          else return Integer.MAX_VALUE;
          }
        }


        return minus?-(int)res:(int )res;
    }

    public static void main(String[] args) {
        myAtoi("-6147483648");
    }
}
