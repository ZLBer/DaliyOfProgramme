package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.List;

public class leet1286 {

    //mine contest
    //先生成所有的 然后按需查找
    class CombinationIterator {
        int index=0;
        public CombinationIterator(String characters, int combinationLength) {
        DFS(characters,"",0,0,combinationLength);
        }

        public String next() {
           return res.get(index++);
        }

        public boolean hasNext() {
          return index<res.size();
        }
        List<String> res=new ArrayList<>();
        void DFS(String characters,String cur,int deep,int count,int combinationLength){
            if(count==combinationLength){
                res.add(cur);
                return;
            }
          if(deep>=characters.length()) return;
            DFS(characters,cur+characters.charAt(deep),deep+1,count+1,combinationLength);
            DFS(characters,cur,deep+1,count,combinationLength);
        }
    }


}
