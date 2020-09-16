package leetcode;

import java.util.HashMap;
import java.util.HashSet;
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
}
