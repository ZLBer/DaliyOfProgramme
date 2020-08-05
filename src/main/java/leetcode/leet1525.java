package leetcode;

public class leet1525 {
/*    public int numSplits(String s) {
        int []count=new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        int []pre=new int[26];
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            pre[s.charAt(i)-'a']++;
            if(check(count,pre)) res++;
        }
        return res;
    }
    boolean check(int []count,int []pre){
        int left=0,right=0;
        for (int i = 0; i < pre.length; i++) {
            if(pre[i]==0){
                right++;
            }
            if(count[i]==pre[i]){
                left++;
            }
        }
        return left==right;
    }*/


    //统计左右 ，当0是调整数字大小
    public int numSplits(String s) {

        int size = 26;
        int[] leftCount = new int[size];
        int[] rightCount = new int[size];
        int leftVaild = 0;
        int rightVaild = 0;
        //先将整个字符串作为右半部分滑窗的内容
        for(char ch : s.toCharArray()){
            int num = ch - 'a';
            if(rightCount[num] == 0){
                rightVaild++;
            }
            rightCount[num]++;
        }

        int c = 0;
        //慢慢调整左半部分滑窗，从左往右遍历，增大左半部分，缩减右半部分，进行滑窗
        for(char ch : s.toCharArray()){
            int num = ch - 'a';
            //左边没有出现过这种字符，那么左边字符 +1
            if(leftCount[num] == 0){
                leftVaild++;
            }
            //右边这是最后一次出现该字符，那么滑窗后右边字符 -1，即这种字符不会再出现在右边了
            if(rightCount[num] == 1){
                rightVaild--;
            }
            leftCount[num]++;
            rightCount[num]--;
            if(leftVaild == rightVaild){
                c++;
            }
        }
        return c;
    }

}
