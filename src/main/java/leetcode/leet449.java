package leetcode;

import java.util.ArrayDeque;

public class leet449 {



    //mine 就简单编码 也不用考虑是不是二叉搜索树
   /* public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "*";
         StringBuilder sb=new StringBuilder();
         Queue<TreeNode> queue=new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()){
             int size=queue.size();
             while (size-->0){
                 TreeNode node=queue.poll();
                 if(node!=null){
                     sb.append(node.val+",");
                     queue.offer(node.left);
                     queue.offer(node.right);
                 }else {
                     sb.append("*"+",");
                 }
             }
         }
         return sb.toString();
        }
        String nullObject="*";
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
         String[]datas=data.split(",");
         if(nullObject.equals(datas[0])) return null;
         Queue<TreeNode> queue=new LinkedList<>();
         TreeNode root=new TreeNode(Integer.parseInt(datas[0]));
         queue.add(root);
         int index=1;
         while (!queue.isEmpty()){
             TreeNode node=queue.poll();
             if(nullObject.equals(datas[index])){
                 node.left=null;
             }else {
                 TreeNode nw=new TreeNode(Integer.parseInt(datas[index]));
                  node.left=nw;
                  queue.add(nw);
             }
             index++;

             if(nullObject.equals(datas[index])){
                 node.right=null;
             }else {
                TreeNode nw=new TreeNode(Integer.parseInt(datas[index]));
               node.right=nw;
               queue.add(nw);
             }
             index++;
         }

         return root;
        }
    }*/




   /* public class Codec {
        //后序遍历+中序(已知) 保证唯一构建二叉树    其实在null的地方可以填*保证唯一
        public StringBuilder postorder(TreeNode root, StringBuilder sb) {
            if (root == null) return sb;

            sb.append(root.val);
            sb.append(' ');
            postorder(root.left, sb);
            postorder(root.right, sb);

            return sb;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "";
            StringBuilder sb = postorder(root, new StringBuilder());
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        //这种构建方法挺好的  以前没见过
        public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            if (nums.isEmpty()) return null;
            int val = nums.getFirst();
            if (val < lower || val > upper) return null;

            nums.removeFirst();

            //这里注意要与之前遍历的顺序相反
            TreeNode root = new TreeNode(val);
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);


            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            for (String s : data.split("\\s+"))
                nums.add(Integer.valueOf(s));
            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        }
    }*/



   //再次优化  去掉分隔符  并且数字转成4位  一个数字固定使用四个字节
    public class Codec {
        // Encodes a tree to a list.
        public void postorder(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            postorder(root.left, sb);
            postorder(root.right, sb);
            sb.append(intToString(root.val));
        }

        // Encodes integer to bytes string
       //32位int  每8位转成一个char
        public String intToString(int x) {
            char[] bytes = new char[4];
            for(int i = 3; i > -1; --i) {
                bytes[3 - i] = (char) ( x>> (i * 8) & 0xff);
            }
            return new String(bytes);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            postorder(root, sb);
            return sb.toString();
        }

        // Decodes list to tree.
        public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            if (nums.isEmpty()) return null;
            int val = nums.getLast();
            if (val < lower || val > upper) return null;

            nums.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);
            return root;
        }

        // Decodes bytes string to integer
        public int stringToInt(String bytesStr) {
            int result = 0;
            for(char b : bytesStr.toCharArray()) {
                result = (result << 8) + (int)b;
            }
            return result;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            int n = data.length();
            for(int i = 0; i < (int)(n / 4); ++i) {
                nums.add(stringToInt(data.substring(4 * i, 4 * i + 4)));
            }

            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        }
    }


}
