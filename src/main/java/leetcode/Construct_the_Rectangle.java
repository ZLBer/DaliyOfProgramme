package leetcode;

/**
 * Created by libin on 2017/10/8.
 */
public class Construct_the_Rectangle {
    public int[] constructRectangle(int area) {
        int gap=9999;
        int []result=new int[2];
        int wh=(int)Math.sqrt(area);
        for(int w=1;w<=wh;w++){
            for(int l=w;l<=area;l++){
             if(w*l==area&&l-w<gap) {
                 gap=l-w;
                 System.out.println(gap);
                 result[0]=l;
                 result[1]=w;
             }
            }
        }
        if(result[0]==0){
            result[0]=1;
            result[1]=1;
        }
        return result;
    }
}
