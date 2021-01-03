package leetcode;

public class leet1684 {
    public int countConsistentStrings(String allowed, String[] words) {
       boolean []letter=new boolean[26];
        for (char c : allowed.toCharArray()) {
            letter[c-'a']=true;
        }

        int res=0;
        for (int i = 0; i < words.length; i++) {
            boolean flag=false;
            for (char c : words[i].toCharArray()) {
                if(letter[c-'a']) continue;
                else {
                    flag=true;
                    break;
                }
            }
           if(!flag) res++;
        }
        return res;
    }
}
