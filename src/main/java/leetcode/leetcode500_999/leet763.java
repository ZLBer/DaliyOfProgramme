package leetcode.leetcode500_999;

import java.util.*;

/**
 * Created by libin on 2019/1/17.
 */
public class leet763 {
    //有点像蛮力法
/*    static public List<Integer> partitionLabels(String S) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < S.length(); ) {
            char a = S.charAt(i);//此范围首个字母
            int index = i;//序列中a字母的最大index
            Set<Character> set = new HashSet<>();
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(j) == a) index = j;
            }
        //添加此范围内的元素
            for (int j = i + 1; j < index; j++) {
                if (S.charAt(j) != a) set.add(S.charAt(j));
            }
            //设置a的最后索引
            int endIndex = index;
            for (int j = endIndex; j < S.length(); j++) {
                if (set.contains(S.charAt(j))) {
                    endIndex = j;
                    //继续添加不存在的元素
                    for(int c=index;c<=endIndex;c++){
                        set.add(S.charAt(c));
                    }

                }
            }
            result.add(endIndex - i + 1);
            i = endIndex + 1;
        }
        return result;
    }*/


//贪心法  ，最好的地方是last数组的计算
 static public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        //计算每个字母最后出现的位置
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;//用j来记录最大位置
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
       //遍历到最大位置 ，
            if (i == j) {
                ans.add(i - anchor + 1);
                //用anchor来记录此段的开始
                anchor = i + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        for (int a : partitionLabels("qiejxqfnqceocmy")) {
            System.out.println(a);
        }
    }
}
