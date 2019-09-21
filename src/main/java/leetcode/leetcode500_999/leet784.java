package leetcode.leetcode500_999;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libin on 2019/1/29.
 */
public class leet784 {

    //mine 递归法/DFS  直接用String做
    List<String> result=new LinkedList<>();
    public List<String> letterCasePermutation(String S) {

helper(S,"",0);

            return result;
    }
    void  helper(String S,String append,int index){
        if(index==S.length()) {
            result.add(append);
            return;
        }

        if(S.charAt(index)>64) {
            Character s;
            helper(S,append+S.toUpperCase().charAt(index),index+1);
            helper(S,append+S.toLowerCase().charAt(index),index+1);
        }
        else  helper(S,append+S.charAt(index),index+1);

    }




    //转成char数组然后DFS
   /* public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }

    */


  //BFS就是直接遍历
  /*  public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        //每一个字母都改
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            //把队列里的每一个都改
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }*/
}
