package leetcode;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by libin on 2019/1/19.
 */
public class leet841 {
    //DFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<List<Integer>> stack=new Stack<>();
        boolean  []visited=new boolean[rooms.size()];

        stack.push(rooms.get(0));
           visited[0]=true;
        while (!stack.isEmpty()){
            List<Integer> room=stack.pop();

            for(Integer key:room){
                if(visited[key]==false)
                       stack.push(rooms.get(key));
                visited[key]=true;
            }
        }

        for(boolean f:visited){
            if(f==false) return false;
        }
        return true;
    }

  //如果用set
  /*  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>(); seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }*/
}
