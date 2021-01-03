package leetcode;

public class leet1672 {
    public int maximumWealth(int[][] accounts) {
        int res=0;
        for (int i = 0; i < accounts.length; i++) {
            int s=0;
            for (int j = 0; j < accounts[0].length; j++) {
                s+=accounts[i][j];
            }
            res=Math.max(s,res);
        }
        return res;

    }




    public static void main(String[] args) {

    }
}
