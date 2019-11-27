package leetcode.leetcode1_499;

public class leet374 {
    public int guessNumber(int n) {
        int left=0,right=n;
        while (left<=right){
            //  int mid=(left+right)/2; //TLE   原因是溢出了
            int mid=left+(right-left)/2;
            if(guess(mid)==0) return mid;
            else if(guess(mid)<0){
               right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return 0;
    }
    int guess(int num){
        return 0;
    }
}
