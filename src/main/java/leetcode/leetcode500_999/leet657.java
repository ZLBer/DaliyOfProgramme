package leetcode.leetcode500_999;

/**
 * Created by libin on 2017/9/2.
 */
public class leet657 {
    public boolean judgeCircle(String moves) {
        int u=0,d=0,l=0,r=0;
        for(int i=0;i<moves.length();i++){
            String a=moves.substring(i,i+1);
            if(i==moves.length()-1)
                a=moves.substring(i);
            System.out.println(a);
            if(a.equals("U"))  {
                u++;
            }
            else if(a.equals("D")){
                d++;
            }
            else if(a.equals("L")){
                l++;
            }
            else r++;
        }
        if(u==d&&l==r) return true;
        else return  false;
    }
}
