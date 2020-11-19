package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leet {
    public String printBin(double num) {

StringBuilder sb=new StringBuilder();
        double index=0.5;
       sb.append("0.");
        for (int i = 0; i < 32; i++) {
            if(num>=index){
               num-=index;
             sb.append("1");
            }else {
              sb.append("0");
            }
           if(num==0) return sb.toString();
           index/=2;
        }
     return "ERROR";
    }
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> set = new HashSet<>();
        for (int a : small) {
            set.add(a);
        }
        int res = Integer.MAX_VALUE;
        int[] arr =new int[0];
        Map<Integer, Integer> queues=new HashMap<>();
        Set<Integer> container = new HashSet<>();
        int j = 0;
        for (int i = 0; i < big.length; i++) {
            while (j < big.length && set.size() != container.size()) {
                if (set.contains(big[j])) {
                    container.add(big[j]);
                    queues.put(big[j],j);
                }
                j++;
            }
            if (container.size() == set.size()) {
                if (res > j - i) {
                    res = j - i;
                    arr = new int[]{i, j-1};
                }
            }

            if (container.contains(big[i])) {
                int index=queues.get(big[i]);
                if(index==i)  container.remove(big[i]);
            }

        } return arr;
    }


    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->a.length()==b.length()?a.compareTo(b):b.length()-a.length());
        for (int i = 0; i < words.length; i++) {
           if(check(words[i],i,words)) return words[i];
        }

        return "";
    }


    boolean check(String word ,int index,String []words){
        if("".equals(word)) return true;

        for (int i = 0; i < words.length; i++) {
           if (index==i) continue;;
            String s=words[i];
            if(word.startsWith(s)){
                if(check(word.substring(s.length(),word.length()),index,words))
                    return true;
            }

        }

        return false;
    }


    //就纯暴力吧..
 /*   public int[][] findContinuousSequence(int target) {
       List<List<Integer>> list = new ArrayList<>();
        int max=0;
       for(int i=(target+1)/2;i>=0;i--){
             List<Integer> temp=help(target,i);
           if(temp==null) continue;
           else {
              max=Math.max(max,temp.size());
           list.add(temp);
           }
        }

       int [][]res=new int[list.size()][max];
        for (int i = 0; i < res.length; i++) {
            List<Integer> integers = list.get(i);
            int []arr=new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                arr[arr.length-1-j]=integers.get(j);
            }
           res[res.length-1-i]=arr;
        }
        return res;
    }

    List<Integer> help(int taget,int i){
       List<Integer> list=new ArrayList<>();
       for(;i>=0;i--){
         taget-=i;
        list.add(i);
        if(taget==0) return list;
        if(taget<0) return null;
       }
       return null;
    }*/
/*
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int i = 1; i <= limit; ++i) {
            for (int j = i;; ++j) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }*/

    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2; //等差数列求和
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }


   /* public Node treeToDoublyList(Node root) {
        if(root==null) return null;
     helper(root);

     head.left=pre;
     pre.right=head;
     return head;
    }
    Node pre, head;
    void helper(Node cur){
      if(cur==null) return ;

      helper(cur.left);
      if(pre!=null) {
          pre.right=cur;
          cur.left=pre;
      }else {
          head=cur;
      }

      pre=cur;

      helper(cur.right);




    }*/


    public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }

}
