package leetcode._5_30Days;

public class NumberComplement {
/*    public int findComplement(int num) {
        String s=Integer.toBinaryString(num);

        char []chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1') chars[i]='0';
            else chars[i]='1';
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        return Integer.parseInt(s.valueOf(chars),2);
    }*/
    public int findComplement(int num) {
        int sum=0;
        int j=0;
        while (sum<num){
          sum+=Math.pow(2,j);
          j++;
        }
        return sum-num;
    }
}
