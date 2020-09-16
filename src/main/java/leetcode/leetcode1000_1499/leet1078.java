package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result=new ArrayList<>();
        String[] sum= text.split(" ");
        for (int i = 1; i < sum.length; i++) {
             if(sum[i].equals(second)&&sum[i-1].equals(first)&&i+1<sum.length){
                    result.add(sum[i+1]);
             }
        }
        return result.toArray(new String[result.size()]);
    }
}
