package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/1/6.
 */
public class leet349 {
    // 用set做
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> re=new LinkedList<>();
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        for(int a: nums1){
            s1.add(a);
        }
        for(int a: nums2){
            s2.add(a);
        }
        for(int a:s2){
            if (s1.contains(a)) re.add(a);
        }
      Integer[] r=  re.toArray(new Integer[re.size()]);
        int[] d = new int[re.size()];
        for(int i = 0;i<re.size();i++){
            d[i] = re.get(i);
        }
        return  d;
    }

  //   先排序
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0;
//        int j = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//                i++;
//            } else if (nums1[i] > nums2[j]) {
//                j++;
//            } else {
//                set.add(nums1[i]);
//                i++;
//                j++;
//            }
//        }
//        int[] result = new int[set.size()];
//        int k = 0;
//        for (Integer num : set) {
//            result[k++] = num;
//        }
//        return result;
//    }

  //先排序再利用二分搜索
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        Arrays.sort(nums2);
//        for (Integer num : nums1) {
//            if (binarySearch(nums2, num)) {
//                set.add(num);
//            }
//        }
//        int i = 0;
//        int[] result = new int[set.size()];
//        for (Integer num : set) {
//            result[i++] = num;
//        }
//        return result;
//    }
//
//    public boolean binarySearch(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] == target) {
//                return true;
//            }
//            if (nums[mid] > target) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return false;
//    }
}
