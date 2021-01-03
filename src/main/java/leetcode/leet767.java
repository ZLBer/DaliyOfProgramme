package leetcode;

import java.util.Arrays;

public class leet767 {

    //mine 贪心贪心贪tmd
    public String reorganizeString(String S) {
        int [][]count=new int[26][2];
        for(char c:S.toCharArray()){
            count[c-'a'][0]++;
            count[c-'a'][1]=c-'a';
        }
        int max=0;
        Arrays.sort(count,(a,b)->b[0]-a[0]);
        if(count[0][0]>S.length()/2+1) return  "";

        char [] res=new char[S.length()];
        int index=0;
        for (int i = 0; i < count.length; i++) {
            char c=(char)('a'+count[0][1]);
            for (int j = 0; j < count[i][0]; j++) {

                res[index]=c;
                index+=2;
                if(index>=res.length) index=1;
            }
        }  

        return new String(res);
    }
}
