package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leet1268 {

    //关键点：每个节点维护一个最大长度为3的队列
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      List<List<String>> res=new ArrayList<>();
      Trie root=new Trie();
    for(String product:products){
        Trie t=root;
        for(char c:product.toCharArray()){
          if(t.sub[c-'a']==null)
              t.sub[c-'a']=new Trie();
          t=t.sub[c-'a'];
          t.suggestion.add(product);
          Collections.sort(t.suggestion);
          if(t.suggestion.size()>3)
              t.suggestion.pollLast();
        }
    }

     Trie node=root;
    for(char c:searchWord.toCharArray()){
        if(node==null){
            res.add(new ArrayList<>());continue;
        }
        node=node.sub[c-'a'];
        if(node!=null){
            res.add(node.suggestion);
        }else {
            res.add(new ArrayList<>());
        }
    }

      return res;
    }

    class Trie{
            Trie[] sub = new Trie[26];
            LinkedList<String> suggestion = new LinkedList<>();
    }
}
