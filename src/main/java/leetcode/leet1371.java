package leetcode;


import java.util.HashMap;

public class leet1371 {

    //mine  bit+剪枝遍历
/*
    public int findTheLongestSubstring(String s) {
     char []vowels=new char[]{'a','e','i','o','u'};
     int []dp=new int[s.length()+1];
     dp[0]=0;
     for(int i=0;i<s.length();i++){
         char c=s.charAt(i);
         dp[i+1]=dp[i];
            for (int j = 0; j < vowels.length; j++) {
                if(vowels[j]==c){
                 //0偶数 1奇数
                  dp[i+1]=dp[i]^(1<<j);
                  break;
                }
            }
     }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Integer.toBinaryString(dp[i]));
        }

     int max=0;
     for(int i=0;i<s.length();i++){
         if(s.length()-i<=max) break;
         for(int j=s.length()-1;j>i;j--){
             if(j-i+1<=max) break;
             if((dp[j+1]^dp[i])==0) max=Math.max(max,j-i+1);
         }

     }
     return max;
    }
*/



    //可以只遍历一次
    //符合全是偶数的情况是00000 之前没意识到
/*    public int findTheLongestSubstring(String s) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int[] dp = new int[s.length() + 1];
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        map.put(0,-1); //很关键的一点 0是-1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dp[i + 1] = dp[i];
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == c) {
                    //0偶数 1奇数
                    dp[i + 1] = dp[i] ^ (1 << j);
                    break;
                }
            }
            map.putIfAbsent(dp[i+1],i);

            max=Math.max(max,i-map.get(dp[i+1]));
        }
        return max;
    }*/

    //放弃数组
        HashMap<Character, Integer> voewlToIndex = new HashMap<Character, Integer>() {
            {
                put('a', 0);
                put('e', 1);
                put('i', 2);
                put('o', 3);
                put('u', 4);
            }
        };
        public int findTheLongestSubstring(String s) {
            HashMap<Integer, Integer> stateToIndex = new HashMap<>();
            stateToIndex.put(0, -1);
            int state = 0, maxLen = 0;
            for(int i = 0; i < s.length(); ++i) {
                char cur = s.charAt(i);
                if(voewlToIndex.containsKey(cur)) {
                    // flip the digits of the state. 1-> 0 or 0 -> 1
                    int digit = voewlToIndex.get(cur); // ideally we can do only one lookup.
                    state ^= (1 << digit);
                }

                stateToIndex.putIfAbsent(state, i);
                maxLen = Math.max(maxLen, i - stateToIndex.get(state));
            }

            return maxLen;

        }

}
