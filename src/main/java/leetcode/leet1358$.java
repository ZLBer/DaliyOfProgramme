package leetcode;

public class leet1358$ {
    //mine  暴力 TLE
 /*   public int numberOfSubstrings(String s) {
     int res=0;
        for(int i=0;i<s.length();i++){
         int a=1,b=1,c=1;
         for(int j=i;j<s.length();j++){
             switch (s.charAt(j)){
                 case 'a':{a--;break;}
                 case 'b':{b--;break;}
                 case 'c':{c--;break;}
             }
             if(a<=0&&b<=0&&c<=0){
             res+=(s.length()-j);
             break;
             }
         }
     }
        return res;
    }*/
    //滑动窗口
    public int numberOfSubstrings(String s) {
        int i=0;
        int []count=new int[3];
        int res=0;
        for(int j=0;j<s.length();j++){
           count[s.charAt(j)-'a']++;

           while (count[0]>0&&count[1]>0&&count[2]>0){
             count[s.charAt(i++)-'a']--;
           }
           res+=i;
        }
        return res;
    }

  //存最后出现的位置
/*    public int numberOfSubstrings(String s) {
        int []last=new int[3];
        last[0]=-1;
        last[1]=-1;
        last[2]=-1;
        int res=0;
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
            res+=1+Math.min(last[0],Math.min(last[1],last[2]));
        }
        return res;
    }*/
}
