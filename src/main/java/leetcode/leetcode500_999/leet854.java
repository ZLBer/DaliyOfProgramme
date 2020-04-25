package leetcode.leetcode500_999;

import java.util.HashMap;
import java.util.Map;

public class leet854 {

    //mine 想法不对
 /* static   public int kSimilarity(String A, String B) {
       Map<String,Integer> map=new HashMap<>();
      int res=0;
        for(int i=0;i<A.length();i++){
            char a=A.charAt(i),b=B.charAt(i);
             if(a==b) continue;
             else {
                 if(map.containsKey(a+""+b+"")){
                     res++;
                     int val=map.get(a+""+b+"")-1;
                     if(val==0){
                         map.remove(a+""+b+"");
                     }else {
                         map.put(a+""+b+"",val);
                     }

                 }else {
                     map.put(b+""+a+"",map.getOrDefault(b+""+a+"",0)+1);
                 }
             }
        }

        int count=0;
        for(int c:map.values()){
            count+=Math.abs(c);
        }
        if(count>0) count--;
        return res+count;
            }*/



 /*   public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> vis= new HashSet<>();
        Queue<String> q= new LinkedList<>();
        q.add(A);
        vis.add(A);
        int res=0;
        while(!q.isEmpty()){
            res++;
            for (int sz=q.size(); sz>0; sz--){
                String s= q.poll();
                int i=0;
                while (s.charAt(i)==B.charAt(i)) i++;
                for (int j=i+1; j<s.length(); j++){
                    if (s.charAt(j)==B.charAt(j) || s.charAt(j)!=B.charAt(i) ) continue;
                    String temp= swap(s, i, j);
                    if (temp.equals(B)) return res;
                    if (vis.add(temp)) q.add(temp);
                }
            }
        }
        return res;
    }
    public String swap(String s, int i, int j){
        char[] ca=s.toCharArray();
        char temp=ca[i];
        ca[i]=ca[j];
        ca[j]=temp;
        return new String(ca);
    }


    //根据上面的思路自己写一遍
    public int kSimilarity(String A, String B) {
  if(A.equals(B)) return 0;
        Queue<String> queue=new LinkedList<>();
        Set<String> set=new HashSet<>();
        set.add(A);
        queue.add(A);
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();

          res++;
          while (size-->0) {
              String s = queue.poll();
              int i = 0;
              while (s.charAt(i) == B.charAt(i)) i++;
              for (int j = i + 1; j < s.length(); j++) {
                  if (s.charAt(j) == B.charAt(j) || s.charAt(j) != B.charAt(i)) continue;
                  String tem = swap(s, i, j);
                  if (tem.equals(B)) return res;
                  if (set.add(tem)) queue.add(tem);
              }
          }
        }
        return -1;
    }*/


   //回溯法 其实和上面的思路差不多
    public int kSimilarity(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        return backtrack(A.toCharArray(), B, map, 0);
    }
    private int backtrack(char[] A, String B, Map<String, Integer> map, int i) {
        String sa = new String(A);
        if (sa.equals(B)) {
            return 0;
        }
        //记忆搜索
        if (map.containsKey(sa)) {
            return map.get(sa);
        }
        int min = Integer.MAX_VALUE;
        while (i < A.length && A[i] == B.charAt(i)) {
            i++;
        }
        //从下一个开始求最小
        for (int j = i + 1; j < B.length(); j++) {
            // 找到可以交换的
            if (A[j] == B.charAt(i)) {
               //交换
                swap(A, i, j);
                //取消一个搜索
                int next = backtrack(A, B, map, i + 1);
                if (next != Integer.MAX_VALUE) {
                    //求最小值next+1
                    min = Math.min(min, next + 1);
                }
                //回溯
                swap(A, i, j);
            }
        }
        //记录
        map.put(sa, min);
        return min;
    }
    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
       // kSimilarity("bccaba","abacbc");
    }
}
