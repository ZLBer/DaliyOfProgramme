package leetcode;

import java.util.*;

public class leet1233 {

    //mine 遍历set
/*
    public List<String> removeSubfolders(String[] folder) {
         Arrays.sort(folder);
        Set<String> set=new HashSet<>();
        for (int i = 0; i < folder.length; i++) {
            boolean flag=false;
            for(String sub:set){
                if(folder[i].startsWith(sub)&&sub.length()<folder[i].length()&&folder[i].charAt(sub.length())=='/'){
                    flag=true;
                    break;
                }
            }
            if(!flag) set.add(folder[i]);
        }

        return new ArrayList<>(set);
    }
*/


    //遍历 /   然后contains
 /*   public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s -> s.length()));
        Set<String> seen = new HashSet<>();
        outer:
        for (String f : folder) {
            for (int i = 2; i < f.length(); ++i)
                if (f.charAt(i) == '/' && seen.contains(f.substring(0, i)))
                    continue outer;
            seen.add(f);
        }
        return new ArrayList<>(seen);
    }
*/

       //按字母续排序  这个显得就聪明多了 O(N)
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        String parent = " /"; // dummy value.
        for (String f : folder) {
            if (!f.startsWith(parent)) {
                parent = f + '/';
                ans.add(f);
            }
        }
        return ans;
    }

    class Node{
        String val;
        Node[]next;

        public Node(String val, Node[] next) {
            this.val = val;
            this.next = next;
        }
    }
}
