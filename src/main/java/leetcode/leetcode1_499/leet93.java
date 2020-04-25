package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.List;

public class leet93 {


    //mine DFS
    public List<String> restoreIpAddresses(String s) {
        DFS(s,0,4,"");
        return res;
    }


  //   Set<String> res=new HashSet<>();
    //可以不用set
  List<String> res=new ArrayList<>();
    void DFS(String s,int deep,int count,String ans){
       if(count==0&&deep==s.length()){
           res.add(ans.substring(1));
           return;
       }
       if(deep>=s.length()||count==0){
           return;
       }

       for(int i=1;i<=4;i++){
           if(deep+i<s.length()+1){
              String  ts=s.substring(deep,deep+i);
               if(check(ts))
                 DFS(s,deep+i,count-1,ans+"."+ts);
           }
       }
    }
    boolean check(String s){
        int num=Integer.valueOf(s);
        //不能有先导0
        if(num>0&&s.charAt(0)=='0') return false;
        //不能有两个0
        if(num==0&&s.length()>1) return false;

        if(num>255||num<0) return false;

        return true;
    }


    //别人的 三重循环
/*    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        //三重循环代表分隔符的位置
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }*/
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
