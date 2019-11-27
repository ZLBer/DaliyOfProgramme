package leetcode.leetcode1000_;

/**
 * Created by libin on 2019/4/23.
 */
public class leet1032 {

    //构造字典树
    public class TrieNode{
        boolean isend=false;
        TrieNode []next=new TrieNode[26];
    }
    TrieNode root =new TrieNode();
    StringBuilder buf =new StringBuilder();
int max=0;
    void insert(String word){
        TrieNode temp = root;
        for(int i=0;i<word.length();i++){
            //从后往前插入
            char c= word.charAt(word.length()-1-i);
            if(temp.next[c-'a']==null){
                temp.next[c-'a']=new TrieNode();
            }
            temp=temp.next[c-'a'];
        }
        temp.isend=true;
    }
    public leet1032(String[] words) {
      for (String  word:words){
     max=Math.max(max,word.length());
   insert(word);
      }
    }

    public boolean query(char letter) {

        if (buf.length() > max) { // Avoid TLE.
            buf.delete(max, buf.length());
        }
       buf.insert(0,letter);
       TrieNode trieNode=root;
       for (char c:buf.toString().toCharArray()){

           if(trieNode.next[c-'a']==null){
               return false;
           }
           if(trieNode.next[c-'a'].isend==true){
               return true;
           }
           trieNode=trieNode.next[c-'a'];
       }
       return false;
    }


}
