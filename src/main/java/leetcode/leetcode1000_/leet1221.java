package leetcode.leetcode1000_;

public class leet1221 {

    //又理解错了
/*    public int balancedStringSplit(String s) {
           char[]arr=s.toCharArray();
           boolean R=true;
           int count=1;
           int result=0;
           int i=1;
           for (; i < arr.length; ) {
            if(arr[i]!=arr[i-1]) {
                result++;
                i+=count;
                count=1;
            }
            else {
                count++;
            }
            i++;
        }
           return result;
    }*/
    public int balancedStringSplit(String s) {
        char[]arr=s.toCharArray();

        int countR=0;
        int countL=0;

        int result=0;
        for (int i = 0; i < arr.length; i++) {

            if(arr[i]=='R') countR++;
            else countL++;

            if(countL!=0&&countR!=0&&countL==countR){
                result++;
                countL=0;
                countR=0;
            }
        }
        return result;
    }
}
