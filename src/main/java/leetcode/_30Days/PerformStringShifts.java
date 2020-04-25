package leetcode._30Days;

public class PerformStringShifts {

    //mine 显得多么冗余
/*    public String stringShift(String s, int[][] shift) {
     int res=0;
        for (int i = 0; i < shift.length; i++) {
            int []sh=shift[i];
            if(sh[0]==0){
                res-=sh[1];
            }else {
                res+=sh[1];
            }
        }
        System.out.println(res);
        if(res==0) return s;
        if(res>0){
            res%=s.length();
            return s.substring(s.length()-res)+s.substring(0,s.length()-res);
        }else {
            res=(-res);
            res%=s.length();
            return s.substring(res)+s.substring(0,res);
        }
    }*/


  //nice 666  用一个统一的方法来解
    public String stringShift(String s, int[][] shift) {
        int pos = 0, len = s.length();
        for (int[] sh : shift) {
            pos += sh[0] == 0 ? sh[1] : -sh[1];
        }
        pos = (pos % len + len) % len;
        return s.substring(pos) + s.substring(0, pos);
    }

    public static void main(String[] args) {
     //   System.out.println("abc".substring(-1));

        System.out.println(-5%2);
    }
}
