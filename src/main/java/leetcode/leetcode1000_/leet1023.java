package leetcode.leetcode1000_;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/28.
 */
public class leet1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> result= new LinkedList<>();
        char []paterns= pattern.toCharArray();
        for (int i = 0; i < queries.length; i++) {
           result.add(isMatch(queries[i].toCharArray(),paterns));
        }

        return result;
    }

   boolean isMatch(char [] querys,char [] patterns){
        int index =0 ;

       for (int i = 0; i < querys.length; i++) {
           if(index<patterns.length&&querys[i]==patterns[index]){
               index++;
           }else if (querys[i]>='a'&&querys[i]<='z'){
               continue;
           }
           else return false;
       }


       if(index==patterns.length) return  true;
       else return false;
   }

   //用正则表达式做
   /* public List<Boolean> camelMatch(String[] queries, String pattern) {
        String newPattern = "[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*";
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) { ans.add(q.matches(newPattern)); }
        return ans;
    }*/
    //正则+流

    /*public List<Boolean> camelMatch(String[] queries, String pattern) {
        String newPattern = "[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*";
        return Arrays.stream(queries).map(q -> q.matches(newPattern)).collect(Collectors.toList());
    }*/
}
