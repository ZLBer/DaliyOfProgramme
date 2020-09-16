package leetcode.tianchi;

import java.util.Arrays;

public class tianchi0905 {
    public static void main(String[] args) {
        System.out.println(1);
    }

    public long greatestcommonmultiple(int a, int b) {
      //  return ((long)4993)*4999*5000;

//  return 193*197*199;
    //    return Math.max(b-4>=a?ICD(b-4,b-3,b-2):0,Math.max(ICD(b,b-1,b-2),b-3>=a?ICD(b-1,b-2,b-3):0));
/*        List<Integer> list=new ArrayList<>();
        for(int i=a;i<=b;i++){
            boolean flag=false;
            for (int j = 0; j < list.size(); j++) {
                if(i%list.get(j)==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                list.add(i);
            }
        }*/
        int [][]arr=new int[b+1][b+1];
        for(int i=a;i<=b;i++){
            for(int j=i+1;j<=b;j++){
                arr[i][j]=multiple(a,b);
            }
        }


        return 0;
    }

    public static int multiple(int x,int y){
        int z ;
        for(z=Math.min(x,y);;z++){
            if(z%x==0&&z%y==0){
                break;
            }
        }
        return z;
    }

    public static int ICD(int a,int b,int c){//求最小公倍数
        int k=getMax(a,b,c);
        for (int i=k;;i++){
            if(i%a==0 && i%b==0 && i%c==0){
                return i;
            }
        }
    }
    public static  int  getMax(int a ,int b,int c){//求最大值
        int []aa={a,b,c};
        Arrays.sort(aa) ;
        return aa[2];
    }










    public int perfectString(String s, int k) {
        int n=s.length();
        int i=0;
        int res=0;
        while (i<n){
            if(s.charAt(i)=='1') {
                i++; continue;
            }
            else {
                int j=1;
                for(;j<k&&i+j<n;j++){
                    if(s.charAt(i+j)=='0'){
                        continue;
                    }else {
                        break;
                    }
                }
                i+=j;
                res++;
            }

        }
        return res;
    }

    public boolean stringGame(String s) {
       int []arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
           int c=s.charAt(i)-'a';
           arr[c]++;
        }

        int count=0;
        int one=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0) count++;
            if(arr[i]==1) one++;
        }

        if(count%2==1) return true;
     else {
        if(one>0) return true;
        else return false;
    }

}

}