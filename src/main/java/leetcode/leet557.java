package leetcode;

/**
 * Created by libin on 2017/9/6.
 */
public class leet557 {
    public String reverseWords(String s) {
        StringBuffer reverse=new StringBuffer();
    String []m=s.split(" ");
    for(int i=0;i<m.length;i++){
        StringBuffer a=new StringBuffer();
        for(int j=m[i].length()-1;j>=0;j--) {
            a.append(m[i].charAt(j));
        }
       if(i<m.length-1) reverse.append(a+" ");
          else reverse.append(a);
    }
    return reverse.toString();
    }
}
