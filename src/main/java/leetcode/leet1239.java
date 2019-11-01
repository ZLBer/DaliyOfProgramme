package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1239 {
    //参加contest的版本
/*    public int maxLength(List<String> arr) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int temp=0;
            boolean flag=true;
          for(char c: arr.get(i).toCharArray()){
              int sc=1<<(c-'a');
              if((temp&sc)==0) temp|=sc;
              else  {
                  flag=false;
                  break;
              }
          }
          if(flag){
          list.add(temp);
          }
        }

        helper(list,0,0,0);
        return max;
    }
    int max=0;
    void helper(List<Integer> list,int deep,int pre,int count){
        max=Math.max(max,count);
          if(deep>=list.size()) {
              return;
          }

          if((pre&list.get(deep))>0) {
              //不加
              helper(list,deep+1,pre,count);
          }
       else {
              int temp = (pre | list.get(deep));
              //加
              helper(list, deep + 1, temp, count + Integer.bitCount(list.get(deep)));
              //不加
              helper(list, deep + 1, pre, count);
          }
    }*/



     //自己改进版 2.0
/*    public int maxLength(List<String> arr) {
        List<Integer> list=new ArrayList<>();
        // 1.translate letter to bit, such as: abc->111 .Also skip the word that have duplicate letter
        for (int i = 0; i < arr.size(); i++) {
            int temp=0;
            boolean flag=true;
            for(char c: arr.get(i).toCharArray()){
                int sc=1<<(c-'a');
                if((temp&sc)==0) temp|=sc;
                else  {
                    flag=false;
                    break;
                }
            }
            if(flag){
                list.add(temp);
            }
        }
      // 2. DFS
        helper(list,0,0,0);
        return max;
    }
    int max=0;
    void helper(List<Integer> list,int deep,int pre,int count){
        max=Math.max(max,count);
        if(deep>=list.size()) {
            return;
        }
        // skip this deep
        helper(list,deep+1,pre,count);
        //if list.get(deep)) is not have the same letter with pre,we can take it.
        if((pre&list.get(deep))==0) {
            int temp = (pre | list.get(deep));
            helper(list, deep + 1, temp, count + Integer.bitCount(list.get(deep)));
        }

    }*/
    //自己改进版 3.0
    public int maxLength(List<String> arr) {
        List<Integer> list=new ArrayList<>();
        // 1.translate letter to bit, such as: abc->111 .Also skip the word that have duplicate letter
        for (int i = 0; i < arr.size(); i++) {
            int temp=0;
            boolean flag=true;
            for(char c: arr.get(i).toCharArray()){
                int sc=1<<(c-'a');
                if((temp&sc)==0) temp|=sc;
                else  {
                    flag=false;
                    break;
                }
            }
            if(flag){
                list.add(temp);
            }
        }
        // 2. DFS
        helper(list,0,0);
        return max;
    }
    int max=0;
    void helper(List<Integer> list,int deep,int pre) {
        max = Math.max(max, Integer.bitCount(pre));
        if (deep >= list.size()) {
            return;
        }
        // skip this deep
        helper(list, deep + 1, pre);
        //if this deep is not have the same letter with pre,we can take it.
        if ((pre & list.get(deep)) == 0) {
            int temp = (pre | list.get(deep));
            helper(list, deep + 1, temp);
        }
    }


    //另一种DFS
  /*  private int result = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }

        if (idx == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }*/


  //bit遍历版本
/*    public int maxLength(List<String> A) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : A) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }*/
}
