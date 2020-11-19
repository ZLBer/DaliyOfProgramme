package leetcode;

public class leet1638 {
    //暴力能过..
/*    public int countSubstrings(String s, String t) {


        int res=0;
        for(int len=1;len<=s.length();len++){
            for(int begin=0;begin+len<=s.length();begin++){
                String temps = s.substring(begin,begin+len);
                for(int i=0;i+len<=t.length();i++){
                    String tempt=t.substring(i,i+len);
                    if(check(temps,tempt)) res++;
                }
            }
        }
        return res;
    }

    boolean check(String s,String t){
        boolean flag=false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)){
                if(!flag) flag=true;
                else return false;
            }
        }
        return flag==true;
    }*/


    //更好的暴力  有种剪枝的味道
/*
    public int countSubstrings(String s, String t) {
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int count=0;
                for(int k=0;i+k<s.length()&&j+k<s.length();k++){
                    if(s.charAt(i+k)!=t.charAt(j+k)) count++;

                    if(count==1)
                        res++;
                    if(count>1)
                        break;;

                }
            }
        }
        return res;
    }
*/



    //枚举分歧点

    public int countSubstrings(String s, String t) {
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            char cs=s.charAt(i);
            for (int j = 0; j < t.length(); j++) {
             char ct=t.charAt(j);
             if(cs==ct) continue;

             int left=1;
             while (i-left>=0&&j-left>=0&&s.charAt(i-left)==s.charAt(j-left)) {
                 left++;
             }
             int right=1;
             while (i+right<s.length()&&j+right<t.length()&&s.charAt(i+right)==t.charAt(j+right)){
                 right++;
             }
            res+=(left*right);
            }
        }
        return res;
    }
}
