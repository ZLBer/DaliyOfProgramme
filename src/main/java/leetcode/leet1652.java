package leetcode;

public class leet1652 {
    public int[] decrypt(int[] code, int k) {
        int left = 0, right = 0, sum = 0;
        if (k == 0) {
            return new int[code.length];
        } else if (k > 0) {
            left = 1;
            right = k;

        } else {
            left = code.length + k;
            right = code.length - 1;
        }
        for (int i = left; i <= right; i++) {
            sum += code[i];
        }
       int []res=new int[code.length];
        for (int i = 0; i < code.length; i++) {
            res[i]=sum;
            System.out.println(left+" "+right);
            sum-=code[left];
            left++;
            right++;
            left%=code.length;
            right%=code.length;
            sum+=code[right];
        }
       return res;
    }

    public static void main(String[] args) {
       // decrypt(new int[]{5,7,1,4},3);
    }
}
