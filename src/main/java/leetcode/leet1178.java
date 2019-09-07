package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;

public class leet1178 {


    //Time Limit Exceeded  9/10
/*   static public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        boolean[][] helper=new boolean[puzzles.length][26];
        for (int i = 0; i < puzzles.length; i++) {
            for(char c:puzzles[i].toCharArray()){
                helper[i][c-'a']=true;
            }
        }

        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int count=0;

            for (int j = 0; j <words.length; j++) {
                //word not contains the first letter of puzzle
                if(words[j].contains(puzzles[i].charAt(0)+"")==false) continue;
                boolean flag=true;
                for(char c:words[j].toCharArray()){
                    if(helper[i][c-'a']==false) {
                      flag=false;
                        break;
                    }
                }
                if(flag) count++;

            }
            result.add(count);
        }
        return result;
    }*/


//改成bit操作依然是tle
 /*   public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
       Map<Integer,Integer> map=new HashMap<>();

       for(String w:words){
           int mask=0;
           for(char c:w.toCharArray()){
                    mask|=1<<(c-'a');
           }
           if (Integer.bitCount(mask) > 7) {
               continue;
           }
           map.put(mask,map.getOrDefault(mask,0)+1);
       }

  List<Integer> result=new ArrayList<>();
       for(String  p:puzzles){
            int first=1<<p.charAt(0)-'a';
             int mask=0;
            for(char c:p.toCharArray()) {
                mask|=1<<c-'a';
            }

            int count=0;

            for(int key:map.keySet()){
                if((key&mask)==key&&(key&first)==first)
                    count+=map.get(key);
            }
            result.add(count);

       }
       return result;
    }*/

//把字母存起来，方便查找第一个字母  省去了遍历所有的时间
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
         Map <Integer,Integer> map=new ConcurrentHashMap<>();
         map.size();
    for (int i = 0; i < 26; i++) {
            memo.put(i, new ArrayList<>());
        }
        for (String word : words) {
            int temp = 0;
            for (char c : word.toCharArray()) {
                temp = temp | (1 << (c - 'a'));
            }
            for (int i = 0; i < 26; i++) {
                if ((temp & (1 << i)) != 0) {
                    memo.get(i).add(temp);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String p : puzzles) {
            int temp = 0;
            for (char c : p.toCharArray()) {
                temp = temp | (1 << (c - 'a'));
            }
            int c = p.charAt(0) - 'a';
            int count = 0;
            for (int key : memo.get(c)) {
                if ((key & temp) == key) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
    public static void main(String[] args) {
 //       findNumOfValidWords(new String[]{"aaaa"},new String[]{"aboveyz"});
    }
}
