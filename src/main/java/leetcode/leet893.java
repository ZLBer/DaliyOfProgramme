package leetcode;

import java.util.HashSet;

/**
 * Created by libin on 2019/1/6.
 */
public class leet893 {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> re=new HashSet<>();
        for(String s:A){
            re.add(s);
        }
        return  re.size();


    }
}
