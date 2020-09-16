package leetcode.leetcode1_499;

import java.util.*;

public class leet126 {
 static    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

     int[][]count=new int[wordList.size()][26];

 /*       for (int i = 0; i < wordList.size(); i++) {
            for (char c : wordList.get(i).toCharArray()) {
                count[i][c-'a']++;
            }
        }*/

        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                if(check(wordList.get(i),wordList.get(j))){
                   map.get(i).add(j);
                   map.get(j).add(i); //相互的
                }
            }
        }



        boolean end=false;

        List<List<String>> result=new ArrayList<>();
     Queue<List<Integer>> queue=new LinkedList<>();
        for (int i = 0; i < wordList.size(); i++) {


            if(check(beginWord,wordList.get(i))){
                queue.add(Arrays.asList(i));
                if(endWord.equals(wordList.get(i))){
                    end=true;
                    result.add(Arrays.asList(beginWord,endWord));
                }
            }
        }
       if(end) return result;


       boolean []visited=new boolean[wordList.size()];

      while (!queue.isEmpty()&&!end){
         int size= queue.size();
         while (size-->0){
            List<Integer> list=queue.poll();
            int index=list.get(list.size()-1);
            visited[index]=true;
            for(int next:map.get(index)){
                if(endWord.equals(wordList.get(next))){
                    end=true;
                   List<String> res=new ArrayList<>();
                   res.add(beginWord);
                    for (Integer in : list) {
                       res.add(wordList.get(in));
                    }
                   res.add(endWord);
                  result.add(res);
                }
               if(!visited[next])  {
                  List<Integer> nextList=new ArrayList<>(list);
                  nextList.add(next);
                   queue.add(nextList);
               }
            }
         }
      }
return result;
    }

    //检查只有一个不同
 static    boolean check(String a,String b){
        int count=0;
        for (int i = 0; i < a.length(); i++) {
          if(a.charAt(i)!=b.charAt(i)){
              if(count==1) return false;
              else count++;
          }
        }
        return count==1;
    }

    public static void main(String[] args) {
        findLadders("red",
                "tax",
                        Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));

        Deque<Integer>deque=new LinkedList<>();
        Deque<Integer> deque1=new ArrayDeque<>();

    }







}
