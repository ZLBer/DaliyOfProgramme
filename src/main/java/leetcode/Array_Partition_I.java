package leetcode;

/**
 * Created by libin on 2017/9/2.
 */
public class Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        sort(nums,0,nums.length-1);
        int count=0;
        for(int i=0;i<nums.length;i=i+2)
            count+=nums[i];
        return count;
    }
//    public int arrayPairSum(int[] nums) {
//        nums=quickSort(nums);
//        for(int i=0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }
//        int count=0;
//        for(int i=0;i<nums.length/2;i++){
//            if(nums[i*2]<nums[i*2+1]){
//                count+=nums[i*2];
//            }
//            else{
//                count+=nums[i*2+1];
//            }
//        }
//
//        return count;
//    }


//快速排序
    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序

    }

    public int [] quickSort(int a[]) {
        sort(a, 0, a.length - 1);
        return a;
    }
}
