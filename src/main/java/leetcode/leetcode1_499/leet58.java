package leetcode.leetcode1_499;

public class leet58 {
    public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        int index=s.length()-1;
        int count=0;
        while (index>=0&&s.charAt(index)==' ')
            index--;
        while (index>=0&&s.charAt(index)!=' '){
            count++;
            index--;
        }
        return count;
    }
}
