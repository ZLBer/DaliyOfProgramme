package leetcode;

import java.util.Arrays;

public class leet1707 {


    //contest 虽然进行了很多优化 但是方法不对还是超时啊
/*   static class Pack{
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int bit;
       List<Integer> list=new ArrayList<>();

        public Pack(int bit) {
            this.bit = bit;
        }
    }
   static public int[] maximizeXor(int[] nums, int[][] queries) {
     
        Map<Integer,Pack> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bit=Integer.toBinaryString(nums[i]).length();
          if(!map.containsKey(bit)){
              map.put(bit,new Pack(bit));
          }
          Pack pack = map.get(bit);
         pack.max=Math.max(nums[i],pack.max);
         pack.min=Math.min(nums[i],pack.min);
         pack.list.add(nums[i]);
        }

        List<Pack> collection=new ArrayList<>(map.values());

        collection.sort((a,b)->b.bit-a.bit);

        int []ans=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int []query=queries[i];
            int bit=Integer.toBinaryString(query[0]).length();
            List<Pack> candidate=new ArrayList<>();
            for (int j = 0; j < collection.size(); j++) {
               Pack pack=collection.get(j);
               if(query[1]>=pack.min) {
                 if(pack.bit>bit) { //比他长度要长，肯定在这里面
                   candidate.add(pack);
                   break;
                 }else {
                    candidate.add(pack);
                 }
               }
            }
          ans[i]=helper(query,candidate);
        }
        return ans;
    }
  static   int helper(int []query,List<Pack> candidate){
        int max=-1;
        for (Pack pack : candidate) {
            for (Integer integer : pack.list) {
           if(integer>query[1]) continue;
           max=Math.max(query[0]^integer,max);
            }   
        }
        return max;
    }*/


    public static void main(String[] args) {

    }


    //字典树也不难写 看了别人的思路自己写的
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] copy = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            copy[i][0] = queries[i][0];
            copy[i][1] = queries[i][1];
            copy[i][2] = i;
        }
        queries = copy;
        Arrays.sort(queries, (a, b) -> a[1] - b[1]);
        int left = 0;
        int []ans=new int[queries.length];
        Node root=new Node();
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            while (left < nums.length && nums[left] <= q[1]) {
                insert(nums[left++],root);
            }

            ans[q[2]]=search(q[0],root);

        }
        return ans;

    }


    void insert(int val, Node node) {
        String bit = Integer.toBinaryString(val);

        for (int i = 0; i < 32; i++) {
            char c = (i >= 32 - bit.length()) ? bit.charAt(i + bit.length() - 32) : '0';
            if (c == '0') {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new Node();
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new Node();
                }
                node = node.right;
            }
        }
        node.val = val;
    }

    int search(int val, Node node) {
        String bit = Integer.toBinaryString(val);
         if(node.left==null&&node.right==null) return -1; //还未进行任何填充
        for (int i = 0; i < 32; i++) {

            char c = (i >= 32 - bit.length()) ? bit.charAt(i + bit.length() - 32) : '0';
            if (c == '0') {
              if(node.right!=null){
                  node=node.right;
              }else {
                  node=node.left;
              }
            }else {
                if(node.left!=null){
                    node=node.left;
                }else {
                    node=node.right;
                }
            }
        }
        return  node.val^val;
    }

    class Node {
        int val = -1;
        Node left = null;
        Node right = null;
    }


}
