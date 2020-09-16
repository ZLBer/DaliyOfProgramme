package leetcode.leetcode1000_1499;

public class leet1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if(s[i].startsWith(searchWord)) return i+1;
        }
        return -1;
        
    }
}
