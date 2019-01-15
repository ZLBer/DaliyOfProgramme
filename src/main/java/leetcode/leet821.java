package leetcode;

/**
 * Created by libin on 2019/1/14.
 */
public class leet821 {
    //啊 好臃肿的算法啊
 /* static   public int[] shortestToChar(String S, char C) {

        int []result=new int[S.length()];
        for(int i=0;i<result.length;i++ ){
           result[i]=10002;
        }
        for(int i=0;i<S.length();){
            if(S.charAt(i)==C) {
               result[i]=0;
               int prestep=1,lateStep=1;
                for(int j=i-1;j>=0;j--){
                    if(result[j]>prestep) {
                        result[j] = prestep;
                    }else {
                        break;
                    }
                    prestep++;
                }
                int j=i+1;
                for(;j<S.length();j++){
                    if(S.charAt(j)==C){
                        i=j;
                        System.out.println(i);
                        break;
                    }
                    else if(result[j]>lateStep)
                        result[j]=lateStep;
                    lateStep++;
                }
                if(j==S.length()) break;

            }else i++;
        }
        return result;
    }*/
//我觉得跟我的差不多 只不过更加精简
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        //正着遍历
        for (int i = 0; i < n; ++i) {
            //用pos记录前一个C的位置
            if (S.charAt(i) == C) pos = i;
            //算出距离前一个C的距离
            res[i] = i - pos;
        }
        //再倒着遍历一次
        for (int i = n - 1; i >= 0; --i) {
            //记录后一个C的位置
            if (S.charAt(i) == C)  pos = i;
            //比较前后C的距离
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }


    public static void main(String[] args) {
        shortestToChar("loveleetcode",'e');
    }
}
