package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet1156 {

    //直接做  关键是数据结构要搞清楚
 /*   public int maxRepOpt1(String text) {
    List<CharState> charStateList=new ArrayList<>();
    int begin=0,end=0;
    char temC=text.charAt(0);
    int []count=new int[26];
    for(int i=0;i<text.length();i++){
        count[text.charAt(i)-'a']++;
      if(text.charAt(i)==temC) end++;
      else {
          charStateList.add(new CharState(temC,begin,end));
          temC=text.charAt(i);
          begin=i;
          end=i+1;
      }
    }
charStateList.add(new CharState(temC,begin,end));
  int maxLength=0;
    //在边上加的情况
   for(int i=0;i<charStateList.size();i++){
       CharState charState=charStateList.get(i);
       int len=charState.end-charState.bigin;
       if(count[charState.c-'a']>len) {
          len++;
       }
     maxLength=Math.max(maxLength,len);
   }

   //中间镂空的情况
        for(int i=1;i<charStateList.size()-1;i++) {
           CharState  left=charStateList.get(i-1);
           CharState  middle=charStateList.get(i);
           CharState right=charStateList.get(i+1);


       if(left.c==right.c&&(middle.end-middle.bigin)==1){
           int len=left.end-left.bigin+right.end-right.bigin;


           //还有多余的
           if(len<count[left.c-'a']){
               maxLength=Math.max(maxLength,len+1);
           }else {
               //没有多余的
               maxLength=Math.max(maxLength,len);
           }
       }
        }
        return maxLength;
    }

    class CharState{
        char c;
        int bigin;
        int end;

        public CharState(char c, int bigin, int end) {
            this.c = c;
            this.bigin = bigin;
            this.end = end;
        }
    }*/


 //
    public int maxRepOpt1(String text) {
        char []chars=text.toCharArray();
int []freq=new int[26];
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i]-'a']++;
        }
        int maxLength=0;
for(int i=0;i<text.length();i++){
     char cur=chars[i];
    int j=i,diff=0,count=0;
    while (j<text.length()&&(cur==chars[j]||diff==0)&&count<freq[cur-'a']){
          if(cur!=chars[j]) diff++;
          count++;
          j++;
    }
maxLength=Math.max(maxLength,count);
}
return maxLength;
    }
    public static void main(String[] args) {
        leet1156 leet1156=new leet1156();
        leet1156.maxRepOpt1("ababa");
    }
}
