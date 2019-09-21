package leetcode.leetcode1_499;

public class leet38 {
    public String countAndSay(int n) {
String [] pre={"1","11","21","1211","111221"};
    if(n<=5) return pre[n-1];

    int index=5;
    StringBuilder stringBuilder=new StringBuilder();
    String p=pre[4];
    while (index!=n){
      int count=1;
      int i=1;
    for(;i<p.length();i++){
        if(p.charAt(i)==p.charAt(i-1)){
           count++;
        }
        else {
            stringBuilder.append(count+""+(p.charAt(i-1)-'0'));
            count=1;
        }

    }
        stringBuilder.append(count+""+(p.charAt(i-1)-'0'));
     index++;
    p=stringBuilder.toString();
    stringBuilder=new StringBuilder();
    }

    return p;
    }
}
