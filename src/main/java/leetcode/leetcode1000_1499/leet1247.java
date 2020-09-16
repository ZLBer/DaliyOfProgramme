package leetcode.leetcode1000_1499;

public class leet1247 {
    public int minimumSwap(String s1, String s2) {
       char[] c1=s1.toCharArray();
       char[] c2=s2.toCharArray();

       int xy=0;
       int yx=0;
       int count=0;
       int x=0,y=0;
        for (int i = 0; i < c1.length; i++) {

             if(c1[i]=='x'&&c2[i]=='y'){
                 xy++;
             }else if(c1[i]=='y'&&c2[i]=='x'){
                 yx++;
             }
        }

        if((xy+yx)%2!=0) return -1;
        count=xy/2+yx/2+xy%2+yx%2;

       return count;
    }
}
