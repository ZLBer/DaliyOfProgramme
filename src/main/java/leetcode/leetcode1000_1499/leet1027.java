package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libin on 2019/4/16.
 */
public class leet1027 {
    //mine Time Limit Exceeded
  /*static   public int longestArithSeqLength(int[] A) {

      int result=Integer.MIN_VALUE;
        List<Map<Integer,Integer>> list=new LinkedList<>();
        list.add(new HashMap<>());
        for (int i = 1; i < A.length; i++) {
            Map<Integer,Integer> mapi= new HashMap<>();
             for(int j=i-1;j>=0;j--){
                 int diff=A[i]-A[j];
                 Map<Integer,Integer> mapj=list.get(j);
                 int d=mapj.getOrDefault(diff,0)+1;
                 int d2=mapi.getOrDefault(diff,0);
                 mapi.put(diff,Math.max(d2,d));
                 result=Math.max(d,result);
             }

             list.add(mapi);
        }



        return result+1;
    }*/
//mine   第二版本  list换成数组
    static   public int longestArithSeqLength(int[] A) {

        int result=Integer.MIN_VALUE;
        Map<Integer,Integer>[] list=new Map[A.length];
        list[0]=new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            Map<Integer,Integer> mapi= new HashMap<>();
            for(int j=i-1;j>=0;j--){
                int diff=A[i]-A[j];
                Map<Integer,Integer> mapj=list[j];
                int d=mapj.getOrDefault(diff,0)+1;
                //此处需要注意，防止把更大的值覆盖了
                int d2=mapi.getOrDefault(diff,0);
                mapi.put(diff,Math.max(d2,d));
                result=Math.max(d,result);
            }
            list[i]=mapi;
        }



        return result+1;
    }

   /* public int longestArithSeqLength(int[] A) {
        if (A.length <= 1) return A.length;

        int longest = 0;

        // Declare a dp array that is an array of hashmaps.
        // The map for each index maintains an element of the form-
        //   (difference, length of max chain ending at that index with that difference).
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];

        for (int i = 0; i < A.length; ++i) {
            // Initialize the map.
            dp[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 1; i < A.length; ++i) {
            int x = A[i];
            // Iterate over values to the left of i.
            for (int j = 0; j < i; ++j) {
                int y = A[j];
                int d = x - y;

                // We at least have a minimum chain length of 2 now,
                // given that (A[j], A[i]) with the difference d,
                // by default forms a chain of length 2.
                int len = 2;

                if (dp[j].containsKey(d)) {
                    // At index j, if we had already seen a difference d,
                    // then potentially, we can add A[i] to the same chain
                    // and extend it by length 1.
                    len = dp[j].get(d) + 1;
                }

                // Obtain the maximum chain length already seen so far at index i
                // for the given differene d;
                int curr = dp[i].getOrDefault(d, 0);

                // Update the max chain length for difference d at index i.
                dp[i].put(d, Math.max(curr, len));

                // Update the global max.
                longest = Math.max(longest, dp[i].get(d));
            }
        }

        return longest;
    }*/


    //Time Limit Exceeded
//dp的key存储diff，map存储index和count
/*    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int res = 2;
        for (int i = 0; i < A.length; i++) {
            //从该节点往后遍历，
            for (int j = i + 1; j < A.length; j++) {
                Map<Integer, Integer> m = dp.computeIfAbsent(A[j] - A[i], d -> new HashMap<>());
                int count=m.getOrDefault(i, 1) + 1;
                m.put(j,count );
                res = Math.max(res, count);
            }
        }
        return res;
    }*/


    public static void main(String[] args) {
        longestArithSeqLength(new int[]{3,6,9,12});
    }
}
