package leetcode;

import java.util.*;

public class leet297 {


    //一开始理解错了   无一位null下面还可以有null，其实null后面就没有了   导致全部的算法都写错了，
    //其实这个hard不算难
/*    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "[]";
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            List<Integer> res=new ArrayList<>();
            res.add(root.val);
            while (!queue.isEmpty()){
                int size=queue.size();
                while (size-->0){
                    TreeNode node=queue.poll();

                    if(node.left!=null){
                        queue.offer(node.left);
                        res.add(node.left.val);
                    }else {
                         res.add(null);
                    }

                    if(node.right!=null){
                        queue.offer(node.right);
                        res.add(node.right.val);
                    }else {
                        res.add(null);
                    }
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<res.size()-1;i++){
                sb.append(res.get(i)+",");
            }
            sb.append(res.get(res.size()-1));
            return "["+sb.toString()+"]";
        }

        // Decodes your encoded data to tree.
          public TreeNode deserialize(String data) {
            if ("[]".equals(data)) return null;
            data = data.substring(1, data.length() - 1);
            if (data.length() == 0) return null;
            String[] datas = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()&&index<datas.length) {
                int size = queue.size();
                while (size-- > 0 && index < datas.length) {
                    TreeNode node = queue.poll();
                    TreeNode left = "null".equals(datas[index]) ? null : new TreeNode(Integer.parseInt(datas[index]));
                    node.left = left;
                    if (node.left != null) {
                        queue.offer(node.left);

                    }
                    index++;
                    if (index >= datas.length) continue;
                    TreeNode right = "null".equals(datas[index]) ? null : new TreeNode(Integer.parseInt(datas[index]));
                    node.right = right;
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    index++;
                }
            }
                    return root;
                }
            }*/



//还是理解错了意思，要求是不一定要按题目中的格式来做..
    //前序遍历就可以了  递归
    public class Codec {
        private static final String spliter = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(spliter);
            } else {
                sb.append(node.val).append(spliter);
                buildString(node.left, sb);
                buildString(node.right,sb);
            }
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(spliter)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String val = nodes.remove();
            if (val.equals(NN)) return null;
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }



  //层序遍历  比自己的要简洁
    /*  public class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    res.append("n ");
                    continue;
                }
                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == "") return null;
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }*/


    public static void main(String[] args) {
      Codec c=  new leet297().new Codec();
      c.deserialize("[1,2,3,null,null,4,5]");
    }
}
