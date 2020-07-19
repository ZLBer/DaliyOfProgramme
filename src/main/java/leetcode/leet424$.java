package leetcode;

public class leet424$ {


    //滑动窗口有时候也不是很容易想啊
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int []count=new int[26];
        int left=0;
        int maxACharCount=0;
        for(int right=0;right<chars.length;right++){
            int index=chars[right]-'A';
            count[index]++;
            maxACharCount=Math.max(maxACharCount,count[index]);
            if(maxACharCount+k<right-left+1){  //注意此处，maxACharCount只可能增大，不可能减小。所以当窗口变大时，会发生不合适的情况，需要左移。
                count[chars[left]-'A']--;
                left++;
            }
        }

        return chars.length-left;

    }
}
