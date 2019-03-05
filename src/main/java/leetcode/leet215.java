package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by libin on 2019/3/5.
 */
public class leet215 {

    //mine  分治法
    //T(n) = T(n/2) + O(n)
   //T(n) = O(n).
    //关于为什么最快是O(n)的解释
    /*  
     *    
    Rank selection uses the partition method from quicksort. Randomized quicksort runs in O(nlogn) expected time with high probability, O(n^2) worst case. The proof for the expected run time can be found in cormen, but roughly speaking, when you randomly choose a pivot, it is nearly in the center of the array, so one can assume it cuts the array into a constant fraction.

Thus if we take a simplistic view of the math, then Quicksort has a running time of

T(n) = 2 * T(n / 2) + O(n).
T(n) = O(nlogn)

BUT, selection makes the following observation. After the single call to partition, the pivot is in its final position in the sorted array. Thus we know the rank of the pivot immediately, and can then determine if the element we are searching for is to the left, right, or is the pivot itself. This requires only one recursive call.

So quickselect has the following running time.

T(n) = T(n/2) + O(n)
T(n) = O(n).
     */  
   static public int findKthLargest(int[] nums, int k) {
       k=nums.length-k;
       int begin=0;
       int end=nums.length-1;
       while (begin<end) {
          // System.out.println("cccc");
           int pivot = quickSort(begin, end, nums, k);
           if (pivot == k){
               return nums[pivot];
           }
           else if (pivot < k) {
               begin = pivot + 1;
           } else end = pivot - 1;
       }
       return nums[begin];
    }

  static int quickSort(int begin,int  end,int nums[],int k){
       if(begin>=end)return begin;
        int i=begin;
        int j=end;
        int pivot=nums[begin];
        while (i<j){
            while (i<j&&nums[j]>pivot)  j--;
            nums[i]=nums[j];
            while (i<j&&nums[i]<=pivot) i++;
            nums[j]=nums[i];
        }
        nums[i]=pivot;
     return i;

    }
/*


//打乱初始序列防止O(n2)
    public int findKthLargest(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);//该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
            exch(a, ind, r);
        }
    }

*/


//一些别的方法

    //先排序
    //O(N lg N) running time + O(1) memory
/*public int findKthLargest(int[] nums, int k) {
    final int N = nums.length;
    Arrays.sort(nums);
    return nums[N - k];
}*/
  //用有线队列
   /* public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll(); //扔掉值最小的元素
            }
        }
        return pq.peek();  //返回最上面的元素
    }*/

    public static void main(String[] args) {
        System.out.println(findKthLargest(new  int[]{3,2,1,5,6,4},2));
    }
}
