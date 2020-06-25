package leetcode._4_30Days;


import java.util.List;

public class LeftmostColumnwithatLeastaOne {
   class BinaryMatrix {
        public int get(int x, int y) {return 0;};
        public List<Integer> dimensions() {return null;};
    }

    //mine 二分
/*    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer>dimensions=binaryMatrix.dimensions();
        int row=dimensions.get(0);
        int left=0,right=dimensions.get(1)-1;

        int res=104;
        for(int i=0;i<row;i++){
            res=Math.min(helper(binaryMatrix,i,right+1,left,right+1),res);
        }
        return res==right+1?-1:res;

    }
    int helper(BinaryMatrix binaryMatrix,int row,int conlumn,int left,int right){
        while (left<right) {
            int mid=(left+right)/2;
            if(binaryMatrix.get(row,mid)==0){
                left=mid+1;
            }else {
                right=mid;
            }
        }

        return left;
    }*/

    //下楼梯
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer>dimensions=binaryMatrix.dimensions();
        int row=dimensions.get(0),col=dimensions.get(1);
        int res=-1;
        int j=col-1;
        for(int i=0;i<row;i++){
           for(;j>=0;j--){
               if(binaryMatrix.get(i,j)==1){
                   res=j;
               }else {
                 break;
               }
           }
        }
        return res;
    }
}
