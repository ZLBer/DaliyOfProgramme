package leetcode.leetcode1000_;

public class leet1208 {

    //mine
/*    public int equalSubstring(String s, String t, int maxCost) {
        int costs[]=new  int[s.length()];
        for (int i = 0; i < costs.length; i++) {
             costs[i]=Math.abs(s.charAt(i)-t.charAt(i));
            System.out.println(costs[i]);
        }


        int result=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            int j=i;
            int cost=0;
            while (j<s.length()&&cost<=maxCost){
                cost+=costs[j];
                j++;
                count++;
            }
            if(j==s.length()&&cost<=maxCost) break;
            result=Math.max(result,count-1);
            count=0;
        }
        result=Math.max(result,count);

        return result;
    }*/


    //滑动窗口
  /*  public int equalSubstring(String s, String t, int maxCost) {
         int i=0,j=0;
         for(;j<s.length();j++){
             maxCost-=Math.abs(s.charAt(j)-t.charAt(j));
             if(maxCost<0) {
                 maxCost += Math.abs(s.charAt(i) - t.charAt(i));
                 i++;
             }
         }

         return j-i;
    }*/

 //另一种容易理解的滑动窗口
    public int equalSubstring(String s, String t, int maxCost) {
        // Convert the problem into a min subarray problem
        char[] sc=s.toCharArray();
        char[] tc=t.toCharArray();
        int[] diff = new int[s.length()];
        for(int i = 0; i < s.length(); ++i) {
            diff[i] = Math.abs(sc[i] - tc[i]);
        }

        // Now find the longest subarray <= maxCost
        // all diff[i] >= 0 (non-negative)

        // Use sliding window?
        int maxLen = 0;
        int curCost = 0;
        int start = 0;

        for(int end = 0; end < diff.length; ++end) {
            curCost += diff[end];
            while(curCost > maxCost) {
                curCost -= diff[start];
                ++start;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
