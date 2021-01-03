package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leet316 {
  static   public String removeDuplicateLetters(String s) {
        int []count=new int[26];
        for (int i = 0; i < s.length(); i++) {
         count[s.charAt(i)-'a']++;
        }

        Deque<Integer>deque=new LinkedList<>();
        boolean []vis=new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            int num=c-'a';
         while (!deque.isEmpty()&&!vis[num]&&count[deque.peekLast()]>=1&&num<deque.peekLast()){
             vis[deque.pollLast()]=false;

         }
         count[num]--;
       if(!vis[num]){
           deque.addLast(num);

           vis[num]=true;
       }


        }

        StringBuilder sb=new StringBuilder();
        for (Integer integer : deque) {
             sb.append(((char)(integer+'a')));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        removeDuplicateLetters("abacb");
    }
}
