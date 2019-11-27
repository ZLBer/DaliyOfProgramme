package leetcode.leetcode1000_;

import java.util.*;

public class leet1255 {
    //爆炸 这个hard也不hard 就一个DFS的事，就怪第二个耽误太多时间
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
      Map<Character, PriorityQueue<Integer>> map=new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            if(map.containsKey(letters[i])) {
                map.get(letters[i]).add(score[letters[i]-'a']);
            }else {
                PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
                priorityQueue.add(score[letters[i]-'a']);
                map.put(letters[i],priorityQueue);
            }
        }

DFS(map,0,words,0);

return  max;
    }
    int max=0;
    void  DFS(Map<Character, PriorityQueue<Integer>> map,int deep,String[]words,int value){
        if(deep>=words.length){
            max=Math.max(max,value);
            return;
        }
        char[] chars=words[deep].toCharArray();
        if(check(chars,map)) {
            //System.out.println("test");
            int tempValue=value;
            List<kv> list=new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                int v=map.get(chars[i]).poll();
                tempValue+=v;
                list.add(new kv(chars[i],v));
            }
           DFS(map,deep+1,words,tempValue);
           //回溯
            for (int i = 0; i < list.size(); i++) {
                map.get(list.get(i).key).add(list.get(i).value);
            } 
        }
        DFS(map,deep+1,words,value);
    }

    boolean check(char []chars,Map<Character, PriorityQueue<Integer>> map){
        int []count=new int[26];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]-'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i]>map.getOrDefault((char)(i+'a'),new PriorityQueue<>()).size()) return false;
        }

        return true;
    }
    class kv{
        kv(Character key,int value){
            this.key=key;
            this.value=value;
        }
        Character key;
        int value;

    }


 //其实回溯起来都是差不多的
  /*  public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0) return 0;
        int[] count = new int[score.length];
        for (char ch : letters) {
            count[ch - 'a']++;
        }
        int res = backtrack(words, count, score, 0);
        return res;
    }
    int backtrack(String[] words, int[] count, int[] score, int index) {
        int max = 0;
        for (int i = index; i < words.length; i++) {
            int res = 0;
            boolean isValid = true;
            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']--;
                res += score[ch - 'a'];
                if (count[ch - 'a'] < 0) isValid = false;
            }
            if (isValid) {
                res += backtrack(words, count, score, i + 1);
                max = Math.max(res, max);
            }
            //回溯
            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']++;
                res = 0;
            }
        }
        return max;
    }*/
/* public int maxScoreWords(String[] words, char[] letters, int[] score) {
     int[] memo = new int[26];
     for (char l : letters) {
         memo[l - 'a']++;
     }
     int n = words.length;
     return dfs(0, memo, score, words);
 }
    int dfs(int index, int[] memo, int[] score, String[] words) {
        if (index == words.length) {
            return 0;
        }
        int res = 0;
        String w = words[index];
        int count = 0;
        int i = 0;
        int[] temp = Arrays.copyOf(memo, memo.length);
        for (; i < w.length(); i++) {
            char c = w.charAt(i);
            if (temp[c - 'a'] > 0) {
                temp[c - 'a']--;
                count += score[c - 'a'];
            } else {
                break;
            }
        }
        //检查是否可以全部装下，若果有就选这个word
        if (i == w.length()) {
            res = Math.max(res, count + dfs(index + 1, temp, score, words));
        }
        //不选这个word
        res = Math.max(dfs(index + 1, memo, score, words), res);
        return res;
    }*/


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue.poll());
    }
}
