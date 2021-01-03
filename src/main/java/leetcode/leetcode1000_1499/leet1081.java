package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1081 {
    //题目都理解不了  太难受了
/*   static public String smallestSubsequence(String text) {
        char[] arr = text.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            //we have seen this char
            if (seen.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            // if the top char is larger than current char, we should remove it
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 1) {
                char temp = stack.pop();
                map.put(temp, map.get(temp) - 1);
                seen.remove(temp);
            }
            stack.push(c);
            seen.add(c);
        }

        StringBuilder sb = new StringBuilder();
        //while (!stack.isEmpty()) sb.insert(0, stack.pop());
        //return sb.toString();


        //credit to @yz5548
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }*/


    public String smallestSubsequence(String s) {
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
       // smallestSubsequence("cdadabcc");
    }
}
