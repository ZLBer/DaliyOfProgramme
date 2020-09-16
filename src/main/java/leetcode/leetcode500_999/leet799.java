package leetcode.leetcode500_999;

public class leet799 {
    //想法错了
  /*  public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured==0) return 0;
      //首先判断可以倒慢前几行
     int level=-1;
        for(int i=1;i<=100;i++){
if(poured>=i){
    level++;
    poured-=i;
}
else {
    break;
}
     }
    if(query_row<=level) return 1;
    if(query_row>level+1) return 0;

   double one=(double) poured/((level+1)*2); //流下去一份的数目
        //判断是1份还是两份
     if(query_glass==0||query_glass==level+1){
         return one;
     }else {
         return 2*one;
     }
    }*/

  //直接模拟就好了 ，别妄图去找规律..
static   public double champagneTower(int poured, int query_row, int query_glass) {
      if(poured==0) return 0;
   double [][]arr=new double[query_row+1][query_row+1];
   arr[0][0]=poured;
   for(int i=1;i<=query_row;i++){
   for(int j=0;j<=i;j++){
       if(j==0){ //两边
         arr[i][j]=arr[i-1][j]>1?(arr[i-1][j]-1)/2:0;
       }else if(j==i){
         arr[i][j]=arr[i-1][j-1]>1?(arr[i-1][j-1]-1)/2:0;
       }else { //中间
           arr[i][j]=(arr[i-1][j]>1?(arr[i-1][j]-1)/2:0)+(arr[i-1][j-1]>1?(arr[i-1][j-1]-1)/2:0);
       }
   }
   }
    /*  for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[0].length; j++) {
              System.out.print(arr[i][j]+" ");
          }
          System.out.println();
      }*/
   return arr[query_row][query_glass]>1?1:arr[query_row][query_glass];
  }

    public static void main(String[] args) {
        champagneTower(4,2,1);
    }
}
