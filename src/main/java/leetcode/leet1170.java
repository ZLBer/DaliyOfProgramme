package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class leet1170 {
/*    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int [] fw=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            fw[i]=fs(words[i]);
        }

        int []result=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
              int query=fs(queries[i]);

            for (int j = 0; j < fw.length; j++) {
                 if(query<fw[j]) result[i]++;
            }
        }
return  result;
    }*/

/*    int fs(String s){
        TreeMap<Character,Integer> map=new TreeMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map.firstEntry().getValue());
        return map.firstEntry().getValue();
    }*/

    public static int fs(String s) {
        int[] seen = new int[26];
        for (char c : s.toCharArray()) {
            seen[c - 'a']++;
        }
        int freq = 0;
        for (int i = 0; i < 26; i++) {
            if (seen[i] > 0) {
                freq = seen[i];
                break;
            }
        }
        return freq;
    }


    //改成二分搜索
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int [] fw=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            fw[i]=fs(words[i]);
        }
        Arrays.sort(fw);

        int []result=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query=fs(queries[i]);

            int left=0,right=fw.length-1;
            while (left<=right){
                int mid=(left+right)/2;
                if(fw[mid]<=query)
                    left=mid+1;
                else
                    right=mid-1;

            }
            result[i]=fw.length-left;
        }
        return  result;
    }
}
