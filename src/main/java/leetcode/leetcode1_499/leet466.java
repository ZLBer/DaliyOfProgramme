package leetcode.leetcode1_499;

public class leet466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count=1;
        int pointS1=0,pointS2=0;
        String moreS1=s1;
        while (count<n1&&pointS2<s2.length()){
          if(moreS1.charAt(pointS1)==s2.charAt(pointS2)){
              pointS1++;
              pointS2++;
          }else {
              pointS1++;
              if(pointS1>=moreS1.length()) {
                  moreS1+=s1;
                  count++;
              }
          }
        }
        return n2/count;
    }
}
