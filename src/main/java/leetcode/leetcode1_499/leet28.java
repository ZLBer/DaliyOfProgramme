package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/28.
 */
public class leet28 {
    //直接调用已知函数
/*    public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
    }*/

//BF
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0&&needle.length()==0)  return 0;
        if(haystack.length()==0) return -1;
        if(needle.length()==0 )return 0;
        for(int i=0;i<haystack.length();i++){
            int point1=i;
            int point2=0;
            if(point1+needle.length()-1>=haystack.length()) return  -1;
            while (haystack.charAt(point1)==needle.charAt(point2)){

                 if(point2==needle.length()-1) return i;
                point1++;
                point2++;
            }
        }
        return -1;
    }

//elegant BF
  /*  public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }*/

    //KMP algorithms     不好写

/*        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;
            if (needle.length() > haystack.length() || haystack.length() == 0) return -1;
            char[] ndl = needle.toCharArray();
            char[] hay = haystack.toCharArray();
            int[] pai = new int[ndl.length];
            pai[0] = -1;
            int k = -1;
            for (int i = 1; i < ndl.length; i++) {
                while (k > -1 && ndl[k + 1] != ndl[i]) {
                    k = pai[k];
                }
                if (ndl[k + 1] == ndl[i]) {
                    k++;
                }
                pai[i] = k;

            }
            k = -1;
            for (int i = 0; i < hay.length; i++) {
                while (k > -1 && ndl[k + 1] != hay[i]) {
                    k = pai[k];
                }
                if (ndl[k + 1] == hay[i]) {
                    k++;
                    if (k == ndl.length - 1) {
                        return i - k;
                    }
                }
            }
            return -1;
        }*/

}
