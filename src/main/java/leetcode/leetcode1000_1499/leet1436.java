package leetcode.leetcode1000_1499;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> from=new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
           from.add(paths.get(i).get(0));
        }
        for (int i = 0; i < paths.size(); i++) {
            if(!from.contains(paths.get(i).get(1))) return paths.get(i).get(1);
        }
        return "";
    }
}
