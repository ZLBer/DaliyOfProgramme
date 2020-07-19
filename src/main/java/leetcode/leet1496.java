package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1496 {
    public boolean isPathCrossing(String path) {
        Set<String> set=new HashSet<>();
        int x=0,y=0;
        set.add(x+","+y);
        for (int i = 0; i < path.length(); i++) {
            char c=path.charAt(i);
            switch (c){
                case 'N':{y++;break;}
                case 'S':{y--;break;}
                case 'E':{x++;break;}
                case 'W':{x--;break;}
            }

            if(set.contains(x+","+y)){
                return true;
            }else {
                set.add(x+","+y);
            }
        }
        return false;
    }
}
