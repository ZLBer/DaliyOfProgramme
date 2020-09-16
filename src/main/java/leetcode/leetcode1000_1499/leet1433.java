package leetcode.leetcode1000_1499;

public class leet1433 {
 /*   public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return check(chars1, chars2) || check(chars2, chars1);
    }

    boolean check(char[] s1, char[] s2) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] < s2[i]) return false;
        }
        return true;
    }*/


    //不用排序
    public boolean checkIfCanBreak(String s1, String s2) {
     int []count1=new int[26];
     int []count2=new int[26];
        for (int i = 0; i < s1.length(); i++) {
           count1[s1.charAt(i)-'a']++;
           count2[s2.charAt(i)-'a']++;
        }

        boolean flag1=true,flag2=true;
        int sum1=0,sum2=0;
        for (int i = 0; i < count1.length; i++) {
          sum1+=count1[i];
          sum2+=count2[i];
          if(sum1>sum2) {
              flag2=false;
          }
          if(sum2>sum1){
              flag1=false;
          }

        }
        return flag1||flag2;
    }
}
