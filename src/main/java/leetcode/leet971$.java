package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet971$ {
    int index=0;
    List<Integer> result=new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

   return dfs(root,voyage)?result: Arrays.asList(-1);
    }

    boolean dfs(TreeNode node,int []voyage){
        if(node==null) return true;
        if(node.val!=voyage[index]) return false;
        index++;
        if(node.left!=null&&node.left.val!=voyage[index]){
            result.add(node.val);
            //交换左右子树
            return dfs(node.right,voyage)&&dfs(node.left,voyage);
        }
   //不交换左右子树
        return dfs(node.left,voyage)&&dfs(node.right,voyage);
    }
}
