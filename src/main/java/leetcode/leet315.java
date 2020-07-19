package leetcode;

import java.util.*;

public class leet315 {
    //线段是模板套上
/*    public List<Integer> countSmaller(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);
        Map<Integer,Integer> indexMap=new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
           indexMap.put(ints[i],i);
        }

       int []res=new int[nums.length];
       SegmentTree segmentTree=new SegmentTree(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
          int index=indexMap.get(nums[i]);
            System.out.println(index);
          res[i]=segmentTree.getCountLessThan(index-1);
            System.out.println(res[i]);
          segmentTree.add(index);
        }
        List<Integer> list=new ArrayList<>(res.length);
        for (int i = 0; i < res.length; i++) {
            list.add(res[i]);
        }
        return  list;
    }



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
    }*/
    //mine 归并排序
    public List<Integer> countSmaller(int[] nums) {

    int [][] arr=new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0]=i;
            arr[i][1]=nums[i];
        }
    Integer []res=new Integer[nums.length];
        Arrays.fill(res,0);
     mergeSort(0,nums.length-1,arr,res);

     return Arrays.asList(res);
    }

   void  mergeSort(int l,int r,int [][]arr,Integer []res){
    if(l>=r){
        return;
    }
   int mid=(l+r)/2;
   mergeSort(l,mid,arr,res);
   mergeSort(mid+1,r,arr,res);

   int [][]temp=new int[r-l+1][2];//临时数组

   int i=l,j=mid+1;

   int counter=0;
   for (int k = 0; k < temp.length; k++) {
    if(i<=mid&&j<=r) { //都存在
        if(arr[i][1]>arr[j][1]){
            counter++;
            temp[k]=arr[j];
            j++;
        }else {
          temp[k]=arr[i];
            res[arr[i][0]]+=counter;
            i++;
        }

    }
    else  if(i<=mid){
       temp[k]=arr[i];
      res[arr[i][0]]+=counter;
      i++;
    }
   else if(j<=r){
        temp[k]=arr[j];
        j++;
    }
   }

       for (int k = 0; k < temp.length; k++) {
         arr[k+l]=temp[k];
       }
  
   }

}


