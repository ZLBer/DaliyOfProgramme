package leetcode.leetcode1_499;

import leetcode.ListNode;

public class leet109 {
    //mine  之前刚遇到过类似的 用递增系列构建二叉树
/*    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        return helper(0,list.size()-1,list);
    }

    //构建树
    TreeNode helper(int start ,int end,List<Integer> list){
        if(end<start)return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=helper(start,mid-1,list);
        root.right=helper(mid+1,end,list);
        return root;
    }

    //mine  之前刚遇到过类似的 用递增系列构建二叉树
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        return helper(0,list.size()-1,list);
    }*/

    //不用额外的数组来存储  用快慢指针来寻找midddle位置
/*    TreeNode helper(ListNode head,ListNode tail){
        if(head==tail) return null;
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=helper(head,slow);
        root.right=helper(slow.next,tail);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {

        return helper(head,null);
    }*/


//不用快慢指针  按照中序遍历一次添加 左子树 根节点 右子树
private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    public TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }
}
