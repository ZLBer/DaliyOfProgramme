package leetcode;

import java.util.*;

public class leetco2 {
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
        }

        return new ArrayList<>(set);
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
