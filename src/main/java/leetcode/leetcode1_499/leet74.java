package leetcode.leetcode1_499;

public class leet74 {
    //mine 当作有序数组就好
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int left=0,right=matrix[0].length*matrix.length-1;
        int r=matrix.length,c=matrix[0].length;
        while (left<right){
            int mid=(left+right)/2;
            //System.out.println(left+"  "+right);
            //  System.out.println(mid/c+"  "+mid%c);
            if(matrix[mid/c][mid%c]==target){
                return true;
            }else if(matrix[mid/c][mid%c]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        //注意最后要检查边缘情况
        return matrix[left/c][left%c]==target;
    }


    //这个方法也挺好的   最右边作为边界，然后就可以找到taget所处的那一行
   /* public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }*/
}
