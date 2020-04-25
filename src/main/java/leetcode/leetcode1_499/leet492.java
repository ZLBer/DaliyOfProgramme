package leetcode.leetcode1_499;

/**
 * Created by libin on 2017/10/8.
 */
public class leet492 {
/*    public int[] constructRectangle(int area) {
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
    }*/

    //mine
/*    public int[] constructRectangle(int area) {
      if(area==1) return new  int[]{1,1};
        int L=(int)Math.sqrt(area),W=area/L;
        //L需要向上取整
        if(L*L!=area){
            L++;
            W=area/L;
        }
      for( ;L<=area;){
        if(L*W==area) return new int[]{L,W};
        L++;W=area/L;
      }
      return null;
    }*/


    //简单的操作  从w的角度来看，并且改成求余操作
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }
}
