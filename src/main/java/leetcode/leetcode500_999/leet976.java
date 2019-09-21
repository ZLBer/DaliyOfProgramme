package leetcode.leetcode500_999;

import leetcode.LQTest.A;

import java.util.Arrays;

/**
 * Created by libin on 2019/1/13.
 */
public class leet976 {
    //超时
//    public int largestPerimeter(int[] A) {
//        int max=0;
//        if(A.length<3) return 0;
//         for(int i=0;i<A.length;i++){
//             for (int j=i+1;j<A.length;j++){
//                 for(int s=j+1;s<A.length;s++){
//                     int a=A[i],b=A[j],c=A[s];
//                     if(a+b>c&&b+c>a&&a+c>b&&(a+b+c)>max)  max=a+b+c;
//                 }
//             }
//         }
//         return max;
//    }

    //先排序
   static public int largestPerimeter(int[] A) {
        int result = 0;
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
        if (A[i] + A[i + 1] > A[i + 2]) {
            System.out.println("++++");
            result = A[i] + A[i + 1] + A[i + 2];
            break;
        }
    }
        return result;
}

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1,2,1}));
    }
}
