package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet648 {

    //mine hashset
 /*   public String replaceWords(List<String> dict, String sentence) {
        Set<String> set=new HashSet<>();
        for (String s : dict) {
             set.add(s);
        }
        String []words=sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for(int j=0;j<words[i].length();j++) {
                String temp=words[i].substring(0, j);
                if (set.contains(temp)) {
                    words[i] = temp;
                    break;
                }
            }
        }
          StringBuilder sb=new StringBuilder();
        for (int i = 0; i < words.length-1; i++) {
            sb.append(words[i]+" ");
        }
        sb.append(words[words.length-1]);
        return sb.toString();
        }*/
  //Tire  字典树
  public class TrieNode {
      char val;
      TrieNode[] children;
      boolean isWord;

      public TrieNode(char val) {
          this.val = val;
          this.children = new TrieNode[26];
          this.isWord = false;
      }
  }

    private TrieNode buildTrie(List<String> dict) {

      TrieNode root=new TrieNode(' ');

      for(String word :dict){
          TrieNode temp=root;
           for(char c:word.toCharArray()){
               if(temp.children[c-'a']==null)
                   temp.children[c-'a']=new TrieNode(c);
               temp=temp.children[c-'a'];
           }
           temp.isWord=true;
      }
      return root;
    }

    private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                //是个单词就返回
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                //继续往下寻找
                temp = temp.children[c - 'a'];
                //找不到子串了
            } else {
                return token;
            }
        }
        return token;
    }
    public String replaceWords(List<String> dict, String sentence) {
      TrieNode root=buildTrie(dict);
      String [] words=sentence.split(" ");
      StringBuilder sb=new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            words[i]=getShortestReplacement(words[i],root);
        }
        for (int i = 0; i < words.length-1; i++) {
            sb.append(words[i]+" ");
        }
        sb.append(words[words.length-1]);
        return sb.toString();
    }

}
