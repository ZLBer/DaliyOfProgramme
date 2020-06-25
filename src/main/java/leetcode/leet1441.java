package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int inedx=1;
        for (int i = 0; i < target.length; i++) {
            while (target[i]!=inedx){
                res.add("Push");
                res.add("Pop");
                inedx++;
            }
            res.add("Push");
            inedx++;
        }
        return res;

    }
}
