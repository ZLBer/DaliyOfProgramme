package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet1505$ {
    //暴力忽然就不能过了.. contest的时候可以过的
  /*  public String minInteger(String num, int k) {
       char []numArr=num.toCharArray();
     for(int index=0;index<num.length()&&k>0;index++){
         System.out.println(k);
      int []point=fint(num,index,k);
     if(point[1]==index)continue; //就是最小的
       num=helper(num,index,point[1]);
     k-=(point[1]-index);
     }
     return num;
    }
   int []fint(String num,int index,int k){
      int []res=new int[]{num.charAt(index),index};
        for(int i=index+1;i<=index+k&&i<num.length();i++){
          if(num.charAt(i)<res[0]){
             res[0]=num.charAt(i);
            res[1]=i;
          }
    }
        return res;
   }

   String helper(String num,int pre,int index){
     String p=num.substring(0,pre);
    String m=num.substring(pre,index);
   String l=num.substring(index+1);
  String res= p+num.charAt(index)+m+l;
       System.out.println(pre+" "+index+" "+res);;
  return res;
   }*/

    public String minInteger(String num, int k) {
        //pqs stores the location of each digit.
        List<Queue<Integer>> pqs = new ArrayList<>();
        for (int i = 0; i <= 9; ++i) {
            pqs.add(new LinkedList<>());
        }

        for (int i = 0; i < num.length(); ++i) {
            pqs.get(num.charAt(i) - '0').add(i);
        }
        String ans = "";
        SegmentTree seg = new SegmentTree(num.length());

        for (int i = 0; i < num.length(); ++i) {
            // At each location, try to place 0....9
            for (int digit = 0; digit <= 9; ++digit) {
                // is there any occurrence of digit left?
                if (pqs.get(digit).size() != 0) {
                    // yes, there is a occurrence of digit at pos
                    Integer pos = pqs.get(digit).peek();
                    // Since few numbers already shifted to left, this `pos` might be outdated.
                    // we try to find how many number already got shifted that were to the left of pos.
                    int shift = seg.getCountLessThan(pos);
                    // (pos - shift) is number of steps to make digit move from pos to i.
                    if (pos - shift <= k) {
                        k -= pos - shift;
                        seg.add(pos); // Add pos to our segment tree.
                        pqs.get(digit).remove();
                        ans += digit;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    //数组模拟
    //https://blog.csdn.net/feng964497595/article/details/100065313
    class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes = new int[4 * (max)];
            n = max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }
 //mode表示节点 ，lr表示管理范围
        private void addUtil(int num, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }

            //到达叶节点
            if (l == r) {
                nodes[node]++;
                return;
            }
            int mid = (l + r) / 2;
            addUtil(num, l, mid, 2 * node + 1); //往左子树
            addUtil(num, mid + 1, r, 2 * node + 2); //右子树
            //从下往上更新
            nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
        }

        // Essentialy it tells count of numbers < num.
        public int getCountLessThan(int num) {
            return getUtil(0, num, 0, n, 0);
        }

        private int getUtil(int ql, int qr, int l, int r, int node) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) { //包含此段。直接返回
                return nodes[node];
            }

            int mid = (l + r) / 2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    }


}
