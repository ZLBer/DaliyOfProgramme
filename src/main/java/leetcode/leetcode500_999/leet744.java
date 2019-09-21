package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/3/8.
 */
public class leet744 {

    //mine  BF
   /* public char nextGreatestLetter(char[] letters, char target) {

        char min='z'+1;
        char result=0;
        int distance=Integer.MAX_VALUE;
        for(int i=0;i<letters.length-1;i++){
         if(letters[i]<min) min=letters[i];
            System.out.println(letters[i]-target);
          if(letters[i]>target&&letters[i]-target<distance)
          {  distance=letters[i]-target;
              result=letters[i];
          }
            System.out.println(result+"    "+distance);
         }

         if(distance==Integer.MAX_VALUE) return min;
        else return result;
    }*/

    //没看到题目说是已经排序的数组
    //二分查找
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[0] > target) return letters[0];
        if (letters[letters.length - 1] <= target) return letters[0];

        return binarySearch(letters, target);
    }

    private char binarySearch(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            }
            else if (letters[mid] > target) {
                end = mid - 1;
            }
        }
        return letters[start];
    }
}
