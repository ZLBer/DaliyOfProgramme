package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leet1625 {
    public String findLexSmallestString(String s, int a, int b) {
     char []nums=s.toCharArray();
     String res=s;
     Set<String> set=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(s);
     while (!queue.isEmpty()){
    String st=queue.poll();
    String s1=helper1(st,a);
    if(!set.contains(s1)) {
        set.add(s1);
      if(res.compareTo(s1)>0) res=s1;
      queue.add(s1);
    }
         s1=helper2(st,b);
         if(!set.contains(s1)) {
             set.add(s1);
             if(res.compareTo(s1)>0) res=s1;
             queue.add(s1);

         }

     }
return res;

    }

   String helper1(String s,int a){
     char []nums=s.toCharArray();
       for (int i = 0; i < nums.length; i++) {
           if(i%2==0) continue;
         nums[i]=(char)(nums[i]+a);
         if(nums[i]>'9') nums[i]=(char)(nums[i]-10);
       }
       return new String(nums);
   }
   String helper2(String s,int b){
    return  s.substring(s.length()-b)+s.substring(0,s.length()-b);
   }


   //也是一种暴力   不是很好理解
    /*public String findLexSmallestString(String s, int a, int b) {
       String res=s;
        for(int i=0;i<s.length();i++) {
            s = s.substring(s.length() - b) + s.substring(0, s.length() - b);
            for (int j = 0; j < 10; j++) {

                char[] chars = s.toCharArray();
                for (int k = 1; k < s.length(); k += 2) {
                    chars[k] += a;
                    if (chars[k] > '9') chars[k] = (char) (chars[k] - 10);
                }
                s = new String(chars);
                if (res.compareTo(s) > 0) res = s;


                if (b % 2 == 1) {
                    for (int m = 0; m < 10; m++) {
                        chars = s.toCharArray();
                        for (int k = 0; k < s.length(); k += 2) {
                            chars[k] += a;
                            if (chars[k] > '9') chars[k] = (char) (chars[k] - 10);
                        }
                        s = new String(chars);
                        if (res.compareTo(s) > 0) res = s;
                    }
                }
            }
        }
        return res;
    }*/


}
