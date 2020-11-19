package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet987 {
/*    Map<Integer,List<Integer>> map=new HashMap<>();
    PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
       helper(0,root);
        while (!priorityQueue.isEmpty()){
        res.add(map.get(priorityQueue.poll()));
        }
        return res;
    }

    class Pack{
       TreeNode node;
       int index;

        public Pack(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    void helper(int num,TreeNode node){
        Queue<Pack> queue=new LinkedList<>();
        queue.add(new Pack(node,0));
        while (!queue.isEmpty()){
          int size=queue.size();
          while (size-->0){
            Pack pack=queue.poll();
            if(!map.containsKey(pack.index)){
                map.put(pack.index,new ArrayList<>());
                priorityQueue.add(pack.index);
            }
            map.get(pack.index).add(pack.node.val);
            if(pack.node.left!=null) queue.add(new Pack(pack.node.left,pack.index-1));
            if(pack.node.right!=null) queue.add(new Pack(pack.node.right,pack.index+1));
          }
        }
    }*/
/*    void helper(int num,TreeNode node){
        if(node==null) return;
       if(!map.containsKey(num)) {
           priorityQueue.add(num);
           map.put(num,new ArrayList<>());
       }
        map.get(num).add(node.val);
       helper(num-1,node.left);
       helper(num+1,node.right);
    }*/





    //让你不仔细读题！让你不仔细读题！让你不仔细读题！
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Each location is a node's x position, y position, and value
        locations = new ArrayList();
        dfs(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList<Integer>());

        int prev = locations.get(0).x;

        for (Location loc: locations) {
            // If the x value changed, it's part of a new report.
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }

            // We always add the node's value to the latest report.
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    public void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }
    class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x)
            return Integer.compare(this.x, that.x);
        else if (this.y != that.y)
            return Integer.compare(this.y, that.y);
        else
            return Integer.compare(this.val, that.val);
    }


}
}


