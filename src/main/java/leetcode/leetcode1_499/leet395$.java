package leetcode.leetcode1_499;

public class leet395$ {

    //mine 失败 错误的解法
  /*  public int longestSubstring(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        char []arr=s.toCharArray();
     for(char c:arr){
         map.put(c,map.getOrDefault(c,0)+1);
     }
        int left=0,right=0;
     int []count=new int[26];
     int res=0;
     while (right<arr.length){
         if(map.get(arr[right])>=k){
             count[arr[right]-'a']++;
         }else {
             while (left<=right){
                 if(check(count,k)) res=Math.maxSum(res,right-left);
                 count[arr[left]-'a']--;
                 left++;
             }
             left++;
         }
         right++;
     }
        if(check(count,k)) res=Math.maxSum(res,right-left);
     return res;
     }
     boolean check(int []count,int k){
         for (int i = 0; i < count.length; i++) {
             if(count[i]>0&&count[i]<k) return false;
         }
         return true;
     }
*/

     //关键点在于合理的划分问题 一个字母、两个字母...就能合理的解决处理很多情况
    public int longestSubstring(String s, int k) {
        int d = 0;

        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

        return d;
    }
     //关键在于保存两个变量
    private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[128];
        int numUnique = 0; // 表示不同字母的数目
        int numNoLessThanK = 0; // 表示次数不少于k字母的数目
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) numUnique++; // increment map[c] after this statement
            if (map[s.charAt(end++)] == k) numNoLessThanK++; // inc end after this statement

            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
                if (map[s.charAt(begin++)] == 0) numUnique--; // inc begin after this statement
            }

            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update maxSum
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
                d = Math.max(end - begin, d);
        }

        return d;
    }


    //tql  关键在于把用不合适的字母把字符串分成多个部分
/*    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str,0,s.length(),k);
    }
    private int helper(char[] str, int start, int end,  int k){
        if (end - start < k) return 0;//substring length shorter than k.
        int[] count = new int [26];
        for (int i = start; i<end; i++) {
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for (int i=0; i<26; i++) {
            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
                for (int j = start; j<end; j++) {
                    if (str[j] == i+'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j+1, end, k);
                        return Math.maxSum(left, right);
                    }
                }
            }
        }
        return end - start;
    }*/
}
