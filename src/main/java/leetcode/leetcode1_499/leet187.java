package leetcode.leetcode1_499;

import java.util.*;

import java.util.List;

public class leet187 {
    //直接法
/*    public List<String> findRepeatedDnaSequences(String s) {
    Set<String> set=new HashSet<>();
    Set<String> res=new HashSet<>();
        for (int i = 0; i < s.length()-9; i++) {
           String t=s.substring(i,i+10);
           if(set.contains(t)) res.add(t);
           set.add(t);
         }
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};

    }*/




    //就是以4为基数进行次方运算
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();

        // rolling hash parameters: base a
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

        int h = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute hash of the current sequence in O(1) time
            if (start != 0)
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];
                // compute hash of the first sequence in O(L) time
            else
                for(int i = 0; i < L; ++i) h = h * a + nums[i];
            // update output and hashset of seen sequences
            if (seen.contains(h)) output.add(s.substring(start, start + L));
            seen.add(h);
        }
        return new ArrayList<String>(output);
    }


  //映射成 00 01 10 11
//处理高位有技巧
/*    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();

        // rolling hash parameters: base a
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

        int bitmask = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute bitmask of the current sequence in O(1) time
            if (start != 0) {
                // left shift to free the last 2 bit
                bitmask <<= 2;
                // add a new 2-bits number in the last two bits
                bitmask |= nums[start + L - 1];
                // unset first two bits: 2L-bit and (2L + 1)-bit
                bitmask &= ~(3 << 2 * L);
            }
            // compute hash of the first sequence in O(L) time
            else {
                for(int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            // update output and hashset of seen sequences
            if (seen.contains(bitmask)) output.add(s.substring(start, start + L));
            seen.add(bitmask);
        }
        return new ArrayList<String>(output);
        }*/
}
