package leetcode.leetcode500_999;

import java.util.*;

public class leet792 {
    //mine 暴力看能过吗
    //加了个set可以过了
  /*  public int numMatchingSubseq(String S, String[] words) {
        int res=0;
        Set<String> set=new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String s=words[i];
            if(set.contains(s)){
                res++;
                continue;
            }
            int p1=0,p2=0;
            while (p1<S.length()&&p2<s.length()){
                if(S.charAt(p1)==s.charAt(p2)){
                    p1++;
                    p2++;
                }else {
                    p1++;
                }

            }
            if(p2>=s.length()) {
                res++;
                set.add(s);
            }
        }
        return res;
    }*/

    // mine
    /*public int numMatchingSubseq(String S, String[] words) {
        int []index=new int[words.length];
        for(char c:S.toCharArray()){
            for (int i = 0; i < words.length; i++) {
                if(index[i]<words[i].length()&&c==words[i].charAt(index[i])){
                    index[i]++;
                }
            }
        }
        int res=0;
        for (int i = 0; i < words.length; i++) {
            if(index[i]>=words[i].length()) res++;
        }
        return res;
    }*/

    //看提示自己写算法  把需要匹配的放到不同的桶中
    //ArrayList比linkedList快
    public int numMatchingSubseq(String S, String[] words) {
        List<Node>[] list=new List[26];
        for (int i = 0; i < list.length; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            list[words[i].charAt(0)-'a'].add(new Node(words[i],0));
        }

        int res=0;
        for (char c : S.toCharArray()) {
            List<Node> temp=list[c-'a'];
            list[c-'a']=new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                Node node=temp.get(i);
                if(node.index==node.word.length()-1) {
                    res++;
                    continue;
                }
                list[node.word.charAt(node.index+1)-'a'].add(new Node(node.word,node.index+1));
            }
        }
        return res;
    }

    class Node{
        String word;
        int index;

        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }

    }

}
