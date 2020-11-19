package leetcode;

public class leet1653 {

    //  就遍历呗  看左边有多少b 右边有多少a
    public int minimumDeletions(String s) {
       int []count=new int[s.length()+1];
       count[0]=0;
       int []countB=new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            count[i+1]=count[i];
            if(s.charAt(i)=='a'){
                count[i+1]++;
            }
        }

        for (int i = s.length()-1; i >= 0; i--) {
            countB[i]=countB[i+1];
            if(s.charAt(i)=='b'){
                countB[i]++;
            }
        }

        int res=Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            res=Math.min(count[i]+countB[i+1],res);
        }
        return res;

    }
}
